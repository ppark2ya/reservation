/**
 * 	admin page 제어
 */

var myApp = angular.module("myApp", ["ngRoute", "datatables"]);

// tree 메뉴 컨트롤러
myApp.controller("treeCtrl", function($scope){
	$scope.activated="customer";
});

// single page 라우터 설정
// .do 요청(컨트롤러를 거치는 경로) 일 경우에는 views 폴더를 통해서 경로를 잡지만
// 직접 .jsp 페이지 요청같은 경우에는 웹 컨텐트경로(wepapp)을 기준으로 경로를 잡는다.
myApp.config(function($routeProvider){
	$routeProvider
	.when("/customer", {
		templateUrl: "/admin/category/customer.html",
		controller: "customerCtrl"
	})
	.when("/board", {
		templateUrl:"/admin/category/board.html",
		controller: "boardCtrl"
	})
	.when("/room", {
		templateUrl:"/admin/category/room.html",
		controller:"roomCtrl"
	})
	.when("/reservation", {
		templateUrl:"/admin/category/reservation.html",
		controller:"resvCtrl"
	})
	.otherwise({redirectTo:"/customer"});
});

myApp.controller("customerCtrl", function($scope, $http){
	$http({
		url: "customerList.do?type=cust",
		method: "get"
	})
	.success(function(data){
		console.log(data);
		// List<Map<key, value>> 형태의 json 데이터를 받는다
		// ex : [{PHONE=010-2323-1234, REGDATE=2017/08/06, ID=park, EMAIL=park@naver.com, NAME=park},{...}]
		$scope.customerList = data;
	});

	$scope.removeRow = function(id){
		var isRemove = confirm("삭제하시겠습니까?");
		if(isRemove){
			var index = -1;
			var custArr = eval($scope.customerList);
			for(var i = 0; i < custArr.length; i++){
				if(custArr[i].ID === id){
					$scope.id = custArr[i].ID;
					index = i;
					break;
				}
			}
			if(index === -1){
				alert("something gone wrong!");
			}

			$scope.customerList.splice(index, 1);
			console.log($scope.id);

			$http({
				url: "custRemoveRow.do",
				method: "post",
				data:{id:$scope.id},
				headers:{
					"Content-Type":"application/json"
				}
			})
			.success(function(data){
				console.log("success");
			})
		}
	}
});

myApp.controller("boardCtrl", function($scope, $http){
	$http({
		url: "boardList.do?type=board",
		method: "get"
	})
	.success(function(data){
		console.log(data);
		$scope.boardList = data;
	});

	$scope.removeRow = function(boardSeq){
		var isRemove = confirm("삭제하시겠습니까?");
		if(isRemove){
			var index = -1;
			var boardArr = eval($scope.boardList);
			for(var i = 0; i < boardArr.length; i++){
				if(boardArr[i].BOARDSEQ === boardSeq){
					$scope.boardSeq = boardArr[i].BOARDSEQ;
					index = i;
					break;
				}
			}
			if(index === -1){
				alert("something gone wrong!");
			}

			$scope.boardList.splice(index, 1);
			console.log($scope.boardSeq);

			$http({
				url: "boardRemoveRow.do",
				method: "post",
				data:{boardSeq:$scope.boardSeq},
				headers:{
					"Content-Type":"application/json"
				}
			})
			.success(function(data){
				console.log("success");
			})
		}
	}
});

myApp.controller("roomCtrl", function($scope, $http){
	$http({
		url: "roomList.do?type=room",
		method: "get"
	})
	.success(function(data){
		console.log(data);
		$scope.roomList = data;
	});

	$scope.removeRow = function(roomSeq){
		var index = -1;
		var roomArr = eval($scope.roomList);
		for(var i = 0; i < roomArr.length; i++){
			if(roomArr[i].ROOMSEQ === roomSeq){
				$scope.roomSeq = boardArr[i].ROOMSEQ;
				index = i;
				break;
			}
		}
		if(index === -1){
			alert("something gone wrong!");
		}

		$scope.roomList.splice(index, 1);
		console.log($scope.roomSeq);

		$http({
			url: "roomRemoveRow.do",
			method: "post",
			data:{roomSeq:$scope.roomSeq},
			headers:{
				"Content-Type":"application/json"
			}
		})
		.success(function(data){
			console.log("success");
		})
	}
});

myApp.controller("resvCtrl", function($scope, $http){
	$http({
		url: "resvList.do?type=resv",
		method: "get"
	})
	.success(function(data){
		console.log(data);
		$scope.resvList = data;
	});

	$scope.removeRow = function(rvSeq){
		var isRemove = confirm("삭제하시겠습니까?");
		if(isRemove){
			var index = -1;
			var resvArr = eval($scope.resvList);
			for(var i = 0; i < resvArr.length; i++){
				if(resvArr[i].RVSEQ === rvSeq){
					$scope.rvSeq = resvArr[i].RVSEQ;
					index = i;
					break;
				}
			}
			if(index === -1){
				alert("something gone wrong!");
			}

			$scope.resvList.splice(index, 1);
			console.log($scope.rvSeq);

			$http({
				url: "resvRemoveRow.do",
				method: "post",
				data:{rvSeq:$scope.rvSeq},
				headers:{
					"Content-Type":"application/json"
				}
			})
			.success(function(data){
				console.log("success");
			})
		}
	}
});
/*
1. 디렉티브란?

쉽게 말해 "AngularJS의 HTML Compiler에 의해 해석된 특정한 행위의 기능을 가진 DOM 엘리먼트"입니다.

디렉티브를 이해하고 생성하기 앞서 사전지식으로 HTML Compiler에 대해 알아두어야할 필요가 있습니다.
built-in된, 또는 사용자가 새롭게 생성한 사용자정의 디렉티브를 HTML에서 사용할 수 있는 이유는
AngularJS의 HTML Compiler가 HTML의 DOM을 돌면서 디렉티브 이름과 같은 DOM 엘리먼트를 찾아내기 때문입니다.
AngularJS의 HTML Complier의 절차는 다음의 2 단계로 축약할 수 있습니다.

compile 단계 : HTML의 DOM 엘리먼트들을 돌면서 디렉티브를 찾는다.
(attribute name, tag name, comments, class name을 이용하여 디렉티브를 매칭시킨다.)
결과로 link function을 리턴한다.
link 단계 : 디렉티브와 HTML이 상호작용(동적인 view) 할 수 있도록 디렉티브에 event listener를 등록하며
scope와 DOM 엘리먼트간에 2-way data binding을 위한 $watch를 설정한다.
위의 HTML Compiler의두 단계를 거쳐 HTML에서 디렉티브를 사용할 수 있게 됩니다.

2. 디렉티브 작명법

Javascript에서 AngularJS의 디렉티브 생성 시 디렉티브 이름은 camelCase작명법을 따라 작성. (ex: testDirective)
HTML에서 AngularJS의 디렉티브를 사용 시 '-'를 이용한 snake-case 작명법으로 사용. (ex: test-directive)
*/

// DataTable 플러그인의 default sort, search 기능을 사용할 때
// 이전에 ajax 요청으로 받아온 데이터를 다시 뿌려주는 역할
// $timeout 기능을 사용하지 않으면 데이터를 다시 출력하지 않음
myApp.directive("repeatDone", function($timeout){
	return function(scope, element, attrs){
		if(scope.$last){
			$timeout(function(){
				$("#customer").DataTable();
				$("#board").DataTable();
				$("#room").DataTable();
				$("#reservation").DataTable();
			})
		}
	}
});
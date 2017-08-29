/**
 *  AngularJs 의 Ajax 통신을 이용한 아이디 중복체크
 */
angular.module("myApp", [])
.controller("Ctrl", function($scope, $http){
	$scope.canUse = false;
	$scope.checkId = {};
	$scope.getId = function(){
		console.log($scope.checkId);
		$http({
			url: "checkid.do",
			method: "get",
			params: $scope.checkId
		}).success(function(data){
			$scope.canUse = data.canUse;
			console.log($scope.canUse);
		})
	}
});
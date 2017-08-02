<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<script>
	alert("아이디 혹은 패스워드가 잘못되었습니다.");
	location.href = "signinform.do?url=${url}";
</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="UserController" method="post">
	<label for="username">用户名:</label>
	<input id="username" type="text" name="username"/><br/>
	<label for="password">密码:</label>
	<input id="password" type="password" name="password"/><br/>
	<label for="netname">网名:</label>
	<input id="netname" type="text" name="netname"/><br/>
	<label for="relname">真实姓名:</label>
	<input id="relname" type="text" name="relname"/><br/>
	<label>性别:</label>
	<input type="radio" name="gender" value="男"/>男
	<input type="radio" name="gender" value="女"/>女<br/>
	<label for="about">简介:</label>
	<textarea id="about" name="about"></textarea><br/>
	<input hidden="hidden" type="text" name="mod" value="4">
	<input type="submit" value="注册">

</form>
</body>

</html>
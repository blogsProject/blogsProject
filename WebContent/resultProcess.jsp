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
	<c:if test="${empty ret }">
		<script type="text/javascript">
			location = "index.jsp";
		</script>
	</c:if>
	<c:choose>
		<c:when test="${ret == 1 }">
			<script type="text/javascript">
				alert("注册成功");
				location = "index.jsp";
			</script>
		</c:when>
		<c:when test="${ret == 2 }">
			<script type="text/javascript">
				alert("密码错误");
				location = "index.jsp";
			</script>
		</c:when>
		<c:when test="${ret == 3 }">
			<script type="text/javascript">
				alert("登录成功");
				location = "index.jsp";
			</script>
		</c:when>
		<c:when test="${ret == 4 }">
			<script type="text/javascript">
				alert("请先登录");
				location = "index.jsp";
			</script>
		</c:when>
		<c:when test="${ret == 5 }">
			<script type="text/javascript">
				alert("请通过正确的方式,访问该页面。");
				location = "index.jsp";
			</script>
		</c:when>
		<c:when test="${ret == 5 }">
			<script type="text/javascript">
				alert("请上传正确格式的文件。");
				location = "index.jsp";
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert("服务器错误");
				location = "index.jsp";
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>
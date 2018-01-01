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
		<c:when test="${ret == 6 }">
			<script type="text/javascript">
				alert("请上传正确格式的文件。");
				location = "index.jsp";
			</script>
		</c:when>
		<c:when test="${ret == 7 }">
			<script type="text/javascript">
				alert("用户名不存在");
				location = "index.jsp";
			</script>
		</c:when>
		<c:when test="${ret == 8 }">
			<script type="text/javascript">
				alert("添加成功");
				location = "index.jsp";
			</script>
		</c:when>
		<c:when test="${ret == 9 }">
			<script type="text/javascript">
				alert("修改成功");
				location = "index.jsp";
			</script>
		</c:when>
		<c:when test="${ret == 10 }">
			<script type="text/javascript">
				alert("删除成功");
				location = "index.jsp";
			</script>
		</c:when>
	<c:when test="${ret == 11 }">
			<script type="text/javascript">
				alert("好友申请发送成功");
				location = "index.jsp";
			</script>
		</c:when>
		<c:when test="${ret == 12 }">
		<script type="text/javascript">
			alert("发表评论成功");
			location="LogController?flag=selectById&lid=${lid }&curpage=1";
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
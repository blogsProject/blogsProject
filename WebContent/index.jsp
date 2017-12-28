<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script src="js/jquery-2.2.4.min.js"></script>
<form name="hform" action="LogController" method="post">
<input type="hidden" name="curpage" value="1" />
<input type="hidden" name="flag" value="home" />
</form>
<script type="text/javascript">
document.hform.submit();
</script>
</body>
</html>
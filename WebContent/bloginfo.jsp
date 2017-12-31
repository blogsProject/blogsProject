<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Blog</title>
<meta name="description" content="Free Responsive Html5 Css3 Templates ">
<meta name="author" content="#">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1,user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="HandheldFriendly" content="true">

<script src="js/jquery.min.js"></script>
<link rel="stylesheet" href="css/zerogrid.css">
<link rel="stylesheet" href="css/style.css">
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link rel="stylesheet" href="css/menu.css">
<script src="js/jquery1111.min.js" type="text/javascript"></script>
<script src="js/script.js"></script>
<link href="owl-carousel/owl.carousel.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome-4.2.0/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<link rel="stylesheet" type="text/css" href="css/component.css" />
<link rel="stylesheet" type="text/css" href="css/normalize1.css" />
<link rel="stylesheet" type="text/css" href="css/demo1.css" />
<link rel="stylesheet" type="text/css" href="css/cs-select.css" />
<link rel="stylesheet" type="text/css" href="css/cs-skin-rotate.css" />
<link rel="stylesheet" type="text/css" href="css/htmleaf-demo.css">
<link rel="stylesheet" type="text/css" href="css/pretty.min.css">
<!-- ----- 
<script type="text/javascript">
<c:if test="${empty page}">
location="index.jsp";
</c:if>
</script>
-->
<style>
@media ( min-width : 1366px) {
	#contentid {
		background: #FFFFFF;
		position: absolute;
		margin-top: 30px;
		margin-left: 900px;
		width: 350px;
		height: 400px;
		max-height: 400px;
		max-width: 350px;
		border: 1px solid #CCC;
		border-radius: 10px;
		z-index: 999;
		padding: 5px;
	}
	#contentid2 {
		background: #FFFFFF;
		position: absolute;
		margin-top: 30px;
		margin-left: 900px;
		width: 350px;
		height: 900px;
		max-height: 900px;
		max-width: 350px;
		border: 1px solid #CCC;
		border-radius: 10px;
		z-index: 999;
		padding: 5px;
	}
	.rizhi {
		height: 100%;
		width: 700px;
		margin-left: 300px;
		text-align: left;
		padding-left: 90px;
		padding-top: 30px;
		padding-bottom: 40px;
		border: 1px solid #d1d1d1;
		border-radius: 10px;
	}
	.rizhi1 {
		margin-top: 20px;
		padding: 20px;
	}
	.news {
		margin-bottom: 20px;
	}
	.ph {
		height: 100%;
		width: 300px;
		margin-left: 1020px;
		text-align: left;
		padding-left: 90px;
		padding-top: 30px;
		padding-bottom: 40px;
		border: 1px solid #d1d1d1;
		border-radius: 10px;
	}
}

@media ( min-width : 1920px) {
	#contentid {
		background: #FFFFFF;
		position: absolute;
		margin-top: 30px;
		margin-left: 1400px;
		width: 350px;
		height: 400px;
		max-height: 400px;
		max-width: 350px;
		border: 1px solid #CCC;
		border-radius: 10px;
		z-index: 999;
		padding: 5px;
	}
	#contentid2 {
		background: #FFFFFF;
		position: absolute;
		margin-top: 30px;
		margin-left: 1400px;
		width: 350px;
		height: 900px;
		max-height: 900px;
		max-width: 350px;
		border: 1px solid #CCC;
		border-radius: 10px;
		z-index: 999;
		padding: 5px;
	}
	.login {
		z-index: 9999;
	}
	.rizhi {
		height: 100%;
		width: 800px;
		margin: 0 auto;
		text-align: left;
		padding-left: 90px;
		padding-top: 30px;
		padding-bottom: 40px;
		border: 1px solid #d1d1d1;
		border-radius: 10px;
	}
	.rizhi1 {
		margin-top: 20px;
		padding: 20px;
	}
	.news {
		margin-bottom: 20px;
	}
	.ph {
		height: 100%;
		width: 300px;
		margin-left: 1400px;
		text-align: left;
		padding-left: 90px;
		padding-top: 30px;
		padding-bottom: 40px;
		border: 1px solid #d1d1d1;
		border-radius: 10px;
	}
}

body {
	
}

#showtext {
	cursor: hand;
	cursor: pointer;
}
/**/
body {
	
}

#showtext {
	cursor: hand;
	cursor: pointer;
}

.none {
	display: none;
	　background: #FFFFFF;
}

.bootstrap-frm1 {
	margin-left: auto;
	margin-right: auto;
	height: 100%;
	width: 100%;
	background: #FFF;
	padding: 20px 30px 20px 30px;
	font: 12px "Helvetica Neue", Helvetica, Arial, sans-serif;
	color: #888;
	text-shadow: 1px 1px 1px #FFF;
	border: 1px solid #DDD;
	border-radius: 10px;
	-webkit-border-radius: 8px;
	-moz-border-radius: 8px;
}

.bootstrap-frm2 {
	margin-left: 110px;
	margin-top: 20px;
	height: 50px;
	width: 120px;
	background: #FFF;
	text-align: center;
	font: 18px "Helvetica Neue", Helvetica, Arial, sans-serif;
	color: #888;
	text-shadow: 1px 1px 1px #FFF;
	border: 1px solid #DDD;
	border-radius: 10px;
	-webkit-border-radius: 8px;
	-moz-border-radius: 8px;
}

input {
	width: 200px;
	height: 30px;
	padding: 5px;
	font-size: 15px;
}

input>submit {
	height: 40px;
}

input::-webkit-input-placeholder { /* WebKit browsers */
	　　color: #999;
	　　
}

　input:-moz-placeholder { /* Mozilla Firefox 4 to 18 */
	　　color: #999;
	　　
}

　　input::-moz-placeholder { /* Mozilla Firefox 19+ */
	　　color: #999;
	　　
}

　　input:-ms-input-placeholder { /* Internet Explorer 10+ */
	　　color: #999;
	　　
}
</style>
</head>

<body>
	<div class="wrap-body">
		<div id='cssmenu' class="align-center">
			<ul>
				<li class="active"><a href='index.jsp'><span>主页</span></a></li>

				<li class=' last'><a href='photo.jsp'><span>相册</span></a></li>
				<li class=' last'><a href='single.html'><span>文件柜</span></a></li>
				<li class='last'><a href="Musc.html"><span>音乐</span></a></li>
				<li class='last'><a href='single.jsp'><span>个人资料</span></a></li>

			</ul>
		</div>
		<section id="container">
			<div class="wrap-container">
				<div id="main-content">
					<!-- 日志 -->
					<div class="rizhi">
						<h3>${log.ltitle }</h3>
						<div style="margin-top: 50px;margin-bottom: 30px; ">
						<p style="font-size: 18px;">${log.lcontent }</p>
						<p style="font-size: 9px;margin-top: 30px;">${log.ltime }</p>
						</div>
						<c:forEach items="${replyList}" var="rep">
						<div>
							<h5>${rep.username }</h5>
								<div>
							<p style="font-size: 18px;">${rep.rcontent}</p>
							<p style="font-size: 9px;">${rep.rdatetime }</p>
							</div>
							</div>
						</c:forEach>
						
					</div>

				</div>

			</div>
			<!-- 分页 -->
			<c:choose>
				<c:when test="${page.curpage-1 <= 0 }"> 
 上一页
</c:when>
				<c:otherwise>
					<a href="LogController?flag=home&curpage=${page.curpage-1 }">上一页</a>
				</c:otherwise>
			</c:choose>
			|
			<c:choose>
				<c:when test="${page.curpage+1 >= page.allPage }"> 
 下一页
</c:when>
				<c:otherwise>
					<a href="LogController?flag=home&curpage=${page.curpage+1 }">下一页</a>
				</c:otherwise>
			</c:choose>
	</div>
	<script src="owl-carousel/owl.carousel.js"></script>
	<script>
		$(document)
				.ready(
						function() {
							$("#owl-slide")
									.owlCarousel(
											{
												autoPlay : 3000,
												items : 1,
												itemsDesktop : [ 1199, 1 ],
												itemsDesktopSmall : [ 979, 1 ],
												itemsTablet : [ 768, 1 ],
												itemsMobile : [ 479, 1 ],
												navigation : true,
												navigationText : [
														'<i class="fa fa-chevron-left fa-5x"></i>',
														'<i class="fa fa-chevron-right fa-5x"></i>' ],
												pagination : false
											});
						});
	</script>
	<script src="js/classie.js"></script>
	<script>
		(function() {

			if (!String.prototype.trim) {
				(function() {

					var rtrim = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g;
					String.prototype.trim = function() {
						return this.replace(rtrim, '');
					};
				})();
			}

			[].slice.call(document.querySelectorAll('input.input__field'))
					.forEach(function(inputEl) {

						if (inputEl.value.trim() !== '') {
							classie.add(inputEl.parentNode, 'input--filled');
						}

						inputEl.addEventListener('focus', onInputFocus);
						inputEl.addEventListener('blur', onInputBlur);
					});

			function onInputFocus(ev) {
				classie.add(ev.target.parentNode, 'input--filled');
			}

			function onInputBlur(ev) {
				if (ev.target.value.trim() === '') {
					classie.remove(ev.target.parentNode, 'input--filled');
				}
			}
		})();
	</script>
</body>
</html>
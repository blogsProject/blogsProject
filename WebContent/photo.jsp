<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>photo</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
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
<link rel="stylesheet" href="css/animate.css">
<link rel="stylesheet" href="css/magnific-popup.css">
<link rel="stylesheet" href="css/salvattore.css">
<link rel="stylesheet" href="css/photostyle.css">
<script src="js/modernizr-2.6.2.min.js"></script>
<script type="text/javascript">
	function showdiv(targetid, objN) {
		var target = document.getElementById(targetid);
		var clicktext = document.getElementById(objN)
		if (target.style.display == "block") {
			target.style.display = "none";
			clicktext.innerText = "登录";
		} else {
			target.style.display = "block";
			clicktext.innerText = '登录';
		}
	}
</script>
<c:if test="${empty flag }">
	<script type="text/javascript">
		alert("请先登录");
		location = "index.jsp";
	</script>
</c:if>
<style>
body {
	
}

#showtext {
	cursor: hand;
	cursor: pointer;
}

#contentid {
	background: #FFFFFF;
	position: absolute;
	margin-top: 60px;
	margin-left: 1500px;
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
	margin-top: 60px;
	margin-left: 1500px;
	width: 350px;
	height: 900px;
	border: 1px solid #CCC;
	border-radius: 10px;
	z-index: 999;
	padding: 5px;
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

.login {
	z-index: 9999;
}
</style>
</head>
<body>


	<div class="wrap-body">
		<div style="position: fixed; width: 100%" id='cssmenu'
			class="align-center">
			<ul>
				<li class="active"><a href='index.jsp'><span>主页</span></a></li>
				  <li class='last'><a href='FilesController?flag=photo'><span>相册</span></a></li>
   				  <li class='last'><a href='FilesController?flag=all'><span>文件柜</span></a></li>
    			  <li class='last'><a href="Musc.html"><span>音乐</span></a></li>
   				  <li class='last'><a href='UserController?flag=single'><span>个人资料</span></a></li>
					<c:if test="${!empty user }">
       <li class='last'  style="margin-right: 10px;margin-left: 160px;"><a id="showusername" ><span>${user.username }</span></a></li>
        <li class='last' style="margin-right: 50px;"><a id="shownetname" ><span>${user.netname }</span></a></li>
        <li class='last' style="margin-right: 50px;"><a href="UserController?flag=exit" id="exit" ><span>登出</span></a></li>
      </c:if>
			</ul>
		</div>

		<section id="container">
			<div class="wrap-container">
				<div id="main-content">


					<div id="fh5co-main">
						<div class="container">
							<div class="row">
								<div id="fh5co-board" data-columns>
									<c:forEach items="${plist }" var="plist">
										<div class="item">
											<div class="animate-box">
												<a href="upload/${plist.fpath }"
													class="image-popup fh5co-board-img"><img
													src="upload/${plist.fpath }"></a>
											</div>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>
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
																itemsDesktop : [
																		1199, 1 ],
																itemsDesktopSmall : [
																		979, 1 ],
																itemsTablet : [
																		768, 1 ],
																itemsMobile : [
																		479, 1 ],
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

							[].slice
									.call(
											document
													.querySelectorAll('input.input__field'))
									.forEach(
											function(inputEl) {

												if (inputEl.value.trim() !== '') {
													classie.add(
															inputEl.parentNode,
															'input--filled');
												}

												inputEl.addEventListener(
														'focus', onInputFocus);
												inputEl.addEventListener(
														'blur', onInputBlur);
											});

							function onInputFocus(ev) {
								classie.add(ev.target.parentNode,
										'input--filled');
							}

							function onInputBlur(ev) {
								if (ev.target.value.trim() === '') {
									classie.remove(ev.target.parentNode,
											'input--filled');
								}
							}
						})();
					</script>


































					<script src="js/jquery.min.js"></script>
					<script src="js/jquery.waypoints.min.js"></script>
					<script src="js/jquery.magnific-popup.min.js"></script>
					<script src="js/salvattore.min.js"></script>
					<script src="js/photomain.js"></script>
</body>
</html>

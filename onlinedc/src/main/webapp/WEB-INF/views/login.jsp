<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/static/css" />
<spring:url var="js" value="/static/js" />
<spring:url var="font" value="/static/font-awesome" />

<!DOCTYPE html>
<html ng-app="nglogin">

<head>

<style>
/* Center the loader */
#loader {
  position: absolute;
  left: 50%;
  top: 50%;
  z-index: 1;
  width: 50px;
  height: 50px;
  margin: -75px 0 0 -75px;
  border: 12px solid #E5E7E9;
  border-radius: 50%;
  border-top: 12px solid #0080FF;
  width: 80px;
  height: 80px;
  -webkit-animation: spin 1.4s linear infinite;
  animation: spin 1.4s linear infinite;
}

@-webkit-keyframes spin {
  0% { -webkit-transform: rotate(0deg); }
  100% { -webkit-transform: rotate(360deg); }
}

@keyframes spin {
  0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
}

/* Add animation to "page content" */
.animate-bottom {
  position: relative;
  -webkit-animation-name: animatebottom;
  -webkit-animation-duration: 1s;
  animation-name: animatebottom;
  animation-duration: 1s
}

@-webkit-keyframes animatebottom {
  from { bottom:-100px; opacity:0 } 
  to { bottom:0px; opacity:1 }
}

@keyframes animatebottom { 
  from{ bottom:-100px; opacity:0 } 
  to{ bottom:0; opacity:1 }
}

#content {
  display: none;
  text-align: left;
}
</style>



<meta charset=UTF-8>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- Page title set in pageTitle directive -->
<title page-title></title>

<!-- Font awesome -->
<link href="${font}/css/font-awesome.css" rel="stylesheet">

<!-- Bootstrap and Fonts -->
<link href="${css}/bootstrap/bootstrap.min.css" rel="stylesheet">

<!-- Main Inspinia CSS files -->
<link href="${css}/animate.css" rel="stylesheet">
<link href="${css}/plugins/iCheck/custom.css" rel="stylesheet">

<link href="${css}/style.css" rel="stylesheet">

</head>

<!-- ControllerAs syntax -->
<!-- Main controller with serveral data used in Inspinia theme on diferent view -->
<body onload="loadding()" ng-controller="LoginCtrl as main" style="background-color: #f3f3f4">

	<!-- Loadding -->
	<div id="loader"></div>
	
	<!-- Main view  -->
	<div style="display:none;" id="content" class="loginColumns animated fadeInDown">
		<div class="row">

			<div class="col-md-6">
				<h2 class="font-bold">Bienvenido a PROMETEO</h2>

				<p>Diseñado con el proposito de responder a las necesidades con
					eficiencia y calidad.</p>

				<p>Trasformado ideas.</p>

			</div>
			<div class="col-md-6">
				<div class="ibox-content">
					<c:url var="loginUrl" value="/login" />
					<form class="" role="form" action="${loginUrl}" method="post">
						<c:if test="${param.error != null}">
							<div class="alert-danger">
								<p class="text-center">¡Algo salió mal!</p>
							</div>
						</c:if>
						<c:if test="${param.logout != null}">
							<div class="alert-success">
								<p class="text-center">¡Nos vemos!</p>
							</div>
						</c:if>
						<div class="">
							<label for="username"><i></i></label> <input type="text"
								class="form-control" id="username" name="username"
								placeholder="Usuario" required>
						</div>
						<div class="form-group">
							<label for="password"><i></i></label> <input type="password"
								class="form-control" id="password" name="password"
								placeholder="Contraseña" required>
						</div>
						<div class="form-group">
							<input icheck type="checkbox" ng-model="loginctrl.checkOne"
								id="rememberme" name="remember-me"><i> </i> Recordar sesión						</div>
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<button type="submit" class="btn btn-primary block full-width m-b">Inicio</button>
						<p>
							<a href="#"> <small>¿No recuerdas la contraseña?</small>
							</a>
						</p>
						<!-- <p class="text-muted text-center">
							<small>¿No tienes cuenta?</small>
						</p>
						<a class="btn btn-sm btn-white btn-block" href="#">Crear una
							cuenta</a> -->
					</form>
					<p class="m-t">
						<small>Desarrollo Comercial</small>
					</p>
				</div>
			</div>
		</div>
		<hr />
		<div class="row">
			<div class="col-md-6">By @eloyus @alex @oty</div>
			<div class="col-md-6 text-right">
				<small>2017-2018</small>
			</div>
		</div>
	</div>
	
	<script>
		var myVar;
		
		function loadding() {
		    myVar = setTimeout(showPage, 1000);
		}
		
		function showPage() {
		  document.getElementById("loader").style.display = "none";
		  document.getElementById("content").style.display = "block";
		}
	</script>


	<!-- jQuery and Plugins -->
	<script src="${js}/jquery/jquery-3.1.1.min.js"></script>
	<script src="${js}/plugins/jquery-ui/jquery-ui.min.js"></script>
	<script src="${js}/plugins/iCheck/icheck.min.js"></script>

	<!-- Main Angular scripts-->
	<script src="${js}/angular/angular.min.js"></script>

	<!-- Custom -->
	<script src="${js}/login.js"></script>

</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<spring:url var="images" value="/static/images" />

<nav class="navbar-default navbar-static-side" role="navigation">
	<div class="sidebar-collapse">
		<ul side-navigation class="nav metismenu" id="side-menu">
			<li class="nav-header">

				<div class="profile-element" uib-dropdown>
					<!-- <img ui-sref="home.welcome" alt="image" class="img-circle"
						src="${images}/chick_2.png" /> -->
					<a uib-dropdown-toggle href=""> 
						<span class="clear"> <span class="block m-t-xs"> <strong
								class="font-bold">Prometeo</strong>
						</span> <span class="text-muted text-xs block">Opciones<b
								class="caret"></b>
						</span>
					</span>
					</a>
					<ul uib-dropdown-menu="" class="animated fadeInRight m-t-xs">
						<li><a href="<c:url value="/logout" />">Salir</a></li>
					</ul>
				</div>
				<div class="logo-element">DC</div>

			</li>
            <li ng-class="{active: $state.includes('content.avance_venta')}" ui-sref-active="active">
            	<a ui-sref="content.avance_venta">
            		<i class="fa fa-desktop"></i> 
            		<span class="nav-label">Avance de ventas</span>
            	</a>
            </li>
			<security:authorize access="hasAuthority('ROLE_ADMIN')">
			<li ng-class="{active: $state.includes('content.usuarios')}">
				<a href="#">
					<i class="fa fa-address-book"></i> 
					<span class="nav-label">Jerarquía</span>
					<span class="fa arrow"></span>
				</a>
				<ul class="nav nav-second-level collapse" ng-class="{in: $state.includes('content.usuarios')}">
					<li ui-sref-active="active"><a ui-sref="content.usuarios">Usuarios</a></li>
					<li ui-sref-active="active"><a ui-sref="#">Nuevo usuario</a></li>
				</ul>
			</li>
			</security:authorize>
		</ul>
	</div>
</nav>
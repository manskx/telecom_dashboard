<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Dashboard - TELE Control Egypt</title>
		<meta name="description" content="overview &amp; stats" />

		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

			<c:url var="assetspath" value="/static/assets/" />

		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="${assetspath}css/bootstrap.css" />
		<link rel="stylesheet" href="${assetspath}css/font-awesome.css" />


		<!-- text fonts -->

		<link rel="stylesheet" href="${assetspath}css/ace-fonts.css" />

		<!-- ace styles -->

		<link rel="stylesheet" href="${assetspath}css/ace.css" class="ace-main-stylesheet" id="main-ace-style" />

		<script src="${assetspath}js/jquery.js"> </script>

		<!-- ace scripts -->


		<!-- ace settings handler -->
		<script src="${assetspath}js/ace-extra.js"> </script>


	</head>



	<body class="no-skin">

		<!-- #section:basics/navbar.layout -->

		<div id="navbar" class="navbar navbar-default">

			<script type="text/javascript">

				try{ace.settings.check('navbar' , 'fixed')}catch(e){}

			</script>



			<div class="navbar-container" id="navbar-container">

				<!-- #section:basics/sidebar.mobile.toggle -->

				<button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">

					<span class="sr-only">Toggle sidebar</span>

					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>

				<!-- /section:basics/sidebar.mobile.toggle -->

				<div class="navbar-header pull-left">

					<!-- #section:basics/navbar.layout.brand -->

					<a href="#" class="navbar-brand">

						<small>

							<i class="fa fa-leaf"></i>

							TELE Control Egypt

						</small>

					</a>



					<!-- /section:basics/navbar.layout.brand -->


				</div>



				<!-- #section:basics/navbar.dropdown -->

				<div class="navbar-buttons navbar-header pull-right" role="navigation">

					<ul class="nav ace-nav">

						<!-- #section:basics/navbar.user_menu -->

						<li class="light-blue">

							<a data-toggle="dropdown" href="#" class="dropdown-toggle">

								<img class="nav-user-photo" src="${assetspath}avatars/user.jpg" alt="Jason's Photo" />

								<span class="user-info">

									<small>Welcome,</small>

									${loggedinuser.name}

								</span>



								<i class="ace-icon fa fa-caret-down"></i>

							</a>



							<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">

								<li>

									<a href="#">

										<i class="ace-icon fa fa-cog"></i>

										Settings

									</a>

								</li>





								<li class="divider"></li>



								<li>

									<a href="<c:url value='/logout' />">

										<i class="ace-icon fa fa-power-off"></i>

										Logout

									</a>

								</li>

							</ul>

						</li>



						<!-- /section:basics/navbar.user_menu -->

					</ul>

				</div>



				<!-- /section:basics/navbar.dropdown -->

			</div><!-- /.navbar-container -->

		</div>



		<!-- /section:basics/navbar.layout -->

		<div class="main-container" id="main-container">

			<script type="text/javascript">

				try{ace.settings.check('main-container' , 'fixed')}catch(e){}

			</script>



			<!-- #section:basics/sidebar -->

			<div id="sidebar" class="sidebar                  responsive">

				<script type="text/javascript">

					try{ace.settings.check('sidebar' , 'fixed')}catch(e){}

				</script>



				<ul class="nav nav-list">



					<li class="">

						

							<i class="menu-icon fa fa-tachometer"></i>

							<span class="menu-text"> Dashboard </span>

						



						<b class="arrow"></b>

					</li>

					
 			<sec:authorize access="hasRole('USER')">
					<li class="">

						<a href="<c:url value='/userdashboard/profile' />">

							<i class="menu-icon fa fa-picture-o"></i>

							<span class="menu-text"> Manage </span>

						</a>

						<b class="arrow"></b>

					</li>
					
					
					<li class="">

						<a href="<c:url value='/userdashboard/smscallpackage' />">

							<i class="menu-icon fa fa-picture-o"></i>

							<span class="menu-text"> SMS Calls Package </span>

						</a>

						<b class="arrow"></b>

					</li>
					
					
					<li class="">

						<a href="<c:url value='/userdashboard/internetpackage' />">

							<i class="menu-icon fa fa-picture-o"></i>

							<span class="menu-text"> Internet Package </span>

						</a>

						<b class="arrow"></b>

					</li>
					
					
					<li class="">

						<a href="<c:url value='/userdashboard/creditcharging' />">

							<i class="menu-icon fa fa-picture-o"></i>

							<span class="menu-text"> Credit Charging </span>

						</a>

						<b class="arrow"></b>

					</li>
	  </sec:authorize>
					
					
				</ul><!-- /.nav-list -->
			</div>

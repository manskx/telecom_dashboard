<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Login Page - TELE Control Egypt </title>
		<meta name="description" content="User login page" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="<c:url value='/static/assets/css/bootstrap.css' />" />

		<link rel="stylesheet" href="<c:url value='/static/assets/css/font-awesome.css' />" />

		<!-- text fonts -->

		<link rel="stylesheet" href="<c:url value='/static/assets/css/ace-fonts.css' />" />

		<!-- ace styles -->

		<link rel="stylesheet" href="<c:url value='/static/assets/css/ace.css' />" />

		<script src="<c:url value='/static/assets/js/jquery.js' />"> </script>

	</head>

	<body class="login-layout light-login">

		<div class="main-container">

			<div class="main-content">

				<div class="row">

					<div class="col-sm-10 col-sm-offset-1">

						<div class="login-container">

							<div class="center">

								<h1>

									<i class="ace-icon fa fa-leaf green"></i>

									<span class="red">Tele Control</span>

									<span class="white" id="id-text2">Egypt</span>

								</h1>

								<h4 class="blue" id="id-company-text">&copy; Dashboard Login</h4>

							</div>

							<div class="space-6"></div>

							<div class="position-relative">

								<div id="login-box" class="login-box <c:if test="${login==true}">visible</c:if> widget-box no-border">

									<div class="widget-body">

										<div class="widget-main">

											<h4 class="header blue lighter bigger">

												<i class="ace-icon fa fa-coffee green"></i>

												Please Enter Your Information

									<c:if test="${param.error != null}">
										<div class="alert alert-danger">
											<p>Invalid username and password.</p>
										</div>
									</c:if>
									<c:if test="${param.logout != null}">
										<div class="alert alert-success">
											<p>You have been logged out successfully.</p>
										</div>
									</c:if>
											</h4>

											<div class="space-6"></div>

						<c:url var="loginUrl" value="/login" />
						<form action="${loginUrl}" method="post" class="form-horizontal">

												<fieldset>

													<label class="block clearfix">

														<span class="block input-icon input-icon-right">

															<input id="username" name="phoneID" type="text" class="form-control" placeholder="Your Phone Number" required>

															<i class="ace-icon fa fa-user"></i>

														</span>

													</label>

													<label class="block clearfix">

														<span class="block input-icon input-icon-right">

															<input name="password" type="password" class="form-control" placeholder="Enter Password" required>

															<i class="ace-icon fa fa-lock"></i>

														</span>

													</label>
													
													<div class="input-group input-sm">
													  <div class="checkbox">
														<label><input type="checkbox" id="rememberme" name="remember-me"> Remember Me</label>  
													  </div>
													</div>
													<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />

													<div class="space"></div>

													<div class="clearfix">

														<button type="submit" class="width-35 pull-right btn btn-sm btn-primary"  value="Log in" >

															<i class="ace-icon fa fa-key"></i>

															<span class="bigger-110">Login</span>

														</button>

													</div>


													<div class="space-4"></div>

												</fieldset>

											</form>


											<div class="space-6"></div>


										</div><!-- /.widget-main -->



										<div class="toolbar clearfix">

											<div>

												<a href="#" data-target="#forgot-box" class="forgot-password-link">

													<i class="ace-icon fa fa-arrow-left"></i>

													forgot password

												</a>

											</div>

											<div>
												<a href="#" data-target="#signup-box" class="user-signup-link">
													I want to register
													<i class="ace-icon fa fa-arrow-right"></i>
												</a>
											</div>

											

										</div>

									</div><!-- /.widget-body -->

								</div><!-- /.login-box -->



								<div id="forgot-box" class="forgot-box widget-box <c:if test="${lostpass==true}">visible</c:if>  no-border">

									<div class="widget-body">

										<div class="widget-main">

									<c:if test="${lostpass_error == true}">
										<div class="alert alert-danger">
											<p>Your Email and/or answer are not valid</p>
										</div>
									</c:if>
									<c:if test="${lostpass_success == true}">
										<div class="alert alert-success">
											<p>${success}</p>
											<p> You temporary new password is ${NewPassword} </p>
										</div>
									</c:if>
											<h4 class="header red lighter bigger">

												<i class="ace-icon fa fa-key"></i>

												Retrieve Password

											</h4>



											<div class="space-6"></div>

											<p>

												Enter your email and Answer you question to receive instructions

											</p>


											<c:url var="lostpasswordUrl" value="/lostpassword" />
											<form action="${lostpasswordUrl}" method="post" class="form-horizontal">

												<fieldset>
													<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
													<label class="block clearfix">

														<span class="block input-icon input-icon-right">

															<input name="email" type="email" class="form-control" placeholder="Email" />

															<i class="ace-icon fa fa-envelope"></i>

														</span>

													</label>
													
													<label class="block clearfix"> What is your first cell phone? (If you forget your password)
													<span class="block input-icon input-icon-right">
															<input name="lostpassanswer" id="lostpassanswer" type="text" class="form-control" placeholder="Answer" />
															<i class="ace-icon fa  fa-info-circle"></i>
														</span>
														<div class="has-error">
															<b class="red"><form:errors path="lostpassanswer" class="help-inline"/></b>
														</div>
													</label>

													<div class="clearfix">

														<button type="submit" class="width-35 pull-right btn btn-sm btn-danger">

															<i class="ace-icon fa fa-lightbulb-o"></i>

															<span class="bigger-110">Retrieve !</span>

														</button>

													</div>

												</fieldset>

											</form>

										</div><!-- /.widget-main -->



										<div class="toolbar center">

											<a href="#" data-target="#login-box" class="back-to-login-link">

												Back to login

												<i class="ace-icon fa fa-arrow-right"></i>

											</a>

										</div>

									</div><!-- /.widget-body -->

								</div><!-- /.forgot-box -->
								<div id="signup-box" class=" <c:if test="${reg==true}">visible</c:if> signup-box widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header green lighter bigger">
												<i class="ace-icon fa fa-users blue"></i>
												New User Registration
											</h4>
											<c:if test="${reg_success==true}">
												<div class="alert alert-success">
													<p>You registered successfully. you can login now.</p>
												</div>
											</c:if>
											<div class="space-6"></div>
											<p> Enter your details to begin: </p>

											<c:url var="regformUrl" value="/registration" />
											<form:form  modelAttribute="user" action="${regformUrl}"  onsubmit="return myPasswordCheck()" method="post" class="form-horizontal">
												<form:input type="hidden" path="id" id="id"/>
												<form:input type="hidden" name="credit" path="credit" id="credit" value="0"/>
												
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<form:input path="name" id="name" type="text" class="form-control" placeholder="Full Name" />
															<i class="ace-icon fa fa-user"></i>
														</span>
														<div class="has-error">
														<b class="red">	<form:errors path="name" class="help-inline"/></b>
														</div>
													</label>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<form:input path="phoneID" id="phoneID" type="text" class="form-control" placeholder="Phone Number" />
															<i class="ace-icon fa fa-phone"></i>
														</span>
														<div class="has-error">
														<b class="red">	<form:errors path="phoneID" class="help-inline"/></b>
														</div>
													</label>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<form:input path="email" id="email" type="email" class="form-control" placeholder="Email" />
															<i class="ace-icon fa fa-envelope"></i>
														</span>
														<div class="has-error">
															<b class="red"><form:errors path="email" class="help-inline"/></b>
														</div>
													</label>

													

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<form:input path="password" id="password" type="password" class="form-control" placeholder="Password" />
															<i class="ace-icon fa fa-lock"></i>
														</span>
														<div class="has-error">
														<b class="red">	<form:errors path="password" class="help-inline"/></b>
														</div>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input  path="password2" id="password2"  type="password" class="form-control" placeholder="Repeat password" />
															<i class="ace-icon fa fa-retweet"></i>
														</span>
													</label>
													
												<label class="block clearfix"> What is your first cell phone? (If you forget your password)
													<span class="block input-icon input-icon-right">
															<form:input path="lostpassanswer" id="lostpassanswer" type="text" class="form-control" placeholder="Answer" />
															<i class="ace-icon fa  fa-info-circle"></i>
														</span>
														<div class="has-error">
															<b class="red"><form:errors path="lostpassanswer" class="help-inline"/></b>
														</div>
													</label>

													<label class="block">
														<input type="checkbox" class="ace" />
														<span class="lbl">
															I accept the
															<a href="#">User Agreement</a>
														</span>
													</label>
													<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
													<input type="hidden" name="type"  value="USER" />
													<input type="hidden" name="reg_date"  value="today" />

													<div class="space-24"></div>

													<div class="clearfix">
														<button type="reset" class="width-30 pull-left btn btn-sm">
															<i class="ace-icon fa fa-refresh"></i>
															<span class="bigger-110">Reset</span>
														</button>

														<button type="submit" value="Register" class="width-65 pull-right btn btn-sm btn-success">
															<span class="bigger-110">Register</span>

															<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
														</button>
													</div>
												</fieldset>
											</form:form>
										</div>

										<div class="toolbar center">
											<a href="#" data-target="#login-box" class="back-to-login-link">
												<i class="ace-icon fa fa-arrow-left"></i>
												Back to login
											</a>
										</div>
									</div><!-- /.widget-body -->
								</div><!-- /.signup-box -->
	

							</div><!-- /.position-relative -->



							

						</div>

					</div><!-- /.col -->

				</div><!-- /.row -->

			</div><!-- /.main-content -->

		</div><!-- /.main-container -->



		<!-- basic scripts -->





		<!-- <![endif]-->





<![endif]-->

		<script type="text/javascript">


		
			if('ontouchstart' in document.documentElement) document.write("<script src='<?php echo base_url();?>include/assets/js/jquery.mobile.custom.js'>"+"<"+"/script>");

		</script>



		<!-- inline scripts related to this page -->

		<script type="text/javascript">
		function myPasswordCheck() {
		    var pass1 = document.getElementById("password").value;
		    var pass2 = document.getElementById("password2").value;
		    var ok = true;
		    if ((pass1 != pass2)||(pass1.length<6)) {
		        alert("Passwords Do not match or less than 6 charachters");
		        document.getElementById("password").style.borderColor = "#E34234";
		        document.getElementById("password2").style.borderColor = "#E34234";
		        ok = false;
		    }

		    return ok;
		}
		
		
			jQuery(function($) {

			 $(document).on('click', '.toolbar a[data-target]', function(e) {

				e.preventDefault();

				var target = $(this).data('target');

				$('.widget-box.visible').removeClass('visible');//hide others

				$(target).addClass('visible');//show target

			 });

			});

			

			



		</script>

	</body>

</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="header_sidebar.jsp" %>	
<c:url var="assetspath" value="/static/assets/" />
			<!-- /section:basics/sidebar -->

			<div class="main-content">

				<div class="main-content-inner">

					<!-- #section:basics/content.breadcrumbs -->

					<div class="breadcrumbs" id="breadcrumbs">

						<script type="text/javascript">

							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}

						</script>



						<ul class="breadcrumb">

							<li>

								<i class="ace-icon fa fa-home home-icon"></i>

								<a href="#">Home</a>

							</li>

							<li class="active">Dashboard</li>

						</ul><!-- /.breadcrumb -->





					</div>



					<!-- /section:basics/content.breadcrumbs -->

					<div class="page-content">

						<!-- #section:settings.box -->

						
					
					<div class="row">
									<div class="col-sm-10 col-sm-offset-1">
										<!-- #section:pages/invoice -->
										<div class="widget-box transparent">
											<div class="widget-header widget-header-large">
												<h3 class="widget-title grey lighter">
													<i class="ace-icon fa fa-leaf green"></i>
													Your Current SmsCall Package
												</h3>

												<!-- #section:pages/invoice.info -->
												<div class="widget-toolbar no-border invoice-info">
													<span class="invoice-info-label">ID:</span>
													<span class="red">#${CurrentSubscribtion.id}</span>

													<br>
													<span class="invoice-info-label">Date:</span>
													<span class="blue">${CurrentSubscribtion.regDate}</span>
												</div>

												

												<!-- /section:pages/invoice.info -->
											</div>

											<div class="widget-body">
												<div class="widget-main padding-24">
													<div class="row">
														<div class="col-sm-6">
															<div class="row">
																<div class="col-xs-11 label label-lg label-info arrowed-in arrowed-right">
																	<b>Package Info</b>
																</div>
															</div>
<c:if test="${activeiservice != null}">
															<div>
																<ul class="list-unstyled spaced">
																	<li>
																		<i class="ace-icon fa fa-caret-right blue"></i>Name
																		<b class="red"> ${activeiservice.name}</b>
																	</li>

																	<li>
																		<i class="ace-icon fa fa-caret-right blue"></i>Fees
																		<b class="red">${activeiservice.fees}</b>
																	</li>

																	<li>
																		<i class="ace-icon fa fa-caret-right blue"></i>SMS
																		<b class="red">${activeiservice.sms}</b>
																	</li>
																	<li>
																		<i class="ace-icon fa fa-caret-right blue"></i>Minutes
																		<b class="red">${activeiservice.call}</b>
																	</li>

																	<li>
																		<i class="ace-icon fa fa-caret-right blue"></i>
																			Description
																		<b class="red">${activeiservice.des}</b>
																	</li>

																	

																	<li>
																		<i class="ace-icon fa fa-caret-right blue"></i>
																			Duration
																		<b class="red">${activeiservice.duration}</b>
																	</li>
																	<div>
														<a href="<c:url value='/userdashboard/smsCallpackage-unsubscribe-${CurrentSubscribtion.id}' />" class="btn btn-block btn-sm btn-danger">
															<span>UnSubscribe</span>
														</a>
													</div>
																</ul>
															</div>
															</c:if>
														</div><!-- /.col -->

			
													</div><!-- /.row -->

													<div class="space"></div>

				

													<div class="hr hr8 hr-double hr-dotted"></div>


													<div class="space-6"></div>
													
													<div class="row">
									<!-- #section:pages/pricing.small-header -->
									<div class="col-xs-4 col-sm-3 pricing-span-header">
										<div class="widget-box transparent">
											<div class="widget-header">
												<h5 class="widget-title bigger lighter">Package Name</h5>
											</div>

											<div class="widget-body">
												<div class="widget-main no-padding">
													<ul class="list-unstyled list-striped pricing-table-header">
														<li>SMS </li>
														<li>Minutes </li>
														<li>Description </li>
														<li>Duration </li>
													</ul>
												</div>
											</div>
										</div>
									</div>

									<!-- /section:pages/pricing.small-header -->

									<!-- #section:pages/pricing.small-body -->
									<div class="col-xs-8 col-sm-9 pricing-span-body">
									<c:forEach items="${iservices}" var="iservice">
										<div class="pricing-span">
											<div class="widget-box pricing-box-small  widget-color-green">
												<div class="widget-header">
													<h5 class="widget-title bigger lighter">${iservice.name}</h5>
												</div>

												<div class="widget-body">
													<div class="widget-main no-padding">
														<ul class="list-unstyled list-striped pricing-table">
															<li> ${iservice.sms} SMS</li>
															<li> ${iservice.call} Minutes</li>
															<li> ${iservice.des} </li>
															<li> ${iservice.duration} Days</li>
															
														</ul>

														<div class="price">
															<span class="label label-lg label-inverse arrowed-in arrowed-in-right">
																${iservice.fees} LE
																<small>/month</small>
															</span>
														</div>
													</div>

													<div>
														<a href="<c:url value='/userdashboard/smsCallpackage-subscribe-${iservice.id}' />" class="btn btn-block btn-sm btn-success">
															<span>Subscribe</span>
														</a>
													</div>
												</div>
											</div>
										</div>
</c:forEach>
	
									</div>

									<!-- /section:pages/pricing.small-body -->
								</div>

												</div>
											</div>
										</div>

										<!-- /section:pages/invoice -->
									</div>
								</div>
								
					</div><!-- /.page-content -->

				</div>

			</div><!-- /.main-content -->



<%@include file="footer.jsp" %>	



			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">

				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>

			</a>

		</div><!-- /.main-container -->



		<!-- basic scripts -->



		<script src="${assetspath}js/bootstrap.js"></script>



		<!-- page specific plugin scripts -->


		<script src="${assetspath}js/jquery-ui.custom.js"></script>

		<script src="${assetspath}js/jquery.ui.touch-punch.js"></script>

		<script src="${assetspath}js/jquery.easypiechart.js"></script>

		<script src="${assetspath}js/jquery.sparkline.js"></script>

		<script src="${assetspath}js/flot/jquery.flot.js"></script>

		<script src="${assetspath}js/flot/jquery.flot.pie.js"></script>

		<script src="${assetspath}/js/flot/jquery.flot.resize.js"></script>
		


		<script src="${assetspath}js/jquery-ui.custom.js"></script>

		<script src="${assetspath}js/jquery.ui.touch-punch.js"></script>

		<script src="${assetspath}js/jquery.easypiechart.js"></script>

		<script src="${assetspath}js/jquery.sparkline.js"></script>

		<script src="${assetspath}js/flot/jquery.flot.js"></script>

		<script src="${assetspath}js/flot/jquery.flot.pie.js"></script>

		<script src="${assetspath}js/flot/jquery.flot.resize.js"></script>



		<!-- ace scripts -->

		<script src="${assetspath}js/ace/elements.scroller.js"></script>

		<script src="${assetspath}js/ace/elements.colorpicker.js"></script>

		<script src="${assetspath}js/ace/elements.fileinput.js"></script>

		<script src="${assetspath}js/ace/elements.typeahead.js"></script>

		<script src="${assetspath}js/ace/elements.wysiwyg.js"></script>

		<script src="${assetspath}js/ace/elements.spinner.js"></script>

		<script src="${assetspath}js/ace/elements.treeview.js"></script>

		<script src="${assetspath}js/ace/elements.wizard.js"></script>

		<script src="${assetspath}js/ace/elements.aside.js"></script>

		<script src="${assetspath}js/ace/ace.js"></script>

		<script src="${assetspath}js/ace/ace.ajax-content.js"></script>

		<script src="${assetspath}js/ace/ace.touch-drag.js"></script>

		<script src="${assetspath}js/ace/ace.sidebar.js"></script>

		<script src="${assetspath}js/ace/ace.sidebar-scroll-1.js"></script>

		<script src="${assetspath}js/ace/ace.submenu-hover.js"></script>

		<script src="${assetspath}js/ace/ace.widget-box.js"></script>

		<script src="${assetspath}js/ace/ace.settings.js"></script>

		<script src="${assetspath}js/ace/ace.settings-rtl.js"></script>

		<script src="${assetspath}js/ace/ace.settings-skin.js"></script>

		<script src="${assetspath}js/ace/ace.widget-on-reload.js"></script>

		<script src="${assetspath}js/ace/ace.searchbox-autocomplete.js"></script>

		



		<!-- inline scripts related to this page -->

		<script type="text/javascript">

			jQuery(function($) {



				//Android's default browser somehow is confused when tapping on label which will lead to dragging the task

				//so disable dragging when clicking on label

				var agent = navigator.userAgent.toLowerCase();

				if("ontouchstart" in document && /applewebkit/.test(agent) && /android/.test(agent))

				  $('#tasks').on('touchstart', function(e){

					var li = $(e.target).closest('#tasks li');

					if(li.length == 0)return;

					var label = li.find('label.inline').get(0);

					if(label == e.target || $.contains(label, e.target)) e.stopImmediatePropagation() ;

				});

		
			

				//show the dropdowns on top or bottom depending on window height and menu position

				$('#task-tab .dropdown-hover').on('mouseenter', function(e) {

					var offset = $(this).offset();

			

					var $w = $(window)

					if (offset.top > $w.scrollTop() + $w.innerHeight() - 100) 

						$(this).addClass('dropup');

					else $(this).removeClass('dropup');

				});

			

			})

		</script>
	<!-- the following scripts are used in demo only for onpage help and you don't need them -->

		<link rel="stylesheet" href="${assetspath}css/ace.onpage-help.css" />




		<script type="text/javascript"> ace.vars['base'] = '..'; </script>

		<script src="${assetspath}js/ace/elements.onpage-help.js"></script>

		<script src="${assetspath}js/ace/ace.onpage-help.js"></script>



	</body>

</html>


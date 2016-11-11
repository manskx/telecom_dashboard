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

						Your Credit :
						
					${loggedinuser.credit}
					</br>
					Your Name :
						
					${loggedinuser.name}
					</br>
					Your Mobile number :
						
					${loggedinuser.phoneID}
					</br>
					Your Email: 
						
					${loggedinuser.email}
		<sec:authorize access="hasRole('ADMIN')">
				<div class="panel panel-default">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead">List of Users </span></div>
			<table class="table table-hover">
	    		<thead>
		      		<tr>
				        <th>name</th>
				        <th>phoneID</th>
				        <th>Email</th>
				        <th>RegDate</th>
				        
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<td>${user.name}</td>
						<td>${user.phoneID}</td>
						<td>${user.email}</td>
						<td>${user.regDate}</td>

					</tr>
				</c:forEach>
	    		</tbody>
	    	</table>
		</div>
				
			<a href="<c:url value='/admindashboard/generatecreditcharging' />" class="btn btn-block btn-sm ">
						<span>Generate Credit Charging Cards</span>
			</a>
				<div class="panel panel-default">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead">List of Charge Credit Cards </span></div>
			<table class="table table-hover">
	    		<thead>
		      		<tr>
				        <th>code</th>
				        <th>value</th>
				        <th>used</th>
				        
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${cards}" var="card">
					<tr>
						<td>${card.code}</td>
						<td>${card.value}</td>
						<td>${card.used}</td>

					</tr>
				</c:forEach>
	    		</tbody>
	    	</table>
		</div>
			
					
	 	 </sec:authorize>
					
					
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


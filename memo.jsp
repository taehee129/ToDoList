<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
	
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Regal Admin</title>
<!-- base:css -->
<link rel="stylesheet"
	href="vendors/mdi/css/materialdesignicons.min.css">
<link rel="stylesheet" href="vendors/feather/feather.css">
<link rel="stylesheet" href="vendors/base/vendor.bundle.base.css">
<!-- endinject -->
<!-- plugin css for this page -->
<link rel="stylesheet" href="vendors/select2/select2.min.css">
<link rel="stylesheet"
	href="vendors/select2-bootstrap-theme/select2-bootstrap.min.css">
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet" href="css/style.css">
<!-- endinject -->
<link rel="shortcut icon" href="images/favicon.png" />
<style type="text/css">
.submitButton  {
	margin-top: 10px;
	float: right;
	display: none;
}
.updateButton {
	margin-top: 10px;
	float: right;
	display: none;
}
</style>


</head>

<body>
	<div class="container-scroller">
		<!-- partial:partials/_navbar.html -->
		<nav class="navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
			<div
				class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
				<a class="navbar-brand brand-logo" href="index.html"><img
					src="images/logo.svg" alt="logo" /></a> <a
					class="navbar-brand brand-logo-mini" href="index.html"><img
					src="images/logo-mini.svg" alt="logo" /></a>
			</div>
			<div
				class="navbar-menu-wrapper d-flex align-items-center justify-content-end">
				<button class="navbar-toggler navbar-toggler align-self-center"
					type="button" data-toggle="minimize">
					<span class="icon-menu"></span>
				</button>
				<ul class="navbar-nav mr-lg-2">
					
				</ul>
				<ul class="navbar-nav navbar-nav-right">
					<li class="nav-item dropdown d-lg-flex d-none">
						<button type="button" class="btn btn-info font-weight-bold"
							id="createMemo" onclick="createMemo()">+ Create New MeMo</button>
					</li>
					
				</ul>
				<button
					class="navbar-toggler navbar-toggler-right d-lg-none align-self-center"
					type="button" data-toggle="offcanvas">
					<span class="icon-menu"></span>
				</button>
			</div>
		</nav>
		<!-- partial -->
		<div class="container-fluid page-body-wrapper">
			<!-- partial:partials/_sidebar.html -->
			<nav class="sidebar sidebar-offcanvas" id="sidebar">
				
				<ul class="nav">
					<li class="nav-item"><a class="nav-link" href="main.do">
							<i class="icon-box menu-icon"></i> <span class="menu-title">ToDo-List</span>
					</a></li>
					
				</ul>
			</nav>
			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper">
					<div class="row">
   	                   <c:forEach var="memo" items="${memoList}">
						<div class="col-md-6 grid-margin stretch-card">
							<div class="card">
								<div class="card-body">
									<h4 class="card-title">Memo</h4>
									
									
								
									<form class="forms-sample">
								
									<input type="hidden" name="id" value ="${memo.id}">
										<div class="form-group">
											 <input
												type="text" class="form-control text" id="exampleInputUsername1" name="title" 
												value="${memo.title}"placeholder="Title">
										</div>
										<div class="form-group">
												 <input
												type="text" class="form-control text" id="exampleInputEmail1" name="content"
												value="${memo.content}"placeholder="Content">
										</div>

										<button type="button"
											class="btn btn-primary mr-2 updateButton">Submit</button>
										<button type ="button"class="btn btn-inverse-primary btn-fw deleteButton">Delete</button>
									</form>
								

								</div>
							</div>
						</div>
					</c:forEach>	
<!-- 메모 섹션 ---------------- -->
					</div>
				</div>
				<!-- content-wrapper ends -->
				<!-- partial:partials/_footer.html -->
				<footer class="footer">
					<div
						class="d-sm-flex justify-content-center justify-content-sm-between">
						<span
							class="text-muted d-block text-center text-sm-left d-sm-inline-block">Copyright
							© bootstrapdash.com 2020</span> <span
							class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center">
							Free <a href="https://www.bootstrapdash.com/" target="_blank">Bootstrap
								dashboard templates</a> from Bootstrapdash.com
						</span>
					</div>
				</footer>
				<!-- partial -->
			</div>
			<!-- main-panel ends -->
		</div>
		<!-- page-body-wrapper ends -->
	</div>
	<!-- container-scroller -->
	<!-- base:js -->
	<script src="vendors/base/vendor.bundle.base.js"></script>
	<!-- endinject -->
	<!-- inject:js -->
	<script src="js/off-canvas.js"></script>
	<script src="js/hoverable-collapse.js"></script>
	<script src="js/template.js"></script>
	<!-- endinject -->
	<!-- plugin js for this page -->
	<script src="vendors/typeahead.js/typeahead.bundle.min.js"></script>
	<script src="vendors/select2/select2.min.js"></script>
	<!-- End plugin js for this page -->
	<!-- Custom js for this page-->
	<script src="js/file-upload.js"></script>
	<script src="js/typeahead.js"></script>
	<script src="js/select2.js"></script>
	<script src="jquery-3.6.0.min.js"></script>
	<script type="text/javascript">
  
 function createMemo(){ 
	 console.log("확인");
  var memo =   		'	<div class="col-md-6 grid-margin stretch-card">'
	+'<div class="card">'
	+'<div class="card-body">'
	+'	<h4 class="card-title">Input size</h4>'
	
	+'	<form class="forms-sample">'
		+	'<div class="form-group">'
		+	'	 <input'
			+	'	type="text" class="form-control text" name="title" '
			+	'	placeholder="Title">'
		+'	</div>'
	+	'	<div class="form-group">'
			+		' <input '
			+		'type="text" class="form-control text" name="content"'
			+		'placeholder="Context">'
		+'	</div>'

	+	'	<button type="button"'
		+	'	class="btn btn-primary mr-2 submitButton">Submit</button>'
		
		+'</form>'
	

	+'</div>'
+'</div>'
+'</div>';


$(".row").append(memo);}

$(document).on("keyup", '.text' ,function(){
	
	if($(this).val() == ''){
		$(this).parents(".forms-sample").find(".submitButton").css("display", "none");
		$(this).parents(".forms-sample").find(".updateButton").css("display", "none");
		console.log("빈 값");
		
	}else {	$(this).parents(".forms-sample").find(".submitButton").css("display", "block");
	$(this).parents(".forms-sample").find(".updateButton").css("display", "block");
	console.log("확인");
	}

	
});

$(document).on("click", '.submitButton', function(){
	
	console.log("ajax 시작");
	var btn = $(this)
	$.ajax({
		url : "insertMemo.do",
		type: "POST",
		data : $(this).parents(".forms-sample").serialize(),
		success : function(data){
			btn.addClass("updateButton");
			btn.removeClass("submitButton");
			console.log("입력받은 id : "+data);
			btn.parents(".forms-sample").append("<input type='hidden' name='id' value='"+data+"'>");
			btn.parents(".forms-sample").append('<button type ="button"class="btn btn-inverse-primary btn-fw deleteButton">Delete</button>');
			alert("메모 입력 완료!");
		},
		error : function(){
			alert("입력 실패!");
		}
		
		
	});
	
	
});

$(document).on("click", '.updateButton', function(){
	
	console.log("ajax 시작");
	var btn = $(this)
	$.ajax({
		url : "updateMemo.do",
		type: "POST",
		data : $(this).parents(".forms-sample").serialize(),
		success : function(data){
			
			
			alert("메모 수정 완료!");
		},
		error : function(){
			alert("수정 실패!");
		}
		
		
	});
	
	
});

$(document).on("click", '.deleteButton', function(){
	var id = $(this).siblings("input[name='id']").val();
	var memoSection = $(this).parents(".col-md-6");


	
	$.ajax({
		url : "deleteMemo.do?id="+id,
		type : "GET",
		success : function(data){
			memoSection.remove();
			alert("삭제 완료!");
			
		},
		error : function(){
			alert("삭제 실패!");
		}
		
	});
	
});
	

	



  
  </script>
	<!-- End custom js for this page-->
</body>

</html>

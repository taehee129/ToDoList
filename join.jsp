<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Regal Admin</title>
  <!-- base:css -->
  <link rel="stylesheet" href="vendors/mdi/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="vendors/feather/feather.css">
  <link rel="stylesheet" href="vendors/base/vendor.bundle.base.css">
  <!-- endinject -->
  <!-- plugin css for this page -->
  <!-- End plugin css for this page -->
  <!-- inject:css -->
  <link rel="stylesheet" href="css/style.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="images/favicon.png" />
</head>

<body>
  <div class="container-scroller">
    <div class="container-fluid page-body-wrapper full-page-wrapper">
      <div class="content-wrapper d-flex align-items-stretch auth auth-img-bg">
        <div class="row flex-grow">
          <div class="col-lg-6 d-flex align-items-center justify-content-center">
            <div class="auth-form-transparent text-left p-3">
              <div class="brand-logo">
                <img src="images/logo-dark.svg" alt="logo">
              </div>
              <h4>New here?</h4>
              <h6 class="font-weight-light">Join us today! It takes only few steps</h6>
              <form class="pt-3" action="join.do" method="post" id="insertForm"> 
                <div class="form-group">
                  <label>이름</label>
                  <div class="input-group">
                    <div class="input-group-prepend bg-transparent">
                      <span class="input-group-text bg-transparent border-right-0">
                        <i class="mdi mdi-account-outline text-primary"></i>
                      </span>
                    </div>
                    <input type="text" class="form-control form-control-lg border-left-0" placeholder="이름" name="name" value="${user.name}">
                  </div>
                </div>
                <div class="form-group">
                  <label>id</label>
                  <div class="input-group">
                    <div class="input-group-prepend bg-transparent">
                      <span class="input-group-text bg-transparent border-right-0">
                        <i class="mdi mdi-email-outline text-primary"></i>
                      </span>
                    </div>
                    
                    <input type="text" class="form-control form-control-lg border-left-0" placeholder="ID" name="id"<c:if test="${param.profilePage ne null}">value="${user.id}" readonly</c:if>   >
                  </div>
                </div>
               
                <div class="form-group">
                  <label>Password</label>
                  <div class="input-group">
                    <div class="input-group-prepend bg-transparent">
                      <span class="input-group-text bg-transparent border-right-0">
                        <i class="mdi mdi-lock-outline text-primary"></i>
                      </span>
                    </div>
                    <input type="password" class="form-control form-control-lg border-left-0" id="exampleInputPassword" placeholder="Password" name="password" value="${user.password}">                        
                  </div>
                </div>
         		<c:choose>
                <c:when test="${param.profilePage eq null}">
                <div class="mt-3">
                  <input type="submit" class="btn btn-block btn-info btn-lg font-weight-medium auth-form-btn" value="Sing Up">
                </div>
                </c:when>
                <c:otherwise>
                  <div class="mt-3">
                  <input type="button" class="btn btn-block btn-info btn-lg font-weight-medium auth-form-btn" onclick="changeAction()" value="수정하기">
                  <button   class="btn btn-block btn-info btn-lg font-weight-medium auth-form-btn" onclick="deleteMember()">삭제하기</button>
                </div>
                </c:otherwise>
                </c:choose>
    
                <div class="text-center mt-4 font-weight-light">
                  Already have an account? <a href="index.jsp" class="text-primary">Login</a>
                </div>
      
              </form>
            </div>
          </div>
          <div class="col-lg-6 register-half-bg d-flex flex-row">
            <p class="text-white font-weight-medium text-center flex-grow align-self-end">Copyright &copy; 2020  All rights reserved.</p>
          </div>
        </div>
      </div>
      <!-- content-wrapper ends -->
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
 <script src="jquery-3.6.0.min.js"></script>
  <script type="text/javascript">
 	function changeAction(){
 		
 		$("#insertForm").attr("action", "updateMember.do");
 		$("#insertForm").submit();
 	}
  	function deleteMember(){
  		var isDelete = confirm("회원 탈퇴 하시겠습니까?")
  		if(isDelete){
  		$("#insertForm").attr("action", "deleteMember.do");
 		$("#insertForm").submit();
  		}
  	}
 	
  </script>
  <!-- endinject -->
</body>

</html>

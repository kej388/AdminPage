<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.0.1">
    <title>eunjinkoh-Movie</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/dashboard/">

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <script src="js/jquery.js"></script>
    <script src="js/script.js"></script>

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="css/dashboard.css" rel="stylesheet">
    <link rel="stylesheet" href="css/shopping.css">
</head>
<body>
	<!-- header------------------------------ -->
  	<jsp:include page="/dashboard/nav.jsp"/>  
  	<!-- header -->

  <div class="container-fluid">
    <div class="row">
    
      <!-- sidebarMenu------------------------------ -->
		<jsp:include page="nav.jsp"/>
      <!-- sidebarMenu -->

      <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
        <h2 style="margin-top: 50px;">영화관리</h2>
        <h4>영화리스트</h4>
        <div class="table-responsive">
        	<a href="#" class="btn" style="display: block; text-align: right;" >정보등록</a>
          <table class="table table-sm">
            <thead>
              <tr style="text-align: center;">
                <th>제목</th>
                <th>감독</th>
                <th>배우</th>
                <th>가격</th>
                <th>수정</th>
                <th>삭제</th>
              </tr>
             </thead>
             <tbody>
	            <c:forEach var="list" items="${list}">
	              <tr style="text-align: center;">
	                <td>${list.title}</td>
	                <td>${list.director}</td>
	                <td>${list.actor}</td>
	                <td>${list.price}</td>
					<td><a href="ProductServlet?command=product_update_form&code=${list.code}">상품수정</a></td>
					<td><a href="ProductServlet?command=product_delete_form&code=${list.code}">상품삭제</a></td>
	              </tr>
	            </c:forEach>
	         </tbody>
          </table>
        </div>
      </main>
    </div>
  	</div>
</body>
</html>
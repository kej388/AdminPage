<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.0.1">
    <title>eunjinkoh-Products</title>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

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
    <link href="css/shopping.css" rel="stylesheet">
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
        <h2 style="margin-top: 50px;">상품관리</h2>
        <h4>상품목록</h4>
        <div class="table-responsive">
          <table class="table table-sm">
            <thead>
              <tr style="text-align: center;">
                <th>상품코드</th>
                <th>상품명</th>
                <th>상품가격</th>
                <th>가능</th>
              </tr>
             </thead>
             <tbody>
	            <c:forEach var="product" items="${productList}">
	              <tr style="text-align: center;">
	                <td>${product.product_code}</td>
	                <td>${product.product_name}</td>
	                <td>${product.product_price}원</td>
	                <td>
						<a href="ProductServlet?command=product_update_form&code=${product.product_code}">상품수정</a>
						<a href="ProductServlet?command=product_delete_form&code=${product.product_code}">상품삭제</a>
					</td>
	              </tr>
	            </c:forEach>
	         </tbody>
          </table>
          <a href="ProductServlet?command=product_insert_form_action">상품등록</a>
        </div>
      </main>
    </div>
  	</div>
  </body>
</html>

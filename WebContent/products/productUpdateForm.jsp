<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
      
      th {
      text-align:center;
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
            <h2 style="margin-top: 50px;">상품관리</h2>
            <h4>상품 수정</h4>
            <span style="display:block; border-bottom: 1px solid #1f4e5f; margin-bottom: 20px;"></span>
            <form method="post" name="frm" action="ProductServlet">
            	<input type="hidden" name="command" value="product_update">
                <input type="hidden" name="code" value="${product.product_code}">
                <input type="hidden" name="nonmakeImg" value="${product.product_pictureurl}">
                <table>
                    <tr>
                        <td style="text-align:center">
                            <c:choose>
                                <c:when test="${empty product.product_pictureurl}">
                                    <img src="upload/noImage.jpg">
                                </c:when>
                                <c:otherwise>
                                    <img src="upload/${product.product_pictureurl}">
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <!-- 상품수정Table ------------------------------- -->
                            <table>
                                <tr> 
                                    <th style="width : 80px"> 상품명 </th>
                                    <td>
                                        <input type="text" name="name" value="${product.product_name}" size="80">
                                    </td>
                                </tr>
                                <tr> 
                                    <th> 가 격 </th>
                                    <td>
                                        <input type="text" name="price" value="${product.product_price}">원
                                    </td>
                                </tr>
                                <tr> 
                                    <th> 사 진 </th>
                                    <td>
                                        <input type="file" name="pictureurl"><br>
                                        (주의사항 : 이미지를 변경하고자 할때만 선택하시오)
                                    </td>
                                </tr>
                                <tr> 
                                    <th> 설 명 </th>
                                    <td>
                                        <textarea cols="90" rows="10" name="description">${product.product_description}</textarea>
                                    </td>
                                </tr>
                            </table>
                            <!-- 상품수정Table -->
                        </td>
                    </tr>
                </table>
                <br>
                <input type="submit" value="수정" onclick="return productCheck()">
                <input type="reset" value="다시작성">
                <input type="button" value="목록" onclick="location.href='ProductServlet?command=product_list_action'">
            </form>
          </main>
        </div>
      </div>
</body>
</html>
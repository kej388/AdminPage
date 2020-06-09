<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.0.1">
    <title>eunjinkoh-Products</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/dashboard/">

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
    <link rel="stylesheet" href="css/shopping.css">
    <script type="text/javascript" src="script/script.js"></script>
  </head>
  <body>
    <!-- header------------------------------ -->
  	<jsp:include page="/dashboard/nav.jsp"/>  
  	<!-- header -->

  <div class="container-fluid">
    <div class="row">
    
      <!-- sidebarMenu------------------------------ -->
		<jsp:include page="nav.jsp"></jsp:include>
      <!-- sidebarMenu -->

      <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
        <h2 style="margin-top: 50px;">상품관리</h2>
        <h4>상품등록</h4>
        <span style="display:block; border-bottom: 1px solid #1f4e5f; margin-bottom: 20px;"></span>
		<form enctype="multipart/form-data" method="post" name="frm" action="ProductServlet">
			<input type="hidden" name="command" value="product_insert">
			<table>
				<tr> 
					<th>
						상품명				
					</th>
					<td>
						<input type="text" name="name" size="80">
					</td>
				</tr>
				<tr> 
					<th>
						가 격				
					</th>
					<td>
						<input type="text" name="price">원
					</td>
				</tr>
				<tr> 
					<th>
						사 진				
					</th>
					<td>
						<input type="file" name="pictureurl"><br>
						(주의사항 : 이미지를 변경하고자 할때만 선택하시오)
					</td>
				</tr>
				<tr> 
					<th>
						설 명				
					</th>
					<td>
						<textarea cols="80" rows="10" name="description"></textarea>
					</td>
				</tr>
			</table>
			<br>
			<input type="submit" value="등록" onclick="return productCheck()" class="inputcss">
			<input type="reset" value="다시작성" class="inputcss">
			<input type="button" value="목록" onclick="location.href='ProductServlet?command=product_list_action'" class="inputcss">
		</form>
      </main>
    </div>
  </div>
  </body>
</html>

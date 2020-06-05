<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	var header = document.getElementsByClassName('nav-item');
	var btns = header.getElementsByClassName('nav-link');
	for (var i = 0; i < btns.length; i++) {
		  btns[i].addEventListener("click", function() {
		    var current = document.getElementsByClassName("active");
		    current[0].className = current[0].className.replace(" active", "");
		    this.className += " active";
		  });
		}
</script>

<nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block sidebar collapse" style="background-color: #f4f7f7;">
   <div class="sidebar-sticky pt-3">
     <ul class="nav flex-column">
       <li class="nav-item">
         <a class="nav-link active" href="ProductServlet?command=dashboard_action">
           <span data-feather="home"></span>
           Dashboard <span class="sr-only">(current)</span>
         </a>
         <a class="nav-link" href="ProductServlet?command=product_list_action">
           <span data-feather="file"></span>
           Products
         </a>
       </li>
     </ul>
   </div>
</nav>
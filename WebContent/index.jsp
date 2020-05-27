<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>eunjinkoh-Login</title>
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

    <link href="css/signin.css" rel="stylesheet">
</head>
<body class="text-center">
    <form class="form-signin" method="post" action="adminLogin.do">
        <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" name="adminemail" class="form-control" value="${adminemail}" placeholder="Email address" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="adminpass" class="form-control" value="${adminpass}" placeholder="Password" required>
        <div class="checkbox mb-3">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-block" type="submit" style="background-color: #aacfd0;">Sign in</button>
        <p class="mt-5 mb-3 text-muted">&copy; eunjinkoh.com</p>
      </form>
      <p>${message}</p>
</body>
</html>
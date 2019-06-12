<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%--   <% Integer.parseInt("datadasasd"); %>일부러 500Error발생시키는 부분 --%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath() %>/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath() %>/css/sign.css" rel="stylesheet">
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  </head>

  <body>

    <div class="container">
								<%//el로 바꾸면! %>
      <form id="frm" action="${pageContext.request.contextPath}/login2" method="post" class="form-signin">
      
        <h2 class="form-signin-heading">Please sign in</h2>
        
        <label for="userId" class="sr-only">userId</label>
        
        <input type="text" id="userId"  name="userId" class="form-control" placeholder="userId" value="brown" required>
        
        <label for="inputPassword" class="sr-only">Password</label>
        
        <input type="password" id="password"  name="userpass" class="form-control" placeholder="Password" value="brown1234" required>
        
        <button id="signInBtn" class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div> <!-- /container -->

  </body>
</html>

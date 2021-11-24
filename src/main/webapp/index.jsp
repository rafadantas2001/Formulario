<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<form action="LoginServlet" method="get">
             <h1> Login </h1> <br>
  <label for="fname">E-MAIL:</label><br>
  <input type="text" name="email"><br>
  <label for="lname">SENHA</label><br>
  <input type="text" name="senha"><br><br>
  <input type="submit" value="Enviar">
</form>

</body>
</html>
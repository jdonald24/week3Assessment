<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "editBandServlet" method = "post">
Show Name: <input type = "text" name = "showName" value= "${bandToEdit.showName}">
Number of Movements: <input type = "text" name = "numOfMovements" value = "${bandToEdit.numOfMovements}">
Number of Marchers: <input type = "text" name = "numOfMarchers" value = "${bandToEdit.numOfMarchers}">
<input type = "hidden" name = "id" value = "${bandToEdit.id}">
<input type = "submit" value = "Save Edited band">
</form>
</body>
</html>
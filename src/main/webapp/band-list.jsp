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
<form action = "navigationServlet" method = "post">
<table>
<c:forEach items="${requestScope.allBands}" var = "currentband">
<tr>
	<td><input type = "radio" name = "id" value ="${currentband.id}"></td>
	<td>${currentband.showName}</td>
	<td>${currentband.numOfMovements}</td>
	<td>${currentband.numOfMarchers}</td>
	</tr>
</c:forEach>
</table>
<input type = "submit" value = "edit" name = "doThisToBand">
<input type = "submit" value = "delete" name = "doThisToBand">
<input type = "submit" value = "add" name = "doThisToBand">
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="createNewCompetitionServlet" method = "post">
Competition Classification (examples: 3a, 4a): <input type = "text" name = "competitionClassification"><br />
Competition Name: <input type = "text" name = "competitionName"><br />
Number of Judges: <input type = "text" name = "numOfJudges"><br />
Number of Bands: <input type = "text" name = "numOfBands"><br />
Available Bands: <br />
<select name ="allBandsToAdd" multiple size = "20">
<c:forEach items = "${requestScope.allBands}" var ="currentband">
<option value = "${currentband.id}"> ${currentband.showName}, ${currentband.numOfMovements}, ${currentband.numOfMarchers} </option>
</c:forEach>
</select>
<br />
<input type = "submit" value = "Create Competition">
</form>
<a href = "index.html">Add a new band instead.</a> 
</body>
</html>
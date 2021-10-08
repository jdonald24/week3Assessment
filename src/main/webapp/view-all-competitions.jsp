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
<form action ="deleteCompetitionServlet" method = "post">
<table>
<c:forEach items="${requestScope.allCompetitions}" var ="currentcompetition">
<tr>
	<td><input type ="radio" name ="id" value="${currentcompetition.id}"></td>
	<td><h2>${currentcompetition.competition.competitionName}</h2></td>
</tr>

<tr>
	<td colspan = "3">Competition Classification: ${currentcompetition.classification}</td>
</tr>
<tr>
	<td colspan = "3">Number of Judges: ${currentcompetition.competition.numOfJudges}</td>
</tr>
<tr>
	<td colspan = "3">Number of Bands: ${currentcompetition.competition.numOfBands}</td>
</tr>
<c:forEach items = "${currentcompetition.listOfBands}" var = "bandVal">
<tr><td></td>
<td colspan = "3">
${bandVal.showName}, ${bandVal.numOfMovements}, ${bandVal.numOfMarchers}
</td>
</tr>
</c:forEach>
</c:forEach>
</table>
<input type= "submit" value="delete" name = "doThisToCompetition">
</form>
<a href ="addBandsForCompetitionServlet">Create a new competition.</a>
<a href="index.html">Add a new band.</a>
</body>
</html>
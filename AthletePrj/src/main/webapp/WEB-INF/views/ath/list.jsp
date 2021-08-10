<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Athletes</title>
</head>
<body>
<h1>Athletes List</h1>
<a href="<c:url value='/ath/insert'/>"/>Insert new athlete information</a>
<table border="1">
<tr>
	<th>id</th>
	<th>name</th>
	<th>birth_date</th>
	<th>age</th>
	<th>gender</th>
	<th>sports</th>
	<th>gold_solo</th>
	<th>silver_solo</th>
	<th>bronze_solo</th>
	<th>gold_team</th>
	<th>silver_team</th>
	<th>bronze_team</th>
	<th>prize</th>
</tr>
<c:forEach var="ath" items="${athList}">
<tr>
	<td><a href="<c:url value='/ath/${ath.id}'/>">${ath.id}</a></td>
	<td>${ath.name}</td>
	<td>${ath.birthDate}</td>
	<td>${ath.age}</td>
	<td>${ath.gender}</td>
	<td>${ath.sports}</td>
	<td>${ath.goldSolo}</td>
	<td>${ath.silverSolo}</td>
	<td>${ath.bronzeSolo}</td>
	<td>${ath.goldTeam}</td>
	<td>${ath.silverTeam}</td>
	<td>${ath.bronzeTeam}</td>
	<td>${ath.prize}</td>
</tr>
</c:forEach>
</table>
</body>
</html>
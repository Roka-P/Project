<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Athlete Info</title>
</head>
<body>
<h1>Athlete Info</h1>
<table border="1">
<tr>
	<th>id</th>
	<td>${ath.id}</td>
</tr>
<tr>
	<th>name</th>
	<td>${ath.name}</td>
</tr>
<tr>
	<th>birth_date</th>
	<td>${ath.birthDate}</td>
</tr>
<tr>
	<th>age</th>
	<td>${ath.age}</td>
</tr>
<tr>
	<th>gender</th>
	<td>${ath.gender}</td>
</tr>
<tr>
	<th>sports</th>
	<td>${ath.sports}</td>
</tr>
<tr>
	<th>gold_solo</th>
	<td>${ath.goldSolo}</td>
</tr>
<tr>
	<th>silver_solo</th>
	<td>${ath.silverSolo}</td>
</tr>
<tr>
	<th>bronze_solo</th>
	<td>${ath.bronzeSolo}</td>
</tr>
<tr>
	<th>gold_team</th>
	<td>${ath.goldTeam}</td>
</tr>
<tr>
	<th>silver_team</th>
	<td>${ath.silverTeam}</td>
</tr>
<tr>
	<th>bronze_team</th>
	<td>${ath.bronzeTeam}</td>
</tr>
<tr>
	<th>prize</th>
	<td>${ath.prize}</td>
</tr>
</table>
<a href="update?id=${ath.id}">Update</a>
<a href="delete?id=${ath.id}">Delete</a>
</body>
</html>

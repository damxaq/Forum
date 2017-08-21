<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Forum</title>
</head>
<body>
	<h1>Temat: ${topic.title}</h1>
	<table border="1">
		<tr>
			<th>Login</th>
			<th width ="500">Tresc</th>
			<th>Data</th>
		</tr>
		<tr>
			<td>${topic.user.login}</td>
			<td>${topic.text}</td>
			<td>${topic.date}</td>
		</tr>
		<c:forEach var="comment" items="${topic.comments}">
			<tr>
				<td>${comment.user.login}</td>
				<td>${comment.text}</td>
				<td>${comment.date}</td>
			</tr>
		</c:forEach>
	</table>
	<form method="post">
		<input type="hidden" name="id" value="${topic.id}"/>
		<p>Wprowadz tresc odpowiedzi:</p>
		<textarea name="text" rows="8" cols="40"></textarea><br/>
		<input type="submit" value="OK"/>
	</form>
</body>
</html>
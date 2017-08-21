<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Forum - rejestracja</title>
</head>
<body>
	<h1>Rejestracja</h1>
	${error}
	<form method="post">
		<p>Login:</p>
		<input type ="text" name="login" maxlength="30"/>
		<p>Wprowadz haslo:</p>
		<input type="password" name="password" maxlength="20"/>
		<p>Potwierdz haslo:</p>
		<input type="password" name ="password2" maxlength="20"/>
		<input type="submit" value ="Register"/>
		
	</form>
</body>
</html>
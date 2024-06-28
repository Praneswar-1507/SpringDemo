<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Page</title>
</head>
<body>
    <h2>Registration Page</h2>
    <form action="/welcome"  method="get">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br><br>
        <label for="password">Email:</label>
        <input type="email" id="password" name="email" required><br><br>
        <label for="email">Password:</label>
        <input type="password" id="email" name="password" required><br><br>
        <input type="submit" name="action" value="Register">
    </form>
</body>
</html>

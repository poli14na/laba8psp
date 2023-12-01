<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<html>
<body>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #ee8989;
        padding: 20px;
    }

    form {
        width: 300px;
        margin: 0 auto;
        background-color:#ee8989;
        border: 1px solid #b65b5b;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }

    h2 {
        text-align: center;
        color: #333;
    }

    label {
        display: block;
        margin-bottom: 10px;
        color: #555;
    }

    input[type="text"],
    input[type="password"] {
        width: 100%;
        padding: 10px;
        border: 1px solid #ee8989;
        border-radius: 3px;
        box-sizing: border-box;
        margin-bottom: 20px;
    }

    a {
        text-decoration: none;
        color: #e5440b;
    }

    input[type="submit"] {
        background-color:  #e5440b;
        color: #ee8989;
        border: none;
        padding: 10px 20px;
        border-radius: 3px;
        cursor: pointer;
        font-size: 16px;
    }

    input[type="submit"]:hover {
        background-color: #f11007;
    }
</style>
<form action="reg" method="post">
    <h2>Registration</h2>
    <label for="login">Your new login:</label>
    <input type="text" id="login" name="login" required><br>

    <label for="password">Your new password:</label>
    <input type="password" id="password" name="password" required><br>

    <a href="login">Login</a><br><br>

    <input type="submit" value="Reg">
</form>
</body>
</html>
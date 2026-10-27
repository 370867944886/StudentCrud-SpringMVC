<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Registration</title>

<style>
    body {
        font-family: Arial, sans-serif;
        margin: 40px;
    }

    form {
        width: 350px;
        padding: 20px;
        border: 1px solid #ccc;
        border-radius: 8px;
    }

    label {
        display: block;
        margin-top: 15px;
    }

    input, select {
        width: 100%;
        padding: 8px;
        margin-top: 5px;
        box-sizing: border-box;
    }

    button {
        margin-top: 20px;
        padding: 10px 15px;
        background-color: #0d6efd;
        color: white;
        border: none;
        cursor: pointer;
    }
</style>
</head>

<body>

<h2>Employee Registration</h2>

<form action="${pageContext.request.contextPath}/registration"
      method="post">

    <label for="name">Name:</label>
    <input type="text" id="name" name="name"
           placeholder="Enter employee name" required>

    <label for="dept">Department:</label>
    <input type="text" id="name" name="dept"
           placeholder="Enter a Department" required>

    <button type="submit">Register</button>

</form>

</body>
</html>
```
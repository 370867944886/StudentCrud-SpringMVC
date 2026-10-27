```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Student</title>

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

    input[readonly] {
        background-color: #eee;
    }

    button {
        margin-top: 20px;
        padding: 10px 15px;
        background-color: #198754;
        color: white;
        border: none;
        cursor: pointer;
    }
</style>
</head>

<body>

<h2>Update Student Details</h2>

<form action="${pageContext.request.contextPath}/update" method="post">

    <label for="rollno">Roll No:</label>
    <input type="number" id="rollno" name="rollno"
           value="${st.rollno}" readonly>

    <label for="name">Name:</label>
    <input type="text" id="name" name="name"
           value="${st.name}" required>

    <label for="dept">Department:</label>
    <input type="text" id="dept" name="dept"
           value="${st.dept}" required>
    <button type="submit">Update</button>

</form>

</body>
</html>
```
```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Details</title>

<style>
    body {
        font-family: Arial, sans-serif;
        margin: 30px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }

    th, td {
        border: 1px solid #ccc;
        padding: 10px;
        text-align: center;
    }

    th {
        background-color: #e8e8e8;
    }

    .edit {
        background-color: #198754;
        color: white;
        padding: 6px 12px;
        text-decoration: none;
    }

    .delete {
        background-color: #dc3545;
        color: white;
        padding: 6px 12px;
        text-decoration: none;
    }

    .footer {
        margin-top: 20px;
        text-align: right;
    }

    .add {
        background-color: #0d6efd;
        color: white;
        padding: 10px 16px;
        text-decoration: none;
        border-radius: 4px;
    }
</style>
</head>

<body>
<c:if test="${not empty status}">
    <p style="color: green; font-weight: bold;">
        ${status}
    </p>
</c:if>

<c:if test="${not empty updatemsg}">
    <p style="color: green; font-weight: bold;">
        ${updatemsg}
    </p>
</c:if>
<c:if test="${not empty afterdelete}">
    <p style="color: green; font-weight: bold;">
        ${msgdel}
    </p>
</c:if>
<h2>Employee Details</h2>

<table>
    <thead>
        <tr>
            <th>Roll No</th>
            <th>Name</th>
            <th>Department</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
    </thead>

    <tbody>
        <c:forEach var="emp" items="${emplist}">
            <tr>
                <td>${emp.rollno}</td>
                <td>${emp.name}</td>
                <td>${emp.dept}</td>

                <td>
                    <a class="edit"
                       href="${pageContext.request.contextPath}/edit?rollno=${emp.rollno}">
                       Edit
                    </a>
                </td>

                <td>
                    <a class="delete"
                       href="${pageContext.request.contextPath}/delete?rollno=${emp.rollno}"
                       onclick="return confirm('Are you sure you want to delete this employee?')">
                       Delete
                    </a>
                </td>
            </tr>
        </c:forEach>

        <c:if test="${empty emplist}">
            <tr>
                <td colspan="5">No employee records found.</td>
            </tr>
        </c:if>
    </tbody>
</table>

<div class="footer">
    <a class="add"
       href="${pageContext.request.contextPath}/registration">
       + Add Register
    </a>
</div>

</body>
</html>
```
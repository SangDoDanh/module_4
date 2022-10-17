<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<h1>Employee List!</h1>
<span style="color: green">${message}</span>
<a href="/employee/create">Add new employee</a>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Contact Number</th>
            <th>Languages</th>
            <th>Delete</th>
            <th>edit</th>
        </tr>
        <c:forEach items="${employeeList}" varStatus="employeeStatus" var="employee">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.name}</td>
                <td>${employee.contactNumber}</td>
                <td>
                    <c:forEach items="${employee.languages}" var="language">
                        <span>${language}, </span>
                    </c:forEach>
                </td>
                <td><a href="">Delete</a></td>
                <td><a href="">Edit</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

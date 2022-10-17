<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Employee</title>
</head>
<body>
    <h1>Add new employee</h1>
        <form:form modelAttribute="employee" action="/employee/add" method="post">
            <table>
                <tr>
                    <td>Employee ID:</td>
                    <td><form:input path="id"/></td>
                </tr>
                <tr>
                    <td>Employee's name:</td>
                    <td><form:input path="name"/></td>
                </tr>
                <tr>
                    <td>Contact's number: </td>
                    <td><form:input path="contactNumber"/></td>
                </tr>
                <tr>
                    <td>Contact's number: </td>
                    <td><form:checkboxes items="${languages}" path="languages"/></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
</body>
</html>

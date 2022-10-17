<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Employee</title>
</head>
<body>
<h1>Setting</h1>
    <form:form action="/update" modelAttribute="email" method="post">
        <table>
            <tr>
                <td>
                    <span>Languages: </span>
                </td>
                <td>
                    <form:hidden path="id"/>
                    <form:select path="languages" items="${languages}"/>
                </td>
            </tr>
            <tr>
                <td>
                    <span>Page size: </span>
                </td>
                <td>
                    <span>Show </span>
                    <form:select path="pageSize" items="${pageSize}"/>
                    <span>email per page</span>
                </td>
            </tr>
            <tr>
                <td>
                    <span>Spam filter: </span>
                </td>
                <td>
                    <form:checkbox path="sampleFilter" value="true" label="Enable spams filter"/>
                </td>
            </tr>
            <tr>
                <td>
                    <span>Signature: </span>
                </td>
                <td>
                    <form:textarea path="signature" rows="3"/>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="update">
                </td>
                <td>
                    <a href="/">cancel</a>
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>

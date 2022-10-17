<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
    <h1>Email Page</h1>
    <span style="color:green;">${message}</span>
    <br>
    <table>
        <tr>
            <th>Languages</th>
            <th>PageSize</th>
            <th>SampleFilter</th>
            <th>Signature</th>
            <th>Setting</th>
        </tr>
        <c:forEach items="${emailList}" var="email">
            <tr>
                <td>${email.languages}</td>
                <td>${email.pageSize}</td>
                <td>${email.sampleFilter}</td>
                <td>${email.signature}</td>
                <td><a href="/setting/${email.id}">Setting</a></td>
            </tr>

        </c:forEach>
    </table>
</body>
</html>

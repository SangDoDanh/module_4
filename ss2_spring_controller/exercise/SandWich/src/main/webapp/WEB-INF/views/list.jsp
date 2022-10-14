<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/save">
    <c:forEach items="${condimentList}" var="condiment" varStatus="condimentCount">
        <label for="condiment${condimentCount.count}">${condiment.name}</label>
        <input type="checkbox" name="condimentName" id="condiment${condimentCount.count}" value="${condiment.name}">
    </c:forEach>
    <br>
    <input type="submit" value="Save">
</form>
<span>${result}</span>
</body>
</html>

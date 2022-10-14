<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student | home</title>
    <style>
        .hidden{
            display: none;
        }
    </style>
</head>
<body>
    <h1>Danh sach sinh vien</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>gender</th>
            <th>Languages</th>
        </tr>
        <c:forEach items="${studentList}" var="student">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.gender}</td>
                <td>
                    <c:forEach items="${student.languages}" var="language">
                        <span>${language} </span>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
    </table>
    <form action="/student/add" method="post">
        <input type="text" name="id" placeholder="name">
        <input type="text" name="name" placeholder="name">
        <select name="gender" id="select-gender">
            <option value="female">Female</option>
            <option value="male">male</option>
        </select>
        <input id="btn-lang" type="button" value="Lang choose">
        <select class="hidden" name="languages" id="select-languages" multiple>
            <option selected value="java">java</option>
            <option value="C#">C#</option>
            <option value="javascript">javascript</option>
        </select>
        <input type="submit" value="Add">
    </form>

    <script>
        const eLang = document.getElementById('btn-lang');
        const eSelectedLang = document.getElementById('select-languages');
        eLang.addEventListener('click',ev => {
           if(eSelectedLang.classList.contains('hidden')){
               eSelectedLang.classList.remove('hidden');
           }else {
               eSelectedLang.classList.add('hidden');

           }
        });
    </script>
</body>
</html>

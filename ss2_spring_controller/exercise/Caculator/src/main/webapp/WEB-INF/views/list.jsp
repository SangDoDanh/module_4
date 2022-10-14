<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style>
        body{
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            background: darkgray;
        }
        input[type='submit'] {
            min-width: 42px;
            min-height: 42px;
            display: inline-block;
            margin: 0px 12px;
        }
        input[type='text'] {
            font-weight: bold;
            color: aqua;
            background: transparent;
            width: 100%;
            margin-bottom: 24px;
            font-size: 48px;
            padding: 0 8px;
            border: none;
            border-bottom: 1px solid aqua;
            outline: none;
        }
        span{
            color: aqua;
            margin-top: 24px;
            font-size: 24px;
            display: inline-block;
            padding: 0 8px;
        }
        form{
            border: 1px solid aqua;
            padding: 8px;
            border-radius: 3px;
            box-shadow: 2px 2px 4px aqua;
            height: 80vh;
        }
    </style>
</head>
<body>
<form action="/calculator" style="width: 500px">
    <h1 style="text-align: center">Calculator</h1>
    <input  type="text" name="number1" placeholder="number 1" value="${number1}">
    <input  type="text" name="number2" placeholder="number 2" value="${number2}" style="margin-bottom: 32px"><br>
    <input type="" name="action" id="action" hidden>
        <input name="operator" type="submit" value="+">
        <input name="operator" type="submit" value="-">
        <input name="operator" type="submit" value="*">
        <input name="operator" type="submit" value="/">
    <br>
    <span>RESULT: ${result}</span>
</form>
</body>
</html>

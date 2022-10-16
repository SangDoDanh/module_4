<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Calculator</title>
  </head>
  <body>
  <form action="/convert">
    USD:
    <input type="text" name="usd">
    Range:
    <input type="text" name="range">
    <span name = "result">VND: ${result}</span><br>
    <input style="margin-top:24px; " type="submit" value="Convert">
  </form>
  </body>
</html>

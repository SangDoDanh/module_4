<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Dict</title>
  </head>
  <body>
    <h1>Trang tu dien</h1>
    <form action="/abc">
      English
      <input type="text" name="eng">
      <input type="submit" value="Dich">
      VietNam: <span>${result}</span>
    </form>
  </body>
</html>

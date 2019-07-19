<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/19
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>欢迎${sessionScope.username}</h1>
    <form action="/word.do">
        <input type="text" name="word">
        <input type="submit" value="提交">
    </form>
    <h2>${word}</h2>
</body>
</html>

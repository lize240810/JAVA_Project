<%--
  Created by IntelliJ IDEA.
  User: southwind
  Date: 2019-07-16
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>
    <a href="add.jsp">添加</a>
  </h2>
    <table>
      <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>成绩</th>
        <th>生日</th>
        <th>操作</th>
      </tr>
      <c:forEach items="${list}" var="users">
        <tr>
          <td>${users.id}</td>
          <td>${users.name}</td>
          <td>${users.score}</td>
          <td>${users.birthday}</td>
          <td>
            <a href="/users.do?method=deleteById&id=${users.id}">删除</a>
            <a href="/users.do?method=findById&id=${users.id}">修改</a>
          </td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: southwind
  Date: 2019-07-16
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/users.do?method=add" method="post">
        <table>
            <tr>
                <td>姓名：</td>
                <td>
                    <input type="text" name="name"/>
                </td>
            </tr>
            <tr>
                <td>成绩：</td>
                <td>
                    <input type="text" name="score"/>
                </td>
            </tr>
            <tr>
                <td>生日：</td>
                <td>
                    <input type="date" name="birthday"/>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="添加"/>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>

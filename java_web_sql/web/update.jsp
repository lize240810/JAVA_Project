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
    <form action="/users.do?method=update" method="post">
        <table>
            <tr>
                <input type="hidden" name="id" value="${users.id}" readonly/>
                <td>姓名：</td>
                <td>
                    <input type="text" name="name" value="${users.name}"/>
                </td>
            </tr>
            <tr>
                <td>成绩：</td>
                <td>
                    <input type="text" name="score" value="${users.score}"/>
                </td>
            </tr>
            <tr>
                <td>生日：</td>
                <td>
                    <input type="date" name="birthday" value="${users.birthday}"/>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="更新"/>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>

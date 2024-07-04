<%--
  Created by IntelliJ IDEA.
  User: 86139
  Date: 2024/7/3
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="1" align="center" style="border-collapse: collapse;width: 500px">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年纪</th>
        <th>手机号</th>
        <th>性别</th>
        <th>班级</th>
    </tr>
    <c:forEach items="${slist}" var="stu">
        <tr align="center">
        <td>${stu.sid}</td>
        <td>${stu.sname}</td>
        <td>${stu.age}</td>
        <td>${stu.phone}</td>
        <td>${stu.sex}</td>
        <td>${stu.grade.gname}</td>
    </tr>
    </c:forEach>

</table>
</body>
</html>

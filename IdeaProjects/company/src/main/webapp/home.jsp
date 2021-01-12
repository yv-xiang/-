<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/3 0003
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看</title>
</head>
<body>
<table align="center" border="1">

    <tr align="center">
        <td><span>ID</span></td>
        <td><span>姓名</span></td>
        <td><span>性别</span></td>
        <td><span>入职日期</span></td>
        <td><span>所属部门</span></td>
        <td><span>部门地址</span></td>
        <td><span>操作</span></td>
    </tr>
    <C:forEach items="${requestScope.find}" var="company" >
        <tr>
            <td><span>${company.tid}</span></td>
            <td><span>${company.tname}</span></td>
            <td><span>${company.tsex}</span></td>
            <td><span>${company.tregisterDate}</span></td>
            <td><span>${company.name}</span></td>
            <td><span>${company.location}</span></td>
            <td>
                <a href="${pageContext.request.contextPath}/OneServlet?tid=${company.tid}">修改</a>
                <a href="${pageContext.request.contextPath}/DeleteServlet?tid=${company.tid} " onclick="return confirm('确定要删除吗？')" >删除</a>
            </td>
        </tr>
    </C:forEach>
    <tr>
    <td>
        <table align="centre">
            <a href="${pageContext.request.contextPath}/add.jsp">增加员工</a>
        </table>
    </td>
    </tr>
</table>
</body>
</html>

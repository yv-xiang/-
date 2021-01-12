<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/4 0004
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/UpdateServlet" method="post" >
    <input type="hidden" name="tid" value="${requestScope.company.tid}">
    <table width="100%" align="center" bgcolor="white">
        <tr>
            <td>
                <table width="100%">
                    <tr align="center">
                        <td width="30%" align="right">
                            <br>
                            姓名
                        </td>
                        <td align="left" width="70%">
                            <br>
                            <input id="tname" name="tname" type="text" placeholder="请输入姓名"  value="${requestScope.company.tname}">
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td>
                <table width="100%">
                    <tr align="center">
                        <td width="30%" align="right">
                            <br>
                            性别
                        </td>
                        <td align="left" width="70%">
                            <br>
                            <input type="radio" name="tsex" value="男" ${requestScope.company.tsex eq "男"?"checked=\"checked\"":""}/>男
                            <input type="radio" name="tsex" value="女" ${requestScope.company.tsex eq "女"?"checked=\"checked\"":""}/>女
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td>
                <table width="100%">
                    <tr align="center">
                        <td width="30%" align="right">
                            <br>
                            入职时间
                        </td>
                        <td align="left" width="70%">
                            <br>
                            <input name="tregisterDate" type="text" placeholder="2000-01-01" value="${requestScope.company.tregisterDate}">
                        </td>
                    </tr>
                </table>
            </td>
        </tr>

        <tr>
            <td>
                <table width="100%">
                    <tr align="center">
                        <td width="30%" align="right">
                            <br>
                            所属部门
                        </td>
                        <td align="left" width="70%">
                            <br>
                            <select name="tdeptId" >
                                <option value=1 ${requestScope.company.tdeptId==1?"selete":""}>开发部</option>
                                <option value=2 ${requestScope.company.tdeptId==2?"selete":""}>产品部</option>
                                <option value=3 ${requestScope.company.tdeptId==3?"selete":""}>市场部</option>
                            </select>
                            <span id="tdeptIdSpan"></span>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>

        <tr height="60">
            <td align="center">
                <table width="100%">
                    <tr align="center">
                        <td width="30%" align="right"></td>
                        <td align="left" width="70%">
                            <br>
                            <br>
                            <input type="submit" value="保存">
                            <input type="reset" value="重置">
                        </td>
                    </tr>
                </table>
            </td>
        </tr>


    </table>
</form>

</body>
</html>

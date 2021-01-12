<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/4 0004
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加</title>
</head>
<body>
<form action="/AddServlet" method="post">

    <br><br><br><br><br>
    <table width="50%" align="center">
        <tr height="60">
            <td align="center">
                <table width="100%">
                    <tr align="center">
                        <td width="30%" align="right">
                            <br>
                            姓名
                        </td>
                        <td align="left" width="70%">
                            <br>
                            <input id="name" name="tname" type="text" placeholder="请输入姓名">
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr height="60">
            <td align="center">
                <table width="100%">
                    <tr align="center">
                        <td width="30%" align="right">
                            <br>
                            性别
                        </td>
                        <td align="left" width="70%">
                            <br>
                            <input type="radio" name="tsex" value="男"/>男
                            <input type="radio" name="tsex" value="女"/>女
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr height="60">
            <td align="center">
                <table width="100%">
                    <tr align="center">
                        <td width="30%" align="right">
                            <br>
                            入职时间
                        </td>
                        <td align="left" width="70%">
                            <br>
                            <input name="tregisterDate" type="text" placeholder="2000-01-01" >
                        </td>
                    </tr>
                </table>
            </td>
        </tr>

        <tr height="60">
            <td align="center">
                <table width="100%">
                    <tr align="center">
                        <td width="30%" align="right">
                            <br>
                            所属部门
                        </td>
                        <td align="left" width="70%">
                            <br>
                            <select name="tdeptId">
                                <option value=1>开发部</option>
                                <option value=2>产品部</option>
                                <option value=3>市场部</option>
                            </select>

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

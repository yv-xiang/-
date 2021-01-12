<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@page import="util.Info"%>
<%@page import="dao.CommDAO"%>
<%@page import="util.PageManager"%>
<html>
  <head>
    <title>户籍信息详细</title>
    <LINK href="css.css" type=text/css rel=stylesheet>

  </head>

  <body >
  <%
	String id=request.getParameter("id");
	HashMap m = new CommDAO().getmap(id,"hujixinxi");
     %>
  户籍信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>户号：</td><td width='39%'><%=m.get("huhao")%></td><td width='11%'>户主姓名：</td><td width='39%'><%=m.get("huzhuxingming")%></td></tr><tr><td width='11%'>组号：</td><td width='39%'><%=m.get("zuhao")%></td><td width='11%'>户籍地址：</td><td width='39%'><%=m.get("hujidizhi")%></td></tr><tr><td width='11%'>总人数：</td><td width='39%'><%=m.get("zongrenshu")%></td><td width='11%'>备注：</td><td width='39%'><%=m.get("beizhu")%></td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>



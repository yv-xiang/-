<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@page import="util.Info"%>
<%@page import="dao.CommDAO"%>
<%@page import="util.PageManager"%>
<html>
  <head>
    <title>个人户籍详细</title>
    <LINK href="css.css" type=text/css rel=stylesheet>

  </head>

  <body >
  <%
	String id=request.getParameter("id");
	HashMap m = new CommDAO().getmap(id,"gerenhuji");
     %>
  个人户籍详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>户号：</td><td width='39%'><%=m.get("huhao")%></td><td width='11%'>户主姓名：</td><td width='39%'><%=m.get("huzhuxingming")%></td></tr><tr><td width='11%'>组号：</td><td width='39%'><%=m.get("zuhao")%></td><td width='11%'>户籍地址：</td><td width='39%'><%=m.get("hujidizhi")%></td></tr><tr><td width='11%'>姓名：</td><td width='39%'><%=m.get("xingming")%></td><td width='11%'>性别：</td><td width='39%'><%=m.get("xingbie")%></td></tr><tr><td width='11%'>民族：</td><td width='39%'><%=m.get("minzu")%></td><td width='11%'>籍贯：</td><td width='39%'><%=m.get("jiguan")%></td></tr><tr><td width='11%'>户口类别：</td><td width='39%'><%=m.get("hukouleibie")%></td><td width='11%'>出生日期：</td><td width='39%'><%=m.get("chushengriqi")%></td></tr><tr><td width='11%'>身份证号：</td><td width='39%'><%=m.get("shenfenzhenghao")%></td><td width='11%'>密码：</td><td width='39%'><%=m.get("mima")%></td></tr><tr><td width='11%'>健康状况：</td><td width='39%'><%=m.get("jiankangzhuangkuang")%></td><td width='11%'>单位名称：</td><td width='39%'><%=m.get("danweimingcheng")%></td></tr><tr><td width='11%'>联系人：</td><td width='39%'><%=m.get("lianxiren")%></td><td width='11%'>联系电话：</td><td width='39%'><%=m.get("lianxidianhua")%></td></tr><tr><td width='11%'>单位地址：</td><td width='39%'><%=m.get("danweidizhi")%></td><td width='11%'>户籍状态：</td><td width='39%'><%=m.get("hujizhuangtai")%></td></tr><tr><td width='11%'>变更事由：</td><td width='39%'><%=m.get("biangengshiyou")%></td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>



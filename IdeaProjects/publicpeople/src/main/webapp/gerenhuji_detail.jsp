<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@page import="util.Info"%>
<%@page import="dao.CommDAO"%>
<%@page import="util.PageManager"%>
<html>
  <head>
    <title>���˻�����ϸ</title>
    <LINK href="css.css" type=text/css rel=stylesheet>

  </head>

  <body >
  <%
	String id=request.getParameter("id");
	HashMap m = new CommDAO().getmap(id,"gerenhuji");
     %>
  ���˻�����ϸ:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>���ţ�</td><td width='39%'><%=m.get("huhao")%></td><td width='11%'>����������</td><td width='39%'><%=m.get("huzhuxingming")%></td></tr><tr><td width='11%'>��ţ�</td><td width='39%'><%=m.get("zuhao")%></td><td width='11%'>������ַ��</td><td width='39%'><%=m.get("hujidizhi")%></td></tr><tr><td width='11%'>������</td><td width='39%'><%=m.get("xingming")%></td><td width='11%'>�Ա�</td><td width='39%'><%=m.get("xingbie")%></td></tr><tr><td width='11%'>���壺</td><td width='39%'><%=m.get("minzu")%></td><td width='11%'>���᣺</td><td width='39%'><%=m.get("jiguan")%></td></tr><tr><td width='11%'>�������</td><td width='39%'><%=m.get("hukouleibie")%></td><td width='11%'>�������ڣ�</td><td width='39%'><%=m.get("chushengriqi")%></td></tr><tr><td width='11%'>���֤�ţ�</td><td width='39%'><%=m.get("shenfenzhenghao")%></td><td width='11%'>���룺</td><td width='39%'><%=m.get("mima")%></td></tr><tr><td width='11%'>����״����</td><td width='39%'><%=m.get("jiankangzhuangkuang")%></td><td width='11%'>��λ���ƣ�</td><td width='39%'><%=m.get("danweimingcheng")%></td></tr><tr><td width='11%'>��ϵ�ˣ�</td><td width='39%'><%=m.get("lianxiren")%></td><td width='11%'>��ϵ�绰��</td><td width='39%'><%=m.get("lianxidianhua")%></td></tr><tr><td width='11%'>��λ��ַ��</td><td width='39%'><%=m.get("danweidizhi")%></td><td width='11%'>����״̬��</td><td width='39%'><%=m.get("hujizhuangtai")%></td></tr><tr><td width='11%'>������ɣ�</td><td width='39%'><%=m.get("biangengshiyou")%></td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=���� onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=��ӡ onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>



<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@page import="util.Info"%>
<%@page import="dao.CommDAO"%>
<%@page import="util.PageManager"%>
<html>
  <head>
    
    <title>���˻���</title>
	<!--bixanjxiqxi-->
	<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
	<script type="text/javascript" src="js/popup.js"></script>
    <LINK href="css.css" type=text/css rel=stylesheet>

  </head>
<script language="javascript">

function hsgxia2shxurxu(nstr,nwbk)
{
	if (eval("form1."+nwbk).value.indexOf(nstr)>=0)
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value.replace(nstr+"��", "");
	}
	else
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value+nstr+"��";
	}
}
</script>

  <body >
<% 

String id = request.getParameter("id"); 
HashMap ext = new HashMap(); 
new CommDAO().update(request,response,"gerenhuji",ext,true,false,""); 
HashMap mmm = new CommDAO().getmaps("shenfenzhenghao",(String)request.getSession().getAttribute("username"),"gerenhuji"); 
%>
  <form  action="gerenhuji_updt2.jsp?f=f&id=<%=mmm.get("id")%>"  method="post" name="form1"  onsubmit="return checkform();">
  �޸ĸ��˻���:
  <br><br>
  <%
  
   %>
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF" style="border-collapse:collapse">
     <tr><td>���֤�ţ�</td><td><input name='shenfenzhenghao' readonly type='text' id='shenfenzhenghao' value='<%= mmm.get("shenfenzhenghao")%>' style='border:solid 1px #000000; color:#666666' />
*ֻ��</td></tr>
     <tr><td>���룺</td><td><input name='mima' type='password' id='mima' value='<%= mmm.get("mima")%>' style='border:solid 1px #000000; color:#666666' /></td></tr>
     <tr><td>����״����</td><td><input name='jiankangzhuangkuang' type='text' id='jiankangzhuangkuang' value='<%= mmm.get("jiankangzhuangkuang")%>' style='border:solid 1px #000000; color:#666666' /></td></tr>
     <tr><td>��λ���ƣ�</td><td><input name='danweimingcheng' type='text' id='danweimingcheng' value='<%= mmm.get("danweimingcheng")%>' style='border:solid 1px #000000; color:#666666' /></td></tr>
     <tr><td>��ϵ�ˣ�</td><td><input name='lianxiren' type='text' id='lianxiren' value='<%= mmm.get("lianxiren")%>' style='border:solid 1px #000000; color:#666666' /></td></tr>
     <tr><td>��ϵ�绰��</td><td><input name='lianxidianhua' type='text' id='lianxidianhua' value='<%= mmm.get("lianxidianhua")%>' style='border:solid 1px #000000; color:#666666' /></td></tr>
     <tr><td>��λ��ַ��</td><td><input name='danweidizhi' type='text' id='danweidizhi' size='50' value='<%=mmm.get("danweidizhi")%>' style='border:solid 1px #000000; color:#666666'/></td></tr>
    <tr>
      <td>&nbsp;</td>
      <td><input type="submit" name="Submit" value="�ύ" onClick="return check();" />
      <input type="reset" name="Submit2" value="����" /></td>
    </tr>
  </table>
</form>

  </body>
</html>



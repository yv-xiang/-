<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@page import="util.Info"%>
<%@page import="dao.CommDAO"%>
<%@page import="util.PageManager"%>
<html>
  <head>
    <title>���˻���</title>
	
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
HashMap mmm = new CommDAO().getmap(id,"gerenhuji"); 

%>
  <form  action="gerenhuji_updtlb.jsp?f=f&id=<%=mmm.get("id")%>"  method="post" name="form1"  onsubmit="return checkform();">
  ���ø��˻���:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF" style="border-collapse:collapse">  
     <tr><td>����״̬��</td><td><select name='hujizhuangtai' id='hujizhuangtai'><option value="Ǩ��">Ǩ��</option><option value="Ǩ��">Ǩ��</option><option value="ע��">ע��</option></select></td></tr><script language="javascript">document.form1.hujizhuangtai.value='<%=mmm.get("hujizhuangtai")%>';</script>     <tr><td>������ɣ�</td><td><textarea name='biangengshiyou' cols='50' rows='5' id='biangengshiyou' style='border:solid 1px #000000; color:#666666'><%=mmm.get("biangengshiyou")%></textarea></td></tr>     
    <tr>
      <td>&nbsp;</td>
      <td><input type="submit" name="Submit" value="�ύ" onClick="return checkform();" />
      <input type="reset" name="Submit2" value="����" /></td>
    </tr>
  </table>
</form>

  </body>
</html>



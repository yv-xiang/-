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
  <form  action="gerenhuji_updt.jsp?f=f&id=<%=mmm.get("id")%>"  method="post" name="form1"  onsubmit="return checkform();">
  �޸ĸ��˻���:
  <br><br>
 
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF" style="border-collapse:collapse">  
     
     <tr><td>���ţ�</td><td><input name='huhao' type='text' id='huhao' value='<%= mmm.get("huhao")%>' style='border:solid 1px #000000; color:#666666' /></td></tr>
     <tr><td>����������</td><td><input name='huzhuxingming' type='text' id='huzhuxingming' value='<%= mmm.get("huzhuxingming")%>' style='border:solid 1px #000000; color:#666666' /></td></tr>
     <tr><td>��ţ�</td><td><input name='zuhao' type='text' id='zuhao' value='<%= mmm.get("zuhao")%>' style='border:solid 1px #000000; color:#666666' /></td></tr>
     <tr><td>������ַ��</td><td><input name='hujidizhi' type='text' id='hujidizhi' size='50' value='<%=mmm.get("hujidizhi")%>' style='border:solid 1px #000000; color:#666666'/></td></tr>
     <tr><td>������</td><td><input name='xingming' type='text' id='xingming' value='<%= mmm.get("xingming")%>' style='border:solid 1px #000000; color:#666666' /></td></tr>
     <tr><td>�Ա�</td><td><select name='xingbie' id='xingbie'><option value="��">��</option><option value="Ů">Ů</option></select></td></tr><script language="javascript">document.form1.xingbie.value='<%=mmm.get("xingbie")%>';</script>
     <tr><td>���壺</td><td><input name='minzu' type='text' id='minzu' value='<%= mmm.get("minzu")%>' style='border:solid 1px #000000; color:#666666' /></td></tr>
     <tr><td>���᣺</td><td><input name='jiguan' type='text' id='jiguan' value='<%= mmm.get("jiguan")%>' style='border:solid 1px #000000; color:#666666' /></td></tr>
     <tr><td>�������</td><td><select name='hukouleibie' id='hukouleibie'><option value="��ס�˿�">��ס�˿�</option><option value="��ס�˿�">��ס�˿�</option></select></td></tr><script language="javascript">document.form1.hukouleibie.value='<%=mmm.get("hukouleibie")%>';</script>
     <tr><td>�������ڣ�</td><td><input name='chushengriqi' type='text' id='chushengriqi' value='<%= mmm.get("chushengriqi")%>' onclick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" readonly='readonly'  /></td></tr>
     <tr><td>���֤�ţ�</td><td><input name='shenfenzhenghao' type='text' id='shenfenzhenghao' value='<%= mmm.get("shenfenzhenghao")%>' style='border:solid 1px #000000; color:#666666' /></td></tr>
     <tr><td>���룺</td><td><input name='mima' type='text' id='mima' value='<%= mmm.get("mima")%>' style='border:solid 1px #000000; color:#666666' /></td></tr>
     <tr><td>����״����</td><td><input name='jiankangzhuangkuang' type='text' id='jiankangzhuangkuang' value='<%= mmm.get("jiankangzhuangkuang")%>' style='border:solid 1px #000000; color:#666666' /></td></tr>
     <tr><td>��λ���ƣ�</td><td><input name='danweimingcheng' type='text' id='danweimingcheng' value='<%= mmm.get("danweimingcheng")%>' style='border:solid 1px #000000; color:#666666' /></td></tr>
     <tr><td>��ϵ�ˣ�</td><td><input name='lianxiren' type='text' id='lianxiren' value='<%= mmm.get("lianxiren")%>' style='border:solid 1px #000000; color:#666666' /></td></tr>
     <tr><td>��ϵ�绰��</td><td><input name='lianxidianhua' type='text' id='lianxidianhua' value='<%= mmm.get("lianxidianhua")%>' style='border:solid 1px #000000; color:#666666' /></td></tr>
     <tr><td>��λ��ַ��</td><td><input name='danweidizhi' type='text' id='danweidizhi' size='50' value='<%=mmm.get("danweidizhi")%>' style='border:solid 1px #000000; color:#666666'/></td></tr>
     <tr style='display:none'><td>����״̬��</td><td><select name='hujizhuangtai' id='hujizhuangtai'><option value="Ǩ��">Ǩ��</option><option value="Ǩ��">Ǩ��</option><option value="ע��">ע��</option></select></td></tr><script language="javascript">document.form1.hujizhuangtai.value='<%=mmm.get("hujizhuangtai")%>';</script>
     <tr style='display:none'><td>������ɣ�</td><td><textarea name='biangengshiyou' cols='50' rows='5' id='biangengshiyou' style='border:solid 1px #000000; color:#666666'><%=mmm.get("biangengshiyou")%></textarea></td></tr>
    <tr>
      <td>&nbsp;</td>
      <td><input type="submit" name="Submit" value="�ύ" onClick="return checkform();" />
      <input type="reset" name="Submit2" value="����" /></td>
    </tr>
  </table>
</form>

  </body>
</html>



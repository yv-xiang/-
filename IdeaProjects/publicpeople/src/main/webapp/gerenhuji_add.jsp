<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@page import="util.Info"%>
<%@page import="dao.CommDAO"%>
<%@page import="util.PageManager"%>
<html>
  <head>
    
    <title>���˻���</title>
	
	<LINK href="css.css" type=text/css rel=stylesheet>
    <script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
	<script type="text/javascript" src="js/popup.js"></script>
	   
  </head>
<%
  String id="";
  id=request.getParameter("id");
 HashMap mlbdq = new CommDAO().getmap(id,"hujixinxi");
 String huhao="";
  	String huzhuxingming="";
  	String zuhao="";
  	String hujidizhi="";
  	
 huhao=(String)mlbdq.get("huhao");
  	huzhuxingming=(String)mlbdq.get("huzhuxingming");
  	zuhao=(String)mlbdq.get("zuhao");
  	hujidizhi=(String)mlbdq.get("hujidizhi");
  	 
 
   %>
<script language="javascript">

function gow()
{
	document.location.href="gerenhuji_add.jsp?id=<%=id%>";
}
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

 <% 
HashMap ext = new HashMap(); 
if(request.getParameter("f")!=null){


ext.put("issh","��");

String sql="update hujixinxi set zongrenshu=zongrenshu+1 where huhao='"+huhao+"'";
new CommDAO().commOper(sql);
}
new CommDAO().insert(request,response,"gerenhuji",ext,true,false,""); 
%>

  <body >
 <form  action="gerenhuji_add.jsp?f=f&id=<%=id%>"  method="post" name="form1"  onsubmit="return checkform();">
  ��Ӹ��˻���:
  <br><br>
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF" style="border-collapse:collapse">
		<tr><td  width="200">���ţ�</td><td><input name='huhao' type='text' id='huhao' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.huhao.value='<%=huhao%>';document.form1.huhao.setAttribute("readOnly",'true');</script>
		<tr><td  width="200">����������</td><td><input name='huzhuxingming' type='text' id='huzhuxingming' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.huzhuxingming.value='<%=huzhuxingming%>';document.form1.huzhuxingming.setAttribute("readOnly",'true');</script>
		<tr><td  width="200">��ţ�</td><td><input name='zuhao' type='text' id='zuhao' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.zuhao.value='<%=zuhao%>';document.form1.zuhao.setAttribute("readOnly",'true');</script>
		<tr><td  width="200">������ַ��</td><td><input name='hujidizhi' type='text' id='hujidizhi' value='' onblur='' size='50' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.hujidizhi.value='<%=hujidizhi%>';document.form1.hujidizhi.setAttribute("readOnly",'true');</script>
		<tr><td  width="200">������</td><td><input name='xingming' type='text' id='xingming' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelxingming' /></td></tr>
		<tr><td>�Ա�</td><td><select name='xingbie' id='xingbie'><option value="��">��</option><option value="Ů">Ů</option></select></td></tr>
		<tr><td  width="200">���壺</td><td><input name='minzu' type='text' id='minzu' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>
		<tr><td  width="200">���᣺</td><td><input name='jiguan' type='text' id='jiguan' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>
		<tr><td>�������</td><td><select name='hukouleibie' id='hukouleibie'><option value="��ס�˿�">��ס�˿�</option><option value="��ס�˿�">��ס�˿�</option></select></td></tr>
		<tr><td width="200">�������ڣ�</td><td><input name='chushengriqi' type='text' id='chushengriqi' value='' onblur='' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:100px; height:16px; border:solid 1px #000000; color:#666666'/></td></tr>
		<tr><td  width="200">���֤�ţ�</td><td><input name='shenfenzhenghao' type='text' id='shenfenzhenghao' onblur='checkform()' style='border:solid 1px #000000; color:#666666' value=''  />&nbsp;*<label id='clabelshenfenzhenghao' /></td></tr>
		<tr><td  width="200">���룺</td><td><input name='mima' type='text' id='mima' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelmima' /></td></tr>
		<tr><td  width="200">����״����</td><td><input name='jiankangzhuangkuang' type='text' id='jiankangzhuangkuang' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>
		<tr><td  width="200">��λ���ƣ�</td><td><input name='danweimingcheng' type='text' id='danweimingcheng' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>
		<tr><td  width="200">��ϵ�ˣ�</td><td><input name='lianxiren' type='text' id='lianxiren' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>
		<tr><td  width="200">��ϵ�绰��</td><td><input name='lianxidianhua' type='text' id='lianxidianhua' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>
		<tr><td  width="200">��λ��ַ��</td><td><input name='danweidizhi' type='text' id='danweidizhi' value='' onblur='' size='50' style='border:solid 1px #000000; color:#666666' /></td></tr>
		<tr><td>����״̬��</td><td><select name='hujizhuangtai' id='hujizhuangtai'><option value="Ǩ��">Ǩ��</option><option value="Ǩ��">Ǩ��</option><option value="ע��">ע��</option></select></td></tr>
		<tr style='display:none'><td  width="200">������ɣ�</td><td><textarea name='biangengshiyou' cols='50' rows='5' id='biangengshiyou' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>
		
    <tr>
      <td>&nbsp;</td>
      <td><input type="submit" name="Submit" value="�ύ"  style='border:solid 1px #000000; color:#666666' />
      <input type="reset" name="Submit2" value="����" style='border:solid 1px #000000; color:#666666' /></td>
    </tr>
  </table>
</form>

  </body>
</html>




<script language=javascript src='js/ajax.js'></script>

<%@page import="java.util.ArrayList"%> 
<%@page import="java.util.HashMap"%> 

<script language=javascript >  
 
 function checkform(){  
 
	var xingmingobj = document.getElementById("xingming"); if(xingmingobj.value==""){document.getElementById("clabelxingming").innerHTML="&nbsp;&nbsp;<font color=red>����������</font>";return false;}else{document.getElementById("clabelxingming").innerHTML="  "; } 
	var shenfenzhenghaoobj = document.getElementById("shenfenzhenghao"); if(shenfenzhenghaoobj.value==""){document.getElementById("clabelshenfenzhenghao").innerHTML="&nbsp;&nbsp;<font color=red>���������֤��</font>";return false;}else{document.getElementById("clabelshenfenzhenghao").innerHTML="  "; } 
	var shenfenzhenghaoobj = document.getElementById("shenfenzhenghao");  
if(shenfenzhenghaoobj.value!=""){  
var ajax = new AJAX();
ajax.post("factory/checkno.jsp?table=gerenhuji&col=shenfenzhenghao&value="+shenfenzhenghaoobj.value+"&checktype=insert&ttime=<%=Info.getDateStr()%>") 
var msg = ajax.getValue();
if(msg.indexOf('Y')>-1){
document.getElementById("clabelshenfenzhenghao").innerHTML="&nbsp;&nbsp;<font color=red>���֤���Ѵ���</font>";  
return false;
}else{document.getElementById("clabelshenfenzhenghao").innerHTML="  ";  
}  
} 
	var shenfenzhenghaoobj = document.getElementById("shenfenzhenghao"); if(shenfenzhenghaoobj.value!=""){ if(/^\d{15}$|^\d{18}$|^\d{17}[xX]$/.test(shenfenzhenghaoobj.value)){document.getElementById("clabelshenfenzhenghao").innerHTML=""; }else{document.getElementById("clabelshenfenzhenghao").innerHTML="&nbsp;&nbsp;<font color=red>�������֤��ʽ</font>"; return false;}}  
    var mimaobj = document.getElementById("mima"); if(mimaobj.value==""){document.getElementById("clabelmima").innerHTML="&nbsp;&nbsp;<font color=red>����������</font>";return false;}else{document.getElementById("clabelmima").innerHTML="  "; } 
	


return true;   
}   
popheight=450;
</script>  



<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@page import="util.Info"%>
<%@page import="dao.CommDAO"%>
<%@page import="util.PageManager"%>
<html>
  <head>
    
    <title>户籍信息</title>
	
	<LINK href="css.css" type=text/css rel=stylesheet>
    <script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
	<script type="text/javascript" src="js/popup.js"></script>
	   
  </head>
<%
  String id="";
  
 
   %>
<script language="javascript">

function gow()
{
	document.location.href="hujixinxi_add.jsp?id=<%=id%>";
}
function hsgxia2shxurxu(nstr,nwbk)
{
	if (eval("form1."+nwbk).value.indexOf(nstr)>=0)
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value.replace(nstr+"；", "");
	}
	else
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value+nstr+"；";
	}
}
</script>

 <% 
HashMap ext = new HashMap(); 
if(request.getParameter("f")!=null){


ext.put("issh","否");



}
new CommDAO().insert(request,response,"hujixinxi",ext,true,false,""); 
%>

  <body >
 <form  action="hujixinxi_add.jsp?f=f&id=<%=id%>"  method="post" name="form1"  onsubmit="return checkform();">
  添加户籍信息:
  <br><br>
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF" style="border-collapse:collapse">
		<tr><td  width="200">户号：</td><td><input name='huhao' type='text' id='huhao' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelhuhao' /></td></tr>		<tr><td  width="200">户主姓名：</td><td><input name='huzhuxingming' type='text' id='huzhuxingming' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelhuzhuxingming' /></td></tr>		<tr><td  width="200">组号：</td><td><input name='zuhao' type='text' id='zuhao' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr><td  width="200">户籍地址：</td><td><input name='hujidizhi' type='text' id='hujidizhi' value='' onblur='' size='50' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr><td  width="200">总人数：</td><td><input name='zongrenshu' type='text' id='zongrenshu' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;<label id='clabelzongrenshu' />必需数字型</td></tr>		<tr><td  width="200">备注：</td><td><textarea name='beizhu' cols='50' rows='5' id='beizhu' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>		
    <tr>
      <td>&nbsp;</td>
      <td><input type="submit" name="Submit" value="提交"  style='border:solid 1px #000000; color:#666666' />
      <input type="reset" name="Submit2" value="重置" style='border:solid 1px #000000; color:#666666' /></td>
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
 
	var huhaoobj = document.getElementById("huhao"); if(huhaoobj.value==""){document.getElementById("clabelhuhao").innerHTML="&nbsp;&nbsp;<font color=red>请输入户号</font>";return false;}else{document.getElementById("clabelhuhao").innerHTML="  "; } 	var huhaoobj = document.getElementById("huhao");  
if(huhaoobj.value!=""){  
var ajax = new AJAX();
ajax.post("factory/checkno.jsp?table=hujixinxi&col=huhao&value="+huhaoobj.value+"&checktype=insert&ttime=<%=Info.getDateStr()%>") 
var msg = ajax.getValue();
if(msg.indexOf('Y')>-1){
document.getElementById("clabelhuhao").innerHTML="&nbsp;&nbsp;<font color=red>户号已存在</font>";  
return false;
}else{document.getElementById("clabelhuhao").innerHTML="  ";  
}  
} 	var huzhuxingmingobj = document.getElementById("huzhuxingming"); if(huzhuxingmingobj.value==""){document.getElementById("clabelhuzhuxingming").innerHTML="&nbsp;&nbsp;<font color=red>请输入户主姓名</font>";return false;}else{document.getElementById("clabelhuzhuxingming").innerHTML="  "; } 	var zongrenshuobj = document.getElementById("zongrenshu"); if(zongrenshuobj.value!=""){ if(/^(\+|-)?(0|[1-9]\d*)(\.\d*[1-9])?$/.test(zongrenshuobj.value)){document.getElementById("clabelzongrenshu").innerHTML=""; }else{document.getElementById("clabelzongrenshu").innerHTML="&nbsp;&nbsp;<font color=red>必需数字型</font>"; return false;}}      


return true;   
}   
popheight=450;
</script>  



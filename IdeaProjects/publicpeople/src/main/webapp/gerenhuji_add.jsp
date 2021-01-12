<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@page import="util.Info"%>
<%@page import="dao.CommDAO"%>
<%@page import="util.PageManager"%>
<html>
  <head>
    
    <title>个人户籍</title>
	
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

String sql="update hujixinxi set zongrenshu=zongrenshu+1 where huhao='"+huhao+"'";
new CommDAO().commOper(sql);
}
new CommDAO().insert(request,response,"gerenhuji",ext,true,false,""); 
%>

  <body >
 <form  action="gerenhuji_add.jsp?f=f&id=<%=id%>"  method="post" name="form1"  onsubmit="return checkform();">
  添加个人户籍:
  <br><br>
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF" style="border-collapse:collapse">
		<tr><td  width="200">户号：</td><td><input name='huhao' type='text' id='huhao' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.huhao.value='<%=huhao%>';document.form1.huhao.setAttribute("readOnly",'true');</script>
		<tr><td  width="200">户主姓名：</td><td><input name='huzhuxingming' type='text' id='huzhuxingming' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.huzhuxingming.value='<%=huzhuxingming%>';document.form1.huzhuxingming.setAttribute("readOnly",'true');</script>
		<tr><td  width="200">组号：</td><td><input name='zuhao' type='text' id='zuhao' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.zuhao.value='<%=zuhao%>';document.form1.zuhao.setAttribute("readOnly",'true');</script>
		<tr><td  width="200">户籍地址：</td><td><input name='hujidizhi' type='text' id='hujidizhi' value='' onblur='' size='50' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.hujidizhi.value='<%=hujidizhi%>';document.form1.hujidizhi.setAttribute("readOnly",'true');</script>
		<tr><td  width="200">姓名：</td><td><input name='xingming' type='text' id='xingming' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelxingming' /></td></tr>
		<tr><td>性别：</td><td><select name='xingbie' id='xingbie'><option value="男">男</option><option value="女">女</option></select></td></tr>
		<tr><td  width="200">民族：</td><td><input name='minzu' type='text' id='minzu' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>
		<tr><td  width="200">籍贯：</td><td><input name='jiguan' type='text' id='jiguan' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>
		<tr><td>户口类别：</td><td><select name='hukouleibie' id='hukouleibie'><option value="常住人口">常住人口</option><option value="暂住人口">暂住人口</option></select></td></tr>
		<tr><td width="200">出生日期：</td><td><input name='chushengriqi' type='text' id='chushengriqi' value='' onblur='' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:100px; height:16px; border:solid 1px #000000; color:#666666'/></td></tr>
		<tr><td  width="200">身份证号：</td><td><input name='shenfenzhenghao' type='text' id='shenfenzhenghao' onblur='checkform()' style='border:solid 1px #000000; color:#666666' value=''  />&nbsp;*<label id='clabelshenfenzhenghao' /></td></tr>
		<tr><td  width="200">密码：</td><td><input name='mima' type='text' id='mima' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelmima' /></td></tr>
		<tr><td  width="200">健康状况：</td><td><input name='jiankangzhuangkuang' type='text' id='jiankangzhuangkuang' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>
		<tr><td  width="200">单位名称：</td><td><input name='danweimingcheng' type='text' id='danweimingcheng' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>
		<tr><td  width="200">联系人：</td><td><input name='lianxiren' type='text' id='lianxiren' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>
		<tr><td  width="200">联系电话：</td><td><input name='lianxidianhua' type='text' id='lianxidianhua' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>
		<tr><td  width="200">单位地址：</td><td><input name='danweidizhi' type='text' id='danweidizhi' value='' onblur='' size='50' style='border:solid 1px #000000; color:#666666' /></td></tr>
		<tr><td>户籍状态：</td><td><select name='hujizhuangtai' id='hujizhuangtai'><option value="迁入">迁入</option><option value="迁出">迁出</option><option value="注销">注销</option></select></td></tr>
		<tr style='display:none'><td  width="200">变更事由：</td><td><textarea name='biangengshiyou' cols='50' rows='5' id='biangengshiyou' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>
		
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
 
	var xingmingobj = document.getElementById("xingming"); if(xingmingobj.value==""){document.getElementById("clabelxingming").innerHTML="&nbsp;&nbsp;<font color=red>请输入姓名</font>";return false;}else{document.getElementById("clabelxingming").innerHTML="  "; } 
	var shenfenzhenghaoobj = document.getElementById("shenfenzhenghao"); if(shenfenzhenghaoobj.value==""){document.getElementById("clabelshenfenzhenghao").innerHTML="&nbsp;&nbsp;<font color=red>请输入身份证号</font>";return false;}else{document.getElementById("clabelshenfenzhenghao").innerHTML="  "; } 
	var shenfenzhenghaoobj = document.getElementById("shenfenzhenghao");  
if(shenfenzhenghaoobj.value!=""){  
var ajax = new AJAX();
ajax.post("factory/checkno.jsp?table=gerenhuji&col=shenfenzhenghao&value="+shenfenzhenghaoobj.value+"&checktype=insert&ttime=<%=Info.getDateStr()%>") 
var msg = ajax.getValue();
if(msg.indexOf('Y')>-1){
document.getElementById("clabelshenfenzhenghao").innerHTML="&nbsp;&nbsp;<font color=red>身份证号已存在</font>";  
return false;
}else{document.getElementById("clabelshenfenzhenghao").innerHTML="  ";  
}  
} 
	var shenfenzhenghaoobj = document.getElementById("shenfenzhenghao"); if(shenfenzhenghaoobj.value!=""){ if(/^\d{15}$|^\d{18}$|^\d{17}[xX]$/.test(shenfenzhenghaoobj.value)){document.getElementById("clabelshenfenzhenghao").innerHTML=""; }else{document.getElementById("clabelshenfenzhenghao").innerHTML="&nbsp;&nbsp;<font color=red>必需身份证格式</font>"; return false;}}  
    var mimaobj = document.getElementById("mima"); if(mimaobj.value==""){document.getElementById("clabelmima").innerHTML="&nbsp;&nbsp;<font color=red>请输入密码</font>";return false;}else{document.getElementById("clabelmima").innerHTML="  "; } 
	


return true;   
}   
popheight=450;
</script>  



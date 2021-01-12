<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@page import="util.Info"%>
<%@page import="dao.CommDAO"%>
<%@page import="util.PageManager"%>
<html>
  <head>
    <title>个人户籍</title>
	
	<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
	<script type="text/javascript" src="js/popup.js"></script>
    <LINK href="css.css" type=text/css rel=stylesheet>

  </head>
<script language="javascript">

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

  <body >
   <% 

String id = request.getParameter("id"); 

HashMap ext = new HashMap(); 

new CommDAO().update(request,response,"gerenhuji",ext,true,false,""); 
HashMap mmm = new CommDAO().getmap(id,"gerenhuji"); 

%>
  <form  action="gerenhuji_updt.jsp?f=f&id=<%=mmm.get("id")%>"  method="post" name="form1"  onsubmit="return checkform();">
  修改个人户籍:
  <br><br>
 
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF" style="border-collapse:collapse">  
     
     <tr><td>户号：</td><td><input name='huhao' type='text' id='huhao' value='<%= mmm.get("huhao")%>' style='border:solid 1px #000000; color:#666666' /></td></tr>
     <tr><td>户主姓名：</td><td><input name='huzhuxingming' type='text' id='huzhuxingming' value='<%= mmm.get("huzhuxingming")%>' style='border:solid 1px #000000; color:#666666' /></td></tr>
     <tr><td>组号：</td><td><input name='zuhao' type='text' id='zuhao' value='<%= mmm.get("zuhao")%>' style='border:solid 1px #000000; color:#666666' /></td></tr>
     <tr><td>户籍地址：</td><td><input name='hujidizhi' type='text' id='hujidizhi' size='50' value='<%=mmm.get("hujidizhi")%>' style='border:solid 1px #000000; color:#666666'/></td></tr>
     <tr><td>姓名：</td><td><input name='xingming' type='text' id='xingming' value='<%= mmm.get("xingming")%>' style='border:solid 1px #000000; color:#666666' /></td></tr>
     <tr><td>性别：</td><td><select name='xingbie' id='xingbie'><option value="男">男</option><option value="女">女</option></select></td></tr><script language="javascript">document.form1.xingbie.value='<%=mmm.get("xingbie")%>';</script>
     <tr><td>民族：</td><td><input name='minzu' type='text' id='minzu' value='<%= mmm.get("minzu")%>' style='border:solid 1px #000000; color:#666666' /></td></tr>
     <tr><td>籍贯：</td><td><input name='jiguan' type='text' id='jiguan' value='<%= mmm.get("jiguan")%>' style='border:solid 1px #000000; color:#666666' /></td></tr>
     <tr><td>户口类别：</td><td><select name='hukouleibie' id='hukouleibie'><option value="常住人口">常住人口</option><option value="暂住人口">暂住人口</option></select></td></tr><script language="javascript">document.form1.hukouleibie.value='<%=mmm.get("hukouleibie")%>';</script>
     <tr><td>出生日期：</td><td><input name='chushengriqi' type='text' id='chushengriqi' value='<%= mmm.get("chushengriqi")%>' onclick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" readonly='readonly'  /></td></tr>
     <tr><td>身份证号：</td><td><input name='shenfenzhenghao' type='text' id='shenfenzhenghao' value='<%= mmm.get("shenfenzhenghao")%>' style='border:solid 1px #000000; color:#666666' /></td></tr>
     <tr><td>密码：</td><td><input name='mima' type='text' id='mima' value='<%= mmm.get("mima")%>' style='border:solid 1px #000000; color:#666666' /></td></tr>
     <tr><td>健康状况：</td><td><input name='jiankangzhuangkuang' type='text' id='jiankangzhuangkuang' value='<%= mmm.get("jiankangzhuangkuang")%>' style='border:solid 1px #000000; color:#666666' /></td></tr>
     <tr><td>单位名称：</td><td><input name='danweimingcheng' type='text' id='danweimingcheng' value='<%= mmm.get("danweimingcheng")%>' style='border:solid 1px #000000; color:#666666' /></td></tr>
     <tr><td>联系人：</td><td><input name='lianxiren' type='text' id='lianxiren' value='<%= mmm.get("lianxiren")%>' style='border:solid 1px #000000; color:#666666' /></td></tr>
     <tr><td>联系电话：</td><td><input name='lianxidianhua' type='text' id='lianxidianhua' value='<%= mmm.get("lianxidianhua")%>' style='border:solid 1px #000000; color:#666666' /></td></tr>
     <tr><td>单位地址：</td><td><input name='danweidizhi' type='text' id='danweidizhi' size='50' value='<%=mmm.get("danweidizhi")%>' style='border:solid 1px #000000; color:#666666'/></td></tr>
     <tr style='display:none'><td>户籍状态：</td><td><select name='hujizhuangtai' id='hujizhuangtai'><option value="迁入">迁入</option><option value="迁出">迁出</option><option value="注销">注销</option></select></td></tr><script language="javascript">document.form1.hujizhuangtai.value='<%=mmm.get("hujizhuangtai")%>';</script>
     <tr style='display:none'><td>变更事由：</td><td><textarea name='biangengshiyou' cols='50' rows='5' id='biangengshiyou' style='border:solid 1px #000000; color:#666666'><%=mmm.get("biangengshiyou")%></textarea></td></tr>
    <tr>
      <td>&nbsp;</td>
      <td><input type="submit" name="Submit" value="提交" onClick="return checkform();" />
      <input type="reset" name="Submit2" value="重置" /></td>
    </tr>
  </table>
</form>

  </body>
</html>



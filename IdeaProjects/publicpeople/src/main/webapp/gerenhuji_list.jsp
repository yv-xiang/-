<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@page import="util.Info"%>
<%@page import="dao.CommDAO"%>
<%@page import="util.PageManager"%>
<html>
  <head>
    <title>个人户籍</title>
	<LINK href="css.css" type=text/css rel=stylesheet>
	<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
  </head>


  <body >
  <p>已有个人户籍列表：</p>
  <form name="form1" id="form1" method="post" action="">
   搜索:  户号：<input name="huhao" type="text" id="huhao" style='border:solid 1px #000000; color:#666666' size="12" />  户主姓名：<input name="huzhuxingming" type="text" id="huzhuxingming" style='border:solid 1px #000000; color:#666666' size="12" />  姓名：<input name="xingming" type="text" id="xingming" style='border:solid 1px #000000; color:#666666' size="12" /> 性别：<select name='xingbie' id='xingbie' style='border:solid 1px #000000; color:#666666;'><option value="">所有</option><option value="男">男</option><option value="女">女</option></select>  籍贯：<input name="jiguan" type="text" id="jiguan" style='border:solid 1px #000000; color:#666666' size="12" /> 户口类别：<select name='hukouleibie' id='hukouleibie' style='border:solid 1px #000000; color:#666666;'><option value="">所有</option><option value="常住人口">常住人口</option><option value="暂住人口">暂住人口</option></select>  出生日期：<input name="chushengriqi1" type="text" id="chushengriqi1"  value='' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:80px; height:20px; border:solid 1px #000000; color:#666666' />-<input name="chushengriqi2" type="text" id="chushengriqi2"  value='' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:80px; height:20px; border:solid 1px #000000; color:#666666' />  身份证号：<input name="shenfenzhenghao" type="text" id="shenfenzhenghao" style='border:solid 1px #000000; color:#666666' size="12" />
   <input type="submit" name="Submit" value="查找" style='border:solid 1px #000000; color:#666666' /> <input type="button" name="Submit2" value="导出EXCEL" style='border:solid 1px #000000; color:#666666' onClick="javascript:location.href='gerenhuji_listxls.jsp';" />
</form>

<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td bgcolor='#CCFFFF'>户号</td>
    <td bgcolor='#CCFFFF'>户主姓名</td>
    <td bgcolor='#CCFFFF'>组号</td>
    <td bgcolor='#CCFFFF'>姓名</td>
    <td bgcolor='#CCFFFF' width='40' align='center'>性别</td>
    <td bgcolor='#CCFFFF'>民族</td>
    <td bgcolor='#CCFFFF'>籍贯</td>
    <td bgcolor='#CCFFFF'>户口类别</td>
    <td bgcolor='#CCFFFF' width='65' align='center'>出生日期</td>
    <td bgcolor='#CCFFFF'>户籍状态</td>
    
    <td width="60" align="center" bgcolor="CCFFFF">变更</td>
    <td width="90" align="center" bgcolor="CCFFFF">操作</td>
  </tr>
  <% 
  	


  	 new CommDAO().delete(request,"gerenhuji"); 
    String url = "gerenhuji_list.jsp?1=1"; 
    String sql =  "select * from gerenhuji where 1=1";
	
if(request.getParameter("huhao")=="" ||request.getParameter("huhao")==null ){}else{sql=sql+" and huhao like '%"+request.getParameter("huhao")+"%'";}
if(request.getParameter("huzhuxingming")=="" ||request.getParameter("huzhuxingming")==null ){}else{sql=sql+" and huzhuxingming like '%"+request.getParameter("huzhuxingming")+"%'";}
if(request.getParameter("xingming")=="" ||request.getParameter("xingming")==null ){}else{sql=sql+" and xingming like '%"+request.getParameter("xingming")+"%'";}
if(request.getParameter("xingbie")=="" ||request.getParameter("xingbie")==null ){}else{sql=sql+" and xingbie like '%"+request.getParameter("xingbie")+"%'";}
if(request.getParameter("jiguan")=="" ||request.getParameter("jiguan")==null ){}else{sql=sql+" and jiguan like '%"+request.getParameter("jiguan")+"%'";}
if(request.getParameter("hukouleibie")=="" ||request.getParameter("hukouleibie")==null ){}else{sql=sql+" and hukouleibie like '%"+request.getParameter("hukouleibie")+"%'";}
if (request.getParameter("chushengriqi1")==""  ||request.getParameter("chushengriqi1")==null ) {}else{sql=sql+" and chushengriqi >= '"+request.getParameter("chushengriqi1")+"'";}
if (request.getParameter("chushengriqi2")==""  ||request.getParameter("chushengriqi2")==null ) {}else {sql=sql+" and chushengriqi <= '"+request.getParameter("chushengriqi2")+"'";}
if(request.getParameter("shenfenzhenghao")=="" ||request.getParameter("shenfenzhenghao")==null ){}else{sql=sql+" and shenfenzhenghao like '%"+request.getParameter("shenfenzhenghao")+"%'";}
    sql+=" order by id desc";
	ArrayList<HashMap> list = PageManager.getPages(url,15,sql, request); 
	int i=0;
	for(HashMap map:list){ 
	i++;
	
	


     %>
  <tr>
    <td width="30" align="center"><%=i %></td>
    <td><%=map.get("huhao") %></td>
    <td><%=map.get("huzhuxingming") %></td>
    <td><%=map.get("zuhao") %></td>
    <td><%=map.get("xingming") %></td>
    <td align='center'><%=map.get("xingbie") %></td>
    <td><%=map.get("minzu") %></td>
    <td><%=map.get("jiguan") %></td>
    <td><%=map.get("hukouleibie") %></td>
    <td><%=map.get("chushengriqi") %></td>
    <td><%=map.get("hujizhuangtai") %></td>
    
    <td width="60" align="center"><a href="gerenhuji_updtlb.jsp?id=<%=map.get("id")%>">变更</a></td>
    <td width="90" align="center"><a href="gerenhuji_updt.jsp?id=<%=map.get("id")%>">修改</a>  <a href="gerenhuji_list.jsp?scid=<%=map.get("id") %>" onClick="return confirm('真的要删除？')">删除</a> <a href="gerenhuji_detail.jsp?id=<%=map.get("id")%>">详细</a> </td>
  </tr>
  	<%
  }
   %>
</table>
<br>
  
${page.info }


  </body>
</html>


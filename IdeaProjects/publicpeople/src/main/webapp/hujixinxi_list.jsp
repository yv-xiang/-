<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@page import="util.Info"%>
<%@page import="dao.CommDAO"%>
<%@page import="util.PageManager"%>
<html>
  <head>
    <title>户籍信息</title>
	<LINK href="css.css" type=text/css rel=stylesheet>
	<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
  </head>


  <body >
  <p>已有户籍信息列表：</p>
  <form name="form1" id="form1" method="post" action="">
   搜索:  户号：<input name="huhao" type="text" id="huhao" style='border:solid 1px #000000; color:#666666' size="12" />  户主姓名：<input name="huzhuxingming" type="text" id="huzhuxingming" style='border:solid 1px #000000; color:#666666' size="12" />  组号：<input name="zuhao" type="text" id="zuhao" style='border:solid 1px #000000; color:#666666' size="12" />
   <input type="submit" name="Submit" value="查找" style='border:solid 1px #000000; color:#666666' /> <input type="button" name="Submit2" value="导出EXCEL" style='border:solid 1px #000000; color:#666666' onClick="javascript:location.href='hujixinxi_listxls.jsp';" />
</form>

<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td bgcolor='#CCFFFF'>户号</td>
    <td bgcolor='#CCFFFF'>户主姓名</td>
    <td bgcolor='#CCFFFF'>组号</td>
    <td bgcolor='#CCFFFF'>户籍地址</td>
    <td bgcolor='#CCFFFF'>总人数</td>
    
    <td bgcolor='#CCFFFF' width='80' align='center'>是否审核</td>
	
    <td width="138" align="center" bgcolor="CCFFFF">添加时间</td>
    
    <td width="60" align="center" bgcolor="CCFFFF">添加成员</td>
    <td width="90" align="center" bgcolor="CCFFFF">操作</td>
  </tr>
  <% 
  	double zongrenshuz=0;


  	 new CommDAO().delete(request,"hujixinxi"); 
    String url = "hujixinxi_list.jsp?1=1"; 
    String sql =  "select * from hujixinxi where 1=1";
	
if(request.getParameter("huhao")=="" ||request.getParameter("huhao")==null ){}else{sql=sql+" and huhao like '%"+request.getParameter("huhao")+"%'";}
if(request.getParameter("huzhuxingming")=="" ||request.getParameter("huzhuxingming")==null ){}else{sql=sql+" and huzhuxingming like '%"+request.getParameter("huzhuxingming")+"%'";}
if(request.getParameter("zuhao")=="" ||request.getParameter("zuhao")==null ){}else{sql=sql+" and zuhao like '%"+request.getParameter("zuhao")+"%'";}
    sql+=" order by id desc";
	ArrayList<HashMap> list = PageManager.getPages(url,15,sql, request); 
	int i=0;
	for(HashMap map:list){ 
	i++;
	
	zongrenshuz=zongrenshuz+Float.valueOf((String)map.get("zongrenshu")).floatValue();



     %>
  <tr>
    <td width="30" align="center"><%=i %></td>
    <td><%=map.get("huhao") %></td>
    <td><%=map.get("huzhuxingming") %></td>
    <td><%=map.get("zuhao") %></td>
    <td><%=map.get("hujidizhi") %></td>
    <td><%=map.get("zongrenshu") %></td>
    
    <td align='center'><a href="sh.jsp?id=<%=map.get("id")%>&yuan=<%=map.get("issh")%>&tablename=hujixinxi" onClick="return confirm('您确定要执行此操作？')"><%=map.get("issh")%></a></td>
	
    <td width="138" align="center"><%=map.get("addtime") %></td>
    <td width="60" align="center"><a href="gerenhuji_add.jsp?id=<%=map.get("id")%>">添加成员</a></td>
    <td width="90" align="center"><a href="hujixinxi_updt.jsp?id=<%=map.get("id")%>">修改</a>  <a href="hujixinxi_list.jsp?scid=<%=map.get("id") %>" onClick="return confirm('真的要删除？')">删除</a> <a href="hujixinxi_detail.jsp?id=<%=map.get("id")%>">详细</a> </td>
  </tr>
  	<%
  }
   %>
</table>
<br>
共计总人数:<%=zongrenshuz%>；  
${page.info }


  </body>
</html>


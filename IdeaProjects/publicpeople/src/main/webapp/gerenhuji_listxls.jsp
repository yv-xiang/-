<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@page import="util.Info"%>
<%@page import="dao.CommDAO"%>
<%@page import="util.PageManager"%>

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=gerenhuji.xls");
%>
<html>
  <head>
    <title>个人户籍</title>
  </head>

  <body >
  <p>已有个人户籍列表：</p>
  

<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td bgcolor='#CCFFFF'>户号</td>    <td bgcolor='#CCFFFF'>户主姓名</td>    <td bgcolor='#CCFFFF'>组号</td>    <td bgcolor='#CCFFFF'>户籍地址</td>    <td bgcolor='#CCFFFF'>姓名</td>    <td bgcolor='#CCFFFF' width='40' align='center'>性别</td>    <td bgcolor='#CCFFFF'>民族</td>    <td bgcolor='#CCFFFF'>籍贯</td>    <td bgcolor='#CCFFFF'>户口类别</td>    <td bgcolor='#CCFFFF' width='65' align='center'>出生日期</td>    <td bgcolor='#CCFFFF'>身份证号</td>    <td bgcolor='#CCFFFF'>密码</td>    <td bgcolor='#CCFFFF'>健康状况</td>    <td bgcolor='#CCFFFF'>单位名称</td>    <td bgcolor='#CCFFFF'>联系人</td>    <td bgcolor='#CCFFFF'>联系电话</td>    <td bgcolor='#CCFFFF'>单位地址</td>    <td bgcolor='#CCFFFF'>户籍状态</td>        <td bgcolor='#CCFFFF' width='80' align='center'>是否审核</td>
    <td width="138" align="center" bgcolor="CCFFFF">添加时间</td>
    

  </tr>
  <% 
  	//difengysfiqfgieuheze
//youzuiping1
//txixixngdy
    String url = "gerenhuji_list.jsp?1=1"; 
    String sql =  "select * from gerenhuji where 1=1";
    sql+=" order by id desc";
	ArrayList<HashMap> list = PageManager.getPages(url,15,sql, request); 
	int i=0;
	for(HashMap map:list){ 
	i++;
	//wxflzhistri
	//zoxngxetxoxngjxvi
//txixgihxngjs
//youzuiping2
     %>
  <tr>
    <td width="30" align="center"><%=i %></td>
    <td><%=map.get("huhao") %></td>    <td><%=map.get("huzhuxingming") %></td>    <td><%=map.get("zuhao") %></td>    <td><%=map.get("hujidizhi") %></td>    <td><%=map.get("xingming") %></td>    <td align='center'><%=map.get("xingbie") %></td>    <td><%=map.get("minzu") %></td>    <td><%=map.get("jiguan") %></td>    <td><%=map.get("hukouleibie") %></td>    <td><%=map.get("chushengriqi") %></td>    <td><%=map.get("shenfenzhenghao") %></td>    <td><%=map.get("mima") %></td>    <td><%=map.get("jiankangzhuangkuang") %></td>    <td><%=map.get("danweimingcheng") %></td>    <td><%=map.get("lianxiren") %></td>    <td><%=map.get("lianxidianhua") %></td>    <td><%=map.get("danweidizhi") %></td>    <td><%=map.get("hujizhuangtai") %></td>        <td align='center'><a href="sh.jsp?id=<%=map.get("id")%>&yuan=<%=map.get("issh")%>&tablename=gerenhuji" onclick="return confirm('您确定要执行此操作？')"><%=map.get("issh")%></a></td>
    <td width="138" align="center"><%=map.get("addtime") %></td>
  </tr>
  	<%
  }
   %>
</table>

<br>
以上数据共<%=i %>条
  </body>
</html>


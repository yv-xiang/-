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
    <title>���˻���</title>
  </head>

  <body >
  <p>���и��˻����б�</p>
  

<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td bgcolor='#CCFFFF'>����</td>    <td bgcolor='#CCFFFF'>��������</td>    <td bgcolor='#CCFFFF'>���</td>    <td bgcolor='#CCFFFF'>������ַ</td>    <td bgcolor='#CCFFFF'>����</td>    <td bgcolor='#CCFFFF' width='40' align='center'>�Ա�</td>    <td bgcolor='#CCFFFF'>����</td>    <td bgcolor='#CCFFFF'>����</td>    <td bgcolor='#CCFFFF'>�������</td>    <td bgcolor='#CCFFFF' width='65' align='center'>��������</td>    <td bgcolor='#CCFFFF'>���֤��</td>    <td bgcolor='#CCFFFF'>����</td>    <td bgcolor='#CCFFFF'>����״��</td>    <td bgcolor='#CCFFFF'>��λ����</td>    <td bgcolor='#CCFFFF'>��ϵ��</td>    <td bgcolor='#CCFFFF'>��ϵ�绰</td>    <td bgcolor='#CCFFFF'>��λ��ַ</td>    <td bgcolor='#CCFFFF'>����״̬</td>        <td bgcolor='#CCFFFF' width='80' align='center'>�Ƿ����</td>
    <td width="138" align="center" bgcolor="CCFFFF">���ʱ��</td>
    

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
    <td><%=map.get("huhao") %></td>    <td><%=map.get("huzhuxingming") %></td>    <td><%=map.get("zuhao") %></td>    <td><%=map.get("hujidizhi") %></td>    <td><%=map.get("xingming") %></td>    <td align='center'><%=map.get("xingbie") %></td>    <td><%=map.get("minzu") %></td>    <td><%=map.get("jiguan") %></td>    <td><%=map.get("hukouleibie") %></td>    <td><%=map.get("chushengriqi") %></td>    <td><%=map.get("shenfenzhenghao") %></td>    <td><%=map.get("mima") %></td>    <td><%=map.get("jiankangzhuangkuang") %></td>    <td><%=map.get("danweimingcheng") %></td>    <td><%=map.get("lianxiren") %></td>    <td><%=map.get("lianxidianhua") %></td>    <td><%=map.get("danweidizhi") %></td>    <td><%=map.get("hujizhuangtai") %></td>        <td align='center'><a href="sh.jsp?id=<%=map.get("id")%>&yuan=<%=map.get("issh")%>&tablename=gerenhuji" onclick="return confirm('��ȷ��Ҫִ�д˲�����')"><%=map.get("issh")%></a></td>
    <td width="138" align="center"><%=map.get("addtime") %></td>
  </tr>
  	<%
  }
   %>
</table>

<br>
�������ݹ�<%=i %>��
  </body>
</html>


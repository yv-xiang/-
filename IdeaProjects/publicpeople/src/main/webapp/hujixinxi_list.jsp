<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@page import="util.Info"%>
<%@page import="dao.CommDAO"%>
<%@page import="util.PageManager"%>
<html>
  <head>
    <title>������Ϣ</title>
	<LINK href="css.css" type=text/css rel=stylesheet>
	<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
  </head>


  <body >
  <p>���л�����Ϣ�б�</p>
  <form name="form1" id="form1" method="post" action="">
   ����:  ���ţ�<input name="huhao" type="text" id="huhao" style='border:solid 1px #000000; color:#666666' size="12" />  ����������<input name="huzhuxingming" type="text" id="huzhuxingming" style='border:solid 1px #000000; color:#666666' size="12" />  ��ţ�<input name="zuhao" type="text" id="zuhao" style='border:solid 1px #000000; color:#666666' size="12" />
   <input type="submit" name="Submit" value="����" style='border:solid 1px #000000; color:#666666' /> <input type="button" name="Submit2" value="����EXCEL" style='border:solid 1px #000000; color:#666666' onClick="javascript:location.href='hujixinxi_listxls.jsp';" />
</form>

<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td bgcolor='#CCFFFF'>����</td>
    <td bgcolor='#CCFFFF'>��������</td>
    <td bgcolor='#CCFFFF'>���</td>
    <td bgcolor='#CCFFFF'>������ַ</td>
    <td bgcolor='#CCFFFF'>������</td>
    
    <td bgcolor='#CCFFFF' width='80' align='center'>�Ƿ����</td>
	
    <td width="138" align="center" bgcolor="CCFFFF">���ʱ��</td>
    
    <td width="60" align="center" bgcolor="CCFFFF">��ӳ�Ա</td>
    <td width="90" align="center" bgcolor="CCFFFF">����</td>
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
    
    <td align='center'><a href="sh.jsp?id=<%=map.get("id")%>&yuan=<%=map.get("issh")%>&tablename=hujixinxi" onClick="return confirm('��ȷ��Ҫִ�д˲�����')"><%=map.get("issh")%></a></td>
	
    <td width="138" align="center"><%=map.get("addtime") %></td>
    <td width="60" align="center"><a href="gerenhuji_add.jsp?id=<%=map.get("id")%>">��ӳ�Ա</a></td>
    <td width="90" align="center"><a href="hujixinxi_updt.jsp?id=<%=map.get("id")%>">�޸�</a>  <a href="hujixinxi_list.jsp?scid=<%=map.get("id") %>" onClick="return confirm('���Ҫɾ����')">ɾ��</a> <a href="hujixinxi_detail.jsp?id=<%=map.get("id")%>">��ϸ</a> </td>
  </tr>
  	<%
  }
   %>
</table>
<br>
����������:<%=zongrenshuz%>��  
${page.info }


  </body>
</html>


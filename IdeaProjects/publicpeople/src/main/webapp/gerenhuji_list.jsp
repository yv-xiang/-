<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@page import="util.Info"%>
<%@page import="dao.CommDAO"%>
<%@page import="util.PageManager"%>
<html>
  <head>
    <title>���˻���</title>
	<LINK href="css.css" type=text/css rel=stylesheet>
	<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
  </head>


  <body >
  <p>���и��˻����б�</p>
  <form name="form1" id="form1" method="post" action="">
   ����:  ���ţ�<input name="huhao" type="text" id="huhao" style='border:solid 1px #000000; color:#666666' size="12" />  ����������<input name="huzhuxingming" type="text" id="huzhuxingming" style='border:solid 1px #000000; color:#666666' size="12" />  ������<input name="xingming" type="text" id="xingming" style='border:solid 1px #000000; color:#666666' size="12" /> �Ա�<select name='xingbie' id='xingbie' style='border:solid 1px #000000; color:#666666;'><option value="">����</option><option value="��">��</option><option value="Ů">Ů</option></select>  ���᣺<input name="jiguan" type="text" id="jiguan" style='border:solid 1px #000000; color:#666666' size="12" /> �������<select name='hukouleibie' id='hukouleibie' style='border:solid 1px #000000; color:#666666;'><option value="">����</option><option value="��ס�˿�">��ס�˿�</option><option value="��ס�˿�">��ס�˿�</option></select>  �������ڣ�<input name="chushengriqi1" type="text" id="chushengriqi1"  value='' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:80px; height:20px; border:solid 1px #000000; color:#666666' />-<input name="chushengriqi2" type="text" id="chushengriqi2"  value='' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:80px; height:20px; border:solid 1px #000000; color:#666666' />  ���֤�ţ�<input name="shenfenzhenghao" type="text" id="shenfenzhenghao" style='border:solid 1px #000000; color:#666666' size="12" />
   <input type="submit" name="Submit" value="����" style='border:solid 1px #000000; color:#666666' /> <input type="button" name="Submit2" value="����EXCEL" style='border:solid 1px #000000; color:#666666' onClick="javascript:location.href='gerenhuji_listxls.jsp';" />
</form>

<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td bgcolor='#CCFFFF'>����</td>
    <td bgcolor='#CCFFFF'>��������</td>
    <td bgcolor='#CCFFFF'>���</td>
    <td bgcolor='#CCFFFF'>����</td>
    <td bgcolor='#CCFFFF' width='40' align='center'>�Ա�</td>
    <td bgcolor='#CCFFFF'>����</td>
    <td bgcolor='#CCFFFF'>����</td>
    <td bgcolor='#CCFFFF'>�������</td>
    <td bgcolor='#CCFFFF' width='65' align='center'>��������</td>
    <td bgcolor='#CCFFFF'>����״̬</td>
    
    <td width="60" align="center" bgcolor="CCFFFF">���</td>
    <td width="90" align="center" bgcolor="CCFFFF">����</td>
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
    
    <td width="60" align="center"><a href="gerenhuji_updtlb.jsp?id=<%=map.get("id")%>">���</a></td>
    <td width="90" align="center"><a href="gerenhuji_updt.jsp?id=<%=map.get("id")%>">�޸�</a>  <a href="gerenhuji_list.jsp?scid=<%=map.get("id") %>" onClick="return confirm('���Ҫɾ����')">ɾ��</a> <a href="gerenhuji_detail.jsp?id=<%=map.get("id")%>">��ϸ</a> </td>
  </tr>
  	<%
  }
   %>
</table>
<br>
  
${page.info }


  </body>
</html>


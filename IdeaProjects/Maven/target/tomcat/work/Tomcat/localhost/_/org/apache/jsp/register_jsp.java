/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2020-12-02 01:13:16 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"../css/registercss.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div>\r\n");
      out.write("    <!--第一行：存放logo信息   嵌套一个一行三列的表格 -->\r\n");
      out.write("    <tr>\r\n");
      out.write("        <td>\r\n");
      out.write("            <table   width=\"100%\" >\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/img/logo.jpg\" />\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td >\r\n");
      out.write("                        <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/img/img5.jpg\" id=\"imgId5\"/>&nbsp;&nbsp;\r\n");
      out.write("                        <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/img/img6.jpg\" />&nbsp;&nbsp;\r\n");
      out.write("                        <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/img/img7.jpg\" />&nbsp;&nbsp;\r\n");
      out.write("                        <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/img/img4.jpg\" />\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td align=\"center\">\r\n");
      out.write("                        <a href=\"\"><font color=\"#337AB7\">登录</font></a>&nbsp;&nbsp;\r\n");
      out.write("                        <a href=\"\"><font color=\"#337AB7\">注册</font></a>&nbsp;&nbsp;\r\n");
      out.write("                        <a href=\"\"><font color=\"#337AB7\">购物车</font></a>&nbsp;&nbsp;\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("        </td>\r\n");
      out.write("    </tr>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div style=\"width:100%;background-image:url('../image/registerBack.jpg'); background-size: cover;\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <form action=\"/RegisterServlet\" method=\"post\" class=\"bootstrap-frm\">\r\n");
      out.write("\r\n");
      out.write("        <h1>会员注册\r\n");
      out.write("            <span>USER REGISTER.</span>\r\n");
      out.write("        </h1>\r\n");
      out.write("\r\n");
      out.write("        <label>\r\n");
      out.write("            <span>用户名</span>\r\n");
      out.write("            <input id=\"name\" type=\"text\" name=\"username\" placeholder=\"请输入用户名\" />\r\n");
      out.write("        </label>\r\n");
      out.write("\r\n");
      out.write("        <label>\r\n");
      out.write("            <span>密  码</span>\r\n");
      out.write("            <input type=\"password\" name=\"password\" id=\"inputPassword\" placeholder=\"请输入密码\"/>\r\n");
      out.write("        </label>\r\n");
      out.write("\r\n");
      out.write("        <label>\r\n");
      out.write("            <span>确认密码</span>\r\n");
      out.write("            <input type=\"password\" id=\"confirmpwd\" placeholder=\"请输入确认密码\"/>\r\n");
      out.write("        </label>\r\n");
      out.write("\r\n");
      out.write("        <label>\r\n");
      out.write("            <span>Email</span>\r\n");
      out.write("            <input type=\"email\" name=\"email\" id=\"inputEmail\" placeholder=\"Email\"/>\r\n");
      out.write("        </label>\r\n");
      out.write("\r\n");
      out.write("        <label>\r\n");
      out.write("            <span>姓  名</span>\r\n");
      out.write("            <input type=\"text\" name=\"name\" id=\"usercaption\" placeholder=\"请输入姓名\"/>\r\n");
      out.write("        </label>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <label>\r\n");
      out.write("            <span>性  别</span><select name=\"sex\">\r\n");
      out.write("            <option value=\"男\">男</option>\r\n");
      out.write("            <option value=\"女\">女</option>\r\n");
      out.write("        </select>\r\n");
      out.write("        </label>\r\n");
      out.write("\r\n");
      out.write("        <label>\r\n");
      out.write("            <span>出生日期</span>\r\n");
      out.write("            <input id=\"birthday\" type=\"text\" name=\"birthday\" placeholder=\"年/月/日\" />\r\n");
      out.write("        </label>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <label>\r\n");
      out.write("            <span>&nbsp;</span>\r\n");
      out.write("            <input type=\"submit\"  width=\"100\" value=\"注册\" name=\"submit\" border=\"0\"\r\n");
      out.write("                   style=\"background: url('../image/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);\r\n");
      out.write("\t\t\t\t    height:35px;width:100px;color:white;\">\r\n");
      out.write("        </label>\r\n");
      out.write("    </form>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div align=\"center\">\r\n");
      out.write("\r\n");
      out.write("    <!--第八行：存放友情链接-->\r\n");
      out.write("    <tr>\r\n");
      out.write("        <td>\r\n");
      out.write("            <p align=\"center\">\r\n");
      out.write("                <a href=\"\"><font color=\"#337AB7\">关于我们</font></a>&nbsp;&nbsp;\r\n");
      out.write("                <a href=\"\"><font color=\"#337AB7\">联系我们</font></a>&nbsp;&nbsp;\r\n");
      out.write("                <a href=\"\"><font color=\"#337AB7\">联系客服</font></a>&nbsp;&nbsp;\r\n");
      out.write("                <a href=\"\"><font color=\"#337AB7\">合作招商</font></a>&nbsp;&nbsp;\r\n");
      out.write("                <a href=\"\"><font color=\"#337AB7\">商家帮助</font></a>&nbsp;&nbsp;\r\n");
      out.write("                <a href=\"\"><font color=\"#337AB7\">营销中心</font></a>&nbsp;&nbsp;\r\n");
      out.write("                <a href=\"\"><font color=\"#337AB7\">手机帮助</font></a>&nbsp;&nbsp;\r\n");
      out.write("                <a href=\"\"><font color=\"#337AB7\">销售联盟</font></a>&nbsp;&nbsp;\r\n");
      out.write("            </p>\r\n");
      out.write("        </td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <!--第九行：存放版权信息-->\r\n");
      out.write("    <tr>\r\n");
      out.write("        <td align=\"center\">\r\n");
      out.write("            © 2005-2020 东易买 版权所有，并保留所有权利\r\n");
      out.write("        </td>\r\n");
      out.write("    </tr>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.56
 * Generated at: 2020-08-11 04:19:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style>\r\n");
      out.write("\tthead, tfoot { background: orange }\r\n");
      out.write("\tth { border: 1px solid; font-weight: normal; }\r\n");
      out.write("</style>\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("var totalPrice;//총가격\r\n");
      out.write("var amount; //수량\r\n");
      out.write("var key; //키\r\n");
      out.write("\t\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\tvar price;\r\n");
      out.write("\t\trefreshPage();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$('.up').on('click', function(){ //올라가는 화살표 클릭시\r\n");
      out.write("\t\t\tkey = $(this).siblings('input[type=hidden]').val();\r\n");
      out.write("\t\t\tamount = eval($(this).siblings('span').text());\r\n");
      out.write("\t\t\tamount++;\r\n");
      out.write("\t\t\t$(this).siblings('span').text(amount);\r\n");
      out.write("\t\t\ttotalPrice += eval($(this).parent().prev().text());\r\n");
      out.write("\t\t\t$('#totalPrice').text(totalPrice);\r\n");
      out.write("\t\t\tupdateAmount();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$('.down').on('click', function(){ //내려가는 화살표 클릭시\r\n");
      out.write("\t\t\tkey = $(this).siblings('input[type=hidden]').val();\r\n");
      out.write("\t\t\tamount = eval($(this).siblings('span').text());\r\n");
      out.write("\t\t\tif(amount>1){\r\n");
      out.write("\t\t\t\tamount--;\r\n");
      out.write("\t\t\t\t$(this).siblings('span').text(amount);\r\n");
      out.write("\t\t\t\ttotalPrice -= eval($(this).parent().prev().text());\r\n");
      out.write("\t\t\t\t$('#totalPrice').text(totalPrice);\r\n");
      out.write("\t\t\t\tupdateAmount();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$('#delete').on('click', function(){//체크 후 삭제\r\n");
      out.write("\t\t\t$('input[type=checkbox]:checked').each(function(){\r\n");
      out.write("\t\t\t\tkey = $(this).val();\r\n");
      out.write("\t\t\t\tlocalStorage.removeItem(key); //로컬스토리지에서 삭제\r\n");
      out.write("\t\t\t\t$(this).parents('#fruitItem').remove(); //화면에서 삭제\r\n");
      out.write("\t\t\t\ttotalPrice -= eval($(this).parent().siblings('th:eq(3)').text())\r\n");
      out.write("\t\t\t\t\t\t\t* eval($(this).parent().siblings('th:eq(4)').text());\r\n");
      out.write("\t\t\t\t$('#totalPrice').text(totalPrice);\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t});//ready\r\n");
      out.write("\t\r\n");
      out.write("\tfunction refreshPage(){\r\n");
      out.write("\t\tvar html = '';\r\n");
      out.write("\t\tvar no = 1;\r\n");
      out.write("\t\ttotalPrice = 0;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfor(var key in localStorage){\r\n");
      out.write("\t\t\tif(key=='length') break;\r\n");
      out.write("\t\t\tvar data = localStorage.getItem(key).split(\"#\");\r\n");
      out.write("\t\t\thtml += '<tr id=\"fruitItem\"><th>'+(no++)+'</th>';\r\n");
      out.write("\t\t\thtml += '<th><img src='+data[0]+' width=100 height=100></th>';\r\n");
      out.write("\t\t\thtml += '<th>'+data[1]+'</th>';\r\n");
      out.write("\t\t\thtml += '<th>'+data[2]+'</th>';\r\n");
      out.write("\t\t\thtml += '<th><img src=img/up.jpg class=up width=10 height=10><br>';\r\n");
      out.write("\t\t\thtml += '<input type=\"hidden\" value='+key+'><span>'+data[3]+'</span><br>';\r\n");
      out.write("\t\t\thtml += '<img src=img/down.jpg class=down width=10 height=10></th>';\r\n");
      out.write("\t\t\thtml += '<th><input type=checkbox value='+key+'></th></tr>';\r\n");
      out.write("\t\t\ttotalPrice += eval(data[2]);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$('#fruitList').html(html);\r\n");
      out.write("\t\t$('#totalPrice').html(totalPrice);\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction updateAmount(){ //로컬 스토리지에 수량 업데이트\r\n");
      out.write("\t\tvar data = localStorage.getItem(key).split(\"#\");\r\n");
      out.write("\t\tvar value = data[0] +\"#\"+ data[1] +\"#\"+ data[2] +\"#\"+ amount;\r\n");
      out.write("\t\tlocalStorage.setItem(key, value);\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<h1 align=\"center\">장바구니</h1>\r\n");
      out.write("<div align=\"right\" width=\"80%\"></div>\r\n");
      out.write("<table align=\"center\" width=\"80%\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td align=\"right\"><a href=\"itemList.do\">쇼핑 계속하기</a></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("<table align=\"center\" width=\"80%\">\r\n");
      out.write("\t<thead>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>번호</th>\r\n");
      out.write("\t\t\t<th>상품이미지</th>\r\n");
      out.write("\t\t\t<th>상품명</th>\r\n");
      out.write("\t\t\t<th>상품가격</th>\r\n");
      out.write("\t\t\t<th>수량</th>\r\n");
      out.write("\t\t\t<th><button id=\"delete\">삭제</button></th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</thead>\r\n");
      out.write("\t<tbody id=\"fruitList\"></tbody>\r\n");
      out.write("\t<tfoot>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td colspan=6>\r\n");
      out.write("\t\t\t\t<p align=\"right\">\r\n");
      out.write("\t\t\t\t\t<span style=\"font-size: 20px; color: lightgrey;\">총 결제금액 : </span>\r\n");
      out.write("\t\t\t\t\t<span id=\"totalPrice\" style=\"font-size: 28px; color: black;\"></span>\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t<tfoot>\r\n");
      out.write("</table>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

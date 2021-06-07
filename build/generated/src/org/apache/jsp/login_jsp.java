package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\" dir=\"ltr\">\n");
      out.write("  <head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <title>Login</title>\n");
      out.write("    <link rel=\"icon\" href=\"src/images/ins-ico.ico\" type=\"image/x-icon\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Roboto&family=Roboto+Slab&display=swap\" rel=\"stylesheet\">\n");
      out.write("    <style>\n");
      out.write("      body\n");
      out.write("      {\n");
      out.write("        background-image: url(\"src/images/wp.jpg\");\n");
      out.write("        background-size: 100%;\n");
      out.write("      }\n");
      out.write("      ul\n");
      out.write("      {\n");
      out.write("        list-style: none;\n");
      out.write("      }\n");
      out.write("      .t\n");
      out.write("      {\n");
      out.write("        display: flex;\n");
      out.write("        font-weight: bold;\n");
      out.write("        text-align: left;\n");
      out.write("        width:300px;\n");
      out.write("        margin-left: 30px;\n");
      out.write("        font-size: 26px;\n");
      out.write("      }\n");
      out.write("      .login_main\n");
      out.write("      {\n");
      out.write("        position: absolute;\n");
      out.write("        transform: translate(110%,30%);\n");
      out.write("        background-color: white;\n");
      out.write("        text-align: center;\n");
      out.write("        margin: 0 auto;\n");
      out.write("        width:400px;\n");
      out.write("        padding: 2%;\n");
      out.write("        box-shadow: inset 0px 4px 4px rgba(0, 0, 0, 0.25);\n");
      out.write("        border-radius: 50px;\n");
      out.write("      }\n");
      out.write("      .user\n");
      out.write("      {\n");
      out.write("        border-radius: 10px;\n");
      out.write("        width:300px;\n");
      out.write("        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);\n");
      out.write("        background-color: #FFD57E;\n");
      out.write("        padding: 8px;\n");
      out.write("      }\n");
      out.write("      i.fa\n");
      out.write("      {\n");
      out.write("        font-size:24px;\n");
      out.write("      }\n");
      out.write("      .inputs\n");
      out.write("      {\n");
      out.write("        width:400px;\n");
      out.write("        margin-left: 50px;\n");
      out.write("        text-align: center;\n");
      out.write("      }\n");
      out.write("      .user input\n");
      out.write("      {\n");
      out.write("        border: none;\n");
      out.write("        font-size: 16px;\n");
      out.write("        width: 250px;\n");
      out.write("        border-radius: 5px;\n");
      out.write("        box-shadow: inset 0px 4px 4px rgba(0, 0, 0, 0.25);\n");
      out.write("        padding: 5px;\n");
      out.write("        margin-left: 10px;\n");
      out.write("        font-family: \"Roboto\",sans-serif;\n");
      out.write("      }\n");
      out.write("      .pass input\n");
      out.write("      {\n");
      out.write("        border: none;\n");
      out.write("        padding: 5px;\n");
      out.write("        width: 250px;\n");
      out.write("        border-radius: 5px;\n");
      out.write("        box-shadow: inset 0px 4px 4px rgba(0, 0, 0, 0.25);\n");
      out.write("        font-size: 16px;\n");
      out.write("        margin-left: 15px;\n");
      out.write("        font-family: \"Roboto\",sans-serif;\n");
      out.write("      }\n");
      out.write("      .pass\n");
      out.write("      {\n");
      out.write("        border-radius: 10px;\n");
      out.write("        padding: 8px;\n");
      out.write("        width:300px;\n");
      out.write("        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);\n");
      out.write("        background-color: #FFD57E;\n");
      out.write("        margin-top: 10px;\n");
      out.write("      }\n");
      out.write("      .posts\n");
      out.write("      {\n");
      out.write("        display: flex;\n");
      out.write("\n");
      out.write("        margin-left: -60px;\n");
      out.write("        align-content: space-around;\n");
      out.write("        font-family: \"Roboto\",sans-serif;\n");
      out.write("        font-size: 16px;\n");
      out.write("      }\n");
      out.write("      #sbtn\n");
      out.write("      {\n");
      out.write("        background: #FFD57E;\n");
      out.write("        font-family: \"Roboto\",sans-serif;\n");
      out.write("        border: none;\n");
      out.write("        font-size: 20px;\n");
      out.write("        padding: 10px;\n");
      out.write("        width:100px;\n");
      out.write("        margin-left: -90px;\n");
      out.write("        cursor: pointer;\n");
      out.write("        border-radius: 80px;\n");
      out.write("        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);\n");
      out.write("      }\n");
      out.write("      #sbtn:hover\n");
      out.write("      {\n");
      out.write("        background: #AC4B1C;\n");
      out.write("        transition: all 0.5s ease;\n");
      out.write("        color: white;\n");
      out.write("      }\n");
      out.write("      a\n");
      out.write("      {\n");
      out.write("        font-weight: bold;\n");
      out.write("        margin-left: -90px;\n");
      out.write("        font-family: \"Roboto\",sans-serif;\n");
      out.write("        font-size: 14px;\n");
      out.write("      }\n");
      out.write("      .posts li\n");
      out.write("      {\n");
      out.write("        padding: 5px;\n");
      out.write("      }\n");
      out.write("      .posts li input:hover\n");
      out.write("      {\n");
      out.write("        cursor: pointer;\n");
      out.write("      }\n");
      out.write("    </style>\n");
      out.write("    <script>\n");
      out.write("        function enableState()\n");
      out.write("        {\n");
      out.write("            document.getElementById('u').disabled=false;\n");
      out.write("            document.getElementById('p').disabled=false;\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("    <div class=\"login_main\">\n");
      out.write("    <div class=\"t\">\n");
      out.write("       <img src=\"src/images/institution-logo.png\" height=\"120px\" width=\"120px\"/><br>UNIVERSITY of Fortress\n");
      out.write("    </div>\n");
      out.write("    <br>\n");
      out.write("    <form action=\"LogServ\" method=\"post\">\n");
      out.write("      <div class=\"inputs\">\n");
      out.write("        <div class=\"user\"><i class=\"fa fa-user-circle\"></i><input type=\"text\" name=\"username\" placeholder=\"UserID\" id=\"u\" disabled/></div>\n");
      out.write("        <br>\n");
      out.write("        <div class=\"pass\"><i class=\"fa fa-lock\"></i><input type=\"password\" name=\"password\" placeholder=\"Password\" id=\"p\" disabled/></div>\n");
      out.write("      <br>\n");
      out.write("        <ul class=\"posts\">\n");
      out.write("          <li>You are A/An?</li>\n");
      out.write("          <li><input type=\"radio\" value=\"Admin\" name=\"user\" onchange=\"enableState()\">Admin</li>\n");
      out.write("          <li><input type=\"radio\" value=\"student\" name=\"user\" onchange=\"enableState()\">Student</li>\n");
      out.write("          <li><input type=\"radio\" value=\"Teacher\" name=\"user\" onchange=\"enableState()\">Teacher</li>\n");
      out.write("          </ul>\n");
      out.write("\n");
      out.write("      <input type=\"submit\" value=\"LOGIN\" id=\"sbtn\" onclick=\"xt()\"/>\n");
      out.write("    </form>\n");
      out.write("    <br><br>\n");
      out.write("    <a href=\"first_reg.jsp\">New User?Register Now!</a>\n");
      out.write("    </div>\n");
      out.write("  </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

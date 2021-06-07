package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import sessions.login;

public final class e_002dfail_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("    \n");
      out.write("       <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("          <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@300&display=swap\" rel=\"stylesheet\">\n");
      out.write("    <style>\n");
      out.write("        body\n");
      out.write("        {\n");
      out.write("            background-image: url(\"src/images/wp.jpg\");\n");
      out.write("            background-size: 100%;\n");
      out.write("        }\n");
      out.write("        .overlay\n");
      out.write("        {\n");
      out.write("            position: absolute;\n");
      out.write("            display: flex;\n");
      out.write("            flex-direction: column;\n");
      out.write("            justify-content: center;\n");
      out.write("            top: 0;\n");
      out.write("            bottom: 0;\n");
      out.write("            left: 0;\n");
      out.write("            right: 0;\n");
      out.write("            background: rgba(0,0,0,0.7);\n");
      out.write("        }\n");
      out.write("        .msg-box\n");
      out.write("        {\n");
      out.write("          width:400px;\n");
      out.write("          height: 180px;\n");
      out.write("          border: 5px solid #FFD57E;\n");
      out.write("          border-radius: 20px;\n");
      out.write("          font-family: \"Noto Sans JP\",sans-serif;\n");
      out.write("          background: white;\n");
      out.write("          text-align: center;\n");
      out.write("          transition: all 0.5s;\n");
      out.write("          margin-left: 35%;\n");
      out.write("        }\n");
      out.write("        .first_error\n");
      out.write("        {\n");
      out.write("            position: relative;\n");
      out.write("            top: 30px;\n");
      out.write("        }\n");
      out.write("        .second_error\n");
      out.write("        {\n");
      out.write("            position: relative;\n");
      out.write("            top: 30px;\n");
      out.write("        }\n");
      out.write("        .links\n");
      out.write("        {\n");
      out.write("            margin-top: 50px;\n");
      out.write("            margin-left: 145px;\n");
      out.write("            padding: 4px;\n");
      out.write("            flex-wrap: wrap;\n");
      out.write("            border: 2px solid #AC4B1C;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            width: 100px;\n");
      out.write("        }\n");
      out.write("        .links a\n");
      out.write("        {\n");
      out.write("            text-decoration: none;\n");
      out.write("            color: black;\n");
      out.write("        }\n");
      out.write("        .check\n");
      out.write("        {\n");
      out.write("            padding: 4px;\n");
      out.write("            margin-top: 50px;\n");
      out.write("            width: 100px;\n");
      out.write("            margin-left: 145px;\n");
      out.write("            box-shadow: 0px 4px 4px rgba(0,0,0,0.4);\n");
      out.write("            transition: 0.5s;\n");
      out.write("            \n");
      out.write("        }\n");
      out.write("        .check:hover\n");
      out.write("        {\n");
      out.write("            cursor:pointer;\n");
      out.write("            background: #FFD57E;\n");
      out.write("            \n");
      out.write("            \n");
      out.write("        }\n");
      out.write("        .check:active\n");
      out.write("        {\n");
      out.write("            box-shadow:none;\n");
      out.write("            margin-top: 55px;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        #alert\n");
      out.write("        {\n");
      out.write("           background:red; \n");
      out.write("           padding:5px; \n");
      out.write("           color:white; \n");
      out.write("           border-radius: 5px;\n");
      out.write("           transition: opacity 0.5s;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("    <script>\n");
      out.write("        function showVerifyBox()\n");
      out.write("        {\n");
      out.write("            document.getElementById('m').style.height=\"220px\";\n");
      out.write("            document.getElementById('vform').style.opacity=\"1\";\n");
      out.write("            document.getElementById('vform').style.marginTop=\"20px\";\n");
      out.write("            document.getElementById('vform').style.transition=\"opacity 0.5s\";\n");
      out.write("            document.getElementById('alert').style.opacity=\"0\";\n");
      out.write("        }\n");
      out.write("        </script>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <div class=\"overlay\">\n");
      out.write("            <div class=\"msg-box\" id=\"m\">\n");
      out.write("                <span class=\"first_error\">");
      out.print(login.userID);
      out.write(" not added to a section.</span>\n");
      out.write("                <div class=\"links\">\n");
      out.write("                 <a href=\"http://localhost:8080/StudentDBMS/student.jsp\">Back to homepage</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
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

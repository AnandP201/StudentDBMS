package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import MongoJDBC.LoginDBConnect;
import ServletHandler.function;

public final class t_002dprof_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <link rel=\"icon\" href=\"src/images/ins-ico.ico\" type=\"image/x-icon\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"src/profPg/p-main.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@300&display=swap\" rel=\"stylesheet\">\n");
      out.write("        <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\">\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=Nixie+One&display=swap\" rel=\"stylesheet\">\n");
      out.write("    <title>My Profile</title>\n");
      out.write("  </head>\n");
      out.write("  <script src=\"src/homepage/main_sc.js\"></script>\n");
      out.write("<body background=\"src/images/wp.jpg\">\n");
      out.write("  <div class=\"overlay\">\n");
      out.write("  <div class=\"title-bar\">\n");
      out.write("    <img src=\" src/images/institution-logo.png\" height=\"70\" width=\"70\">\n");
      out.write("    <div class=\"title\">FOR-SIms</div>\n");
      out.write("    <div class=\"u_det\" style=\"display:none;\"><b>Welcome! <span id=\"user-name\">");
      out.print(request.getAttribute("user"));
      out.write("</span></b></div>\n");
      out.write("       <div class=\"home\" onclick=\"goHome('teacher')\"><i class=\"fa fa-home\"></i></div>\n");
      out.write("    <div class=\"settings\" onclick=\"showSettings()\"><i class=\"fa fa-wrench\"></i></div>\n");
      out.write("    </div>\n");
      out.write("  <div class=\"settings-menu\" id='s1' style=\"display:none;\">\n");
      out.write("    <ul>\n");
      out.write("    <li><i class=\"fa fa-sign-out\"></i><a onclick=\"delAndSignOut()\">Sign Out</a></li>\n");
      out.write("    <li><i class=\"fa fa-key\"></i><b>Reset Password</b></a></li>\n");
      out.write("    <li><i class=\"fa fa-external-link-square\"></i><a href=\"https://www.google.com\" target=\"_blank\">About Us</a></li>\n");
      out.write("    </ul>\n");
      out.write("  </div>\n");
      out.write("  <div class=\"col\" id=\"col\">\n");
      out.write("      <form action=\"function\" method=\"get\" name=\"delForm\" id=\"dform\" style=\"display: none;\">\n");
      out.write("          <input type=\"text\" id=\"dtxt\" name=\"dtxt\" style=\"dispay:none;\"/>\n");
      out.write("      </form>\n");
      out.write("        <div class=\"u_img\"><img src=\"src/images/institution-logo.png\" height=\"90\" width=\"90\"></div>\n");
      out.write("        <div class=\"user_name\"><span id=\"collection-name\">");
      out.print(request.getAttribute("user-type"));
      out.write("</span> PROFILE</div>\n");
      out.write("    <div class=\"profile_table\">\n");
      out.write("      <table cellspacing=\"20\">\n");
      out.write("          \n");
      out.write("          \n");
      out.write("          ");

              int l=LoginDBConnect.size;
          
      out.write("\n");
      out.write("          ");

            for(int i=0;i<l;i++)
            {
          
      out.write("\n");
      out.write("          <tr>\n");
      out.write("          <td>");
      out.print(request.getAttribute("k"+i));
      out.write("</td>\n");
      out.write("          <td>:</td>\n");
      out.write("          <td>");
      out.print(request.getAttribute("v"+i));
      out.write("</td>\n");
      out.write("          </tr>\n");
      out.write("          ");

              }
          
      out.write("\n");
      out.write("      </table>\n");
      out.write("      <div class=\"dp\">\n");
      out.write("          <img src=\"src/");
      out.print(function.imgPath);
      out.write("\" size=\"200\" height=\"200\"/>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("      </div>\n");
      out.write("</div>\n");
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

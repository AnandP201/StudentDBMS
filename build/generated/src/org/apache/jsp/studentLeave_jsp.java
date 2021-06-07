package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DataList.studentData;
import sessions.login;
import sessions.functions;

public final class studentLeave_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <link rel=\"stylesheet\" href=\"src/homepage/s-main.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@300&display=swap\" rel=\"stylesheet\">\n");
      out.write("        <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\">\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Nixie+One&display=swap\" rel=\"stylesheet\">\n");
      out.write("    <title>Student List Portal</title>\n");
      out.write("  </head>\n");
      out.write("  <script src=\"src/homepage/main_sc.js\"></script>\n");
      out.write("  <body background=\"src/images/wp.jpg\" onload=\"disp()\">\n");
      out.write("      <div class=\"overlay\">\n");
      out.write("  <div class=\"title-bar\">\n");
      out.write("    <img src=\" src/images/institution-logo.png\" height=\"70\" width=\"70\">\n");
      out.write("    <div class=\"title\">FOR-SIms</div>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <span id=\"user-name\" style=\"display: none;\">");
      out.print(login.userID);
      out.write("</span>\n");
      out.write("    <span id=\"flag\" style=\"display:none;\">");
      out.print(functions.leaveAppliedFlag);
      out.write("</span>\n");
      out.write("    <div class=\"home\"><a href=\"http://localhost:8080/StudentDBMS/student.jsp\" style=\"text-decoration:none; color:black;\"><i class=\"fa fa-home\"></i></a></div>\n");
      out.write("    <div class=\"settings\" onclick=\"showSettings()\"><i class=\"fa fa-wrench\"></i></div>\n");
      out.write("       <span id=\"student_registered_entity\" style=\"display:none;\">");
      out.print(studentData.rf);
      out.write("</span>\n");
      out.write("  </div>\n");
      out.write("      <div class=\"open\" onclick=\"showMenu()\" style=\"margin-left:-250px;\" id='o1'><i class=\"fa fa-angle-double-right\" id=\"right\"></i><i class=\"fa fa-angle-double-left\" id=\"left\" style=\"opacity:0;\"></i></div>\n");
      out.write("  <div class=\"settings-menu\" id='s1' style=\"display:none;\">\n");
      out.write("    <ul>\n");
      out.write("    <li><i class=\"fa fa-sign-out\"></i><a onclick=\"delAndSignOut()\">Sign Out</a></li>\n");
      out.write("    <li><i class=\"fa fa-key\"></i><a href=\"#\"><b>Reset Password</b></a></li>\n");
      out.write("    <li><i class=\"fa fa-external-link-square\"></i><a href=\"https://www.google.com\" target=\"_blank\">About Us</a></li>\n");
      out.write("    </ul>\n");
      out.write("  </div>\n");
      out.write("  <div class=\"col\" id=\"col\">\n");
      out.write("      <form action=\"function\" method=\"get\" name=\"delForm\" id=\"dform\" style=\"display: none;\">\n");
      out.write("          <input type=\"text\" id=\"dtxt\" name=\"dtxt\" style=\"dispay:none;\"/>\n");
      out.write("      </form>\n");
      out.write("      <form action=\"function\" method=\"get\" id=\"displayLeaveForm\" style=\"display:none;\">\n");
      out.write("          <input type=\"text\" id=\"userTXT\" name=\"user_leave\"/>\n");
      out.write("      </form>\n");
      out.write("      <div class=\"section1\">\n");
      out.write("          <form method=\"post\" action=\"function\" id=\"leaveapp\">\n");
      out.write("              <div class=\"Leaveoptions\">\n");
      out.write("          <input type=\"radio\" value=\"half-day\" name=\"leavetype\" id=\"hd\" onchange=\"showLeavePattern();\"/>HALF-DAY LEAVE\n");
      out.write("          <input type=\"radio\" value=\"full-day\" name=\"leavetype\" id=\"fd\" onchange=\"showLeavePattern();\"/>FULL-DAY LEAVE\n");
      out.write("          <input type=\"radio\" value=\"multiple-day\" name=\"leavetype\" id=\"gl\" onchange=\"showLeavePattern()\"/>GENERAL-LEAVE\n");
      out.write("              </div>\n");
      out.write("          <br>\n");
      out.write("          <table align=\"left\" cellpadding=\"3\" cellspacing=\"5\">\n");
      out.write("              <tr>\n");
      out.write("                  <td>Start Time</td>\n");
      out.write("                  <td><input type=\"time\" name=\"startTime\" id=\"sTime\" disabled></td>\n");
      out.write("                  <td>End Time</td>\n");
      out.write("                  <td><input type=\"time\" name=\"endTime\" id=\"eTime\" disabled></td>\n");
      out.write("              </tr>\n");
      out.write("              <br>\n");
      out.write("              <tr>\n");
      out.write("                  <td>From</td>\n");
      out.write("                  <td><input type=\"date\" name=\"startDate\" id=\"sDate\" disabled></td>\n");
      out.write("                  <td>To</td>\n");
      out.write("                  <td><input type=\"date\" name=\"endDate\" id=\"eDate\" disabled></td>\n");
      out.write("              </tr>\n");
      out.write("          </table>\n");
      out.write("          <textarea id=\"leavepurpose\" placeholder=\"State purpose of your leave\" cols=\"65\" rows=\"3\" name=\"reason\" required></textarea>\n");
      out.write("          </form>   \n");
      out.write("          <span id=\"apply_btn\" onclick=\"applyLeave()\">APPLY LEAVE</span>\n");
      out.write("          <span id=\"showleaves_btn\"><input type=\"radio\" onchange=\"showLeaveStatus()\"/>Show applied leaves</span>\n");
      out.write("      \n");
      out.write("      <div class=\"section2\" style=\"opacity: 1;\">\n");
      out.write("          \n");
      out.write("          <div class=\"card\" id=\"div1\"></div> \n");
      out.write("      </div>\n");
      out.write("  </div>\n");
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

package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DataList.studentData;
import sessions.login;

public final class studentWiseList_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("  <body background=\"src/images/wp.jpg\">\n");
      out.write("      <div class=\"overlay\">\n");
      out.write("       \n");
      out.write("  <div class=\"title-bar\">\n");
      out.write("    <img src=\" src/images/institution-logo.png\" height=\"70\" width=\"70\">\n");
      out.write("    <div class=\"title\">FOR-SIms</div>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <span id=\"user-name\" style=\"display: none;\">");
      out.print(login.userID);
      out.write("</span>\n");
      out.write("    <div class=\"home\"><a href=\"http://localhost:8080/StudentDBMS/admin.jsp\" style=\"text-decoration:none; color:black;\"><i class=\"fa fa-home\"></i></a></div>\n");
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
      out.write("      <div class=\"select_table\">\n");
      out.write("          <span class=\"fn_title\">Student Management<span><br>\n");
      out.write("                  <select name=\"class\" id=\"cls\" onchange=\"ch()\">\n");
      out.write("          <option value=\"csa\">CS-A</option>\n");
      out.write("          <option selected=\"true\" hidden=\"true\">Choose a section</option>\n");
      out.write("          <option value=\"csb\">CS-B</option>\n");
      out.write("          <option value=\"coa\">COM-A</option>\n");
      out.write("          <option value=\"cob\">COM-B</option>\n");
      out.write("          <option value=\"students\">All </option>\n");
      out.write("      </select>\n");
      out.write("                  <form action=\"function\" method=\"get\" id=\"sListForm\" style=\"display:none\">\n");
      out.write("                      <input type=\"text\" id=\"s\" name=\"tableselector\"/>\n");
      out.write("                  </form>\n");
      out.write("      </div>\n");
      out.write("      ");

                String coll=studentData.currTable;
                String disp;
                String f;
                int count=studentData.totalStudents;
                if(count>1)
                {
                    f="students";
                }
                else
                {
                    f="student";
                }
                if(coll.equalsIgnoreCase("students"))
                {
                   disp=count+" "+f+" found !";
                }
                else
                {
                    disp=count+" "+f+" found in "+coll.toUpperCase()+"!";
                }
            if((coll!=" ")&&(studentData.warning==null))
                {
             
      out.write("\n");
      out.write("             <span id=\"information\">");
      out.print(disp);
      out.write("</span>\n");
      out.write("             ");

                 }
             
      out.write("\n");
      out.write("      <div class=\"table_view\">\n");
      out.write("          <table border=\"1\" cellpadding=\"3\" cellspacing=\"2\" id=\"sList\">\n");
      out.write("        <tr>\n");
      out.write("           ");

               for(int i=0;i<studentData.totalFields;i++)
               {
                if(studentData.tableHeader!=null)
                {
           
      out.write("\n");
      out.write("           <td>");
      out.print(studentData.tableHeader[i].toUpperCase());
      out.write("</td>\n");
      out.write("           ");

                }

               }
           
      out.write("\n");
      out.write("           ");

               if(studentData.actionAndDespFlag==1)
               {
           
      out.write("\n");
      out.write("           <td><b>ACTION</b></td>\n");
      out.write("           ");

               }
           
      out.write("\n");
      out.write("         </tr>\n");
      out.write("         \n");
      out.write("        ");

        for(int i=0;i<studentData.totalStudents;i++)
        {
           String t=studentData.student.get(i).get(0);
        
      out.write("\n");
      out.write("        <tr>\n");
      out.write("        ");

            for(int k=0;k<studentData.totalFields;k++)
            {      
        
      out.write("\n");
      out.write("        <td>");
      out.print(studentData.student.get(i).get(k));
      out.write("</td>\n");
      out.write("        ");

            }
            String msg=" ";
            if(studentData.isAlotted(t)&&studentData.actionAndDespFlag==1)
            {
                msg="Student is registered in "+studentData.currRegisteredTable.toUpperCase();
            }
        
      out.write("\n");
      out.write("        ");

            if(msg.equals(" ")&&studentData.actionAndDespFlag==1)
            {
        
      out.write("\n");
      out.write("        <td class=\"gen\" id=\"");
      out.print(t);
      out.write("\" onclick=\"registerStudent('");
      out.print(t);
      out.write("');\" style=\"font-family: 'Nixie One',cursive\"><b>Register Student</b></td>\n");
      out.write("        ");

            }
            else
           {
            if(studentData.actionAndDespFlag==1)
            {
        
      out.write("\n");
      out.write("        <td class=\"gen_d\" style=\"font-family: 'Nixie One',cursive\"><b>");
      out.print(msg);
      out.write("</b></td>\n");
      out.write("        ");

            }
           }
        
      out.write("\n");
      out.write("    </tr>\n");
      out.write("    \n");
      out.write("        ");

            }
            if(studentData.warning!=null)
            {
        
      out.write("\n");
      out.write("        <span class=\"warning\">");
      out.print(studentData.warning);
      out.write("</span>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("          </table>\n");
      out.write("      </div>\n");
      out.write("   </div>\n");
      out.write("      <div class=\"col_register\" id=\"col_r\">\n");
      out.write("          <span id=\"col_register_title\">REGISTER <b><span id=\"student\"></span></b></span>\n");
      out.write("          <form action=\"function\" method=\"post\" id=\"studentreg\">\n");
      out.write("              <table>\n");
      out.write("                  <input type=\"text\" name=\"nid\" style=\"display:none;\" id=\"nameFromtable\"/>\n");
      out.write("                  <tr>\n");
      out.write("                      <td style=\"text-align: left\">Section</td>\n");
      out.write("                      <td><input type=\"text\" name=\"sec\" maxlength=\"3\" placeholder=\"Enter CS/CO+'section'\" oninput=\"checkValidString()\"/>\n");
      out.write("                  </tr>\n");
      out.write("                  <tr>\n");
      out.write("                      <td  style=\"text-align: left\">Assign a Unique ID (CID)</td>\n");
      out.write("                      <td><input type=\"text\" name=\"cid\" placeholder=\"Current Year+Branch Code(CS/CO)+Unique No\" maxlength=\"7\"/></td>\n");
      out.write("                  </tr>\n");
      out.write("              </table>\n");
      out.write("          </form>\n");
      out.write("          <br>\n");
      out.write("          <span class=\"back_btn\" onclick=\"backToTable()\">BACK</span>\n");
      out.write("          <span class=\"register_student_btn\" onclick=\"submitRegisterForm()\">SUBMIT</span>\n");
      out.write("      </div>\n");
      out.write("      </div>\n");
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

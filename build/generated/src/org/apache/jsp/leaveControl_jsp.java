package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoClient;
import sessions.login;

public final class leaveControl_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("       ");

         String studentName=login.userID;
         String leavetype=request.getParameter("leaveType");
         String leaveReason=request.getParameter("reason");
         String sTime=" ",eTime=" ",sDate=" ",eDate=" ";
         if(leavetype.equalsIgnoreCase("half-day"))
         {
             sTime=request.getParameter("startTime");
             eTime=request.getParameter("endTime");
             sDate=request.getParameter("startDate");
         }
         if(leavetype.equalsIgnoreCase("full-day"))
         {
             sDate=request.getParameter("startDate");
         }
         if(leavetype.equalsIgnoreCase("multiple-day"))
         {
             sDate=request.getParameter("startDate");
             eDate=request.getParameter("endDate");
         }
         MongoClient mongoClient = MongoClients.create("mongodb+srv://data:2001anand@cluster0.nownt.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
         MongoDatabase database = mongoClient.getDatabase("sdbms");
         MongoCollection collection=database.getCollection("Leave");
         
         
         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
         LocalDateTime now = LocalDateTime.now();
         String curr=dtf.format(now);
         
         if(leavetype.equalsIgnoreCase("half-day"))
         {
             collection.insertOne(new Document("Applicant",studentName).append("Leave Type", leavetype).append("On Date",sDate).append("From Time",sTime).append("To Time",eTime).append("Reason",leaveReason).append("Applied On", curr));
         }
         if(leavetype.equalsIgnoreCase("full-day"))
         {
             
         }
         if(leavetype.equalsIgnoreCase("multiple-day"))
         {
             
         }
         
         
       
      out.write("\n");
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

package ServletHandler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import MongoJDBC.LoginDBConnect;
import MongoJDBC.RegisterDBConnect;
import MongoJDBC.DBConnect;
import DataList.studentData;
import DataList.teacherData;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import java.io.FileOutputStream;
import javax.servlet.RequestDispatcher;
import org.bson.types.ObjectId;
import sessions.functions;
import sessions.login;

public class function extends HttpServlet {
    RequestDispatcher rd;
    public String []values;
    public String []keys;
    String filepath;
    public static String imgPath;
    String p;
    public static int delete_flag=2;
    public static String username;
    
    public void init()
    {
        filepath=getServletContext().getRealPath("/");
    }
    
    public String getPath()
    {
        return p;
    }
    public String download(String ObjectId,String user)
    {
        String path=filepath+"src\\"+user+".jpg";
        imgPath=user+".jpg";
        try
        {
            FileOutputStream fout=new FileOutputStream(path);
            GridFSBucket g=GridFSBuckets.create(new LoginDBConnect().getDatabaseName());
            g.downloadToStream(new ObjectId(ObjectId), fout);
            fout.close();
        }
        catch(IOException e)
        {
            return null;
        }
       return p;
    }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("tableselector")!=null)
        {
            RequestDispatcher r=request.getRequestDispatcher("studentWiseList.jsp");
            String table=request.getParameter("tableselector");
            if(table.equalsIgnoreCase("students"))
            {
                studentData.actionAndDespFlag=1;
            }
            else
            {
                studentData.actionAndDespFlag=0;
            }
            studentData.currTable=table;
            new studentData().parseRecordAndGenerate(new DBConnect().getRecords(table));
            request.setAttribute("table",table);
            r.forward(request, response);
        }
        if(request.getParameter("ttableselector")!=null)
        {
            RequestDispatcher r=request.getRequestDispatcher("teacherWiseList.jsp");
            String table=request.getParameter("ttableselector");
            if(table.equalsIgnoreCase("teacher"))
            {
                teacherData.actionAndDespFlag=1;
                teacherData.displayFlag=1;
            }
            else
            {
                teacherData.displayFlag=1;
                teacherData.actionAndDespFlag=0;
            }
            teacherData.currTable=table;
            new teacherData().parseRecordAndGenerate(new DBConnect().getTRecords(table));
            r.forward(request, response);
        }
        if(request.getParameter("sectionValue")!=null)
        {
            String section=request.getParameter("sectionValue");
            functions.displayleaveAtAdmin=1;
            int k=studentData.setLeaves(new DBConnect().getLeavesFromSection(section));
            int l=studentData.extractLeaveIDS(section);
            if(k==1)
              {
                        functions.noleavesfoundFlag=1;
              }
            response.sendRedirect("http://localhost:8080/StudentDBMS/adminleaveside.jsp");
        }
        else if(request.getParameter("dtxt")!=null)
        {
            String id=request.getParameter("dtxt");
            new RegisterDBConnect().findandDelete(id);
            functions.delocateFlags();
            response.sendRedirect("login.jsp");
        }
                    
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("pass")!=null)
        {
            String pass=request.getParameter("pass");
            delete_flag=new RegisterDBConnect().findandDeleteWithPassword(pass);
            if(delete_flag==1)
            {
                rd=request.getRequestDispatcher("login.jsp");
                request.setAttribute("msg","Logged out successfully");
                rd.forward(request, response);
            }
            else if(delete_flag==0)
            {
                response.sendRedirect("fail.jsp");
            }
        }
        else if(request.getParameter("sec")!=null)
        {
            String section=request.getParameter("sec").toLowerCase();
            String cid=request.getParameter("cid").toUpperCase();
            String nid=request.getParameter("nid");
            new DBConnect().addtoClass(section, cid, nid);
            response.sendRedirect("http://localhost:8080/StudentDBMS/studentWiseList.jsp");
        }
        else if(request.getParameter("tsec")!=null)
        {
            String section=request.getParameter("tsec").toLowerCase();
            
            String eid=request.getParameter("eid");

            String nid=request.getParameter("nid");
            String subjects=request.getParameter("sub");
            teacherData.displayFlag=0;
            new DBConnect().addtoClass(section, eid, nid,subjects);
            
            response.sendRedirect("http://localhost:8080/StudentDBMS/teacherWiseList.jsp");
        }
        else if(request.getParameter("reason")!=null)
        {
            String leavetype=request.getParameter("leavetype");
            String leaveReason=request.getParameter("reason");
            String sTime=" ",eTime=" ",sDate=" ",eDate=" ";
            
         if(leavetype.equalsIgnoreCase("half-day"))
         {
             sTime=request.getParameter("startTime");
             eTime=request.getParameter("endTime");
             sDate=request.getParameter("startDate");
             new DBConnect().addLeave(sTime, eTime, sDate, leavetype, leaveReason);
         }
         if(leavetype.equalsIgnoreCase("full-day"))
         {
             sDate=request.getParameter("startDate");
             new DBConnect().addLeave(sDate, leavetype, leaveReason);
         }
         if(leavetype.equalsIgnoreCase("multiple-day"))
         {
             sDate=request.getParameter("startDate");
             eDate=request.getParameter("endDate");
             new DBConnect().addLeave(sDate, eDate, leavetype, leaveReason);
         }
         functions.leaveAppliedFlag=1;
         functions.displayLeave=1;
         response.sendRedirect("http://localhost:8080/StudentDBMS/studentLeave.jsp"); 
        }
        else if(request.getParameter("deleteCard")!=null)
        {
            String ID=request.getParameter("deleteCard");
            String username=request.getParameter("tofinduser");
            new DBConnect().dropLeaveById(ID,username);
            response.sendRedirect("http://localhost:8080/StudentDBMS/studentLeave.jsp");
        }
        else if(request.getParameter("userleave")!=null)
        {
            functions.displayLeave=1;
            response.sendRedirect("http://localhost:8080/StudentDBMS/studentLeave.jsp");
        }
        else if(request.getParameter("toApproveField")!=null)
        {
            String ID=request.getParameter("toApproveField");
            String adminName=login.userID;
            new DBConnect().approveLeave(ID, adminName);
            response.sendRedirect("http://localhost:8080/StudentDBMS/adminleaveside.jsp");
        }
        else if(request.getParameter("toRejectField")!=null)
        {
            String ID=request.getParameter("toRejectField");
            new DBConnect().rejectLeave(ID);
            response.sendRedirect("http://localhost:8080/StudentDBMS/adminleaveside.jsp");
        }
        else if(request.getParameter("peerText")!=null)
        {
            String name=request.getParameter("peerText");
            new studentData().setPeers(name);
            functions.peerDisplayFlag=1;
            if(new DBConnect().isTeacher(name))
            {
                response.sendRedirect("http://localhost:8080/StudentDBMS/teacherPeer.jsp");
            }
            else
            {
                response.sendRedirect("http://localhost:8080/StudentDBMS/studentPeer.jsp");
            }
            
        }
        else
        {
        String user=request.getParameter("inp");
        String coll=request.getParameter("int");
        String objectID=new LoginDBConnect().getObjectID(user, coll);
        
        p=download(objectID,user);
        
        try
        {
            values=new LoginDBConnect().getValues(user, coll);
            keys=new LoginDBConnect().getKeys(user, coll);
        }
        
        catch(NullPointerException n)
        {
            System.out.println("No record found");
        }
        
        if(coll.equalsIgnoreCase("admin"))
        {
            rd=request.getRequestDispatcher("a-prof.jsp");
        }
        if(coll.equalsIgnoreCase("students"))
        {
            rd=request.getRequestDispatcher("s-prof.jsp");
        }
        if(coll.equalsIgnoreCase("teacher"))
        {
            rd=request.getRequestDispatcher("t-prof.jsp");
        }
        for(int i=0;i<keys.length;i++)
        {
            request.setAttribute("k"+i, keys[i]);
        }
        for(int i=0;i<values.length;i++)
        {
            request.setAttribute("v"+i, values[i]);
        }
        rd.forward(request, response);
    }

        }
        
        
}

package ServletHandler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DataList.LoginData;
import sessions.login;
import MongoJDBC.LoginDBConnect;
import javax.servlet.RequestDispatcher;


public class LogServ extends HttpServlet{

    public int flag;
    public static String username;
    
    LoginData l=new LoginData();
    LoginDBConnect c=new LoginDBConnect();
    RequestDispatcher rd;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String user=request.getParameter("user");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        l.setUser(user);
        l.setUsername(username);
        l.setPassword(password);
        
        c.connectToDatabase(l);
        flag=c.verifyUser(l);
        if(flag==1)
        {
            if(c.u.equalsIgnoreCase("admin"))
            {
                rd=request.getRequestDispatcher("admin.jsp");
            }
            else if(c.u.equalsIgnoreCase("students"))
            {
                rd=request.getRequestDispatcher("student.jsp");
            }
            else if(c.u.equalsIgnoreCase("teacher"))
            {
                rd=request.getRequestDispatcher("teacher.jsp");
            }
            /**request.setAttribute("user", l.getUserID());
            request.setAttribute("user-type",c.u);
            studentData.adminName=l.getUserID();
            teacherData.adminName=l.getUserID();
            studentData.logTable=l.getUser();**/
            login.userID=l.getUserID();
            login.userType=c.u;
            rd.forward(request, response);
        }
        else
        {
            rd=request.getRequestDispatcher("fail.jsp");
            LoginDBConnect.username=l.getUserID();
            LoginDBConnect.tablename=c.u;
            rd.forward(request, response);
        }   
    }
}

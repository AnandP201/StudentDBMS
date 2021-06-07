package ServletHandler;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataList.RegisterData;
import MongoJDBC.RegisterDBConnect;
import java.util.List;
import javax.servlet.RequestDispatcher;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class RegServ extends HttpServlet {

    RegisterData reg=new RegisterData();
    RegisterDBConnect r=new RegisterDBConnect();
    
    FileItem fi;
    File file;
    String filepath;
    String user,name,qf,dob,gender,email,branch,dept,uid,password,address,phno,degree,imgID;
    
    @Override
    public void init()
    {
        filepath=getServletContext().getInitParameter("file-upload");
    }
    
    public void setVariables(FileItem it)
    {
        if(it.getFieldName().equals("user"))
        {
            user=it.getString();
        }
        if(it.getFieldName().equals("name"))
        {
            name=it.getString();
        }
        if(it.getFieldName().equals("qf"))
        {
            qf=it.getString();
        }
        if(it.getFieldName().equals("dob"))
        {
            dob=it.getString();
        }
         if(it.getFieldName().equals("gender"))
        {
            gender=it.getString();
        }
          if(it.getFieldName().equals("email"))
        {
            email=it.getString();
        }
           if(it.getFieldName().equals("branch"))
        {
            branch=it.getString();
        }
            if(it.getFieldName().equals("dept"))
        {
            dept=it.getString();
        }
             if(it.getFieldName().equals("username"))
        {
            uid=it.getString();
        }
              if(it.getFieldName().equals("password"))
        {
            password=it.getString();
        }
               if(it.getFieldName().equals("phno"))
        {
            phno=it.getString();
        }
                if(it.getFieldName().equals("degree"))
               {
                   degree=it.getString();
               }
                if(it.getFieldName().equals("add"))
                {
                    address=it.getString();
                }
    }
    
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {
        
         try
        {
            List<FileItem> fi=new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
            for(FileItem it: fi)
            {
               if(it.isFormField())
               {
                  setVariables(it);
               }
               else
               {
                   filepath+=it.getName();
                   file=new File(filepath);
                   it.write(file);
                   imgID=r.storeAndReturnImgID(filepath,name);
               }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        reg.setName(name);
        reg.setBranch(branch);
        reg.setDepartment(dept);
        reg.setEmail(email);
        reg.setDegree(degree);
        reg.setGender(gender);
        reg.setQf(qf);
        reg.setDob(dob);
        reg.setUser(user);
        reg.setPassword(password);
        reg.setUid(uid);
        reg.setAddress(address);
        reg.setPhno(phno);
        reg.setImageID(imgID);
        
        r.checkAndAddToDB(reg);
        
        request.setAttribute("user", reg.getUid());
        request.setAttribute("table",reg.getUser());
        RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
        rd.forward(request, response);
        }
}

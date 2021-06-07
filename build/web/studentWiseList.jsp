<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="src/images/ins-ico.ico" type="image/x-icon">
    <link rel="stylesheet" href="src/homepage/s-main.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@300&display=swap" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Nixie+One&display=swap" rel="stylesheet">
    <title>Student List Portal</title>
  </head>
  <script src="src/homepage/main_sc.js"></script>
  <body background="src/images/wp.jpg">
      <div class="overlay">
       
  <div class="title-bar">
    <img src=" src/images/institution-logo.png" height="70" width="70">
    <div class="title">FOR-SIms</div>
    <%@ page import="DataList.studentData"%>
    <%@page import="sessions.login"%>
    <span id="user-name"><%=login.userID%></span>
    <div class="home"><a href="http://localhost:8080/StudentDBMS/admin.jsp" style="text-decoration:none; color:black;"><i class="fa fa-home"></i></a></div>
    <div class="settings" onclick="showSettings()"><i class="fa fa-wrench"></i></div>
  </div>
      <div class="open" onclick="showMenu()" style="margin-left:-250px;" id='o1'><i class="fa fa-angle-double-right" id="right"></i><i class="fa fa-angle-double-left" id="left" style="opacity:0;"></i></div>
  <div class="settings-menu" id='s1' style="display:none;">
    <ul>
    <li><i class="fa fa-sign-out"></i><a onclick="delAndSignOut()">Sign Out</a></li>
    <li><i class="fa fa-key"></i><a href="#"><b>Reset Password</b></a></li>
    <li><i class="fa fa-external-link-square"></i><a href="https://www.google.com" target="_blank">About Us</a></li>
    </ul>
  </div>
  <div class="col" id="col">
      <form action="function" method="get" name="delForm" id="dform" style="display: none;">
          <input type="text" id="dtxt" name="dtxt" style="dispay:none;"/>
      </form>
      <div class="select_table">
          <span class="fn_title">Student Management<span><br>
                  <select name="class" id="cls" onchange="ch()">
          <option value="csa">CS-A</option>
          <option selected="true" hidden="true">Choose a section</option>
          <option value="csb">CS-B</option>
          <option value="coa">COM-A</option>
          <option value="cob">COM-B</option>
          <option value="students">All </option>
      </select>
                  <form action="function" method="get" id="sListForm" style="display:none">
                      <input type="text" id="s" name="tableselector"/>
                  </form>
      </div>
      <%
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
             %>
             <span id="information"><%=disp%></span>
             <%
                 }
             %>
      <div class="table_view">
          <table border="1" cellpadding="3" cellspacing="2" id="sList">
        <tr>
           <%
               for(int i=0;i<studentData.totalFields;i++)
               {
                if(studentData.tableHeader!=null)
                {
           %>
           <td><%=studentData.tableHeader[i].toUpperCase()%></td>
           <%
                }

               }
           %>
           <%
               if(studentData.actionAndDespFlag==1)
               {
           %>
           <td><b>ACTION</b></td>
           <%
               }
           %>
         </tr>
         
        <%
        for(int i=0;i<studentData.totalStudents;i++)
        {
           String t=studentData.student.get(i).get(0);
        %>
        <tr>
        <%
            for(int k=0;k<studentData.totalFields;k++)
            {      
        %>
        <td><%=studentData.student.get(i).get(k)%></td>
        <%
            }
            String msg=" ";
            if(studentData.isAlotted(t)&&studentData.actionAndDespFlag==1)
            {
                msg="Student is registered in "+studentData.currRegisteredTable.toUpperCase();
            }
        %>
        <%
            if(msg.equals(" ")&&studentData.actionAndDespFlag==1)
            {
        %>
        <td class="gen" id="<%=t%>" onclick="registerStudent('<%=t%>');" style="font-family: 'Nixie One',cursive"><b>Register Student</b></td>
        <%
            }
            else
           {
            if(studentData.actionAndDespFlag==1)
            {
        %>
        <td class="gen_d" style="font-family: 'Nixie One',cursive"><b><%=msg%></b></td>
        <%
            }
           }
        %>
    </tr>
    
        <%
            }
            if(studentData.warning!=null)
            {
        %>
        <span class="warning"><%=studentData.warning%></span>
        <%
            }
        %>
          </table>
      </div>
   </div>
      <div class="col_register" id="col_r">
          <span id="col_register_title">REGISTER <b><span id="student"></span></b></span>
          <form action="function" method="post" id="studentreg">
              <table>
                  <input type="text" name="nid" style="display:none;" id="nameFromtable"/>
                  <tr>
                      <td style="text-align: left">Section</td>
                      <td><input type="text" name="sec" maxlength="3" placeholder="Enter CS/CO+'section'" oninput="checkValidString()"/>
                  </tr>
                  <tr>
                      <td  style="text-align: left">Assign a Unique ID (CID)</td>
                      <td><input type="text" name="cid" placeholder="Current Year+Branch Code(CS/CO)+Unique No" maxlength="7"/></td>
                  </tr>
              </table>
          </form>
          <br>
          <span class="back_btn" onclick="backToTable()">BACK</span>
          <span class="register_student_btn" onclick="submitRegisterForm()">SUBMIT</span>
      </div>
      </div>
  </body>
</html>

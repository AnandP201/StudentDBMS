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
    <title>Teacher allotment portal</title>
  </head>
  <script src="src/homepage/main_sc.js"></script>
  <body background="src/images/wp.jpg">
      <div class="overlay">
  <div class="title-bar">
    <img src=" src/images/institution-logo.png" height="70" width="70">
    <div class="title">FOR-SIms</div>
    <%@page import="DataList.teacherData"%>
    <%@page import="sessions.login"%>
    <%@page import="sessions.functions"%>
    <input type="text" id="flagchecker" style="display: none;" value="<%=functions.cidAlreadyPresentFlag%>"/>
    <span id="user-name"><%=login.userID%></span>
    <span id="teacher_registered_entity" style="display:none;"><%=teacherData.rf%></span>
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
          <span class="fn_title">Teacher Management<span><br>
                  <select name="class" id="cls" onchange="ch()">
          <option value="csa">CS-A</option>
          <option selected="true" hidden="true">Choose a section</option>
          <option value="csb">CS-B</option>
          <option value="coa">COM-A</option>
          <option value="cob">COM-B</option>
          <option value="teacher">All (To register)</option>
      </select>
                  <form action="function" method="get" id="sListForm" style="display:none">
                      <input type="text" id="s" name="ttableselector"/>
                  </form>
      </div>
      <%
          if(teacherData.displayFlag==1)
          {
                String coll=teacherData.currTable;
                String disp;
                String f;
                int count=teacherData.totalTeachers;
                if(count>1)
                {
                    f="faculties";
                }
                else
                {
                    f="faculty";
                }
                if(coll.equalsIgnoreCase("teacher"))
                {
                   disp=count+" "+f+" found !";
                }
                else
                {
                    disp=count+" "+f+" found in "+coll.toUpperCase()+"!";
                }
            if((coll!=" ")&&(teacherData.warning==null))
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
               for(int i=0;i<teacherData.totalFields;i++)
               {
                if(teacherData.tableHeader!=null)
                {
           %>
           <td><%=teacherData.tableHeader[i].toUpperCase()%></td>
           <%
                }

               }
           %>
           <%
               if(teacherData.actionAndDespFlag==1)
               {
           %>
           <td>REGISTRATION STATUS</td>
           <td>ACTIONS</td>
           <%
               }
           %>
         </tr>
         
        <%
        for(int i=0;i<teacherData.totalTeachers;i++)
        {
           String e=teacherData.teacher.get(i).get(0);
           String t=teacherData.teacher.get(i).get(1);
        %>
        <tr>
        <%
            for(int k=0;k<teacherData.totalFields;k++)
            {      
        %>
        <td><%=teacherData.teacher.get(i).get(k)%></td>
        <%
            }
        %>
        <%
            if(teacherData.getAllotedSections(t)!=null&&teacherData.actionAndDespFlag==1)
            {
                String data=teacherData.getAllotedSections(t);
         %> 
         <td class="al_g">Done! in <b><%=data%><b></td>
         <%
            }
            else 
            {
                if(teacherData.actionAndDespFlag==1)
                {
          %>
          <td align="center"><I>Pending<I></td>
          <%
                }
            }
            if(teacherData.actionAndDespFlag==1)
            {
        %>
        <td class="gen" id="<%=t%>" onclick="register('<%=t%>','<%=e%>');" style="font-family: 'Nixie One',cursive"><b>Deploy faculty</b></td>
        <%
            }
         }
        %>
        </tr>
        <%
            if(teacherData.warning!=null)
            {
        %>
        <span class="warning"><%=teacherData.warning%></span>
        <%
            }
    }
        %>
          </table>
      </div>
   </div>
      <div class="col_register" id="col_r">
          <span id="col_register_title">ALLOT <b><span id="student"></span></b></span> 
          <form action="function" method="post" id="studentreg">
              <table>
                  <input type="text" name="nid" style="display:none;" id="nameFromtable"/>
                  <input type="text" name="idt" style="display:none;" id="idfromtable"/>
                  <tr>
                      <td style="text-align: left">Section</td>
                      <td><input type="text" name="tsec" maxlength="3" id="sec_field" placeholder="Enter CS/CO+'section'" oninput="checkValidString()"/>
                  </tr>
                  <tr>
                      <td  style="text-align: left">Assign Employee ID (EID)</td>
                      <td><input type="text" name="eid" id="ecolumn" placeholder="E+Unique No." maxlength="4"/>
                  </tr>
                  <tr>
                      <td style="text-align: left">Teaching Courses</td>
                      <td><input type="text" name="sub" placeholder="Seperated by commas"/>
                  </tr>
              </table>
          </form>
          <br>
          <span class="back_btn" onclick="backToTable()" style="">BACK</span>
          <span class="register_student_btn" onclick="submitRegisterForm()">SUBMIT</span>
      </div>
      </div>
  </body>
</html>

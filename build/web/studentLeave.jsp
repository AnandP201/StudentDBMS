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
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.3/css/fontawesome.min.css">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Nixie+One&display=swap" rel="stylesheet">
    <title>Student List Portal</title>
  </head>
  <script src="src/homepage/main_sc.js"></script>
  <body background="src/images/wp.jpg" onload="disp()">
      <div class="overlay">
  <div class="title-bar">
    <img src=" src/images/institution-logo.png" height="70" width="70">
    <div class="title">FOR-SIms</div>
    <%@page import="DataList.studentData"%>
    <%@page import="sessions.login"%>
    <%@page import="sessions.functions"%>
    <span id="user-name"><%=login.userID%></span>
    <span id="flag" style="display:none;"><%=functions.leaveAppliedFlag%></span>
    <div class="home"><a href="http://localhost:8080/StudentDBMS/student.jsp" style="text-decoration:none; color:black;"><i class="fa fa-home"></i></a></div>
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
      <form action="function" method="post" id="displayLeaveForm" style="display:none;">
          <input type="text" id="userTXT" name="userleave"/>
      </form>
      <div class="section1">
          <form method="post" action="function" id="leaveapp">
              <div class="Leaveoptions">
          <input type="radio" value="half-day" name="leavetype" id="hd" onchange="showLeavePattern();"/>HALF-DAY LEAVE
          <input type="radio" value="full-day" name="leavetype" id="fd" onchange="showLeavePattern();"/>FULL-DAY LEAVE
          <input type="radio" value="multiple-day" name="leavetype" id="gl" onchange="showLeavePattern()"/>GENERAL-LEAVE
              </div>
          <br>
          <table align="left" cellpadding="3" cellspacing="5">
              <tr>
                  <td>Start Time</td>
                  <td><input type="time" name="startTime" id="sTime" disabled></td>
                  <td>End Time</td>
                  <td><input type="time" name="endTime" id="eTime" disabled></td>
              </tr>
              <br>
              <tr>
                  <td>From</td>
                  <td><input type="date" name="startDate" id="sDate" disabled></td>
                  <td>To</td>
                  <td><input type="date" name="endDate" id="eDate" disabled></td>
              </tr>
          </table>
          <textarea id="leavepurpose" placeholder="State purpose of your leave" cols="65" rows="3" name="reason" required></textarea>
          </form>   
          <span id="apply_btn" onclick="applyLeave()">APPLY LEAVE</span>
          <span id="showleaves_btn"><input type="radio" onchange="showLeaveStatus()"/>Show applied leaves</span>
      
      <div class="section2" style="opacity: 1;">
          <%
              if(functions.displayLeave==1)
              {
                  studentData.leaveDisplay(login.userID);
                  int num_leaves=functions.numberOfLeaves;
                  
                  for(int i=0;i<num_leaves;i++)
                  {
                      int field_size=studentData.leaves.get(i).size();
          %>
                     <div class="card">
                         <table>
          <%
                    for(int j=0;j<field_size;j++)
                    {
          %>
            <tr>
              <td><b><%=studentData.titles.get(i).get(j).toUpperCase()%><b></td>
              <td align="right"><%=studentData.leaves.get(i).get(j)%></td>
            </tr>
          <%
                    }   
          %>
           </table>
          <span id="drop_btn" onclick="dropLeave('<%=studentData.leaveID.get(i)%>')"><i class="fa fa-trash"></i></span>
          <form action="function" method="post" style="display: none;" id="carddeleteform">
              <input type="text" id="delID" name="deleteCard"/>
              <input type="text" id="uname" name="tofinduser" value="<%=login.userID%>"/>
          </form>
          <%
              String str=studentData.getLeaveApproveStatus(studentData.leaveID.get(i));
              if(str.equalsIgnoreCase("YES"))
              {
          %>
          <span id="leave_approved"><i class="fa fa-check-circle"></i>APPROVED</span>
          <%
              }
              else if(str.equalsIgnoreCase("INV"))
                {
          %>
          <span id="leave_rejected"><i class="fa fa-thumbs-down"></i>NOT APPROVED</span>
          <%
              }
          %>
                     </div>
          <%
              
                  }
          %>
          
          <%
              }
          %>
          
      </div>
  </div>
  </body>
</html>

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
    <title>Leave Approval Portal</title>
  </head>
  <script src="src/homepage/main_sc.js"></script>
   <%@page import="sessions.login"%>
    <%@page import="DataList.studentData"%>
    <%@page import="sessions.functions"%>
  <body background="src/images/wp.jpg">
      <div class="overlay">
  <div class="title-bar">
    <img src=" src/images/institution-logo.png" height="70" width="70">
    <div class="title">FOR-SIms</div>
   
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
      <form action="function" method="post" style="display: none;" id="adminLeaveForm">
              <input type="text" name="toApproveField" id="toApp"/>
       </form>  
      <form action="function" method="post" style="display: none;" id="adminRejectForm">
          <input type="text" name="toRejectField" id="toRej"/>
      </form>
      <form action="function" method="get" name="delForm" id="dform" style="display: none;">
          <input type="text" id="dtxt" name="dtxt" style="dispay:none;"/>
      </form>
      <div class="select_table">
          <span class="fn_title">Student Leave Approval<span><br>
                  <select name="class" id="cls" onchange="getSection()">
          <option value="csa">CS-A</option>
          <option selected="true" hidden="true">Choose a section</option>
          <option value="csb">CS-B</option>
          <option value="coa">COM-A</option>
          <option value="cob">COM-B</option>
      </select>
                  <form action="function" method="get" id="leaveForm" style="display:none">
                      <input type="text" id="s" name="sectionValue"/>
                  </form>
      </div>
      <div class="section2">
          <%
              if(functions.displayleaveAtAdmin==1)
              {
                  if(functions.noleavesfoundFlag==1)
                  {
           %>
           <span class="warning">No records found</span>
           <%
                  }
                  else
                  {
                  int num_leaves=functions.numberOfLeaves;
                  for(int i=0;i<num_leaves;i++)
                  {
                      int field_size=studentData.leaves.get(i).size();
          %>
            <div class="card" style="height: 180px;">
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
          <span id="approve_btn" onclick="approveLeave('<%=studentData.leaveID.get(i)%>')"><i class="fa fa-check"></i><b>APPROVE</b></span>
          <span id="reject_btn" onclick="rejectLeave('<%=studentData.leaveID.get(i)%>')"><i class="fa fa-times-circle"></i><b>REJECT</b></span>        
          </div>
          <%
              
                  }
          %>
          
          <%
              }
            }
          %>
  </div>
  </div>
      </div>
  </body>
</html>

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
    <title>View Class</title>
  </head>
  <script src="src/homepage/main_sc.js"></script>
  <body background="src/images/wp.jpg">
      <div class="overlay">
       
  <div class="title-bar">
    <img src=" src/images/institution-logo.png" height="70" width="70">
    <div class="title">FOR-SIms</div>
    <%@page import="DataList.studentData"%>
    <%@page import="sessions.login"%>
    <%@page import="sessions.functions"%>
    <span id="user-name"><%=login.userID%></span>
    <div class="home"><a href="http://localhost:8080/StudentDBMS/teacher.jsp" style="text-decoration:none; color:black;"><i class="fa fa-home"></i></a></div>
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
      
      </div>
      <div class="select_table"><span class="fn_title" style="top: 50px;">Peer List</span><br></div>
      <div class="table_view">
           <%
               if(functions.peerDisplayFlag==1)
               {
           %>
          <table border="1" cellpadding="3" cellspacing="2" id="sList">
              <tr>
                  <%
                      for(int i=0;i<6;i++)
                      {
                  %>
                  <td><%=studentData.keys[i]%></td>
                  <%
                      }
                  %>
              </tr>
              <%
                  for(int i=0;i<studentData.peer.size();i++)
                  {
              %>
              <tr>
              <%
                  for(int j=0;j<studentData.peer.get(i).size();j++)
                  {
              %>
              <td><%=studentData.peer.get(i).get(j)%></td>
              <%
                  }
              %>
              </tr>
              <%
                  }
              %>
          </table>
          <%
              }
          %>
      </div>
        
   </div>
     
      </div>
  </body>
</html>

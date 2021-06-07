<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="src/images/ins-ico.ico" type="image/x-icon">
    <link rel="stylesheet" href="src/profPg/p-main.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@300&display=swap" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Nixie+One&display=swap" rel="stylesheet">
    <title>My Profile</title>
  </head>
  <script src="src/homepage/main_sc.js"></script>
<body background="src/images/wp.jpg">
  <div class="overlay">
      <div class="title-bar">
    <img src=" src/images/institution-logo.png" height="70" width="70">
    <%@page import="sessions.login"%>
    <div class="title">FOR-SIms</div>
    <span id="user-name"><%=login.userID%></span>
    <div class="home"><a href="http://localhost:8080/StudentDBMS/teacher.jsp" style="text-decoration:none; color:black;"><i class="fa fa-home"></i></a></div>
    <div class="settings" onclick="showSettings()"><i class="fa fa-wrench"></i></div>
    </div>
  <div class="settings-menu" id='s1' style="display:none;">
    <ul>
    <li><i class="fa fa-sign-out"></i><a onclick="delAndSignOut()">Sign Out</a></li>
    <li><i class="fa fa-key"></i><b>Reset Password</b></a></li>
    <li><i class="fa fa-external-link-square"></i><a href="https://www.google.com" target="_blank">About Us</a></li>
    </ul>
  </div>
  <div class="col" id="col">
      <form action="function" method="get" name="delForm" id="dform" style="display: none;">
          <input type="text" id="dtxt" name="dtxt" style="dispay:none;"/>
      </form>
        <div class="u_img"><img src="src/images/institution-logo.png" height="90" width="90"></div>
        <div class="user_name"><span id="collection-name"><%=request.getAttribute("user-type")%></span> PROFILE</div>
    <div class="profile_table">
      <table cellspacing="20">
          <%@page import="MongoJDBC.LoginDBConnect" %>
          <%@page import="ServletHandler.function"%>
          <%
              int l=LoginDBConnect.size;
          %>
          <%
            for(int i=0;i<l;i++)
            {
          %>
          <tr>
          <td><%=request.getAttribute("k"+i)%></td>
          <td>:</td>
          <td><%=request.getAttribute("v"+i)%></td>
          </tr>
          <%
              }
          %>
      </table>
      <div class="dp">
          <img src="src/<%=function.imgPath%>" size="200" height="200"/>
      </div>
    </div>
      </div>
</div>
  </body>
</html>

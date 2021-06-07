<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="src/images/ins-ico.ico" type="image/x-icon">
    <link rel="stylesheet" href="src/homepage/main-d.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@300&display=swap" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Nixie+One&display=swap" rel="stylesheet">
    <title>Home</title>
  </head>
  <script src="src/homepage/main_sc.js"></script>
<body background="src/images/wp.jpg">
  <div class="overlay">
  <div class="title-bar">
      <%@page import="sessions.login"%>
    <img src="src/images/institution-logo.png" height="70" width="70">
    <div class="title">FOR-SIms</div>
    <div class="u_det"><b>Welcome! <span id="user-name"><%=login.userID%></span>
            <span id="collection-name" style="display:none;"><%=login.userType%></span></b></div>
    <div class="settings" onclick="showSettings()"><i class="fa fa-wrench"></i></div>
  </div>
  <div class="side-bar" id="bar1" style="margin-left:-250px;">
    <ul>
        <li onclick="showProfile()">My Profile</li>
        <li onclick="showLeave()">Leave Application</li>
        <li onclick="showTeachers()">Contact Faculty</li>
        <li onclick="showPeers()">View Classmates</li>
    </ul>
        <form action="function" method="post" id="showPeerForm" style="display:none;">
            <input type="text" id="pf" name="peerText" style="display:none;">
        </form>
      <form action="function" method="post" id="sub" style="display:none;">
          <input type="text" id="inp" name="inp"  style="display:none;"/>
          <input type="text" id="int" name="int"  style="display:none;"/>
      </form>
    <span class="l" style="top: 430px;">Fortress MS@copyright.eu</span>
  </div>
      <div class="open" onclick="showMenu()" style="margin-left:-250px;" id='o1'><i class="fa fa-angle-double-right" id="right"></i><i class="fa fa-angle-double-left" id="left" style="opacity:0;"></i></div>
  <div class="settings-menu" id='s1' style="display:none;">
    <ul>
        <li><i class="fa fa-sign-out"></i><a onclick="delAndSignOut()">Sign Out</a></li>
    <li><i class="fa fa-key"></i><a href="#">Reset Password</a></li>
    <li><i class="fa fa-external-link-square"></i><a href="https://www.google.com" target="_blank">About Us</a></li>
    </ul>
  </div>
  <div class="col" id="col">
      <form action="function" method="get" id="dform" style="display: none;">
          <input type="text" id="dtxt" name="dtxt" style="dispay:none;"/>
      </form>
    <div class="col1">
      <ul>
        <i class="fa fa-graduation-cap"></i>    Student<br><br><br>
        <li>Know your colleagues</li>
        <li>Request Leave</li>
        <li>View your profile</li>
      </ul>
    </div>
      <div class="col2">
        <ul>
          <i class="fa fa-user"></i>    Teacher<br><br><br>
          <li>View your profile</li>
          <li>View your class</li>
        </ul></div>
        <div class="col3">
          <ul>
            <i class="fa fa-globe"></i>     Admin<br><br><br>
            <li>Approve faculty request</li>
            <li>Approve student leave</li>
            <li>Approve new student</li>
          </ul></div>
            <span class="prompt">Just a menu away, to access your controls!!</span>
      </div>
</div>
  </body>
</html>

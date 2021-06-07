<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    <link rel="icon" href="src/images/ins-ico.ico" type="image/x-icon">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&family=Roboto+Slab&display=swap" rel="stylesheet">
    <style>
      body
      {
        background-image: url("src/images/wp.jpg");
        background-size: 100%;
      }
      ul
      {
        list-style: none;
      }
      .t
      {
        display: flex;
        font-weight: bold;
        text-align: left;
        width:300px;
        margin-left: 30px;
        font-size: 26px;
      }
      .login_main
      {
        position: absolute;
        transform: translate(110%,30%);
        background-color: white;
        text-align: center;
        margin: 0 auto;
        width:400px;
        padding: 2%;
        box-shadow: inset 0px 4px 4px rgba(0, 0, 0, 0.25);
        border-radius: 50px;
      }
      .user
      {
        border-radius: 10px;
        width:300px;
        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
        background-color: #FFD57E;
        padding: 8px;
      }
      i.fa
      {
        font-size:24px;
      }
      .inputs
      {
        width:400px;
        margin-left: 50px;
        text-align: center;
      }
      .user input
      {
        border: none;
        font-size: 16px;
        width: 250px;
        border-radius: 5px;
        box-shadow: inset 0px 4px 4px rgba(0, 0, 0, 0.25);
        padding: 5px;
        margin-left: 10px;
        font-family: "Roboto",sans-serif;
      }
      .pass input
      {
        border: none;
        padding: 5px;
        width: 250px;
        border-radius: 5px;
        box-shadow: inset 0px 4px 4px rgba(0, 0, 0, 0.25);
        font-size: 16px;
        margin-left: 15px;
        font-family: "Roboto",sans-serif;
      }
      .pass
      {
        border-radius: 10px;
        padding: 8px;
        width:300px;
        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
        background-color: #FFD57E;
        margin-top: 10px;
      }
      .posts
      {
        display: flex;

        margin-left: -60px;
        align-content: space-around;
        font-family: "Roboto",sans-serif;
        font-size: 16px;
      }
      #sbtn
      {
        background: #FFD57E;
        font-family: "Roboto",sans-serif;
        border: none;
        font-size: 20px;
        padding: 10px;
        width:100px;
        margin-left: -90px;
        cursor: pointer;
        border-radius: 80px;
        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
      }
      #sbtn:hover
      {
        background: #AC4B1C;
        transition: all 0.5s ease;
        color: white;
      }
      a
      {
        font-weight: bold;
        margin-left: -90px;
        font-family: "Roboto",sans-serif;
        font-size: 14px;
      }
      .posts li
      {
        padding: 5px;
      }
      .posts li input:hover
      {
        cursor: pointer;
      }
    </style>
    <script>
        function enableState()
        {
            document.getElementById('u').disabled=false;
            document.getElementById('p').disabled=false;
        }
    </script>
  </head>
  <body>
    <div class="login_main">
    <div class="t">
       <img src="src/images/institution-logo.png" height="120px" width="120px"/><br>UNIVERSITY of Fortress
    </div>
    <br>
    <form action="LogServ" method="post">
      <div class="inputs">
        <div class="user"><i class="fa fa-user-circle"></i><input type="text" name="username" placeholder="UserID" id="u" disabled/></div>
        <br>
        <div class="pass"><i class="fa fa-lock"></i><input type="password" name="password" placeholder="Password" id="p" disabled/></div>
      <br>
        <ul class="posts">
          <li>You are A/An?</li>
          <li><input type="radio" value="Admin" name="user" onchange="enableState()">Admin</li>
          <li><input type="radio" value="student" name="user" onchange="enableState()">Student</li>
          <li><input type="radio" value="Teacher" name="user" onchange="enableState()">Teacher</li>
          </ul>

      <input type="submit" value="LOGIN" id="sbtn" onclick="xt()"/>
    </form>
    <br><br>
    <a href="first_reg.jsp">New User?Register Now!</a>
    </div>
  </body>
</html>

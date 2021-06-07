<!DOCTYPE html>
<html>
    
       <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
          <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@300&display=swap" rel="stylesheet">
    <style>
        body
        {
            background-image: url("src/images/wp.jpg");
            background-size: 100%;
        }
        .overlay
        {
            position: absolute;
            display: flex;
            flex-direction: column;
            justify-content: center;
            top: 0;
            bottom: 0;
            left: 0;
            right: 0;
            background: rgba(0,0,0,0.7);
        }
        .msg-box
        {
          width:400px;
          height: 150px;
          border: 5px solid #FFD57E;
          border-radius: 20px;
          font-family: "Noto Sans JP",sans-serif;
          background: white;
          text-align: center;
          transition: all 0.5s;
          margin-left: 35%;
        }
        .first_error
        {
            position: relative;
            top: 30px;
        }
        .second_error
        {
            position: relative;
            top: 30px;
        }
        .links
        {
            margin-top: 50px;
            margin-left: 145px;
            padding: 4px;
            flex-wrap: wrap;
            border: 2px solid #AC4B1C;
            border-radius: 10px;
            width: 100px;
        }
        .links a
        {
            text-decoration: none;
            color: black;
        }
        .check
        {
            padding: 4px;
            margin-top: 50px;
            width: 100px;
            margin-left: 145px;
            box-shadow: 0px 4px 4px rgba(0,0,0,0.4);
            transition: 0.5s;
            
        }
        .check:hover
        {
            cursor:pointer;
            background: #FFD57E;
            
            
        }
        .check:active
        {
            box-shadow:none;
            margin-top: 55px;
        }
        
        #alert
        {
           background:red; 
           padding:5px; 
           color:white; 
           border-radius: 5px;
           transition: opacity 0.5s;
        }
    </style>
    <script>
        function showVerifyBox()
        {
            document.getElementById('m').style.height="220px";
            document.getElementById('vform').style.opacity="1";
            document.getElementById('vform').style.marginTop="20px";
            document.getElementById('vform').style.transition="opacity 0.5s";
            document.getElementById('alert').style.opacity="0";
        }
        </script>
    <body>
        <%@page import="sessions.login"%>
        <div class="overlay">
            <div class="msg-box" id="m">
                <span class="first_error"><%=login.userID%> not added to a section.</span>
                <div class="links">
                 <a href="http://localhost:8080/StudentDBMS/student.jsp">Back to homepage</a>
                </div>
            </div>
        </div>
    </body>
</html>

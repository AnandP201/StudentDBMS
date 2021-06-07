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
          height: 180px;
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
        <div class="overlay">
            <div class="msg-box" id="m">
                <%@page import="MongoJDBC.LoginDBConnect"%>
                <%@page import="ServletHandler.function"%>
                <%
                    int f=LoginDBConnect.login_fail_flag;
                    int e_flag=function.delete_flag;
                    if(f==1)
                    {
                %>
                    <span class="second_error"><b><%=LoginDBConnect.username%></b> is already <b>active</b> as <%=LoginDBConnect.tablename%></span>
                    <div class="check" onclick="showVerifyBox()">VERIFY AND LOGOUT</div>
                    <form action="function" method="post" id="vform" style="opacity:0;">
                        Enter password for <b><%=LoginDBConnect.username%></b> : <input type="password" name="pass"/>
                    <input type="submit" value="VERIFY"/>
                    </form>
                    <%
                        if(e_flag==0)
                        {
                    %>
                        <span id="alert">Wrong password entered!!</span>
                    <%  
                        }  
                        
                    %>
                    <%
                    }
                    else
                    {
                    %>
                <span class="first_error"><b><%=LoginDBConnect.username%></b> not registered as <b><%=LoginDBConnect.tablename%></b> in system.<br><b>OR</b><br><b>UserID</b> or <b>Password</b> is wrong.</span>
                <div class="links">
                 <a href="login.jsp">Back to login</a>
                <%
                    }
                %>
                
                    
                </div>
            </div>
        </div>
    </body>
</html>

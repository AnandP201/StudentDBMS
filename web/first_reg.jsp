<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Registration</title>
    <link rel="icon" href="src/images/ins-ico.ico" type="image/x-icon">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&family=Roboto+Slab&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="src/register/reg_css.css"> 
        <script src="src/register/reg_js.js"></script>
    
  </head>
  <body background="src/images/wp.jpg">
      <div class="parent">
      <div class="t">
      <img src="src/images/institution-logo.png" height="130px" width="130px">UNIVERSITY of Fortress
    </div>
    <div class="formt">Registration Request Proforma</div>
      <br>
      <form action="RegServ" method="post" enctype="multipart/form-data">
      <div class="ch">
          <div class="ch1" id='1'>
            <b>You are A?</b>
          <ul>
            <li><input type="radio" name="user" value="teacher" id="teacher" onclick="change()">&nbsp &nbspTeacher</li>
            <li><input type="radio" name="user" value="student" id="student" onclick="change()">&nbsp &nbspStudent</li>
          </ul>
        </div>

        <div class="ch2" id='2'>
        <table>
          <tr>
            <td>Enter Name :</td>
            <td><input type="text" name="name" id="name"/></td>
          </tr>
          <tr>
            <td>Gender :</td>
            <td><input type="text" name="gender" id="gender"/></td>
          </tr>
          <tr id="rowd">
            <td>Enter Date Of Birth :</td>
            <td><input type="text" name="dob" id="dob"></td>
          </tr>
          <tr id="rowq">
            <td>Enter Qualifications :</td>
            <td><input type="text" name="qf" id="qf"/></td>
          </tr>
          <tr>
          <tr>
              <td>Choose a profile picture :</td>
              <td><input onchange="upload_check()" type="file" id="imgfile" accept="image/*" name="img" /></td>
          </tr>
            <td>E-Mail :</td>
            <td><input type="text" name="email" id="email"/></td>
          </tr>
          <tr>
              <td>Phone No :</td>
              <td><input type="text" name="phno" id="phno"/></td>
          </tr>
          <tr>
              <td>Address :</td>
              <td><input type="text" name="add" id="add"/></td>
          </tr>
          <tr>
            <td>Department :</td>
            <td><input type="text" name="dept" id="dept"/></td>
          </tr>
          <tr>
            <td>Branch :</td>
            <td><input type="text" name="branch" id="branch"/></td>
          </tr>
          <tr id="rowu">
            <td>Degree Undertaking :</td>
            <td><input type="text" name="degree" id="degree"/></td>
          </tr>
          <tr>
            <td>Create your UserID :</td>
            <td><input type="text" name="username" id="username" minlength="4" maxlength="8" placeholder="8 characters only allowed"/></td>
          </tr>
          <tr>
            <td>Create your password :</td>
            <td><input type="text" name="password" id="password"/></td>
          </tr>
        </table>
        </div>
        </div>
          <input type="submit" value="REGISTER" class='sbtn' id="sbtn">
        <br>
    </div>
  </form>
  </body>
</html>

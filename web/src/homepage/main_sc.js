function showSettings()
{
  if(document.getElementById('s1').style.display=="none")
  {
    document.getElementById('s1').style.display="block";
  }
  else {
    document.getElementById('s1').style.display="none";
  }
}
function showMenu()
{
  if(document.getElementById('bar1').style.marginLeft=="-250px")
  {
    document.getElementById('bar1').style.marginLeft="";
    document.getElementById('o1').style.marginLeft="";
    document.getElementById('right').style.opacity="0";
    document.getElementById('left').style.opacity="1";
  }
  else {
    document.getElementById('bar1').style.marginLeft="-250px";
    document.getElementById('o1').style.marginLeft="-250px";
    document.getElementById('right').style.opacity="1";
    document.getElementById('left').style.opacity="0";
  }
}
function showProfile()
{
      var user=document.getElementById('user-name').innerHTML;
      var table=document.getElementById('collection-name').innerHTML;
      
      document.getElementById('int').value=table;
      document.getElementById('inp').value=user;
      document.getElementById('sub').submit();
}

function delAndSignOut()
{
    var user=document.getElementById('user-name').innerHTML;
   
    document.getElementById('dtxt').value=user;
    
    document.getElementById('dform').submit();
}

function ch()
{
   var c=document.getElementById("cls").value;
   document.getElementById("s").value=c;
   document.getElementById("sListForm").submit();
}

function showStudents()
{
    window.location="studentWiseList.jsp";
}
function showTeachers()
{
    window.location="teacherWiseList.jsp";
}
function register(name,eid)
{
    if(eid!="*")
    {
        document.getElementById("idfromtable").value=eid;
        document.getElementById("ecolumn").readonly=true;
        document.getElementById("ecolumn").value=eid;
    }
    document.getElementById("col_r").style.marginTop="200px";
    document.getElementById("student").innerHTML=name;
    document.getElementById("col").style.opacity=0.7;
    document.getElementById("nameFromtable").value=name;
}

function registerStudent(name)
{
    document.getElementById("col_r").style.marginTop="200px";
    document.getElementById("student").innerHTML=name;
    document.getElementById("col").style.opacity=0.7;
    document.getElementById("nameFromtable").value=name;
}

function backToTable()
{
    document.getElementById("col_r").style.marginTop="-500px";
    document.getElementById("col").style.opacity=1;
}

function submitRegisterForm()
{
    document.getElementById("studentreg").submit();
}
function showLeaveDisplayForm()
{
    window.location.href="http://localhost:8080/StudentDBMS/adminleaveside.jsp";
}


function checkValidString()
{
   var str=document.getElementById("sec_field").value;
   var res=/[A-Z]/.test(str);
   if(!res)
   {
       document.getElementById("sec_field").value="";
   }
   
}
function showLeavePattern()
{
    var startTime=document.getElementById("sTime");
    var endTime=document.getElementById("eTime");
    var startDate=document.getElementById("sDate");
    var endDate=document.getElementById("eDate");
    if(document.getElementById("hd").checked)
    {
        startTime.disabled=false;
        endTime.disabled=false;
        startDate.disabled=false;
        endDate.disabled=true;
    }
    if(document.getElementById("fd").checked)
    {
        startTime.disabled=true;
        endTime.disabled=true;
        startDate.disabled=false;
        endDate.disabled=true;
        
    }
    if(document.getElementById("gl").checked)
    {
        startTime.disabled=true;
        endTime.disabled=true;
        startDate.disabled=false;
        endDate.disabled=false;
    }
}
function applyLeave()
{
    document.getElementById("leaveapp").submit();     
}

function showLeave()
{
    window.location.href="http://localhost:8080/StudentDBMS/studentLeave.jsp";
}

function disp()
{
    var f=document.getElementById("flag").innerHTML;
    if(f=="1")
    {
      alert("Leave applied successfully");
      document.getElementById("flag").innerHTML="0";
    }
}

function showLeaveStatus()
{
    var user=document.getElementById("user-name").innerHTML;
    document.getElementById("userTXT").value=user;
    document.getElementById("displayLeaveForm").submit();
}

function dropLeave(ID)
{
    document.getElementById("delID").value=ID;
    document.getElementById("carddeleteform").submit();
}

function getSection()
{
   var c=document.getElementById("cls").value;
   document.getElementById("s").value=c;
   document.getElementById("leaveForm").submit();
}

function approveLeave(ID)
{
    document.getElementById("toApp").value=ID;
    document.getElementById("adminLeaveForm").submit();
}

function rejectLeave(ID)
{
    document.getElementById("toRej").value=ID;
    document.getElementById("adminRejectForm").submit();
}

function showPeers()
{
    var name=document.getElementById("user-name").innerHTML;
    document.getElementById("pf").value=name;
    document.getElementById("showPeerForm").submit();
    
}
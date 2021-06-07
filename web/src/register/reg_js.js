function change()
{
  if(document.getElementById('student').checked||document.getElementById('teacher').checked)
  {
    document.getElementById('sbtn').style.display="block";
    document.getElementById('1').style.borderBottomLeftRadius="0px";
    document.getElementById('1').style.borderBottomRightRadius="0px";
    document.getElementById('2').style.borderTopLeftRadius="0px";
    document.getElementById('2').style.borderTopRightRadius="0px";
    document.getElementById('2').style.display="block";
  }

  if(document.getElementById('student').checked)
  {
    document.getElementById('rowq').style.display='none';

    if(document.getElementById('rowd').style.display=='none')
    {
      document.getElementById('rowd').style.display='';
    }
    if(document.getElementById('rowu').style.display=='none')
    {
        document.getElementById('rowu').style.display='';
    }
  }

  if(document.getElementById('teacher').checked)
  {
    document.getElementById('rowd').style.display='none';
    document.getElementById('rowu').style.display='none';

    if(document.getElementById('rowq').style.display=='none')
    {
      document.getElementById('rowq').style.display='';
    }
  }

  
}
window.onload=function()
{
    document.getElementById('aw').style.marginTop="-100px";
    document.getElementById('aw').style.transition="all 1s";
}

 function reform()
{
  document.getElementById('aw').style.marginTop="-1000px";
  document.getElementById('overlay').style.opacity="0";
  document.getElementById('p').style.zIndex="1";
}

function upload_check()
{
    var upl = document.getElementById("imgfile");
    
    if(upl.files[0].size > 200000)
    {
       alert("Image size under 200Kb only allowed");
       upl.value = "";
    }
};
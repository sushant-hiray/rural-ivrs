<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="/rural-ivrs/resources/bootstrap.js"> </script>
<script>
$(document).ready(function() {

   $(".dropdown-menu li a").click(function(){

     $("#lang").html($(this).text()+"&nbsp<span class='caret'></span>");

   });
   $(".CreateG").click(function(){
	   $("#lang").html("Language"+"&nbsp<span class='caret'></span>");
	   var g_name = $('input[id=Gname]').val();
	   $("#Gname").val("");
	   
	   var list='<li><a href="#">Inbox</a></li><li><a href="#">Approved</a></li><li><a href="#">Rejected</a></li><li><a id= "upload" href="#upload">Upload</a></li><li><a href="#">Manage</a></li>';
	   $("#Groups").append("<div class='btn-group g_container'> <a id='group-setting' class='btn dropdown-toggle g_button' data-toggle='dropdown' href='#'>"+g_name+"&nbsp<span class='caret'></span></a><ul class='dropdown-menu' id='group_act'>"+list+"</ul></div>");
   });
   
   /* $("#group-act").change(function() {
	   var currentId = $(this).attr('id');
	   switch(currentId) {
	   case 'upload':
		   alert("Hello WOlrd uplosd");
		   break;
	   };
   }); */
   
   $("#Groups").on('click', 'a[href^="#upload"]', function() {
	   $("#Uploader").modal("show");
   });   

});
</script>

<link href="/rural-ivrs/resources/bootstrap.css" rel="stylesheet"/>
<title>Insert title here</title>
<style type="text/css">
	  html{
	  height:100%;
	  }
      body {
        padding-top: 60px;
        padding-bottom: 40px;
        height: 85%;
      }
     .g_button{
     width:80px;
     
     }
     .g_container{
     margin-top:10px;
     margin-left:0px;
     }
     .level2{
     height:95%;
     padding:2%;
     border: 1px solid #90EE90;
     text-align:center;
     border-bottom-right-radius:20px;
     border-bottom-left-radius:20px;
     
     }
     .level1{
     background-color:#90EE90;
     text-align:center;
     height:inherit;
     
     }
     .mycontainer{
     height:100%;
     }
     .row1{
     height:7%;
     }
     .modal-body{
     height:200px;
     }
</style>
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <button type="button"  class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="brand" href="#">Rural-IVRS</a>
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li class="active"><a href="#">Home</a></li>
              <li><a href="#about">About</a></li>
              <li><a href="#contact">Contact</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>
<div   class="container-fluid mycontainer">
<div class="row-fluid row1">
    <div class="span2 level1">
    	Groups
      <!--Sidebar content-->
    </div>
    <div class="span10 level1">
      <!--Body content-->
    </div>
  </div>
  <div class="row-fluid mycontainer">
    <div id="Groups" class="span2 level2">
    <p><a data-toggle="modal" href="#example" class="btn btn-primary">Create Group</a></p>
      <!--Sidebar content-->
      
    </div>
    <div id="workspace" class="span10 level2">
    
    <ul class="nav nav-tabs" id="myTab">
  		<li class="active"><a href="#Members">Members</a></li>
  		<li><a href="#Requests">Join Requests</a></li>
  		<li><a href="#Reports">Reports</a></li>
  		<li><a href="#settings">Settings</a></li>
  		
	</ul> 
	<div class="tab-content">
  		<div class="tab-pane active" id="Members">RuralIvrs</div>
 	 	<div class="tab-pane" id="Requsets"></div>
  		<div class="tab-pane" id="Reports"></div>
  		<div class="tab-pane" id="settings"></div>
	</div>
      <!--Body content-->
    </div>
  </div>
</div>
<div id="example" class="modal hide fade in" style="display: none; ">  
<div class="modal-header">  
<a class="close" data-dismiss="modal">×</a>  
<h3>Create New Group</h3>  
</div>  
<div class="modal-body">  
<form class="form-inline">
<input type="text" id="Gname" class="input-small" placeholder="Group Name">
    <div class="btn-group">
    <a class="btn dropdown-toggle" id="lang" data-toggle="dropdown" href="#">
    Language
    <span class="caret"></span>
    </a>
    <ul class="dropdown-menu">
    <li><a href="#">Hindi</a></li>
    <li><a href="#">English</a></li>
    <li><a href="#">Marathi</a></li>
    </ul>
    </div>    
</form>        
</div>  
<div class="modal-footer">  
<a href="#"  class="btn btn-success CreateG">Create</a>  
<a href="#" class="btn" data-dismiss="modal">Cancel</a>  
</div>  
</div>  
<div id="Uploader" class="modal hide fade in"  style="display: none; ">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
    <h3>Modal header</h3>
  </div>
  <div class="modal-body">
    
    <div class="fileupload fileupload-new" data-provides="fileupload">
  		<span class="btn btn-file"><span class="fileupload-new">Select file</span><span class="fileupload-exists">Change</span><input type="file" /></span>
  		<span class="fileupload-preview"></span>
  		<a href="#" class="close fileupload-exists" data-dismiss="fileupload" style="float: none">×</a>
	</div>
    
  </div>
  <div class="modal-footer">
    <a href="#" class="btn">Close</a>
    <a href="#" class="btn btn-primary">Save changes</a>
  </div>
</div>  
</body>
</html>
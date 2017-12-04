<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>

<head>

<link href="resources/css/srudentstyle.css" rel='stylesheet' type='text/css' />
<link href="resources/css/font-awesome.css" rel='stylesheet' type='text/css' />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<script>
var home = "${pageContext.request.contextPath}"
  $(document).ready(function() {
	  $( ".saveclass" ).hide(); 
	  $(".sphone").prop("disabled", true);
	  $(".semail").prop("disabled", true);
	 
		
	 });
  
  function editStudent(sid){
// 	  alert(sid);
	  $( ".saveclass" ).hide();
	  $( ".editclass" ).show();
	  
	  $(".sphone").prop("disabled", true);
	  $(".semail").prop("disabled", true);
	  
	  $("#editid"+sid).hide();
	  $("#saveid"+sid).show();
	  
	  $("#studentphone"+sid).prop("disabled", false);
	  $("#studentemail"+sid).prop("disabled", false);
  }
  
  function updateStudent(sid){
	  
	  var studentPhone=$("#studentphone"+sid).val();
	  var studentEmail=$("#studentemail"+sid).val();
	  var studentName=$("#studentname"+sid).val();
	  var studentPass=$("#studentpass"+sid).val();
// 	  alert(studentPhone+" "+studentEmail);
	  $
		.ajax({
			type : 'GET',
			url : home + "/updateStudent",
			data : "&studentPhone=" + studentPhone+"&studentEmail=" + studentEmail+"&studentId=" + sid+"&studentName=" + studentName+"&studentPass=" + studentPass,	
			success : function(response) {
				$( ".saveclass" ).hide();
				$( ".editclass" ).show();
				
				 $(".sphone").prop("disabled", true);
				  $(".semail").prop("disabled", true);
				  
				  $(".sphone").prop("disabled", true);
				  $(".semail").prop("disabled", true);
	
				alert("Updated Succsufully:"+response);
			}
		});
	  
  }
  
  
  function deleteStudent(sid){
	  $
		.ajax({
			type : 'GET',
			url : home + "/deleteStudent",
			data :"&studentId=" + sid,	
			success : function(response) {
				
	
				alert("Deleted Succsufully:");
				location.reload();
			}
		});
  }
  
  function saveRelation(){
	  alert("Student Added Succesfully");
// 		 if(doValidation()==1){
			 document.selectionForm.submit();
// 		 }
	}
  
  </script>
<div class="container">

<header>
   <%@include file="studentHeader.jsp"%>
</header>
  
<nav>
 <%@include file="studentSidebarLeft.jsp"%>
 
</nav>

<article>

<div id="tempdiv"></div>
  <h1>Admin Home</h1>
  <form:form action="saveNewStudentAdmin" id="selectionForm" name="selectionForm" modelAttribute="student" method="post"> 
  <table border="2">
 				<tr><td>Student Name</td><td><form:input path="sname" /></td></tr>
 				<tr><td>Student Phone</td><td><form:input path="sphone" /></td></tr>
 				<tr><td>Student Email</td><td><form:input path="semail" /></td></tr>
 				<tr><td>Default password</td><td><form:input path="spassword" /></td></tr>
 				
<!--  				test -->
				<tr><td>Street</td><td><form:input path="street" /></td></tr>
				<tr><td>City</td><td><form:input path="city" /></td></tr>
				<tr><td>Country</td><td><form:input path="country" /></td></tr>

<!-- test -->

                 <tr><td></td><td> <button type="button" class="btn btn-primary" id="saveButton" onclick="saveRelation();">Save</button><td/></tr>
  </table>
</form:form> 
  
  
</article>

<footer> <%@include file="studentFooter.jsp"%></footer>

</div>

</body>
</html>
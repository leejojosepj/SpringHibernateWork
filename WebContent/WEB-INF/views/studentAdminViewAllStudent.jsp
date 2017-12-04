<!DOCTYPE html>
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
	 
	  $(".studentAddressStreet").prop("disabled", true);
	  $(".studentAddressCity").prop("disabled", true);
	  $(".studentAddressCountry").prop("disabled", true);
		
	 });
  
  function editStudent(sid){
// 	  alert(sid);
	  $( ".saveclass" ).hide();
	  $( ".editclass" ).show();
	  
	  $(".sphone").prop("disabled", true);
	  $(".semail").prop("disabled", true);
	  $(".studentAddressStreet").prop("disabled", true);
	  $(".studentAddressCity").prop("disabled", true);
	  $(".studentAddressCountry").prop("disabled", true);
	  
	  $("#editid"+sid).hide();
	  $("#saveid"+sid).show();
	  
	  $("#studentphone"+sid).prop("disabled", false);
	  $("#studentemail"+sid).prop("disabled", false);
	  $("#studentAddressStreet"+sid).prop("disabled", false);
	  $("#studentAddressCity"+sid).prop("disabled", false);
	  $("#studentAddressCountry"+sid).prop("disabled", false);
  }
  
  function updateStudent(sid){
	  
	  var studentPhone=$("#studentphone"+sid).val();
	  var studentEmail=$("#studentemail"+sid).val();
	  var studentName=$("#studentname"+sid).val();
	  var studentPass=$("#studentpass"+sid).val();
	  
	  var studentAddressStreet=$("#studentAddressStreet"+sid).val();
	  var studentAddressCity=$("#studentAddressCity"+sid).val();
	  var studentAddressCountry=$("#studentAddressCountry"+sid).val();
	  var studentAddressId=$("#studentAddressId"+sid).val();
	  
	  
// 	  alert(studentPhone+" "+studentEmail);
	  $
		.ajax({
			type : 'GET',
			url : home + "/updateStudent",
			data : "&studentPhone=" + studentPhone+"&studentEmail=" + studentEmail+"&studentId=" + sid+"&studentName=" + studentName+"&studentPass=" + studentPass+"&studentAddressStreet=" + studentAddressStreet+"&studentAddressCity=" + studentAddressCity+"&studentAddressCountry=" + studentAddressCountry+"&studentAddressId=" + studentAddressId,
			success : function(response) {
				$( ".saveclass" ).hide();
				$( ".editclass" ).show();
				
				 $(".sphone").prop("disabled", true);
				  $(".semail").prop("disabled", true);
				  
				  $(".sphone").prop("disabled", true);
				  $(".semail").prop("disabled", true);
				  
				  $(".studentAddressStreet").prop("disabled", true);
				  $(".studentAddressCity").prop("disabled", true);
				  $(".studentAddressCountry").prop("disabled", true);
	
				alert("Updated Succsufully");
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
  
  <table border="2" style="width: 100px;">
 				 <tr>
					<th><b>#</b></th>
					<th><b>Student name</b></th>
					<th><b>Student Phone</b></th>
					<th><b>Student Email</b></th>
					<th><b>Street</b></th>
					<th><b>City</b></th>
					<th><b>Country</b></th>
					
					<th>Options</th>
				</tr>
				
				<c:forEach var="student" items="${students}" varStatus="index"> 
				 <tr>
				 <td>${index.count}</td>
				 <td><input type="text" value="${student.sname}" id="studentname${student.sid}" class="sname" readonly>
				 <input type="hidden" id="studentpass${student.sid}" value="${student.spassword}">
				 </td>
				 <td><input  type="text" value="${student.sphone}" id="studentphone${student.sid}" class="sphone" style="width: 100px;"></td>
				 <td><input type="text" value="${student.semail}" id="studentemail${student.sid}" class="semail"></td>
				 
				 
<!-- 				 test -->
				 <td><input type="text" value="${student.studentAddress.street}" id="studentAddressStreet${student.sid}" class="studentAddressStreet"></td>
				 <td><input type="text" value="${student.studentAddress.city}" id="studentAddressCity${student.sid}" class="studentAddressCity"></td>
				 <td><input type="text" value="${student.studentAddress.country}" id="studentAddressCountry${student.sid}" class="studentAddressCountry">
				 <input type="hidden" value="${student.studentAddress.addressId}" id="studentAddressId${student.sid}">
				 </td>
		
<!-- 				 test -->
				 
				 <td><a href="#" id="editid${student.sid}" class="editclass" style="margin-right: 5px;" onclick="editStudent(${student.sid});">Edit</a>
				 <a href="#" id="saveid${student.sid}" class="saveclass" style="margin-right: 5px;" onclick="updateStudent(${student.sid});">Save</a>
				 <a href="#" id="Deleteid${student.sid}" class="deleteclass" onclick="deleteStudent(${student.sid})">Delete</a></td>
				 
				 </tr>
				
  				 </c:forEach> 
  
  </table>
  
  
  
</article>

<footer> <%@include file="studentFooter.jsp"%></footer>

</div>

</body>
</html>
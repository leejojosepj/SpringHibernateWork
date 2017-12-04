<!DOCTYPE html>
<html>

<head>

<link href="resources/css/srudentstyle.css" rel='stylesheet' type='text/css' />
</head>
<body>

<div class="container">

<header>
   <%@include file="studentHeader.jsp"%>
</header>
  
<nav>
 <%@include file="studentSidebarLeft.jsp"%>
 
</nav>

<article>


  <h1>Student Home</h1>
  
  <div>
  <table border="2">
 				<tr><td>Student Name</td><td>${studentDetails.sname}</td></tr>
 				<tr><td>Student Phone</td><td>${studentDetails.sphone}</td></tr>
 				<tr><td>Student Email</td><td>${studentDetails.semail}</td></tr>
 				<tr><td>Default password</td><td>${studentDetails.spassword}</td></tr>
 				
<!--  				test -->
				<tr><td>Street</td><td>${studentDetails.studentAddress.street}</td></tr>
				<tr><td>City</td><td>${studentDetails.studentAddress.city}</td></tr>
				<tr><td>Country</td><td>${studentDetails.studentAddress.country}</td></tr>

<!-- test -->

<!--                  <tr><td></td><td> <button type="button" class="btn btn-primary" id="saveButton" onclick="saveRelation();">Save</button><td/></tr> -->
  </table>
  </div>
  <div  style="width: 50%;height: 300px;background-color:#fbede7;float: left;">
  <p><b>Interceptor.java</b> file in <b>com.leejo.bo</b> package
here we implemented the concept of url tracking and redirecting <br><br>

for example , if you type <b>http://localhost:8080/ExampleMy/adminHome</b> without login ,You will redirect to login page again<br><br>
Same time you can use <b>http://localhost:8080/ExampleMy/interceptorExample</b> url,This will give the page<br><br>
please go through <b>Interceptor.java</b> file in <b>com.leejo.bo</b> package



</p>
  </div>
  
</article>

<footer> <%@include file="studentFooter.jsp"%></footer>

</div>

</body>
</html>
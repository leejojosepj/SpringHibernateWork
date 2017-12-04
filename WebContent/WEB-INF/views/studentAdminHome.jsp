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

<div id="tempdiv"></div>
  <h1>Admin Home</h1>
  <div style="width: 100%;height: 300px;background-color: red;">
  <div style="width: 50%;height: 300px;background-color:#e8e5b6;float: left;">
  <p>This spring 4 hibernate 4 demo gives basic idea about java application with spring hibernate CRUD operation</p>
  <p><b>View student</b> link in left side panel you can use for view all student and 
     here there is options for delete and update existing student
     <b>Add student</b> link in left panel you can use for add new student </p>
  
  </div>
  <div  style="width: 50%;height: 300px;background-color:#fbede7;float: left;">
  <p><b>Interceptor.java</b> file in <b>com.leejo.bo</b> package
here we implemented the concept of url tracking and redirecting <br><br>

for example , if you type <b>http://localhost:8080/ExampleMy/adminHome</b> without login ,You will redirect to login page again<br><br>
Same time you can use <b>http://localhost:8080/ExampleMy/interceptorExample</b> url,This will give the page<br><br>
please go through <b>Interceptor.java</b> file in <b>com.leejo.bo</b> package



</p>
  </div>
  </div>
</article>

<footer> <%@include file="studentFooter.jsp"%></footer>

</div>

</body>
</html>
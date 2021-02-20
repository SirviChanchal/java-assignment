<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page isELIgnored = "false" %>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">

ul {
  list-style-type: none;
 
  height:50px;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover {
  background-color: #111;
}

table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
  background-color: #4CAF50;
  color: white;
}

</style>
<title>Insert title here</title>
</head>
<body>
<ul>
  <li><a class="active" href="#">Home</a></li>

  <li><a href="#">Contact</a></li>
  <li><a href="#">About</a></li>
    <li style="float: right; margin-bottom: 20px; margin-right: 20px"><a  href="logout">Logout</a></li>
</ul>

	<h1 style="color:green">Hi <%=(String)session.getAttribute("username")%>
		 , Welcome to your profile page</h1>
		 
		 <br>
		 <br>
		 <br>
		 <p style="background-color: #1abc9c; color: white; text-align: center; width: 100%;"> Details</p>
    <table>
         
         <tr>
           <th>Name</th>
           <th>Age</th>
           <th>City</th>
           <th>Contact No.</th>
          </tr> 
          <tr>
               <th><%=(String)session.getAttribute("name")%></th>
                  <th><%=session.getAttribute("age")%></th>
                     <th><%=(String)session.getAttribute("city")%></th>
                        <th><%=session.getAttribute("mobile")%></th>
          </tr>
    </table>
</body>
</html>
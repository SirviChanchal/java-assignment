<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
      pageEncoding="ISO-8859-1" %>
      <%@ page isELIgnored = "false" %>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<style type="text/css">

/* table style*/
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

/* navbar style*/

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
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<ul>
  <li><a class="active" href="home">Home</a></li>

  <li><a href="#">Contact</a></li>
  <li><a href="#">About</a></li>
  <li style="float: right; margin-top: 10px; margin-right: 20px;"><form  action="searchuser" method="post">
<input type="text" placeholder="Enter Name" name="name">
<input type="submit" value="Search">
</form></li>
  <li style="float: right; margin-bottom: 20px; margin-right: 20px"><a  href="logout">Logout</a></li>
</ul>


<i class="mdi mdi-heart text-danger">	<h1 style="color:green">Hi Admin 
		, Welcome to Admin Panel</h1></i>
		 
		   <p style="background-color: #1abc9c; color: white; text-align: center; width: 200px;">Search Results</p>
                  <div>
                    <table>
                      <thead>
                        <tr>
                            <th style="color: blue;">User ID</th>
                            <th style="color: blue;">Name</th>
                            <th style="color: blue;">Email ID</th>
                            <th style="color: blue;">Age</th>
                            <th style="color: blue;">Mobile</th>
                            <th style="color: blue;">City</th>
                           
                            
                        </tr>
                      </thead>
                      <tbody>
                    <c:if test="${not empty usearchresult}"> 
                      <c:forEach items="${usearchresult}" var="k">
                        <tr>
                             <td style="color: #800000;">${k.userid }</td>
                            <td style="color: #800000;">${k.name }</td>
                            <td style="color: #800000;">${k.username }</td>
                            <td style="color: #800000;">${k.age}</td>
                            <td style="color: #800000;">${k.mobile}</td>
                               <td style="color: #800000;">${k.city}</td>
                            
                               
                            <!-- <td>
                            <form action="assignkey"></form>
                            </td> -->
                            
                        </tr>
                        </c:forEach>
                        </c:if>
                    <c:if test="${empty usearchresult }">
                       <p style="color: red">NO Customer Details present</p>
                    
                   </c:if>    
                   </tbody>
                   </table>
                   </div>
		 
		 
		   <p style="background-color: #1abc9c; color: white; text-align: center; width: 200px;">Customer Details</p>
                  <div>
                    <table>
                      <thead>
                        <tr>
                            <th style="color: blue;">User ID</th>
                            <th style="color: blue;">Name</th>
                            <th style="color: blue;">Email ID</th>
                            <th style="color: blue;">Age</th>
                            <th style="color: blue;">Mobile</th>
                            <th style="color: blue;">City</th>
                           
                            
                        </tr>
                      </thead>
                      <tbody>
                    <c:if test="${not empty users}"> 
                      <c:forEach items="${users}" var="k">
                        <tr>
                             <td style="color: #800000;">${k.userid }</td>
                            <td style="color: #800000;">${k.name }</td>
                            <td style="color: #800000;">${k.username }</td>
                            <td style="color: #800000;">${k.age}</td>
                            <td style="color: #800000;">${k.mobile}</td>
                               <td style="color: #800000;">${k.city}</td>
                            
                               
                            <!-- <td>
                            <form action="assignkey"></form>
                            </td> -->
                            
                        </tr>
                        </c:forEach>
                        </c:if>
                    <c:if test="${empty users }">
                       <p style="color: red">NO Customer Details present</p>
                    
                   </c:if>    
                   </tbody>
                   </table>
                   </div>
                   <br>
                   <br>
                   <h3 style="background-color: #1abc9c; color: white; text-align: center; width: 200px;">Delete Customer </h3>
                    		   <form action="delete" method="post" style="float:  left;"> 
                      				<input type="text"  placeholder="Enter User Id" name="uid">
                      				<input type="submit" value="Delete Customer" >
                                 </form>
                  <br>
                  <br>
                  <h3 style="background-color: #1abc9c; color: white; text-align: center; width: 200px;">Update Customer</h3>
                    <form action="update" method="post" style="float:  left;"> 
                      				<input type="text"  placeholder="Enter User Id" name="userid">
                      				<input type="text"  placeholder="Enter New Name " name="name">
                      				<input type="text"  placeholder="Enter New Mobile No. " name="mobile">
                      				<input type="text"  placeholder="Enter New City " name="city">
                      				<input type="submit" value="Update Customer" >
                     </form>
                     
                     <br>
                     <br>
                     <br>
                     <br>
                     <br>
                     <br>
</body>
</html>
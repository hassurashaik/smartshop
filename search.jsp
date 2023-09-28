
    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, th, td {
  border: 0.5px solid white;
}
    body{
background: rgb(1,0,36);
    background: linear-gradient(90deg, rgba(2,0,36,1) 0%, rgba(9,9,121,1) 35%, rgba(0,212,255,1) 100%);
      min-height:600px;
      margin:0;
      padding:0;
      color:white

    }
</style>
</head>
<body>
<table width="100%">


<tr>
<th><h1>NAME</h1></th>
<th><h1>CATEGORY</h1></th>
<th><H1>PRICE</H1></th>
<th><h1>ACTIVE</h1></th>

</tr>

<% 
int z=0;
String search=request.getParameter("pro");

try{

Class.forName("com.mysql.cj.jdbc.Driver");  
Connection c =DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","12345678");
     	    	
Statement st=c.createStatement();
HttpSession s = request.getSession();

String name = (String)request.getSession().getAttribute("name");

    
  
    ResultSet rs=st.executeQuery("select * from product where (name like '%"+search+"' or cat like '%"+search+"') and active like 'yes' ");
    while(rs.next()){
    z=1;%>
    
<tr>
<td><%=rs.getString(1) %></td>
<td><%=rs.getString(2) %></td>
<td><%=rs.getString(3) %></td>
<td><%=rs.getString(4) %></td>
<td><a href="addcart.jsp?id=<%=rs.getString(1) %>" ><input type=submit></a></td>
</tr>
<%
    }}catch(Exception e){
System.out.println(e);}%>


</table>

</body>
</html>
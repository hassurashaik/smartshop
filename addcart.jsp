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
<%


String pro_name=request.getParameter("id");



try{  
	Class.forName("com.mysql.cj.jdbc.Driver");  
    Connection c =DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","12345678"); 
    Statement st=c.createStatement();
    HttpSession s = request.getSession();

    String name = (String)request.getSession().getAttribute("name");
   
    String q="insert into cart(name,pro_name)values(?,?)";
	
  
    PreparedStatement p=c.prepareStatement(q);
    p.setString(1,name);
    p.setString(2,pro_name);
   
int i=p.executeUpdate();
    if(i>0) {
    
    	
   	 
   	session.setAttribute("name",name);  
	response.sendRedirect("adcart.jsp");

    	

    		
    		
    		   
    }
    else {
    	out.print("no");
    }
 
}
catch(Exception e){ System.out.println(e);}  



%>


</body>
</html>

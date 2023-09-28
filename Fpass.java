

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Fpass
 */
@WebServlet("/Fpass")
public class Fpass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fpass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
PrintWriter out=response.getWriter();


String name=request.getParameter("name");
String email=request.getParameter("email");
String mobilenumber=request.getParameter("mobilenumber");
String securityquestion=request.getParameter("securityquestion");
String answer=request.getParameter("answer");
String newpassword=request.getParameter("newpassword");
try{  
	Class.forName("com.mysql.cj.jdbc.Driver");  
    Connection c =DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","12345678"); 
    Statement st=c.createStatement();
    ResultSet rs=st.executeQuery("select * from user where name='"+name+"' and email='"+email+"' and mobilenumber='"+mobilenumber+"' and securityquestion='"+securityquestion+"' and answer='"+answer+"'");
    int z=0;
    while(rs.next()) {
    	z=1;
    st.executeUpdate("update user set password='"+newpassword+"' where name='"+name+"'");
    	response.sendRedirect("index.html");
    }
    if(z==0) {
    	response.sendRedirect("fpass.html");
    	
    }
   
     
}
catch(Exception e){ System.out.println(e);}  
} 




}






import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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

String password=request.getParameter("password");
try{  
	Class.forName("com.mysql.cj.jdbc.Driver");  
    Connection c =DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","12345678"); 
    Statement st=c.createStatement();
    ResultSet rs=st.executeQuery("select * from user where name='"+name+"' and password='"+password+"'");
    int z=0;
    if(name.equals("hassura") && password.equals("786") ){
    	response.sendRedirect("admin.html");

    	
    	
    }
    else {
    while(rs.next()) {
    	z=1;
    	 HttpSession session = request.getSession();
    	session.setAttribute("name",name);      	    	
    
    	response.sendRedirect("home.html");
    }
    if(z==0) {

    	response.sendRedirect("index.html");
    	
    	
    }
   
    
  }}
 

catch(Exception e){ System.out.println(e);} 


}
}
	



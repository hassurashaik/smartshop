

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SHOP_SIGN
 */
@WebServlet("/SHOP_SIGN")
public class SHOP_SIGN extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SHOP_SIGN() {
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
		String password=request.getParameter("password");
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection c =DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","12345678"); 
           
            String q="insert into user(name,email,mobilenumber,securityquestion,answer,password)values(?,?,?,?,?,?)";
          
            PreparedStatement p=c.prepareStatement(q);
            p.setString(1,name);
            p.setString(2,email);
            p.setString(3,mobilenumber);
            p.setString(4,securityquestion);
            p.setString(5,answer);
            p.setString(6,password);
 int i=p.executeUpdate();
            if(i>0) {
            	
            	RequestDispatcher rd=request.getRequestDispatcher("index.html");
            	rd.include(request, response);
            }
            else {
            	out.print("no");
            }
		 
		}
		catch(Exception e){ System.out.println(e);}  
		} 
		
		
		

}

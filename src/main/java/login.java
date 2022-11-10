

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String user=request.getParameter("Email");
		String passw=request.getParameter("Password");
		response.setContentType("text/html");
	
		
		
	
	try
	{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/ecommerce";
		Connection con=DriverManager.getConnection(url,"root","Shubh@94154#!@");
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery("select * from reg_details where email='"+user+"'and pasword='"+passw+"'");
		if(rs.next())
		{
			
			setWarningMsg("WELCOME TO WALPI.COM");
			RequestDispatcher rDispatcher=request.getRequestDispatcher("afterlog.html");
			rDispatcher.forward(request, response);
			
		}
		else {
		setWarningMsg("enter correct details");
			//o.println("<div class="p">  enter correct credentials</div>");
			RequestDispatcher rd=request.getRequestDispatcher("/login.html");  
	        rd.include(request, response);  
		}
		
		
		
	
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
		
	}

	private void setWarningMsg(String string) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

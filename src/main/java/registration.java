

import java.io.IOException;
import java.security.spec.MGF1ParameterSpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class registration
 */
@WebServlet("/registration")
public class registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public registration() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String user=request.getParameter("Email");
		String passw=request.getParameter("Password");
		String gender=request.getParameter("Gender");
		
		String city=request.getParameter("City");
		String state=request.getParameter("State");
		
		
		
	
	
	try
	{
		
		Class.forName("database.sql");
		String url="jdbc:mysql://localhost:3306/ecommerce";
		Connection con=DriverManager.getConnection(url,"root","Shubh@94154#!@");
		
	String rs="insert into reg_details(email,gender,city,state,pasword) values(?,?,?,?,?)"; 
	
	PreparedStatement ps=con.prepareStatement(rs);
	ps.setString(1, user);
	ps.setString(2, gender);
	
	ps.setString(3, city);
	ps.setString(4, state);
	ps.setString(5, passw);

	ps.executeUpdate();

		
		
		con.close();
	
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
		
	}

	
		
	}

	



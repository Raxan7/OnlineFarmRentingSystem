
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.SQLException;



@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Connect to the actual form and send data into the database
		
		String JDBC_URL = "jdbc:mysql://sql.freedb.tech:3306/freedb_raxan7_db";
    	String USER = "freedb_saidi";
    	String PASSWORD = "7*vtUS?fjyBFJg3";
		// I/O objects
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		// // Capture data from the Sign Up form 
		String first_name = request.getParameter("fname");
		String last_name = request.getParameter("lname");
		String email = request.getParameter("E-mail");
		String password = request.getParameter("password");
		String user_type = request.getParameter("user_type");
		
//		String first_name = "Saidi";
//		String last_name = "Manyerere";
//		String email = "manyerere201@gmail.com";
//		String password = "blender1";
		
		// Connect to the database
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);;
			String sql = "INSERT INTO user (email, first_name, last_name, password, user_type) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, email);
			statement.setString(2, first_name);
			statement.setString(3, last_name);
			statement.setString(4, password);
			statement.setString(5, user_type);
			statement.executeUpdate();
			
			// Close the resources
			statement.close();
			conn.close();
			
			session.setAttribute("email", email);
			session.setAttribute("first_name", first_name);
			session.setAttribute("last_name", last_name);
			session.setAttribute("user_type", user_type);
			session.setMaxInactiveInterval(3600);
			
			response.sendRedirect("test.jsp");
			// out.print("Successfully sent the data into the database");
		} catch (ClassNotFoundException | SQLException e) {
			out.print("An error occured");
			e.printStackTrace();}
		
		// Capture data from the Sign Up form and send it to the database
		
	}
}


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helpers.DBConnection;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	/**
	 * Sign Up Servlet provides the functionality to handle Sign Up into the system
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		// // Capture data from the Sign Up form 
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		// Connect to the database
		try {
			Connection conn = DBConnection.getConnection();
			String sql = "INSERT INTO user (email, first_name, last_name, password) VALUES (?, ?, ?, ?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, email);
			statement.setString(2, first_name);
			statement.setString(3, last_name);
			statement.setString(4, password);
			statement.executeUpdate();
			
			// Close the resources
			statement.close();
			conn.close();
		} catch (Exception e) {
			
		}
		
		// Capture data from the Sign Up form and send it to the database
		
	}

}





















@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String username = request.getParameter("username");
     String password = request.getParameter("password");

     try {
         Connection conn = DBConnection.getConnection();
         String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
         PreparedStatement statement = conn.prepareStatement(sql);
         statement.setString(1, username);
         statement.setString(2, password);
         statement.executeUpdate();

         // Close resources
         statement.close();
         conn.close();
     } catch (Exception e) {
         e.printStackTrace();
     }

     // Redirect or show a success message
 }
}


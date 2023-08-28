
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import helpers.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;


@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Connect to the actual form and send data into the database
		
		// I/O objects
		PrintWriter out = response.getWriter();
		
		// // Capture data from the Sign Up form 
		String first_name = request.getParameter("firstname");
		String last_name = request.getParameter("lastname");
		String email = request.getParameter("E-mail");
		String password = request.getParameter("password");
		
//		String first_name = "Saidi";
//		String last_name = "Manyerere";
//		String email = "manyerere201@gmail.com";
//		String password = "blender1";
		
		// Connect to the database
		try {
			Class.forName("com.mysql.jdbc.Driver");
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
			out.print("Successfully sent the data into the database");
		} catch (ClassNotFoundException | SQLException e) {
			out.print("An error occured");
		}
		
		// Capture data from the Sign Up form and send it to the database
		
	}
}
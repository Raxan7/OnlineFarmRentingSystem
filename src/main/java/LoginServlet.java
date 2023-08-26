

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helpers.DBConnection;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		// I/O objects
		PrintWriter out = response.getWriter();
		
	    // Capture data from the Sign Up form 
//		String email = request.getParameter("email");
//		String password = request.getParameter("password");
		
		String email = "manyerere201@gmail.com";
		String password = "blender1";
		
		// Connect to the database
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DBConnection.getConnection();
			String sql = "SELECT * FROM user WHERE email = '" + email + "'";
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				out.println(resultSet.getString(1));
				out.println(resultSet.getString(2));
				out.println(resultSet.getString(3));
				out.println(resultSet.getString(4));
				out.println();
;				if (resultSet.getString(4).equals(password)) {
					out.println("The user with the said password exists");
				} else {
					out.println("Wrong password or email, please check again");
				}
			}
			
			// Close the resources
			conn.close();
		} catch (Exception e) {
			out.println("An error occured");
			out.println(e);
			e.printStackTrace();
		}
	}

}

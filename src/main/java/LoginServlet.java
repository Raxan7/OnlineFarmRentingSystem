import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
    	
    	String JDBC_URL = "jdbc:mysql://localhost:3306/FarmRentSystemDB";
    	String USER = "saidi";
    	String PASSWORD = "blender1";
		
		// I/O objects
		PrintWriter out = response.getWriter();
		
	    // Capture data from the Sign Up form 
		String email = request.getParameter("E-mail");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();

		// Connect to the database
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
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
					session.setAttribute("email", email);
					session.setMaxInactiveInterval(3600);
					response.sendRedirect("test.jsp");
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

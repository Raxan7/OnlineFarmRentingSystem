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

import org.mindrot.jbcrypt.BCrypt;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
    	
//    	String JDBC_URL = "jdbc:mysql://localhost:3306/FarmRentSystemDB";
//    	String USER = "saidi";
//    	String PASSWORD = "blender1";
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
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
			String sql = "SELECT * FROM user WHERE email = '" + email + "'";
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				System.out.println(resultSet.getString(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));
				System.out.println(resultSet.getString(4));
				System.out.println(resultSet.getString(5));
				String storedHashedPassword = resultSet.getString(4);
				boolean passwordMatch = BCrypt.checkpw(password, storedHashedPassword);
				
				if (passwordMatch) {
					out.println("The user with the said password exists");
					session.setAttribute("email", email);
					session.setAttribute("first_name", resultSet.getString(2));
					session.setAttribute("last_name", resultSet.getString(3));
					session.setAttribute("user_type", resultSet.getString(5));
					session.setMaxInactiveInterval(3600);
					if (resultSet.getString(5).equals("ADMINISTRATOR")) {
						response.sendRedirect(request.getContextPath() + "/admin_pages/Admin-Panel.html");
					} else {
						response.sendRedirect(request.getContextPath() + "/templates/test.jsp");
					}
				} 
			}
			response.sendRedirect(request.getContextPath() + "/notLoggedIn.html");	
			
			// Close the resources
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

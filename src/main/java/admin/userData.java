package admin;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class userData extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
         String firstname=request.getParameter("first_name");
         String lastname=request.getParameter("last_name");
         String email=request.getParameter("email");
         String password=request.getParameter("password");
         String user_type=request.getParameter("user_type");

             try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/FarmRentSystemDB","saidi","blender1");
            PreparedStatement stmt=conn.prepareStatement("INSERT INTO user(firstname,lastname,email,password,user_type) VALUES(?,?,?,?,?)");
            stmt.setString(1, firstname);
            stmt.setString(2, lastname);
            stmt.setString(3, email);
            stmt.setString(4, password);
            stmt.setString(5, user_type);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
            out.println("data inserted successfully");
             
             } catch (ClassNotFoundException | SQLException ex) {
                 out.println("there was an error occured");
             }
                
                 
    }

}

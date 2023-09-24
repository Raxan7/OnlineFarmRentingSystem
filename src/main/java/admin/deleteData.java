package admin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class deleteData extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int farmId=Integer.parseInt(request.getParameter("id"));
        
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/FarmRentSystemDB","saidi","blender1");
        PreparedStatement stmt=conn.prepareStatement("delete from farm where id=? ");
        stmt.setInt(1, farmId);
        stmt.executeUpdate();
        stmt.close();
        conn.close();
        
        
        }catch(Exception e){
        e.printStackTrace();
        }
        response.sendRedirect("farmDisplayProcess");
        
        
    }


}

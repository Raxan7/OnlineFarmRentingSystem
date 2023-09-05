import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FarmDataRetrieveServlet
 */
@WebServlet("/FarmDataRetrieveServlet")
public class FarmDataRetrieveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		String JDBC_URL = "jdbc:mysql://localhost:3306/FarmRentSystemDB";
//		String USER = "saidi";
//		String PASSWORD = "blender1";
		
		String JDBC_URL = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7644068";
    	String USER = "sql7644068";
    	String PASSWORD = "FjBAgfzDAG";
		
		List<String> allId = new ArrayList<String>(); 
		String id = request.getParameter("id");
		byte[] img = null;
		ServletOutputStream sos = null;
		String sqlQuery = "SELECT image FROM farm WHERE id = '"+ id + "'";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
			PreparedStatement ps = connection.prepareStatement(sqlQuery);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				img = rs.getBytes(1);
			}
			
			sos = response.getOutputStream();
			sos.write(img);
//			response.sendRedirect("farmView.jsp");
//			request.setAttribute("imageIds", allId);
//	        request.getRequestDispatcher("farmView.jsp").forward(request, response);
			

        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
}
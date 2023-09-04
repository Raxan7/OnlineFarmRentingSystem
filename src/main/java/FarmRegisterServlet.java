

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Servlet implementation class FarmRegisterServlet
 */
@javax.servlet.annotation.MultipartConfig
@WebServlet("/FarmRegisterServlet")
public class FarmRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(false);
		
		String JDBC_URL = "jdbc:mysql://localhost:3306/FarmRentSystemDB";
		String USER = "saidi";
		String PASSWORD = "blender1";
		// doGet(request, response);
		// Get the image file from the request
		String location = request.getParameter("location");
        String description = request.getParameter("description");
        String fsize = request.getParameter("fsize");
        String fstatus = request.getParameter("fstatus");
        String contact = request.getParameter("contact");
        String owner = (String)session.getAttribute("email");
        Part filePart = request.getPart("image");
        InputStream inputStream = filePart.getInputStream();

        // Connect to the database
        Connection connection = null;
        PreparedStatement statement = null;
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            String SQL_INSERT_IMAGE = "INSERT INTO farm (location, description, image, farm_size, status, contact, owner) VALUES (?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(SQL_INSERT_IMAGE);
            statement.setString(1, location);
            statement.setString(2, description);
            statement.setBlob(3, inputStream);
            statement.setString(4, fsize);
            statement.setString(5, fstatus);
            statement.setString(6, contact);
            statement.setString(7, owner);

            // Insert the image into the database
            statement.executeUpdate();
            
            statement.close();
            connection.close();
            
         // Send a success message to the client
            response.setContentType("text/plain");
            response.getWriter().write("Image uploaded successfully");
            response.sendRedirect("test.jsp");
        } catch (Exception e) {
            e.printStackTrace();
         // Send a success message to the client
            response.setContentType("text/plain");
            response.getWriter().write("Image upload failed");
        }

        
    }
}


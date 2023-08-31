

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import helpers.DBConnection;

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
		// doGet(request, response);
		// Get the image file from the request
        Part filePart = request.getPart("image");
        String name = request.getParameter("name");
        InputStream inputStream = filePart.getInputStream();

        // Connect to the database
        Connection connection = null;
        PreparedStatement statement = null;
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            connection = DBConnection.getConnection();
            String SQL_INSERT_IMAGE = "INSERT INTO images (name, image) VALUES (?, ?)";
            statement = connection.prepareStatement(SQL_INSERT_IMAGE);
            statement.setString(1, name);
            statement.setBlob(2, inputStream);

            // Insert the image into the database
            statement.executeUpdate();
            
            statement.close();
            connection.close();
            
         // Send a success message to the client
            response.setContentType("text/plain");
            response.getWriter().write("Image uploaded successfully");
            response.sendRedirect("imageTest.jsp");
        } catch (Exception e) {
            e.printStackTrace();
         // Send a success message to the client
            response.setContentType("text/plain");
            response.getWriter().write("Image upload failed");
        }

        
    }
}


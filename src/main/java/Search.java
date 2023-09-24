//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.PrintWriter;
//import java.sql.Blob;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Base64;
//import java.util.List;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet("/FarmSearchServlet")
//public class Search extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // Get the search query parameter from the request
//        String searchQuery = request.getParameter("location");
//
//        // JDBC database connection setup (ensure you have the JDBC driver in your project)
//        String jdbcUrl = "jdbc:mysql://localhost:3306/farm";
//        String dbUsername = "root";
//        String dbPassword = "";
//        
//        List<Farm> farms = new ArrayList<>(); // Create a list to hold Farm objects
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);
//
//            // Create a SQL query to search farms by location
//            String sql = "SELECT * FROM farm WHERE location LIKE ?";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, "%" + searchQuery + "%"); // Use '%' for wildcard search
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                int owner = resultSet.getInt("owner");
//                String location = resultSet.getString("location");
//                String description = resultSet.getString("description");
//                byte[] imageBytes = resultSet.getBytes("image");
//                String farmSize = resultSet.getString("farm_size");
//                String status = resultSet.getString("status");
//                String contact = resultSet.getString("contact");
//                
//                // Encode the image data to Base64
//                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
//
//                Farm farm = new Farm(id,owner, location, description, base64Image, farmSize, status, contact);
//                farms.add(farm);
//            }
//
//
//            // Close resources
//            resultSet.close();
//            preparedStatement.close();
//            connection.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//          request.setAttribute("farms", farms); // Store the list of Farm objects in the request scope
//
//        request.getRequestDispatcher("/templates/farmdisplay.jsp").forward(request, response);
//    }
//
//    // Helper method to convert a Blob to a byte array
//    private byte[] getBytesFromBlob(Blob blob) throws IOException, SQLException {
//        if (blob == null) {
//            return null;
//        }
//        InputStream inputStream = blob.getBinaryStream();
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        byte[] buffer = new byte[4096];
//        int bytesRead = -1;
//        while ((bytesRead = inputStream.read(buffer)) != -1) {
//            outputStream.write(buffer, 0, bytesRead);
//        }
//        return outputStream.toByteArray();
//    }
//}
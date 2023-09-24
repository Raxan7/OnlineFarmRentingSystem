import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GenerateFarmDataPDF")
public class GetReport extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Database connection parameters
        String jdbcUrl = "jdbc:mysql://localhost:3306/FarmRentSystemDB";
        String dbUser = "saidi";
        String dbPassword = "blender1";

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
 
            // Establish the database connection
            Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);

            // SQL query to fetch data from the "farm" table
            String sqlQuery = "SELECT * FROM farm";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Create a PDF document
            Document document = new Document(PageSize.A4);

            // Set the content type and create a response output stream for the PDF
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=farm_data.pdf");
            OutputStream out = response.getOutputStream();
            PdfWriter.getInstance(document, out);

            document.open();

            // Create a PDF table
            PdfPTable table = new PdfPTable(6); // 8 columns

            // Add headers to the table
            table.addCell("ID");
            table.addCell("Location");
//            table.addCell("Description");
            table.addCell("Farm Size");
            table.addCell("Status");
            table.addCell("Contact");
            table.addCell("Owner");

            // Add data to the table (iterate through your database results)
            while (resultSet.next()) {
                table.addCell(resultSet.getString("id"));
                table.addCell(resultSet.getString("location"));
//                table.addCell(resultSet.getString("description"));
                table.addCell(resultSet.getString("farm_size"));
                table.addCell(resultSet.getString("status"));
                table.addCell(resultSet.getString("contact"));
                table.addCell(resultSet.getString("owner"));
            }

            // Add the table to the document
            document.add(table);

            // Close the document
            document.close();

            // Close the database resources
            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException | DocumentException e) {
            e.printStackTrace();
        }
    }
}

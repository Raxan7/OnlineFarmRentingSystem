package admin;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;

@MultipartConfig(maxFileSize = 1024 * 1024 * 5)

public class farmUploadProcess extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String location=request.getParameter("location");
        String description=request.getParameter("desscription");
        String farm_size=request.getParameter("farm_size");
        String farm_price=request.getParameter("farm_price");
        String status=request.getParameter("status");
        String sales_status=request.getParameter("sales_status");
        String contact=request.getParameter("contact");
        if(location.isEmpty()){
            out.println("location is empty");
        
        }
        
        Part filepart=request.getPart("image");
        String filename=Paths.get(filepart.getSubmittedFileName()).getFileName().toString();
        InputStream fileContent=filepart.getInputStream();
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/FarmRentSystemDB","saidi","blender1");
        
        PreparedStatement stmt=conn.prepareStatement("INSERT INTO farm(location,desscription,image,farm_size,farm_price,status,sales_status,contact) VALUES(?,?,?,?,?,?,?,?)");
        stmt.setString(1, location);
        stmt.setString(2, description);
        stmt.setBinaryStream(3, fileContent);
        stmt.setString(4, farm_size);
        stmt.setString(5, farm_price);
        stmt.setString(6, status);
        stmt.setString(7, sales_status);
        stmt.setString(8, contact);
        stmt.executeUpdate();
        stmt.close();
        out.println("successfully");
        
        
        }catch(SQLException | ClassNotFoundException e){
        e.printStackTrace();
        }

        
        
        
        
        
    }

}

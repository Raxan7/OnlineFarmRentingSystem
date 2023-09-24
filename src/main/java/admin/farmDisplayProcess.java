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
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;

public class farmDisplayProcess extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<farmDisplayConstructor> viewFarm= new ArrayList<>();
        try{
            PrintWriter out = response.getWriter();

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/FarmRentSystemDB","saidi","blender1");
            String farmResult="select id,location,description,image,farm_size,farm_price,status,sales_status,contact from farm";
            PreparedStatement stmt=conn.prepareStatement(farmResult);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
				int id=rs.getInt("id");
				String location=rs.getString("location");
				 String desscription=rs.getString("description");
				  byte[] image=rs.getBytes("image");
				   String farm_size=rs.getString("farm_size");
				String farm_price=rs.getString("farm_price");
				 String status=rs.getString("status");
				 String sales_status=rs.getString("sales_status");
				 String contact=rs.getString("contact");
				 String base64Image = Base64.getEncoder().encodeToString(image);

                     
               farmDisplayConstructor display=new farmDisplayConstructor(id,location,desscription,base64Image,farm_size,farm_price,status,sales_status,contact);
               viewFarm.add(display);
        
            }
           
        
        }catch(Exception e){
        e.printStackTrace();
        }
                request.setAttribute("display", viewFarm);
        request.getRequestDispatcher("/admin_pages/farmDisplay.jsp").forward(request, response);
       
    }


}

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/EditFarmServelet")
public class EditFarmServelet extends HttpServlet {

    private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       
		String farm_id = request.getParameter("farm_id");	
		
		String flocation = request.getParameter("location");
//		String fImage = request.getParameter("image");
		String fDescription = request.getParameter("description");
		String fSize = request.getParameter("fsize");
		String fPrice = request.getParameter("fprice");
		String fStatus = request.getParameter("fstatus");
		String contact = request.getParameter("contact");
		
		System.out.println(farm_id);
		System.out.println(flocation);
//		System.out.println(fImage);
		System.out.println(fDescription);
		System.out.println(fSize);
		System.out.println(fPrice);
		System.out.println(fStatus);
		System.out.println(contact);
	        
        try{
            PrintWriter out = response.getWriter();
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FarmRentSystemDB","saidi", "blender1");
            
            
            PreparedStatement st = con.prepareStatement("UPDATE farm SET location=?, description=?, farm_size=?, farm_price=?, status=?, contact=? WHERE id=?");
            st.setString(1, flocation);
            st.setString(2, fDescription);
            st.setString(3, fSize);
            st.setString(4, fPrice);
            st.setString(5, fStatus);
            st.setString(6, contact);
            st.setString(7, farm_id);
            st.executeUpdate();
            
            st.close();
            con.close();  
            response.sendRedirect(request.getContextPath() + "/templates/Seller.jsp?farm_id="+farm_id);
            

    }
        catch(Exception e){
            System.out.print(e);
        }
}
}
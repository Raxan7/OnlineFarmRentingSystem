

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BuyServlet
 */
@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		String user_id = (String)session.getAttribute("email");
		String farm_id = request.getParameter("farm_id");
		
		String fSalesStatus = "SOLD";
		
	        
     try{
         PrintWriter out = response.getWriter();
         
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FarmRentSystemDB","saidi", "blender1");
         
         
         PreparedStatement st = con.prepareStatement("UPDATE farm SET sales_status=?, buyer_id=? WHERE id=?");
         st.setString(1, fSalesStatus);
         st.setString(2, user_id);
         st.setString(3, farm_id);
         st.executeUpdate();
         
         st.close();
         con.close();  
         response.sendRedirect(request.getContextPath() + "/templates/checkout.jsp?farm_id="+farm_id);
         

     } catch(Exception e){
         System.out.print(e);
     }
	}

}

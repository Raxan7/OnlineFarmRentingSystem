
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class DeleteServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().append("Served at: ").append(request.getContextPath());
	String farm_id = request.getParameter("farm_id");
       // name = "Franciska";
//	System.out.println(farm_id);
        
        try{
            PrintWriter out = response.getWriter();
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_raxan7_db","freedb_saidi", "7*vtUS?fjyBFJg3");
            
            PreparedStatement st = con.prepareStatement("SELECT sales_status FROM farm WHERE id='"+ farm_id +"'");
            ResultSet rs = st.executeQuery();
            
            while(rs.next()) {
//            	System.out.println(rs.getString(1));
            	if(rs.getString(1)=="AVAILABLE") {
                  PreparedStatement stmt = con.prepareStatement("DELETE FROM farm WHERE id='"+ farm_id + "'");
                  stmt.executeUpdate();	
            	}
            	else {
//            		System.out.println("You can't delete the farm is already sold");
            		response.sendRedirect("soldFarmError.jsp?farm_id="+ farm_id);
            	}
            }
//            PreparedStatement st = con.prepareStatement("DELETE FROM farm WHERE id='"+ farm_id + "'");
//            st.executeUpdate();
	  
            con.close();
            response.sendRedirect("MyFarm.jsp");
            

    }
        catch(Exception e){
            System.out.print(e);
        }
}
}
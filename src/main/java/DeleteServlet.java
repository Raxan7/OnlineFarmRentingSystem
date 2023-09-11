
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class DeleteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().append("Served at: ").append(request.getContextPath());
	String f_id = request.getParameter("f_id");
       // name = "Franciska";
	System.out.println(f_id);
        
        try{
            PrintWriter out = response.getWriter();
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_raxan7_db","freedb_saidi", "7*vtUS?fjyBFJg3");
            
            
            PreparedStatement st = con.prepareStatement("delete from farm where id='"+ f_id + "'");
            int i = st.executeUpdate();
	    if (i==0){
		out.println("Row has been deleted");
	    }
	    else{
		out.println("No rows has been deleted");
	    }
            
            response.sendRedirect("MyFarm.jsp");
            con.close();

    }
        catch(Exception e){
            System.out.print(e);
        }
}
}
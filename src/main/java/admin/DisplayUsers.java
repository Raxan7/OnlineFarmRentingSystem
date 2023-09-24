package admin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;

public class DisplayUsers extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        List<UsersDisplayConstructor> display=new ArrayList<>();
        
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/FarmRentSystemDB","saidi","blender1");
        String data="SELECT * FROM user";
        PreparedStatement stmt=conn.prepareStatement(data);
        ResultSet rs=stmt.executeQuery();
        while(rs.next()){
        String firstname=rs.getString("first_name");
        String lastname=rs.getString("last_name");
        String email=rs.getString("email");
        String password=rs.getString("password");
        String user_type=rs.getString("user_type");
        System.out.println(firstname);
        UsersDisplayConstructor dataset=new UsersDisplayConstructor(firstname,lastname,email,password,user_type);
        display.add(dataset);
        
        }
    }catch(Exception e){
        out.println("failed to query data");
        
    }
      request.setAttribute("display", display);
      request.getRequestDispatcher("/admin_pages/RetriveData.jsp").forward(request,response); 
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

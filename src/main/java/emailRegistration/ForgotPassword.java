package emailRegistration;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import dao.UserDAO;
import db.DBException;
import model.StatusPojo;
import model.UserPojo;
import util.BCrypt;
import util.GlobalConstants;
import util.MailUtil;
import util.Utils;

/**
 * Servlet implementation class ForgotPassword
 */
@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(ForgotPassword.class.getName());
	
    public ForgotPassword() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inputEmail = request.getParameter("inputEmail");
		StatusPojo sp = new StatusPojo(); 
		try {
			UserPojo up = UserDAO.selectUSERbyEmail(inputEmail); 
			if(up!=null) {
				String hash = Utils.prepareRandomString(30);
				UserDAO.updateEmailVerificationHashForResetPassword(inputEmail, BCrypt.hashpw(hash,GlobalConstants.SALT));
				MailUtil.sendResetPasswordLink(up.getUSER_ID()+"", inputEmail, hash);
				sp.setCode(0);
				sp.setMessage("We have sent reset password link to your email");
			} else {
				sp.setCode(-1);
				sp.setMessage("This email doesn't exist");
			}
		} catch (DBException | MessagingException e) {
			LOGGER.debug(e.getMessage());
			sp.setCode(-1);
			sp.setMessage(e.getMessage());
		}
		PrintWriter pw = response.getWriter();
	    pw.write(Utils.toJson(sp));
	    pw.flush();
	    pw.close();
	}

}

package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		if (user != null && pass != null && user.trim().equals("abc") && pass.trim() .equals("xyz")) {
			HttpSession session = request.getSession();
			session.setAttribute("user",user);
			request.setAttribute("login_status","Login Success");
			request.getServletContext() . getRequestDispatcher("/menu.jsp").forward(request, response);
			return null;
			
		}else {
		 return null;
		}
	}
}

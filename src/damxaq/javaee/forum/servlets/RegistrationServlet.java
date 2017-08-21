package damxaq.javaee.forum.servlets;

import java.io.IOException;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import damxaq.javaee.forum.dao.UsersDAO;
import damxaq.javaee.forum.entitis.User;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/registration.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		if (login!=null && password != null && password2!=null && password.equals(password2) && !"".equals(password)){
			UsersDAO dao =(UsersDAO)request.getAttribute("usersDAO");
			try{
				dao.loadAfterLogin(login);
				request.setAttribute("error", "login exist!");
				doGet(request, response);
				return;
			} catch(NoResultException nre){
				User u = new User();
				u.setLogin(login);
				u.setPassword(password);
				if(dao.addUser(u)){
					response.sendRedirect(request.getContextPath() + "/index");
				}
				else 
					request.setAttribute("error", "registration failed!");
			}
		} else{
			request.setAttribute("error", "login data error!");
			doGet(request, response);
		}
	}

}

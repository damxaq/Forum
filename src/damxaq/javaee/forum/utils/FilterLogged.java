package damxaq.javaee.forum.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import damxaq.javaee.forum.dao.UsersDAO;
import damxaq.javaee.forum.entitis.User;

@WebFilter(urlPatterns = "/*")
public class FilterLogged implements Filter {
	
	private ServletContext context;
	
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		//HttpServletResponse res = (HttpServletResponse)response;
		req.setCharacterEncoding("UTF-8");
		String login = req.getRemoteUser();
		if (login!=null){
			User u = (User)req.getSession().getAttribute("user");
			if(u==null){
				UsersDAO dao = (UsersDAO)req.getAttribute("usersDAO");
				u = dao.loadAfterLogin(login);
				req.getSession().setAttribute("user", u);
			}
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("AuthenticationFilter initialized");
		this.context.getAttribute("user");
	}

}

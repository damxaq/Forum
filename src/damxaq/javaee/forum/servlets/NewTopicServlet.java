package damxaq.javaee.forum.servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import damxaq.javaee.forum.dao.TopicsDAO;
import damxaq.javaee.forum.entitis.Topic;
import damxaq.javaee.forum.entitis.User;

@WebServlet("/newTopic")
public class NewTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/newTopic.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String text = request.getParameter("text");
		if(!"".equals(title) && !"".equals(text)){
			Timestamp t = new Timestamp(new Date().getTime());
			User loged = (User)request.getSession().getAttribute("user");
			TopicsDAO dao = (TopicsDAO)request.getAttribute("topicsDAO");
			Topic topic = new Topic();
			topic.setDate(t);
			topic.setText(text);
			topic.setTitle(title);
			topic.setUser(loged);
			if (dao.addTopic(topic))
				response.sendRedirect(request.getContextPath() + "/topic?id="+ topic.getId());
		}
	}

}

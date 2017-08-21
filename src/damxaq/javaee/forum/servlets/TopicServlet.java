package damxaq.javaee.forum.servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import damxaq.javaee.forum.dao.CommentsDAO;
import damxaq.javaee.forum.dao.TopicsDAO;
import damxaq.javaee.forum.entitis.Comment;
import damxaq.javaee.forum.entitis.Topic;
import damxaq.javaee.forum.entitis.User;

@WebServlet("/topic")
public class TopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stringId = request.getParameter("id");
		if (stringId!=null){
			int id = Integer.parseInt(stringId);
			TopicsDAO dao = (TopicsDAO)request.getAttribute("topicsDAO");
			Topic t = dao.loadTopic(id);
			request.setAttribute("topic", t);
			request.getRequestDispatcher("WEB-INF/view/topic.jsp").forward(request, response);
			
		} else
			response.sendRedirect(request.getContextPath() + "/");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String text = request.getParameter("text");
		String stringId = request.getParameter("id");
		if (text!=null && stringId!=null){
			int id = Integer.parseInt(stringId);
			CommentsDAO commentsDAO = (CommentsDAO)request.getAttribute("commentsDAO");
			TopicsDAO topicsDAO = (TopicsDAO)request.getAttribute("topicsDAO");
			User loged = (User)request.getSession().getAttribute("user");
			Topic topic = topicsDAO.loadTopic(id);
			Comment comment = new Comment();
			comment.setDate(new Timestamp(new Date().getTime()));
			comment.setText(text);
			comment.setUser(loged);
			comment.setTopic(topic);
			commentsDAO.addComment(comment);
		}
		doGet(request, response);
	}

}

package damxaq.javaee.forum.utils;

import javax.persistence.EntityManager;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import damxaq.javaee.forum.dao.CommentsDAO;
import damxaq.javaee.forum.dao.TopicsDAO;
import damxaq.javaee.forum.dao.UsersDAO;

@WebListener
public class InitiatorDB implements ServletRequestListener {

  
    public void requestDestroyed(ServletRequestEvent arg0)  { 
    }

    public void requestInitialized(ServletRequestEvent arg0)  { 
         EntityManager em = DBConfig.createEntityManager();
         UsersDAO usersDAO  = new UsersDAO(em);
         TopicsDAO topicsDAO = new TopicsDAO(em);
         CommentsDAO commentsDAO = new CommentsDAO(em);
         ServletRequest req = arg0.getServletRequest();
         req.setAttribute("commentsDAO", commentsDAO);
         req.setAttribute("topicsDAO", topicsDAO);
         req.setAttribute("usersDAO", usersDAO);
    }
	
}

package damxaq.javaee.forum.utils;

import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener
{

	@Override
	public void contextDestroyed(ServletContextEvent arg0)
	{
		System.out.println("Application finish: " + new Date());
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0)
	{
		System.out.println("Application start: " + new Date());

	}

}

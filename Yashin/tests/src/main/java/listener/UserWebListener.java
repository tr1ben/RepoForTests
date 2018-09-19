package listener;

import repository.UserRepo;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class UserWebListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        UserRepo.createRepo();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}

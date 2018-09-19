package servlets;

import model.User;
import repository.UserRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        if (null == httpServletRequest.getSession().getAttribute("user")) {

            httpServletRequest.getRequestDispatcher("/WEB-INF/htm/login.html").forward(httpServletRequest, httpServletResponse);

        } else {

            httpServletResponse.sendRedirect("/");

        }


    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        if (null == httpServletRequest.getSession().getAttribute("user")) {

            String login = httpServletRequest.getParameter("login");
            String password = httpServletRequest.getParameter("pass");

            User user = new User(0, login, password);
            UserRepo.add(user);

            httpServletRequest.getSession().setAttribute("user", user);
            httpServletResponse.sendRedirect("/");

        } else {

            httpServletResponse.sendRedirect("/");

        }

    }

}

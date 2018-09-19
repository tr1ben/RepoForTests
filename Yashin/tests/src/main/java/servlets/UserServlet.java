package servlets;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import model.User;
import repository.UserRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "users", urlPatterns = {"/users"})
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        Gson gson = new Gson();
        httpServletResponse.getWriter().write(gson.toJson(UserRepo.getUsers()));
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String userJSON = httpServletRequest.getReader().readLine();
        Gson gson = new Gson();
        User user = gson.fromJson(userJSON, User.class);
        UserRepo.add(user);
        JsonObject jsonElement = new JsonObject();
        jsonElement.addProperty("SuccessCode", "OPERATION_SUCCESS");
        httpServletResponse.getWriter().write(jsonElement.toString());
        httpServletResponse.setStatus(201);
    }
}

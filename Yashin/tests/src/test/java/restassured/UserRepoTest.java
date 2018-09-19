package restassured;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.get;


public class UserRepoTest {

    @Test(description = "GET")
    public void getUsers() {
        Response response = get("http://localhost:8080/users");
        Gson gson = new Gson();
        ArrayList<User> users = (ArrayList<User>) gson.fromJson(response.asString(), ArrayList.class);
        Assert.assertFalse(users.isEmpty());
    }

    @Test(description = "POST")
    public void addUser() {

        User user = new User(0, "Test", "1111");
        Gson gson = new Gson();

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(gson.toJson(user));
        Response response = request.post("http://localhost:8080/users");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201);
        String successCode = response.jsonPath().get("SuccessCode");
        Assert.assertEquals(successCode, "OPERATION_SUCCESS");
        System.out.println(response.getBody().asString());
    }

}

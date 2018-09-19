package restassured;

import static io.restassured.RestAssured.get;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

public class RestAssuredTest {

    @Test(description = "GET")
    public void getRequestTest(){
        Response response = get("http://jsonplaceholder.typicode.com/users");
        JSONArray jsonResponse = new JSONArray(response.asString());
        for (int i = 0; i < jsonResponse.length(); ++i) {
            JSONObject rec = jsonResponse.getJSONObject(i);
            int id = rec.getInt("id");
            String username = rec.getString("username");
            System.out.println("ID: " + id + "\tUsername: " + username);
        }
    }

    @Test(description = "POST")
    public void postRequestExampleTest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "param");
        requestBody.put("body", "pam");
        requestBody.put("userId", "13");

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(requestBody.toString());
        Response response = request.post("https://jsonplaceholder.typicode.com/posts");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201);
        System.out.println("\nОбъект: ");
        System.out.println(response.getBody().asString());
    }
}

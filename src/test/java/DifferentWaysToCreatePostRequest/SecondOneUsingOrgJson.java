package DifferentWaysToCreatePostRequest;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.equalTo;

public class SecondOneUsingOrgJson {

    @Test
    public void createUserByUsingOrgJson() {

        JSONObject data = new JSONObject();
        data.put("title", "API Testing");
        data.put("body", "Learning Rest Assured");


                given()
                .contentType("application/json")
                .body(data.toString())     //Important Note as we are storing the data as object
                                           //so we need to convert it into the String we need to user .toString() method

                .when()
                .post("https://jsonplaceholder.typicode.com/posts")

                .then()
                .statusCode(201)
                .body("title", equalTo("API Testing"))
                .log().all();

    }
}

package DifferentWaysToCreatePostRequest;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FirstOneUsingHashMap {


    //post request body using HashMap
    @Test
    public void usingHashMap() {
        HashMap hm1 = new HashMap();
        hm1.put("title", "Postman Practice");
        hm1.put("body", "learning automation");

                 given()
                .contentType("application/json")
                .body(hm1)

                .when()
                .post("https://jsonplaceholder.typicode.com/posts")

                .then()
                .statusCode(201)
                .body("title", equalTo("Postman Practice"))
                .body("body", equalTo("learning automation"))
                .log().all();

    }
}

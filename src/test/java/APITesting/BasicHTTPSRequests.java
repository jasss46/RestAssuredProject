package APITesting;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class BasicHTTPSRequests {


    @Test(priority = 1)
    public void getUserDetail() {

                 given()

                .when()
                .get("https://dummyjson.com/users/1")

                .then()
                .statusCode(200)
                .log().all();


    }

    @Test(priority = 2)
    public void createUser() {

        HashMap data = new HashMap();
        data.put("title", "Jaswinder");
        data.put("price", "Singh");


        given()
                .contentType("application/json")
                .body(data)


                .when()
                .post("https://fakestoreapi.com/products")


                .then()
                .statusCode(201)
                .log().all();


    }
}

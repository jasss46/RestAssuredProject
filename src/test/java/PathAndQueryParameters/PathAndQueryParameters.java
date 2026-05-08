package PathAndQueryParameters;

//package DifferentWaysToCreatePostRequest;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PathAndQueryParameters {

    //https://jsonplaceholder.typicode.com/posts/1


    @Test
    public void pathAndQueryParametersChecking(){

      //
                given()
                        .pathParam("mypath","posts")  //Path parameters
                        .queryParam("number","1")   //query parameters

                .when()
                        .get("https://jsonplaceholder.typicode.com/{mypath}")
                .then()
                        .statusCode(200)
                        .log().all();

    }
}

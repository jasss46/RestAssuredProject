package Authentications;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class BasicAuthentication {

    @Test
    public void basicOne() {

        given()
                .auth().basic("user", "passwd")

                .when()
                .get("https://httpbin.org/basic-auth/user/passwd")

                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
                .log().all();


    }

    @Test(priority = 2)
    public void basicOne1() {

        given()
                .auth().digest("user", "passwd")

                .when()
                .get("https://httpbin.org/basic-auth/user/passwd")

                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
                .log().all();


    }

    @Test(priority = 3)
    public void basicOne2() {

        given()
                .auth().preemptive().basic("user", "passwd")

                .when()
                .get("https://httpbin.org/basic-auth/user/passwd")

                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
                .log().all();


    }

    @Test(priority = 4)
    public void bearerTokenAuth() {

        String bearerToken = "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";

        given()
                .header("Authorization", "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")

                .when()
                .get("https://github.com/")

                .then()
                .statusCode(200)
                .log().all();


    }
@Test(priority = 5)
    public void oauth1Authentication(){

        given()
                .auth().oauth("consumerKey","cosumerSecrat","accesstoken","tokenSecrat")// this is for 0Auth 1.0 authentication


                .when()
                .get("Url")
                .then()
                .statusCode(200);






    }

    @Test(priority = 6)

    public void oauth2(){

        given()
                .auth().oauth2("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")

                .when()
                .get("https://github.com/")

                .then()
                .statusCode(200)
                .log().all();




    }




}

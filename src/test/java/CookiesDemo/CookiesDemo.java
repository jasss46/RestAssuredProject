package CookiesDemo;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CookiesDemo {


    @Test
    public void captureCookies() {


        given()


                .when()
                .get("https://www.google.com/")


                .then()
                .statusCode(200)
                .cookie("AEC","AaJma5t6-Ndzxt7JisIOnBxjWDbmX2Jffbg4QBJzzOljp4sV4w_HU8Cu1Ms")
                .log().all();

    }

    public void captureCookiesInfo(){
        
    }
}

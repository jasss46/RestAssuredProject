package CookiesDemo;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class HeadersDemo {



    @Test(priority = 1)

    //for Single Headers
    public void headerCapturing(){


        when()
                .get("https://www.google.com/")

                .then()
                .header("Content-Type",equalTo("text/html; charset=ISO-8859-1"))
                .and()
                .header("Content-Encoding",equalTo("gzip"))
                .and()
                .header("Server","gws");



    }

    @Test (priority = 2)

    public void getHeadersInfo(){

        Response res= given()

                .when()
                .get("https://www.google.com/");


        //get single header info
     String headerValue=   res.getHeader("Content-Type");
        System.out.println(headerValue);

        //get all headers info

      Headers allHeaders=      res.getHeaders();

      for( Header hd:  allHeaders){
          System.out.println(hd.getName()+ ""+ hd.getValue());
      }


    }

    @Test(priority = 3)
    public void getInformationFromLog(){

        when().get("https://www.google.com/")

                .then()
                .statusCode(200)
                .log().headers();

    }



}

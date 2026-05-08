package DailyPractice;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.PriorityQueue;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class FirstOne {

    @Test(priority = 1)

    public void getUserDetail() {

        given()
                .when()
                .get("https://jsonplaceholder.typicode.com")
                .then()
                .statusCode(200)
                .log().all();

    }

    @Test(priority = 2)
    public void createUserDetail() {

        HashMap data = new HashMap();
        data.put("name", "Jaswinder Singh");
        data.put("email", "jasssingh46@gmail.com");

        given()
                .contentType("application/json")
                .body(data)

                .when()
                .post("https://jsonplaceholder.typicode.com/posts")

                .then()
                .statusCode(201)
                .log().all();

    }

    @Test(priority = 3)

    public void createUserDetail2() {

        JSONObject data1 = new JSONObject();
        data1.put("name", "Jass");
        data1.put("email", "jas123@gmail.com");


        given()
                .contentType("application/json")
                .body(data1.toString())

                .when()
                .post("https://jsonplaceholder.typicode.com/posts")

                .then()
                .statusCode(201)
                .log().all();


    }

    @Test(priority = 4)
    //https://jsonplaceholder.typicode.com/posts
    public void createUserDetail4() throws FileNotFoundException {

        File f= new File(".\\data6.json");
        FileReader fr= new FileReader(f);
        JSONTokener jt= new JSONTokener(fr);
        JSONObject jo= new JSONObject(jt);


        given()
                .contentType("application/json")

                .when()
                .post("https://jsonplaceholder.typicode.com/posts")

                .then()
                .statusCode(201)
                .log().all();


    }

    @Test(priority = 5)
    public void pathParam(){

            //https://jsonplaceholder.typicode.com/posts/1

        given()
                .contentType("application/json")
                .pathParams("name","posts")
                .queryParam("number",'1')


                .when()
                .get("https://jsonplaceholder.typicode.com/{name}")


                .then()
                .statusCode(200)
                .log().all();


    }

    @Test(priority=6)
    public void authentication1(){

        given()
                .contentType("application/json")
                .auth().basic("postman","password")

                .when()
                .get("https://postman-echo.com")

                .then()
                .statusCode(200)
                .header("Content-Encoding","gzip");
    }

@Test(priority = 7)

    public void bearerTokenOne(){

        given()
                .header("Authorization","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")

                .when()
                .get("https://github.com/")


                .then()
                .statusCode(200)
                .log().headers();

}



}


package DailyPractice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class AnotherRestOne {

    private static final Logger log = LoggerFactory.getLogger(AnotherRestOne.class);

    @Test(priority = 1)
    public void getUserDetail() {

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RequestSpecification httpRequest = given();
        Response response = httpRequest.request(Method.GET, "/posts/1");
        String responseBody = response.getBody().asPrettyString();
        System.out.println(responseBody);
        int statusCode = response.getStatusCode();
        System.out.println("The Status code which we will get is " + statusCode);
    }


    @Test(priority = 2)
    public void getUserDetail2() {

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        RequestSpecification httpRequest = given();

        Response response = httpRequest.request(Method.GET, "/users/1");

        String responseBody = response.getBody().asPrettyString();
        System.out.println(responseBody);


    }

    @Test(priority = 3)
    public void getUserDetail3() {

        given()
                .when()
                .get("https://jsonplaceholder.typicode.com")
                .then()
                .statusCode(200)
                .log().all();
    }


    @Test(priority = 4)
    public void getUserDetail4() {

        RestAssured.baseURI = "https://fakestoreapi.com";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/products/1");

        String responseBody = response.getBody().asPrettyString();
        int statusCode = response.getStatusCode();

        System.out.println(responseBody);
        System.out.println(statusCode);


        JsonPath js = response.jsonPath();
        String titleHeader = js.getString("title");

        Assert.assertEquals(titleHeader, "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops");


    }

    @Test(priority = 5)

    public void createPostRequest(){

        RestAssured.baseURI= "https://fakestoreapi.com";

        RequestSpecification httpRequest= RestAssured.given();

        JSONObject jo= new JSONObject();
        jo.put("title","testProduct");
         httpRequest.header("Content-Type","application/json");
        httpRequest.body(jo.toString());
        Response response= httpRequest.request(Method.POST,"/products");
        String responseBody= response.getBody().asPrettyString();

        System.out.println(responseBody);

    }


    @Test(priority = 6)
    public void getRequest() {

        RestAssured.baseURI = "https://www.google.com/";

        RequestSpecification httprequest = RestAssured.given();


        Response response = httprequest.request(Method.GET);

        String responseBody = response.getBody().asPrettyString();
        System.out.println(responseBody);

        Headers getallheaders = response.headers(); //capture all headers from response

        for (Header header : getallheaders) {
            System.out.println(header.getName());// to extract key
            System.out.println(header.getValue());// to extract value

        }

    }
        @Test(priority = 7)

    //verify each node
        public void verifyResponseBody(){

        RestAssured.baseURI= "https://fakestoreapi.com";

        RequestSpecification httpReq= RestAssured.given();


        Response response= httpReq.request(Method.GET,"/products/1");

        String responseBody= response.getBody().asPrettyString();
            System.out.println(responseBody);

            JsonPath jsonPath= response.jsonPath();


            System.out.println("The Title mentioned is: "+jsonPath.getString("title"));
            System.out.println("The Price mentioned is: "+jsonPath.getString("price"));
            System.out.println("The Description mentioned is: "+jsonPath.getString("description"));
            System.out.println("The Category mentioned is: "+jsonPath.getString("category"));


            Assert.assertEquals(jsonPath.getString("title"),"Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops");
            Assert.assertEquals(jsonPath.getString("price"),"109.95");
            Assert.assertEquals(jsonPath.getString("description"),"Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday");



        }
        @Test(priority = 8)
        public void authenticationAPI(){

        }
        }






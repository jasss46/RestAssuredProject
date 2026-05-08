package DailyPractice;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestOne {

    @Test(priority = 1)
    public void getRequestUsingRestAssured(){

        RestAssured.baseURI= "https://jsonplaceholder.typicode.com/posts";

        RequestSpecification httpsRequest= RestAssured.given();

        Response response= httpsRequest.request(Method.GET);

        String ResponseBody= response.getBody().asPrettyString();


        System.out.println(ResponseBody);

        int StatusCode= response.getStatusCode();
        System.out.println(StatusCode);
        Assert.assertEquals(StatusCode,200);



    }

    @Test (priority = 2)
    public void postUserDetails(){

        RestAssured.baseURI= "https://jsonplaceholder.typicode.com/posts";

        RequestSpecification httpRequest= RestAssured.given();

        JSONObject jo= new JSONObject();
        jo.put("name","jaswinder");
        jo.put("title","Testing");
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(jo.toString());

        Response response= httpRequest.request(Method.POST);

        String responseBody= response.asPrettyString();

        System.out.println(responseBody);

        int StatusCode= response.getStatusCode();

        System.out.println(StatusCode);
        Assert.assertEquals(StatusCode,201);






    }
}

package RestAssuredLearning;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class Demo_Post_Request {

@Test
    public void registrationSuccessfull(){


    //Specify Base URI
        RestAssured.baseURI= "https://jsonplaceholder.typicode.com/posts";


        //Request object
        RequestSpecification httpsRequest= RestAssured.given();


        //Request payload we are sending with post data
    JSONObject requestParams= new JSONObject();
    requestParams.put("name","Jaswinder");
    requestParams.put("email", "jaswindersinghgmail.com");

    httpsRequest.header("Content-Type","application/json");
    httpsRequest.body(requestParams.toString());

//ResponseObject
        Response response= httpsRequest.request(Method.POST);
//        Validations
        String ResponseBody= response.getBody().asPrettyString();
        System.out.println(ResponseBody);
    }
}

package RestAssuredLearning;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.http.HttpRequest;

public class Demo_Get_Request {

    @Test
    public void getWheatherDetails(){


        //Specify the BaseURI

        RestAssured.baseURI="https://jsonplaceholder.typicode.com/posts";


        //Request Object
        RequestSpecification httpRequest= RestAssured.given();

        Response response= httpRequest.request(Method.GET);
       int StatusCode= response.getStatusCode();

        String responseBody= response.getBody().asPrettyString();

        Assert.assertEquals(StatusCode,200);

        System.out.println(responseBody);
        System.out.println(StatusCode);

      String statusLine=   response.getStatusLine();
        System.out.println(statusLine);
        Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
    }

}

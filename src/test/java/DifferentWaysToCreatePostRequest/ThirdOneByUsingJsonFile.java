package DifferentWaysToCreatePostRequest;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class ThirdOneByUsingJsonFile {

    //By using External JSON File

    @Test
    public void fromExternalFile() throws FileNotFoundException {
        File f = new File(".\\body.json");    // To specify File Path

        FileReader fr = new FileReader(f);             // To read the file

        JSONTokener jt = new JSONTokener(fr);          // For JSON Part
        JSONObject data = new JSONObject(fr);          // To convert it into the JSON Object

        given()
                .contentType("application/json").accept("application/json")
                .body(data.toString())

                .when()
                .post("https://jsonplaceholder.typicode.com/posts")

                .then()
                .statusCode(201)
//                .body("title",equalTo("API Testing"))
                .log().all();

    }
}

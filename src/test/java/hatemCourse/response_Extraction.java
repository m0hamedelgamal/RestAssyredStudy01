package hatemCourse;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasItem;

public class response_Extraction {
    @Test
    public void assertionWith_hasEntry() {
        baseURI = "https://64ea0695bf99bdcc8e67378a.mockapi.io/api/v1";
        /* Extract a value using the response.path
         * here the response will return a string not a response / jsonn object
         * */
        String res_name = given().baseUri(baseURI).
                when().get("/userinfo").
                then().extract().response().path("[1].name");
        System.out.println(res_name);

        //Extract a value using the path

        Response res_response = given().baseUri(baseURI).
                when().get("/userinfo");
        System.out.println(res_response.then().extract().response().path("[0].fname"));

        /*Extract a value using the jsonpath
         *
         * */
        JsonPath js_path=new JsonPath(res_response.asString());
        System.out.println(js_path.getString("[1].createdAt"));

    }
}

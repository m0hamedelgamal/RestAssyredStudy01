package examples;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PutAndPatch {
    @Test(enabled = false )
    public void put() {
        JSONObject request_jsn = new JSONObject();
        request_jsn.put("name", "name1");
        request_jsn.put("job", "thief");

        baseURI = "https://reqres.in/api";
        given().
                contentType(ContentType.JSON).
                body(request_jsn.toJSONString()).
                when().put("/users/1").
                then().statusCode(200);
    }

    @Test
    public void patch() {
        JSONObject request_jsn = new JSONObject();
        request_jsn.put("name", "update name ");
        request_jsn.put("job", "Update thief");

        baseURI = "https://reqres.in/api";
        given().contentType(ContentType.JSON).
                body(request_jsn.toJSONString()).
                when().patch("/users/2").
                then().statusCode(200).log().body().toString();
    }

}

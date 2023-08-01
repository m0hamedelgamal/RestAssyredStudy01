package examples;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class PutAndPatch {

    @Test
    public void post() {

        //define the base URI and the parameter
        baseURI = "https://reqres.in/api";
        String requestBody = "{\n" +
                "    \"name\": \"Gemi\",\n" +
                "    \"job\": \"X000job\"" +
                "\n" + "}";
        //Send the post request
        Response myresponse = given().
                contentType(ContentType.JSON)
                .body(requestBody).post("/users");
        //Validate the response is passed
        assertEquals(201, myresponse.getStatusCode());

        //Log the body and the response code
        myresponse.then().log().body();
        System.out.println(myresponse.getStatusCode());
    }

    @Test(enabled = false)
    public void put() {
        JSONObject request_jsn = new JSONObject();
        request_jsn.put("first_name", "name1");
        request_jsn.put("job", "thief");
        baseURI = "https://reqres.in/api";
        given().
                contentType(ContentType.JSON).
                body(request_jsn.toJSONString()).
                when().put("/users/100").
                then().statusCode(200).log().all();
    }

    @Test(enabled = false)
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

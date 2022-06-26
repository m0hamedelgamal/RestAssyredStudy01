package examples;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;



public class GetandPost

{
    public void getdata()
    {
        baseURI="https://reqres.in/api";
        given().get("users?page=2").
                then().log().body().statusCode(200) ;

    }

   }

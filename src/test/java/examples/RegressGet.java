package examples;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RegressGet {
    @Test(enabled = true)
    public void Getdata() {

        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println("ResponseCode is " + response.getStatusCode());
        System.out.println(" The Time is " + response.getTime());

//        JsonPath jpth= new JsonPath  (response.asString());
//        System.out.println(jpth.getString("data[0]"));

        System.out.println(response.jsonPath().getString("data[0]"));
        System.out.println("HERE WE GO . . . . . . . . . . . . . . .");
    }

    @Test(enabled = false)
    public void getdata2() {
        baseURI = "https://reqres.in/api";
        given().get("users/24").
                then().log().body();
    }


}

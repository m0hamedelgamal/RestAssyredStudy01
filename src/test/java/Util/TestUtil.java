package Util;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TestUtil
{

public  void setBaseURI()
{
    RestAssured.baseURI="";
}
public void setBasePath()
{

}
public Response getResponse ()
{
    return given().get();
}

}

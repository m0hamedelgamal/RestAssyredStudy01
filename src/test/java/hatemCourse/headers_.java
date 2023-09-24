package hatemCourse;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class headers_ {
    @Test
    public void checkTheRequestHeaders() {
        baseURI = "https://64ea0695bf99bdcc8e67378a.mockapi.io/api/v1";
//Defien the header as a singile header
        Header testheader1 = new Header("key0", "value0");
        Header testheader2 = new Header("key1", "value1");
        Headers test_headers = new Headers(testheader1, testheader2);

        given()
                .baseUri(baseURI)
                .header(testheader1)
                .header(testheader2)
                .headers(test_headers).
                when()
                .get("/userinfo")
                .then()
                .log().headers();

    }
    @Test
    public void headersAsHsshMap() {
        //can define headers as a hashmap while the hashmap take the key and value then :
        HashMap<String, String> headers_map = new HashMap();
        headers_map.put("key0", "value0");
        headers_map.put("key1", "value1");
        given()
                .baseUri(baseURI)
                .headers(headers_map).
                when()
                .get("/userinfo")
                .then()
                .log().headers();

    }
}

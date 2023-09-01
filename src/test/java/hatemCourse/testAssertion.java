package hatemCourse;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class testAssertion {
    @Test
    public void assertionWith_ThestatusCode() {

        baseURI = "https://64ea0695bf99bdcc8e67378a.mockapi.io/api/v1";
        given().
                baseUri(baseURI).
                when().get("/userinfo/2")
                .then().log().body()
                .assertThat().statusCode(200);
    }

    @Test
    public void assertionWith_EqualTo() {

        baseURI = "https://64ea0695bf99bdcc8e67378a.mockapi.io/api/v1";
        Response requestResponse =
                given().baseUri(baseURI).
                        when().get("/userinfo/2");
        requestResponse.then().assertThat().body("name", equalTo("Mrs. Sammy Ziemann"));
    }

    @Test
    public void assertionWith_HasItem() {

        baseURI = "https://64ea0695bf99bdcc8e67378a.mockapi.io/api/v1";
        Response requestResponse = given().baseUri(baseURI).
                when().get("/userinfo");
        requestResponse.prettyPrint();
        requestResponse.then().assertThat().
                body("fname", hasItem("fname 2"));
    }

    @Test
    public void assertionWith_hasItems() {
        baseURI = "https://64ea0695bf99bdcc8e67378a.mockapi.io/api/v1";
        Response requestResponse = given().baseUri(baseURI).
                when().get("/userinfo");
        requestResponse.then().assertThat().
                body("id", hasItems("1"));
    }

    @Test
    public void assertionWith_Not() {
        baseURI = "https://64ea0695bf99bdcc8e67378a.mockapi.io/api/v1";
        Response requestResponse = given().baseUri(baseURI).
                when().get("/userinfo");
        requestResponse.then().assertThat().
                body("fname", not(hasItems("fname a2", "fname 11")));
    }

    @Test
    public void assertionWith_Contains() {
        baseURI = "https://64ea0695bf99bdcc8e67378a.mockapi.io/api/v1";
        Response requestResponse = given().baseUri(baseURI).
                when().get("/userinfo");
        requestResponse.then().assertThat().
                body("fname", contains("fname 1", "fname 2", "fname 3", "fname 4"));
    }

    @Test
    public void assertionWith_containsInAnyOrder() {
        baseURI = "https://64ea0695bf99bdcc8e67378a.mockapi.io/api/v1";
        Response requestResponse = given().baseUri(baseURI).
                when().get("/userinfo");
        requestResponse.then().assertThat().
                body("fname", containsInAnyOrder("fname 3", "fname 4", "fname 1", "fname 2"));
    }

    @Test
    public void assertionWith_Empty() {
        baseURI = "https://64ea0695bf99bdcc8e67378a.mockapi.io/api/v1";
        Response requestResponse = given().baseUri(baseURI).
                when().get("/userinfo");
        requestResponse.then().assertThat().
                body("id", is(empty()));
    }

    @Test
    public void assertionWith_notEmpty() {
        baseURI = "https://64ea0695bf99bdcc8e67378a.mockapi.io/api/v1";
        Response requestResponse = given().baseUri(baseURI).
                when().get("/userinfo");
        requestResponse.then().assertThat().body("id", is(not(empty())));
    }

    @Test
    public void assertionWith_hasSize() {
        baseURI = "https://64ea0695bf99bdcc8e67378a.mockapi.io/api/v1";
        Response requestResponse = given().baseUri(baseURI).
                when().get("/userinfo");
        requestResponse.then().assertThat().body("id", hasSize(4));
//Same can be use instead the equal to
        requestResponse.then().assertThat().body("id.size()", equalTo(4));
    }

    @Test
    public void assertionWith_everyItem() {
        baseURI = "https://64ea0695bf99bdcc8e67378a.mockapi.io/api/v1";
        Response requestResponse = given().baseUri(baseURI).
                when().get("/userinfo");
        requestResponse.then().assertThat().
                body("createdAt", everyItem(startsWith("2023")));
    }

    @Test
    public void assertionWith_hasKey() {
        baseURI = "https://64ea0695bf99bdcc8e67378a.mockapi.io/api/v1";
        Response requestResponse =
                given().baseUri(baseURI).
                        when().get("/userinfo");
        requestResponse.then().assertThat().
                body("[0]", hasKey("createdAt"));
    }

    @Test
    public void assertionWith_hasValue() {
        baseURI = "https://64ea0695bf99bdcc8e67378a.mockapi.io/api/v1";
        Response requestResponse = given().baseUri(baseURI).
                when().get("/userinfo");
        requestResponse.then().assertThat().
                body("[0]", hasValue("Indonesia"));
    }

    @Test
    public void assertionWith_hasEntry() {
        baseURI = "https://64ea0695bf99bdcc8e67378a.mockapi.io/api/v1";
        Response requestResponse = given().baseUri(baseURI).
                when().get("/userinfo");
        requestResponse.then().assertThat().
                body("[0]", hasEntry("id", "1"));
    }
}
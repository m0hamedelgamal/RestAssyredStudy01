package hatemCourse;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class testAssertion {
    @Test
    public void validateThestatusCode() {

        baseURI = "https://64ea0695bf99bdcc8e67378a.mockapi.io/api/v1";
        given().
                baseUri(baseURI).
                when().get("/userinfo/2")
                .then().log().body()
                .assertThat().statusCode(200);
    }

    @Test
    public void validatetheEqualTo() {

        baseURI = "https://64ea0695bf99bdcc8e67378a.mockapi.io/api/v1";
        Response requestResponse =
                given().baseUri(baseURI).
                        when().get("/userinfo/2");
        requestResponse.then().assertThat().body("name", equalTo("Mrs. Sammy Ziemann"));
    }

    @Test
    public void validatetheHasItem() {

        baseURI = "https://64ea0695bf99bdcc8e67378a.mockapi.io/api/v1";
        Response requestResponse = given().baseUri(baseURI).
                when().get("/userinfo");
        requestResponse.prettyPrint();
        requestResponse.then().assertThat().
                body("fname", hasItem("fname 2"));
    }

    @Test
    public void validatetheResponseHasItems() {

        baseURI = "https://64ea0695bf99bdcc8e67378a.mockapi.io/api/v1";
        Response requestResponse = given().baseUri(baseURI).
                when().get("/userinfo");
        requestResponse.then().assertThat().
                body("fname", hasItems("fname 2", "fname 1"));

    }
}
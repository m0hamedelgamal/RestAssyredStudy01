package examples;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

@Test
public class getMethodTest {
    public void getrequest() {
        baseURI = "https://reqres.in/api";
        Response response =
                given().when().get("/users/");

//Define the json path
        JsonPath jsonPath = response.jsonPath();
        System.out.println(jsonPath.get("data.'email'"));
    }

    @Test
    public void testHasSizeMatcher() {
        given()
                .when().get("https://reqres.in/api/users/")
                .then()
                .assertThat()
                .body("data", hasSize(6));
    }
    @Test
    public void testhasItem() {
        given()
                .when()
                .get("https://reqres.in/api/users/")
                .then()
                .assertThat()
                .body("data[1].'email'", equalTo("janet.weaver@reqres.in"));
    }

    @Test
    public void validateThePrinterFormat() {
        // Assert the
        Response response = given().when().get("https://reqres.in/api/users/");
        String responseformat = response.getContentType();
        String formatWithNoChar = responseformat.substring(0, responseformat.indexOf(";"));
        assertThat(formatWithNoChar
                , Matchers.equalTo("application/json"));
    }


}
package examples;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class UseParameters {
    @DataProvider()
    public Object[][] usersIDs() {
        return new Object[][]
                {
                        {1, "george.bluth@reqres.in"},
                        {2, "janet.weaver@reqres.in"},
                        {3, "emma.wong@reqres.in"}
                };
    }

    @Test(dataProvider = "usersIDs")
    public void testUsers(int id, String email) {
        given()
                .pathParams("id", id)
                .get("https://reqres.in/api/users/{id}")
                .then().assertThat().body("data.'email'", equalTo(email))
                .log().body();
    }
}

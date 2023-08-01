package examples;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class restAssuredOptimization {

    //Define request specification
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;

    @BeforeClass
    public void defineRequestSpec() {
        //Defien the requestSpecificationBuilder
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/api").build();
        //Define the Response Specification Builder
        responseSpec = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(200)
                .build();
    }
    @Test
    public void useRequestSpec() {
        given().spec(requestSpec)
                .when().get("/users/2")
                .then().spec(responseSpec)
                .log().body()
                .assertThat().body("data.'id'",equalTo(2));
    }

}

package ch_akashCourse;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;

public class BookingClass {

    RequestSpecification myreqeust =RestAssured.given()
                    .baseUri("https://restful-booker.herokuapp.com")
                    .contentType(ContentType.JSON);
    String responseToken;
    @Test (priority = 1)
    public void extract_Login_Token() {

        HashMap<String, Object> body = new HashMap();
        body.put("username", "admin");
        body.put("password", "password123");

        Response myresponse = myreqeust.body(body)
                .basePath("/auth")
                .when().post();

        responseToken = myresponse.path("token").toString();
        System.out.println(responseToken);
    }

    @Test (priority = 2)
    public void print_booking_ids() {
        Response myresponse = myreqeust.basePath("/booking")
                .auth().oauth2(responseToken)
                .get();
        //Extract the response data
        int bookingID = myresponse.path("bookingid[0]");

        System.out.println(bookingID);
        //myreqeust.basePath("/booking/"+bookingID).get().prettyPrint();
        // Extract the same values using the a list
//        List<String> ids = myresponse.path("bookingid");
//        System.out.println("the list of the ids "+ids.toString());
//
    }

    @Test(priority = 3)
    public void CreateBooking() {
        //Define the booking dates
        HashMap<String, Object> bookingDates = new HashMap();
        bookingDates.put("checkin", "2023-01-01");
        bookingDates.put("checkout", "2023-02-01");
        //Define booking Details
        HashMap<String, Object> bookingDetails = new HashMap();
        bookingDetails.put("firstname", "XXX");
        bookingDetails.put("lastname", "MAN");
        bookingDetails.put("totalprice", 1200);
        bookingDetails.put("depositpaid", true);
        bookingDetails.put("additionalneeds", "launch");
        bookingDetails.put("bookingdates", bookingDates);

        myreqeust.body(bookingDetails).post().then().log().body();
    }
}

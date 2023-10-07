package ch_akashCourse;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import pojo.BookingDates;
import pojo.BookingDetails;

import java.util.HashMap;

public class BookingUsingLombok {
    RequestSpecification myreqeust = RestAssured.given()
            .baseUri("https://restful-booker.herokuapp.com")
            .contentType(ContentType.JSON);
    String token;
    @Test(priority = 1)
    public void login()
    {
        HashMap<String, Object> body = new HashMap();
        body.put("username", "admin");
        body.put("password", "password123");

        Response myresponse = myreqeust.body(body)
                .basePath("/auth")
                .when().post();
        token = myresponse.path("token").toString();}

    @Test(priority = 2)
    public void AddnewBooking() {
        BookingDetails bookingRequestDetails = new BookingDetails();
        BookingDates bookingRequesDates = new BookingDates();

        bookingRequesDates.setCheckin("2024-01-01");
        bookingRequesDates.setCheckout("2024-01-10");

        bookingRequestDetails.setFirstname("OneMan");
        bookingRequestDetails.setLastname("LOMBOK");
        bookingRequestDetails.setTotalprice(1100);
        bookingRequestDetails.setAdditionalneeds("No need");
        bookingRequestDetails.setDepositpaid(false);
        bookingRequestDetails.setBookingdates(bookingRequesDates);

        myreqeust.auth().oauth2(token)
                .basePath("/booking")
                .body(bookingRequestDetails).post().then().log().body();
//
//                when().post()
//                .then().log().body();


    }

}

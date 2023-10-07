package pojo;


import lombok.Data;

import java.util.HashMap;

@Data
public class BookingDetails
{

    private  String firstname , lastname , additionalneeds  ;
    private BookingDates bookingdates ;
    private  int totalprice ;
    private  boolean depositpaid ;
}

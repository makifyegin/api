package com.cybertek.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class SpartanGetRequest {

    String baseUrl = "http://3.93.10.240:8000";

    /*   Given Accept type application/jsn
       When user send GET request to api/spartans end point
       Then status code must 2000
       Then response Content Type must be application/json
       And response body should include spartan result*/
    @Test
    public void test1() {

        Response response = RestAssured.given().accept(ContentType.JSON)
                .when()
                .get(baseUrl + "api/spartans");


    }

}

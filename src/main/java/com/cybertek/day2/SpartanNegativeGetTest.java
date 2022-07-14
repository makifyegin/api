package com.cybertek.day2;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SpartanNegativeGetTest {
    @BeforeAll
    public static void init() {
//save baseurl inside this variable so that we don't need to type each http url.
        RestAssured.baseURI = "http://3.93.10.240:8000";

    }



    /*
     * TASK
     * Given Accept type application/xml
     * When user send GET request to /api/spartans/10 end point
     * Then status code must be 406
     * And response Content Type must be application/xml*/

    @DisplayName("Get request to /api/spartans/10")
    @Test
    public void test1() {

        Response response = RestAssured.given().accept(ContentType.XML)
                .when()
                .get("/api/spartans/10");

        //verify status code is 406
        Assertions.assertEquals(406,response.statusCode());

        //verify content type
        Assertions.assertEquals("application/xml;charset=UTF-8",response.contentType());




    }
}

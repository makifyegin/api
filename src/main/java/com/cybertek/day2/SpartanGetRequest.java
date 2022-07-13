package com.cybertek.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
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
                .get(baseUrl + "/api/spartans");

//printing status code from response object
        System.out.println("response.statusCode() = " + response.statusCode());

        //printing response content type from response object
        System.out.println("response.contentType() = " + response.contentType());

        //print whole result body
        response.prettyPrint();

        //how to do API testing then?

        Assertions.assertEquals(response.statusCode(), 200);

        //verify content type is application/json
        Assertions.assertEquals(response.contentType(), "application/json");


    }

        /*   Given Accept type application/jsn
       When user sends a get  request to api/spartans/3 end point
       Then status code should be  200
       And Content Type should be application/json
       and json body should contain Fidole
       */

    @DisplayName("GET one spartan /api/spartans/3 and verify")
    @Test
    public void test2() {

        Response response = RestAssured.given().accept(ContentType.JSON).
                when().get(baseUrl + "/api/spartans/3");
        //Verify status code 200
        Assertions.assertEquals(200, response.statusCode());

        Assertions.assertEquals(response.contentType(), "application/json");

        //Verify that json body contains Fidole

        Assertions.assertTrue(response.body().asString().contains("Fidole"));


    }


    /*
    Given no headers provided
    When users sends GET request to /api/hello
    Then response status code should be 200
    And Content type header should be "text/plain;charset=UTF-8"
    And header should contain date
    And Content-Length should be 17
    And body should be "Hello from Sparta"

    * */


    @DisplayName("GET request to /api/hello")
    @Test
    public void test3() {
        Response response = RestAssured.when().get(baseUrl + "/api/hello");

        Assertions.assertEquals(200, response.statusCode());

        Assertions.assertEquals("text/plain;charset=UTF-8", response.contentType());

        Assertions.assertTrue(response.headers().hasHeaderWithName("Date"));
        //how to get and header from response using header key


        System.out.println("response.header(\"Content-Length\") = " + response.header("Content-Length"));

        System.out.println(response.header("Date"));

        //verify content lebgth is 17
        Assertions.assertEquals("17", response.header("Content-Length"));


        Assertions.assertEquals("Hello from Sparta", response.body().asString());


    }
}

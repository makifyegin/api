package com.cybertek.day2;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HrGetRequests {

    //Before All is an annotation equals to @BeforeClass in testNg, we use with static method name.
    @BeforeAll
    public static void init() {
//save baseurl inside this variable so that we don't need to type each http url.
        RestAssured.baseURI = "http://3.93.10.240:1000/ords/hr";

    }

    @DisplayName("GET request to /regions")
    @Test
    public void test1() {

        Response response = RestAssured.get("/regions");

        //print the status code
        System.out.println(response.statusCode());

    }
    /*
     * Given accept type is application/json
     * When user sends get request to /regions/2
     * Then response status code must be 200
     * and content type equals to application/json
     * and response body contains Americas
     * */


    @DisplayName("GET request to /regions/2")
    @Test
    public void test2() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when()

                .get("/regions/2");

        //I checked the status code
        Assertions.assertEquals(200, response.statusCode());
//I checked the contentType

        response.prettyPrint();
        Assertions.assertEquals("application/json", response.contentType());

        Assertions.assertTrue(response.body().asString().contains("Americas"));


    }


}

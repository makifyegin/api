package com.cybertek.Day3;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import static io.restassured.RestAssured.given;

public class SpartanTestsParameters {

    @BeforeAll
    public static void init() {
//save baseurl inside this variable so that we don't need to type each http url.
        RestAssured.baseURI = "http://44.203.152.162:8000";

    }

    /*
    * Given accept type is Json
    * And Id parameter value is 5
    * When user sends GET request to /api/spartans/{id}
    * Then response status code should be 200
    * And response content-type: application/json
    * And "Blythe" should be in response payload*/

    @DisplayName("GET  request to /api/spartans/{id} with  ID=5")
    @Test
    public void test1(String id) {
//        Response response = RestAssured.given().
//                when().accept(ContentType.JSON).
//                get("/api/spartan/:" + "5");
//
//

        Response response = given().accept(ContentType.JSON)
                .and().pathParam("id", 5)
                .when()
                .get("/api/spartans/{id}");

        Assertions.assertEquals(200,response.contentType());

        Assertions.assertEquals("application/json", response.contentType());



    }


}

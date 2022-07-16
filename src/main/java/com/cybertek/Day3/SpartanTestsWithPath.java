package com.cybertek.Day3;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpartanTestsWithPath {

    @BeforeAll
    public static void init() {
//save baseurl inside this variable so that we don't need to type each http url.
        RestAssured.baseURI = "http://44.203.152.162:8000";

    }

    /*
     Given accept type is json
     And path param id is 10
     When user sends a get request to "api/spartans/{id}"
     Then status code is 200
     And content-type is "application/json"
     And response payload values match the following:
          id is 10,
          name is "Lorenza",
          gender is "Female",
          phone is 3312820936
   */

    @DisplayName("GET one spartan with Path Method")
    @Test
    public void test1() {

        Response response = given().accept(ContentType.JSON)
                .and().pathParam("id", 10)
                .and().when().get("/api/spartans/{id}");

        assertEquals(200, response.statusCode());
        assertEquals("application/json", response.contentType());


        System.out.println(response.path("name").toString());

        System.out.println(response.path("name").toString());
        System.out.println(response.path("gender").toString());
        System.out.println(response.path("phone").toString());
        int id = response.path("id");
        String name = response.path("name");
        String gender = response.path("gender");
        long phone = response.path("phone");


        //assert the value
        assertEquals(10, id);
        assertEquals("Lorenza", name);
        assertEquals("Female", gender);
        assertEquals(31267235, phone);


    }

    @DisplayName("GET all spartan and navigate with Path()")
    @Test

    public void test2() {
        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans");
        response.prettyPrint();

        int firstId = response.path("id[0]");
        System.out.println("firstId = " + firstId);

        String name = response.path("name[0]");
        System.out.println("name = " + name);

        String lastFirstName = response.path("name[-1]");
        System.out.println("lastFirstName = " + lastFirstName);

        List<String> names = response.path("name");
        System.out.println(names);


        for (String s : names) {
            System.out.println(s);
        }


    }
}

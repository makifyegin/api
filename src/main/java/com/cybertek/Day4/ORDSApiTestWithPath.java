package com.cybertek.Day4;

import com.cybertek.utilities.HRTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ORDSApiTestWithPath extends HRTestBase {

    @DisplayName("GET request to countries with Path method")
    @Test
    public void test1() {
        Response response = given().accept(ContentType.JSON)
                .and().queryParams("q", "{\"region_id\":2}")
                .when()
                .get("/countries");
//print limit result
        System.out.println("response.path(\"limit\") = " + response.path("limit"));
//print hasMore
        System.out.println("response.path(\"hasmore\") = " + response.path("hasmore"));


    //print first country id
        String firstCountryId = response.path("items[0].country_id");


        System.out.println("firstCountryId = " + firstCountryId);


        //print second country name

        String secondCountryId = response.path("items[1].country_name");

        String thirdHref = response.path("items[2].links[0].href");

        // get me all country names

        List<String> countryNames = response.path("items.country_name");
        System.out.println("countryNames = " + countryNames);

        //assert that all the regions ids are equal to 2

        List<Integer> allRegionsIDs = response.path("items.region_id");

        for (Integer regionsId : allRegionsIDs) {
            System.out.println("allRegionsID = " + regionsId);
            assertEquals(2,regionsId);
        }



        assertEquals(200, response.statusCode());


    }

}

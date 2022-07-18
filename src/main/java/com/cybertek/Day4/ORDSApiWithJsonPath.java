package com.cybertek.Day4;

import com.cybertek.utilities.HRTestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class ORDSApiWithJsonPath extends HRTestBase {

    @DisplayName("GET request to Countries")
    @Test
    public void test1() {

        Response response = get("/countries");
        response.prettyPrint();
        //get the second country name with JsonPath

        //to use jsonPath we assign response to JsonPAth
        JsonPath jsonPath = response.jsonPath();
        String secondCountryName = jsonPath.getString("items[1].country_name");
        System.out.println("secondCountryName = " + secondCountryName);


        //get all country ids


        List<String> allCountryIds = jsonPath.getList("items.country_id");
        System.out.println(allCountryIds);


        //get all country name where their region id is equal to 2

        List<String> countryNameForRegionId2 = jsonPath.getList("items.findAll {it.region_id==2}.country_name");

        System.out.println("countryNameForRegionId2 = " + countryNameForRegionId2);

    }

}

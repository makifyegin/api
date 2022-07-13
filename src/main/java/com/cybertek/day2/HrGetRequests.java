package com.cybertek.day2;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class HrGetRequests {

    //Before All is an annotation equals to @BeforeClass in testNg, we use with static method name.
    @BeforeAll
    public static void init() {

        RestAssured.baseURI = "http://3.93.10.240:1000/ords/hr";

    }
}

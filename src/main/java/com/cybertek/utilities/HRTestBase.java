package com.cybertek.utilities;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import javax.security.auth.login.Configuration;

public class HRTestBase {

    @BeforeAll
    public  static void init() {
//save baseurl inside this variable so that we don't need to type each http url.
        RestAssured.baseURI = ConfigurationReader.getProperty("ip");



    }

}

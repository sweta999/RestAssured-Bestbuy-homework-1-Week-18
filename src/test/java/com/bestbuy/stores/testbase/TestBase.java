package com.bestbuy.stores.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;


public class TestBase {

    @BeforeClass
    // this will build the URL
    public static void init(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        //RestAssured.basePath = "/products";
        //RestAssured.basePath = "/stores";
        //RestAssured.basePath = "/services";
        RestAssured.basePath = "/categories";
    }

}

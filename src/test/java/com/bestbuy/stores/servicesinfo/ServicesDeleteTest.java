package com.bestbuy.stores.servicesinfo;

import com.bestbuy.stores.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ServicesDeleteTest extends TestBase {

    @Test
    public void getDeleteService() {
        Response response = given()
                .pathParam("id", 4 )
                .when()
                .delete("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}

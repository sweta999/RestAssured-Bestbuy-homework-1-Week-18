package com.bestbuy.stores.extractingresponsedata;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.json.JSONArray;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class SearchJsonPathExample {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then();
    }

    // 1) Extract limit
    @Test
    public void test001() {
        int limit = response.extract().path("limit");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total number of limit is: " + limit);
        System.out.println("------------------End of Test---------------------------");

    }

    // 2) Extract total
    @Test
    public void test002() {
        int total = response.extract().path("total");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total is : "+ total);
        System.out.println("------------------End of Test---------------------------");

    }

    // 3) Extract the name of 5th store
    @Test
    public void test003() {
        String name = response.extract().path("data[5].name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The 5th name of the store is : " + name);
        System.out.println("------------------End of Test---------------------------");
    }

    // 4) Extract the names of all the store
    @Test
    public void test004() {
        List<HashMap<String, Object>> names = response.extract().path("data.name");

//        names.stream().forEach(System.out::println);
        /*for (HashMap<String, Object> name : names) {
            System.out.println(name);
        }*/

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of all the store are : " + names);
        System.out.println("------------------End of Test---------------------------");

    }

    // 5)Extract the storeId of all the store
    @Test
    public void test005() {
        List<HashMap<String, Object>> storeId = response.extract().path("data.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The storeId of all store are : " + storeId);
        System.out.println("------------------End of Test---------------------------");
    }

    // 6) Print the size of the data list - Ans = 10
    @Test
    public void test006() {
        List<HashMap<String, Object>> datasize = response.extract().path("data");
        int sizeOfJSONArrayString = new JSONArray(datasize).length();

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The size of the data list is:: " + sizeOfJSONArrayString);
        System.out.println("------------------End of Test---------------------------");
    }

    // 7) Get all the value of the store where store name = Roseville. Ans=gives me all values. e.g id,name,type,address etc..
    @Test
    public void test007() {
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name=='Roseville'}");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of the store where store name is Roseville: " + values);
        System.out.println("------------------End of Test---------------------------");
    }

    // 8) Get the address of the store where store name = Northtown. Ans = [300 Northtown Dr Ne]
    @Test
    public void test008() {
        List<String> address = response.extract().path("data.findAll{it.name=='Northtown'}.address");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The address of the store Northtown is : " + address);
        System.out.println("------------------End of Test---------------------------");
    }

    // 9) Get all the services of 8th store. Ans = [{id=1, name=Geek Squad Services, createdAt=2016-11-17T17:56:35.881Z, updatedAt=2016-11-17T17:56:35.881Z, storeservices={createdAt=2016-11-17T17:57:08.418Z, updatedAt=2016-11-17T17:57:08.418Z, storeId=16, serviceId=1}}, {id=2, name=Best Buy Mobile, createdAt=2016-11-17T17:56:35.881Z, updatedAt=2016-11-17T17:56:35.881Z, storeservices={createdAt=2016-11-17T17:57:08.418Z, updatedAt=2016-11-17T17:57:08.418Z, storeId=16, serviceId=2}}, {id=4, name=Apple Shop, createdAt=2016-11-17T17:56:35.881Z, updatedAt=2016-11-17T17:56:35.881Z, storeservices={createdAt=2016-11-17T17:57:08.418Z, updatedAt=2016-11-17T17:57:08.418Z, storeId=16, serviceId=4}}, {id=6, name=Camera Experience Shop , createdAt=2016-11-17T17:56:35.881Z, updatedAt=2016-11-17T17:56:35.881Z, storeservices={createdAt=2016-11-17T17:57:08.418Z, updatedAt=2016-11-17T17:57:08.418Z, storeId=16, serviceId=6}}, {id=7, name=Electrical Recycling, createdAt=2016-11-17T17:56:35.881Z, updatedAt=2021-07-14T20:03:47.512Z, storeservices={createdAt=2016-11-17T17:57:08.418Z, updatedAt=2016-11-17T17:57:08.418Z, storeId=16, serviceId=7}}, {id=8, name=Magnolia Home Theater, createdAt=2016-11-17T17:56:35.881Z, updatedAt=2016-11-17T17:56:35.881Z, storeservices={createdAt=2016-11-17T17:57:08.418Z, updatedAt=2016-11-17T17:57:08.418Z, storeId=16, serviceId=8}}, {id=10, name=Windows Store, createdAt=2016-11-17T17:56:35.881Z, updatedAt=2016-11-17T17:56:35.881Z, storeservices={createdAt=2016-11-17T17:57:08.418Z, updatedAt=2016-11-17T17:57:08.418Z, storeId=16, serviceId=10}}, {id=11, name=Samsung Experience, createdAt=2016-11-17T17:56:35.881Z, updatedAt=2016-11-17T17:56:35.881Z, storeservices={createdAt=2016-11-17T17:57:08.418Z, updatedAt=2016-11-17T17:57:08.418Z, storeId=16, serviceId=11}}, {id=12, name=Car & GPS Installation Services, createdAt=2016-11-17T17:56:35.881Z, updatedAt=2016-11-17T17:56:35.881Z, storeservices={createdAt=2016-11-17T17:57:08.418Z, updatedAt=2016-11-17T17:57:08.418Z, storeId=16, serviceId=12}}, {id=19, name=Pacific Kitchen & Home, createdAt=2016-11-17T17:56:35.881Z, updatedAt=2016-11-17T17:56:35.881Z, storeservices={createdAt=2016-11-17T17:57:08.418Z, updatedAt=2016-11-17T17:57:08.418Z, storeId=16, serviceId=19}}]
    @Test
    public void test009() {
        List<HashMap<String, ?>> services = response.extract().path("data[8].services");
        //data.findAll{it.name=='data[8].services'}.services
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All services of 8th store : " + services);
        System.out.println("------------------End of Test---------------------------");
    }

    // 10) Get storeservices of the store where service name = Sony Experience
    @Test
    public void test010() {
        List<HashMap<String, ?>> storeservices = response.extract().path("data.findAll{it.name=='Sony Experience'}.services");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The storeservices of the store where service name is Sony Experience: " + storeservices);
        System.out.println("------------------End of Test---------------------------");
    }

    // 11) Get all the storeId of all the store
    @Test
    public void test011() {
        //List<HashMap<Integer, ?>> storeID = response.extract().path("data[0].services[0].storeservices.storeId");
        //List<Integer> storeID = response.extract().path("data[*].services[*].storeservices.storeId");
        List<HashMap<Integer, ?>> storeID = response.extract().path("data.services.storeservices.storeId");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The storeId of all the store: " + storeID);
        System.out.println("------------------End of Test---------------------------");
    }

    // 12) Get id of all the store
    @Test
    public void test012() {
        List<Integer> Id = response.extract().path("data.id");


        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Id of all the store is : " + Id);
        System.out.println("------------------End of Test---------------------------");
    }

    // 13) Find the store "names" where state = MN instead of (WI)
    @Test
    public void test013() {
        List<String> names = response.extract().path("data.findAll{it.state==~/MN.*/}.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The store names where state = MN : " + names);
        System.out.println("------------------End of Test---------------------------");
    }

    // 14) Find the Total number of "services" for the store where store "name = Sioux Falls" (Cedar Rapids)
    @Test
    public void test014() {
        //List<Integer> services = response.extract().path("data.findAll{it.name=='Sioux Falls'}.services");
        //List<Integer> services = response.extract().path("data[9].services.total");
        List<String> names = response.extract().path("data.findAll{it.name=='Sioux Falls'}.services");
        //int total = names.size();

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total number of services for store Sioux Falls is  : " + names);
        System.out.println("------------------End of Test---------------------------");
    }

}

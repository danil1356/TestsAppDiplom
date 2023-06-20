package com.example.testsapp;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import static io.restassured.RestAssured.given;

@SpringBootTest
class TestsAppApplicationTests {

    @Test
    void getUser() {
        Response response = RestAssured.get("http://localhost:8086/Users");
        int code = response.getStatusCode();
        ResponseBody body = response.getBody();
        System.out.println("Status "+code);
        System.out.println(body.print());
        Assert.assertEquals(code, 200);
    }

    @Test
    void getJWT() throws JSONException {
        RestAssured.baseURI = "http://localhost:8086";

        JSONObject requestBody = new JSONObject()
                .put("login","daniilTeach")
                .put("password","1");

        Response response = given()
                .body(requestBody.toString())
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when().post("/Auth/login")
                .then().statusCode(200).extract().response();

        response.prettyPrint();
    }

    @Test
    void postEntity() throws JSONException {
        RestAssured.baseURI = "http://localhost:8086";

        JSONObject requestBody = new JSONObject()
                .put("name", "тестовая тема");


        Response response = given()
                .body(requestBody.toString())
                .header("Authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkYW5paWxUZWFjaCIsInJvbGVzIjpbIlJPTEVfVXNlciIsIlJPTEVfVGVhY2hlciIsIlJPTEVfU3R1ZGVudCIsIlJPTEVfQWRtaW4iXSwiaWF0IjoxNjg2Mzk5OTg3LCJleHAiOjE2ODY0MDM1ODd9.acs2prhMHrd08QvFdNxeVM7BT29cbvOXa6gcfSFtthk")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when().post("/Themes")
                .then().statusCode(200).extract().response();

        response.prettyPrint();
    }

}

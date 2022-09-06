package org.example.response;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.Serializable;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BreedResponseBuilder extends CommonResponseService {

    private static final String BREED_PATH = "breeds";

    public static Response getBreedModelResponse() {
        RequestSpecification requestSpecification = given()
                .basePath(BREED_PATH);
        return commonResponse.getResponse(Method.GET, requestSpecification);
    }

    public static Response getBreedModelWithQueryParam(Map<String, ? extends Serializable> map) {
        RequestSpecification requestSpecification = given()
                .basePath(BREED_PATH);
        map.forEach(requestSpecification::queryParam);
        return commonResponse.getResponse(Method.GET, requestSpecification);
    }
}

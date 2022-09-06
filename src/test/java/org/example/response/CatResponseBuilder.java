package org.example.response;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.Serializable;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class CatResponseBuilder extends CommonResponseService {

    private static final String CAT_PATH = "facts";
    private static final String CAT_PATH_FOR_RANDOM = "fact";
    private static final String CAT_PATH_WRONG_URL = "factttt";

    public static Response getCatModelResponse() {
        RequestSpecification requestSpecification = given()
                .basePath(CAT_PATH);
        return commonResponse.getResponse(Method.GET, requestSpecification);
    }

    public static Response getCatModelWithQueryParam(Map<String, ? extends Serializable> map) {
        RequestSpecification requestSpecification = given()
                .basePath(CAT_PATH);
        map.forEach(requestSpecification::queryParam);
        return commonResponse.getResponse(Method.GET, requestSpecification);
    }

    public static Response getRandomCatModelResponse() {
        RequestSpecification requestSpecification = given()
                .basePath(CAT_PATH_FOR_RANDOM);
        return commonResponse.getResponse(Method.GET, requestSpecification);
    }

    public static Response getWrongRandomCatModelResponse() {
        RequestSpecification requestSpecification = given()
                .basePath(CAT_PATH_WRONG_URL);
        return commonResponse.getResponse(Method.GET, requestSpecification);
    }
}

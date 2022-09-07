package org.example.response;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.Serializable;
import java.util.Map;

import static io.restassured.RestAssured.given;

public abstract class CommonResponseService {

    protected static final CommonResponse commonResponse = new CommonResponse();

    public static Response getModelResponse(String path) {
        RequestSpecification requestSpecification = given()
                .basePath(path);
        return commonResponse.getResponse(Method.GET, requestSpecification);
    }

    public static Response getModelWithQueryParam(String path, Map<String, ? extends Serializable> map) {
        RequestSpecification requestSpecification = given()
                .basePath(path);
        map.forEach(requestSpecification::queryParam);
        return commonResponse.getResponse(Method.GET, requestSpecification);
    }
}

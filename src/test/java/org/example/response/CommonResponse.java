package org.example.response;

import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CommonResponse {

    private static final String URL = "https://catfact.ninja/";

    public Response getResponse(Method method, RequestSpecification requestSpecification) {
        requestSpecification
                .baseUri(URL)
                .contentType(ContentType.JSON)
                .log().method()
                .log().uri().log().headers();
        return requestSpecification.request(method);
    }
}

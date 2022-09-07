package org.example.tests;

import io.restassured.response.Response;
import org.example.StatusCodeAndMsg;
import org.example.Utils.FilePath;
import org.example.Utils.FileUtil;
import org.example.model.BreedCollectionModel;
import org.example.model.BreedModel;
import org.example.model.CatFactCollectionModel;
import org.example.model.CatFactModel;
import org.example.model.ErrorModel;
import org.example.response.BreedResponseBuilder;
import org.example.response.CatResponseBuilder;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

public class CompareModalsTest {

    @Test(description = "API 2.1")
    public void CheckCatsListStatusCode() {
        Response response = CatResponseBuilder.getCatModelResponse();
        String contentType = response.contentType();
        assertThat("Status code is not 200 OK", response.getStatusCode(), Matchers.equalTo(StatusCodeAndMsg.OK.getCode()));
        assertThat("Content-Type is not 'application/json'", contentType, Matchers.equalTo("application/json"));
    }

    @Test(description = "API 2.1")
    public void CheckRandomCatStatusCode() {
        Response response = CatResponseBuilder.getRandomCatModelResponse();
        assertThat("Status code is not 200 OK", response.getStatusCode(), Matchers.equalTo(StatusCodeAndMsg.OK.getCode()));
    }

    @Test(description = "API 2.1")
    public void CheckCatModel() {
        Response response = CatResponseBuilder.getCatModelWithQueryParam(Map.of("page", 1, "limit", 3));
        List<CatFactModel> actualCatsList = response.as(CatFactCollectionModel.class).getData();
        List<CatFactModel> expectedCatsList = FileUtil.convertToModel(FilePath.CATS_FILE_PATH.getFilePath(), CatFactModel.class);
        assertThat("Status code is not 200 OK", response.getStatusCode(), Matchers.equalTo(StatusCodeAndMsg.OK.getCode()));
        assertThat("Lists of models are not equal", actualCatsList, Matchers.equalTo(expectedCatsList));
    }

    @Test(description = "API 2.1")
    public void CheckBreedStatusCode() {
        Response response = BreedResponseBuilder.getBreedModelResponse();
        assertThat("Status code is not 200 OK", response.getStatusCode(), Matchers.equalTo(StatusCodeAndMsg.OK.getCode()));
    }

    @Test(description = "API 2.1")
    public void CheckBreedModel() {
        Response response = BreedResponseBuilder.getBreedModelWithQueryParam(Map.of("page", 1, "limit", 3));
        List<BreedModel> actualBreedsList = response.as(BreedCollectionModel.class).getData();
        List<BreedModel> expectedBreedList = FileUtil.convertToModel(FilePath.BREED_FILE_PATH.getFilePath(), BreedModel.class);
        assertThat("Status code is not 200 OK", response.getStatusCode(), Matchers.equalTo(StatusCodeAndMsg.OK.getCode()));
        assertThat("Lists of models are not equal", actualBreedsList, Matchers.equalTo(expectedBreedList));
    }

    @Test(description = "API 2.1")
    public void CheckWrongCatUrlStatusCode() {
        Response response = CatResponseBuilder.getWrongRandomCatModelResponse();
        ErrorModel errorModel = response.as(ErrorModel.class);
        assertThat("Status code is not 404 NOT_FOUND", response.getStatusCode(), Matchers.equalTo(StatusCodeAndMsg.NOT_FOUND.getCode()));
        assertThat("Error message is not 'Not Found'", errorModel.getMessage(), Matchers.equalTo(StatusCodeAndMsg.NOT_FOUND.getMsg()));
    }
}

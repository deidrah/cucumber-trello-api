package pl.akademiaqa.api.trello.boards;

import io.restassured.response.Response;
import pl.akademiaqa.handlers.api.RequestHandler;
import lombok.RequiredArgsConstructor;

import static io.restassured.RestAssured.given;

@RequiredArgsConstructor
public class ReadBoardRequest {
    private final BaseRequest baseRequest;

    public Response readBoard(RequestHandler requestHandler) {

        return given()
                .spec(baseRequest.requestSetup(requestHandler.getQueryParams(), requestHandler.getPathParams()))
                .when()
                .get(requestHandler.getEndpoint() + "{id}")
                .then()
                .log().ifError()
                .extract()
                .response();
    }
}
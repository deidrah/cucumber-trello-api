package pl.akademiaqa.cucumber.api.trello.boards;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pl.akademiaqa.cucumber.steps.handlers.trello.TrelloAuthentication;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class CreateBoardRequest {

    TrelloAuthentication trelloAuthentication = new TrelloAuthentication();

    public Response createBoard() {

        Map<String, String> params = new HashMap<>();
        params.put("name", "TRELLO BOARD FROM CUCUMBER");
        params.put("key", trelloAuthentication.getKey());
        params.put("token", trelloAuthentication.getToken());

        return given()
                .queryParams(params)
                .contentType(ContentType.JSON)
                .when()
                .post("https://api.trello.com/1/boards/")
                .then()
                .log().ifError()
                .extract()
                .response();
    }
}

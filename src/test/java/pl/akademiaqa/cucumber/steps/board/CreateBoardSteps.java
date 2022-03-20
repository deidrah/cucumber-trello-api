package pl.akademiaqa.cucumber.steps.board;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import pl.akademiaqa.api.trello.boards.CreateBoardRequest;
import pl.akademiaqa.api.trello.boards.ReadBoardRequest;
import pl.akademiaqa.common.CommonValues;
import pl.akademiaqa.handlers.api.RequestHandler;
import pl.akademiaqa.handlers.api.ResponseHandler;
import pl.akademiaqa.url.TrelloUrl;

@RequiredArgsConstructor
public class CreateBoardSteps {

    private final CreateBoardRequest createBoardRequest;
    private final RequestHandler requestHandler;
    private final ResponseHandler responseHandler;

    private String boardId;

    @When("I create a new board")
    public void i_create_a_new_board() {
        requestHandler.setEndpoint(TrelloUrl.BOARDS);
        requestHandler.addQueryParam("name", CommonValues.BOARD_NAME);
        responseHandler.setResponse(createBoardRequest.createBoard(requestHandler));
        Assertions.assertThat(responseHandler.getStatusCode()).isEqualTo(HttpStatus.SC_OK);
    }

}

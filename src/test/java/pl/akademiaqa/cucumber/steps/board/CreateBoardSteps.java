package pl.akademiaqa.cucumber.steps.board;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import pl.akademiaqa.cucumber.api.trello.boards.CreateBoardRequest;
import pl.akademiaqa.cucumber.steps.handlers.api.RequestHandler;
import pl.akademiaqa.url.TrelloUrl;

@RequiredArgsConstructor
public class CreateBoardSteps {

    private final CreateBoardRequest createBoardRequest;
    private final RequestHandler requestHandler;

    @When("I create a new board")
    public void i_create_a_new_board() {
        requestHandler.setEndpoint(TrelloUrl.BOARDS);
        requestHandler.addQueryParam("name", "THIS IS NEW BOARD");
        Response response = createBoardRequest.createBoard(requestHandler);
        Assertions.assertThat(response.statusCode()).isEqualTo(200);
    }
    @Then("I can read created board details")
    public void i_can_read_created_board_details() {

    }

}

package pl.akademiaqa.cucumber.steps.board;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pl.akademiaqa.cucumber.api.trello.boards.CreateBoardRequest;

public class CreateBoardSteps {

    CreateBoardRequest createBoardRequest = new CreateBoardRequest();

    @When("I create a new board")
    public void i_create_a_new_board() {
        Response response = createBoardRequest.createBoard();
        System.out.println(response.statusCode());
    }
    @Then("I see created board")
    public void i_see_created_board() {

    }

}

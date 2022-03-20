package pl.akademiaqa.cucumber.steps.authentication;

import io.cucumber.java.en.Given;
import lombok.RequiredArgsConstructor;
import pl.akademiaqa.cucumber.steps.handlers.api.RequestHandler;
import pl.akademiaqa.cucumber.steps.handlers.trello.TrelloAuthentication;

@RequiredArgsConstructor
public class TrelloAuthenticationSteps {

    private final TrelloAuthentication trelloAuthentication;
    private final RequestHandler requestHandler;

    @Given("I am authenticated to Trello")
    public void i_am_authenticated_to_trello() {
        requestHandler.addQueryParam("key", trelloAuthentication.getKey());
        requestHandler.addQueryParam("token", trelloAuthentication.getToken());
    }

}

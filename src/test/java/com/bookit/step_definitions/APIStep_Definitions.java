package com.bookit.step_definitions;

import com.bookit.pojos.Room;
import com.bookit.utilities.APIUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.openqa.selenium.json.Json;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class APIStep_Definitions {
    private RequestSpecification requestSpecification;
    private Response response;
    private String token ;
    private JsonPath jsonPath;
    private ContentType contentType;

    @Given("authorization token is provided for {string}")
    public void authorization_token_is_provided_for(String role) {
        token = APIUtilities.getToken(role);
    }

    @Given("user accepts content type as {string}")
    public void user_accepts_content_type_as(String string) {
        if(string.toLowerCase().contains("json")){
            contentType = ContentType.JSON;
        } else if (string.toLowerCase().contains("xml")){
            contentType = ContentType.XML;
        } else if (string.toLowerCase().contains("html")){
            contentType = ContentType.HTML;
        }
    }

    @When("user sends GET request to {string}")
    public void user_sends_GET_request_to(String path) {
        response = given().accept(contentType).auth().oauth2(token).
                   when().get(path).prettyPeek();
    }

    @Then("user should be able to see {int} rooms")
    public void user_should_be_able_to_see_rooms(int expectedNumberOfRuums) {
        List<?> rooms = response.jsonPath().get();
        Assert.assertEquals(expectedNumberOfRuums,rooms.size());
    }

    @Then("user verifies that response status code is {int}")
    public void user_verifies_that_response_status_code_is(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode,response.getStatusCode());
    }

    @Then("user should be able to see all room names")
    public void userShouldBeAbleToSeeAllRoomNames() {
        List<Room> rooms = response.jsonPath().getList("",Room.class);
        for(Room room :rooms){
            System.out.println(room.getName());
        }
    }

    @Then("user payload contains following room names:")
    public void userPayloadContainsFollowingRoomNames(List<String> dataTable) {
        List<String> roomNames = response.jsonPath().getList("name");
        Assert.assertTrue(roomNames.containsAll(dataTable));

        // Hamcrest Matcher verify.
        MatcherAssert.assertThat(roomNames,hasItem(in(dataTable)));
    }

    @When("user sends POST request to {string} with following information:")
    public void user_sends_POST_request_to_with_following_information(String path, List<Map<String,?>> dataTable) {
            for(Map<String, ?> user : dataTable){
                // for multiple students
                response = given().queryParams(user).contentType(ContentType.JSON).
                           auth().oauth2(token).
                            when().post(path).prettyPeek();

            }
    }
    @Then("user deletes previously added students")
    public void user_deletes_previously_added_students(List<Map<?,?>> dataTable) {
        // we cannot delete studenst based on email
        // we can delete based on id.
        response = get("/api/students/100").prettyPeek();
    }
}

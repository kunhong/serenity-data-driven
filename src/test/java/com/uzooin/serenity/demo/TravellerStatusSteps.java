package com.uzooin.serenity.demo;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.matchers.BeanMatcher;

import java.util.Optional;
import static org.hamcrest.Matchers.is;


import static net.thucydides.core.matchers.BeanMatcherAsserts.shouldMatch;

public class TravellerStatusSteps extends TravellerSteps {
    private Response response = null;
    @Step
    public void a_traveller_joins_the_frequent_flyer_program() {
        response = SerenityRest.when().get("https://restcountries.eu/rest/v2/alpha/col");

        System.out.println("response : " + response.getBody().prettyPrint());

    }

    @Step
    public void the_traveller_flies(int kilometersTravelled) {
        Optional.ofNullable(response).ifPresent(res -> res.then().statusCode(200));


        intialize_traveller_step();
    }

    @Step
    public void traveller_should_have_a_status_of(Status status) {
        Optional.ofNullable(response).ifPresent(res -> res.then().body("name", is("Colombia")));
        print_traveller_name();
    }

}

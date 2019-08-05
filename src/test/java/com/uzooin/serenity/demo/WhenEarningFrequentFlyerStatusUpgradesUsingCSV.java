package com.uzooin.serenity.demo;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.*;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="testdata/status-levels.csv")
//@UseTestDataFrom("$DATADIR/status-levels.csv,/Users/hongkun/workspace/serenity/external-data.csv")
public class WhenEarningFrequentFlyerStatusUpgradesUsingCSV {
    private int kilometersTravelled;
    private Status expectedStatus;
    private MemberShip membership;

    public void setKilometersTravelled(int kilometersTravelled) {
        this.kilometersTravelled = kilometersTravelled;
    }

    public void setExpectedStatus(String expectedStatus) {
        this.expectedStatus = Status.valueOf(expectedStatus);
    }

    public void setMembership(String membership) {
        this.membership = MemberShip.valueOf(membership);
    }

    @Qualifier
    public String qualifier() {
        return kilometersTravelled + "=>" + expectedStatus + "(" + membership + ")";
    }
    @Steps
    TravellerStatusSteps travellerSteps;

    @Before
    public void before() {
        System.out.println(">>>>>>>>>>>>> BEFORE TESTING");
    }

    // http://thucydides.info/docs/thucydides/_adding_tags_to_test_cases.html
    @Test
    @WithTagValuesOf({"lookups", "release:release-2"})
    @Title("Traveller should really earn next status with enough points")
    public void reallyhouldEarnNextStatusWithEnoughPoints() {
        // GIVEN
        travellerSteps.a_traveller_joins_the_frequent_flyer_program();

        // WHEN
        travellerSteps.the_traveller_flies(kilometersTravelled);

        // THEN
        travellerSteps.traveller_should_have_a_status_of(expectedStatus);
    }
}

package com.uzooin.serenity.demo;

import com.uzooin.runner.ExcelReader;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.eclipse.jetty.util.annotation.Name;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

@UseTestDataFrom(value="testdata/status-levels.csv")
public class StepDefinitions {
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

    @Steps
    TravellerStatusSteps travellerStatusSteps;


    @When("the traveller files")
    public void the_traveller_flies() throws Exception {
        ExcelReader.setExcelFile("/Users/hongkun/workspace/serenity/serenity-data-drvien-csv/src/test/resources/data/test.xlsx", "sheet1");
        System.out.println("3/3 : " + ExcelReader.getCellData(3,3));
        travellerStatusSteps.the_traveller_flies(kilometersTravelled);
    }

    @Then("the traveller should have a status of <EXPECTED_STATUS>")
    public void the_traveller_should_have_a_status_of(@Name("EXPECTED_STATUS") String EXPECTED_STATUS) {
        travellerStatusSteps.traveller_should_have_a_status_of(Status.valueOf(EXPECTED_STATUS));
    }

    @Given("Read from excel file")
    public void read_from_execel_file(String sheetName) throws Exception {
        ExcelReader.setExcelFile("data/test.xlsx", "sheet1");
        System.out.println("1/1 : " + ExcelReader.getCellData(1,1));

    }
}



package com.uzooin.serenity.demo;

import net.thucydides.core.annotations.Step;

public abstract class TravellerSteps {
    Traveller traveller;
    @Step
    public void intialize_traveller_step() {
        traveller = new Traveller("KunHong");
    }

    @Step
    public void print_traveller_name() {
        System.out.println("Name is " + traveller.getName());
    }
}

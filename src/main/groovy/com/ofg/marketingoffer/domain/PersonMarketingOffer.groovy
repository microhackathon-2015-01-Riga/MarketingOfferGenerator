package com.ofg.marketingoffer.domain;

import org.springframework.data.annotation.Id;

public class PersonMarketingOffer {

    @Id
    private String loanApplicationId;
    
    private String firstName;
    
    private String lastName;
    
    private String offer;

    public PersonMarketingOffer(String loanApplicationId, String firstName, String lastName, String offer) {
        this.loanApplicationId = loanApplicationId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.offer = offer;
    }

    public String getFullName() {
        return fullName;
    }

    public String getOffer() {
        return offer;
    }
}

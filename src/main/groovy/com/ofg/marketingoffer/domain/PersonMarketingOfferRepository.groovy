package com.ofg.marketingoffer.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

interface PersonMarketingOfferRepository extends MongoRepository<PersonMarketingOffer, String> {

    PersonMarketingOffer findByFirstNameAndLastName(String fullName, String lastName);
}

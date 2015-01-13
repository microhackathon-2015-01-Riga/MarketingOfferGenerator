package com.ofg.marketingoffer.application
import com.google.common.base.Optional
import com.ofg.marketingoffer.domain.PersonMarketingOffer
import com.ofg.marketingoffer.domain.PersonMarketingOfferRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import static com.google.common.base.Optional.fromNullable

@Component
public class PersonalOfferGenerator {

    private final PersonMarketingOfferRepository marketingOfferRepository;
    
    @Autowired
    public PersonalOfferGenerator(PersonMarketingOfferRepository marketingOfferRepository) {
        this.marketingOfferRepository = marketingOfferRepository;         
    }
    
    public void createOffer(String loanApplicationId, String firstName, String lastName, String decision) {
        String offer = generateOffer(firstName, lastName, decision);
        PersonMarketingOffer marketingOffer = new PersonMarketingOffer(loanApplicationId, firstName, lastName, offer);
        marketingOfferRepository.save(marketingOffer); 
    }

    private String generateOffer(String firstName, String lastName, String decision) {
        return "Some offer for $firstName $lastName with decision $decision";
    }

    public Optional<String> findOffer(String firstName, String lastName) {
        PersonMarketingOffer personOffer = marketingOfferRepository.findByFirstNameAndLastName(firstName, lastName);
        return fromNullable(personOffer != null ? personOffer.getOffer() : null);
    }
}

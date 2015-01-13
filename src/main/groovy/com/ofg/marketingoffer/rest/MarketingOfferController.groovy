package com.ofg.marketingoffer.rest

import com.google.common.base.Optional
import com.ofg.marketingoffer.application.PersonalOfferGenerator
import com.wordnik.swagger.annotations.Api
import com.wordnik.swagger.annotations.ApiOperation
import groovy.transform.TypeChecked
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import javax.validation.constraints.NotNull

import static org.springframework.web.bind.annotation.RequestMethod.GET
import static org.springframework.web.bind.annotation.RequestMethod.PUT

@Slf4j
@RestController
@RequestMapping('/api/marketing')
@TypeChecked
@Api(value = "marketingOffer", description = "Creates marketing offers for clients")
class MarketingOfferController {
    
    private final PersonalOfferGenerator offerGenerator;
    
    @Autowired
    public MarketingOfferController(PersonalOfferGenerator personalOfferGenerator) {
        this.offerGenerator = personalOfferGenerator;
    }

    @RequestMapping(
            value = '{loanApplicationId}',
            method = PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create marketing offer for specified loanApplicationId")
    ResponseEntity<?> createMarketingOffer(@PathVariable @NotNull String loanApplicationId, 
                                           @RequestBody @NotNull LoanApplicationDecision decision) {
        Person person = decision.getPerson();
        offerGenerator.createOffer(loanApplicationId, person.getFirstName(), person.getLastName(), decision.getDecision());
        return new ResponseEntity<?>(HttpStatus.CREATED);
    }


    @RequestMapping(
            value = '{firstName}_{lastName}',
            method = GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get marketing offer for specified person identified by first and last name")
    ResponseEntity<MarketingOffer> getMarketingOffer(@PathVariable @NotNull String firstName, 
                                                     @PathVariable @NotNull String lastName) {
        Optional<String> offer = offerGenerator.findOffer(firstName, lastName);
        if (offer.isPresent()) {
            return new ResponseEntity<MarketingOffer>(new MarketingOffer(offer.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<MarketingOffer>(HttpStatus.NOT_FOUND);
        }
    }
}
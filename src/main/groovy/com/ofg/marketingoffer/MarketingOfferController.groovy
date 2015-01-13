package com.ofg.marketingoffer
import com.ofg.marketingoffer.model.LoanApplicationDecision
import com.ofg.marketingoffer.model.MarketingOffer
import com.wordnik.swagger.annotations.Api
import com.wordnik.swagger.annotations.ApiOperation
import groovy.transform.TypeChecked
import groovy.util.logging.Slf4j
import org.springframework.http.MediaType
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

    @RequestMapping(
            value = '{loanApplicationId}',
            method = PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create marketing offer for specified loanApplicationId")
    Void createMarketingOffer(@PathVariable @NotNull long loanApplicationId, @RequestBody @NotNull LoanApplicationDecision decision) {

    }


    @RequestMapping(
            value = '{firstName}_{lastName}',
            method = GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get marketing offer for specified person identified by first and last name")
    MarketingOffer getMarketingOffer(@PathVariable @NotNull String firstName, @PathVariable @NotNull String lastName) {
            
    }

}

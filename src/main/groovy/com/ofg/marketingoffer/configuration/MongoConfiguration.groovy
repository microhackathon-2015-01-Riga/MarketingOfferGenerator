package com.ofg.marketingoffer.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.github.fakemongo.Fongo;
import com.mongodb.Mongo;

@Configuration
@EnableMongoRepositories(basePackages = "com.ofg.marketingoffer.domain")
public class MongoConfiguration extends AbstractMongoConfiguration {

    @Override
    public Mongo mongo() throws Exception {
        return new Fongo("marketingoffer").getMongo();
    }

    @Override
    public String getDatabaseName() {
        return "marketingoffer";
    }
}
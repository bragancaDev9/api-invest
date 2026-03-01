package com.project.api_invest_myversion.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.api_invest_myversion.model.entities.Invest;

public interface InvestRepository extends MongoRepository<Invest, String> {}

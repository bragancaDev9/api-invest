package com.project.api_invest_myversion.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.api_invest_myversion.model.entities.Account;

public interface AccountRepository extends MongoRepository<Account, String> {}

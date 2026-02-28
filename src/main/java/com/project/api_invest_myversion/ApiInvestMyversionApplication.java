package com.project.api_invest_myversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.api_invest_myversion.model.entities.Account;
import com.project.api_invest_myversion.model.entities.Phone;
import com.project.api_invest_myversion.model.entities.enums.AccountType;
import com.project.api_invest_myversion.repositories.AccountRepository;

@SpringBootApplication
public class ApiInvestMyversionApplication implements CommandLineRunner {
	@Autowired
	AccountRepository accountRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ApiInvestMyversionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Account a1 = new Account(null, "Bryan", "123.456.789-01", AccountType.COMMON);
		Phone p1 = new Phone("(78) 90123-4567");
		Phone p2 = new Phone("(78) 99012-3456");
		a1.getPhones().add(p1);
		a1.getPhones().add(p2);
		a1.deposit(200.00);
		a1.withdraw(20.00);
		
		accountRepository.save(a1);
	}
}

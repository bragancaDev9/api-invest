package com.project.api_invest_myversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.api_invest_myversion.model.entities.Account;
import com.project.api_invest_myversion.model.entities.Address;
import com.project.api_invest_myversion.model.entities.Invest;
import com.project.api_invest_myversion.model.entities.Phone;
import com.project.api_invest_myversion.model.entities.enums.AccountType;
import com.project.api_invest_myversion.model.entities.enums.InvestType;
import com.project.api_invest_myversion.model.entities.enums.Market;
import com.project.api_invest_myversion.repositories.AccountRepository;
import com.project.api_invest_myversion.repositories.InvestRepository;

@SpringBootApplication
public class ApiInvestMyversionApplication implements CommandLineRunner {
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private InvestRepository investRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ApiInvestMyversionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Account a1 = new Account(null, "Bragança", "123.456.789-01", AccountType.COMMON);
		Address ad1 = new Address("Rua A", "123", "12345-678");
		Phone p1 = new Phone("(78) 90123-4567");
		Invest i1 = new Invest(null, "REF Invests", 0.01, 0.05, 10.0, 0.06, Market.DIGITAL, InvestType.REAL_ESTATE_FUND);
		a1.getAddresses().add(ad1);
		a1.getPhones().add(p1);
		a1.getInvests().add(i1);
		
		investRepository.save(i1);
		accountRepository.save(a1);
	}
}

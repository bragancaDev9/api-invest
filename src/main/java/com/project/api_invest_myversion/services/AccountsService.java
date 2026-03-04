package com.project.api_invest_myversion.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.api_invest_myversion.model.entities.Account;
import com.project.api_invest_myversion.repositories.AccountRepository;
import com.project.api_invest_myversion.services.exceptions.ObjectNotFoundException;

@Service
public class AccountsService {
	@Autowired
	private AccountRepository accountRepository;
	
	// Create
	public Account insert(Account account) {
		return accountRepository.save(account);
	}
	
	// Read
	public List<Account> findAll() {
		return accountRepository.findAll();
	}
	
	public Account findById(String id) {
		Optional<Account> account = accountRepository.findById(id);
		
		return account.orElseThrow(() -> new ObjectNotFoundException("Object wasn't found! Id: " + id));
	}
	
	// Update
	public Account update(Account account) {
		Account newAccount = accountRepository.findById(account.getId())
			.orElseThrow(() -> new ObjectNotFoundException("Object wasn't found! Id: " + account.getId()));
		updateData(newAccount, account);
		return accountRepository.save(newAccount);
	}
	
	private void updateData(Account newAccount, Account account) {
		newAccount.setAccountType(account.getAccountType());
		newAccount.setName(account.getName());
	}
	
	// Delete
	public void delete(String id) {
		findById(id);
		accountRepository.deleteById(id);
	}
}

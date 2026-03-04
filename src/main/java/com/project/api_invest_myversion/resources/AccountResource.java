package com.project.api_invest_myversion.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project.api_invest_myversion.model.entities.Account;
import com.project.api_invest_myversion.services.AccountsService;

@RestController
@RequestMapping("/accounts")
public class AccountResource {
	@Autowired
	private AccountsService accountService;
	
	// Create
	@PostMapping
	public ResponseEntity<Account> insert(@RequestBody Account account) {
		Account newAccount = accountService.insert(account);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(newAccount.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	// Read
	@GetMapping
	public ResponseEntity<List<Account>> findAll() {
		List<Account> accounts = accountService.findAll();
		
		return ResponseEntity.ok(accounts);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Account> findById(@PathVariable String id) {
		Account account = accountService.findById(id);
		
		return ResponseEntity.ok(account);
	}
	
	// Update
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody Account account, @PathVariable String id) {
		account.setId(id);
		account = accountService.update(account);
		return ResponseEntity.noContent().build();
	}
	
	// Delete
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		accountService.delete(id);
		return ResponseEntity.noContent().build();	
	}
}

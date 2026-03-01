package com.project.api_invest_myversion.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.project.api_invest_myversion.model.entities.enums.AccountType;

@Document(collection = "accounts")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String name, cpfOrCnpj;
	private Date creationDate;
	private Double balance;
	private AccountType accountType;
	
	private List<Phone> phones = new ArrayList<>();
	private List<Address> addresses = new ArrayList<>();
	private List<Invest> invests = new ArrayList<>();
	
	public Account() {}

	public Account(String id, String name, String cpfOrCnpj, AccountType accountType) {
		this.id = id;
		this.name = name;
		this.cpfOrCnpj = cpfOrCnpj;
		this.balance = 0.0;
		this.creationDate = new Date();
		this.accountType = accountType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpfOrCnpj() {
		return cpfOrCnpj;
	}

	public void setCpfOrCnpj(String cpfOrCnpj) {
		this.cpfOrCnpj = cpfOrCnpj;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	
	public List<Phone> getPhones() {
		return phones;
	}
	
	public List<Address> getAddresses() {
		return addresses;
	}
	
	public List<Invest> getInvests() {
		return invests;
	}

	public void deposit(Double amount) {
		balance += amount;
	}
	
	public void withdraw(Double amount) {
		balance -= amount + 5.0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(id, other.id);
	}
}

package com.project.api_invest_myversion.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.project.api_invest_myversion.model.entities.enums.InvestType;
import com.project.api_invest_myversion.model.entities.enums.Market;

@Document(collection = "invests")
public class Invest implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final double FGC = 100;
	
	@Id
	private String id;
	private String name;
	private Double otherTaxes, liquidity, unitPrice, iof;
	private Date operationDate;
	private Market market;
	private InvestType investType;
	
	@DBRef
	private Account account;
	
	public Invest() {}

	public Invest(String id, String name, Double otherTaxes, Double liquidity, Double unitPrice, Double iof,
	Market market, InvestType investType) {
		this.id = id;
		this.name = name;
		this.otherTaxes = otherTaxes;
		this.liquidity = liquidity;
		this.unitPrice = unitPrice;
		this.iof = iof;
		this.operationDate = new Date();
		this.market = market;
		this.investType = investType;
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

	public Double getOtherTaxes() {
		return otherTaxes;
	}

	public void setOtherTaxes(Double otherTaxes) {
		this.otherTaxes = otherTaxes;
	}

	public Double getLiquidity() {
		return liquidity;
	}

	public void setLiquidity(Double liquidity) {
		this.liquidity = liquidity;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Double getIof() {
		return iof;
	}

	public void setIof(Double iof) {
		this.iof = iof;
	}

	public Date getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}

	public Market getMarket() {
		return market;
	}

	public void setMarket(Market market) {
		this.market = market;
	}
	
	public InvestType getInvestType() {
		return investType;
	}

	public void setInvestType(InvestType investType) {
		this.investType = investType;
	}
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public static double getFgc() {
		return FGC;
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
		Invest other = (Invest) obj;
		return Objects.equals(id, other.id);
	}
}

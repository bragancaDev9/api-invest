package com.project.api_invest_myversion.model.entities;

import java.io.Serializable;

public class Phone implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String phone;

	public Phone() {}

	public Phone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}

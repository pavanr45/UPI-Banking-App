package com.demo.feb_12;

public class Account {
	
	int accNo ;
	String custName;
	double balance;
	
	public Account() {
		
	}

	public Account(int accNo, String custName, double balance) {
		super();
		this.accNo = accNo;
		this.custName = custName;
		this.balance = balance;
	}

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	

}

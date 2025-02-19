package com.demo.feb_12;

public class AccountController{

	public static Account getAccountDetailsByName(String name) {
		
		
		AccountDao dao = new AccountDao();
		
		Account accountObj =dao.getAccountDetailsByName(name);
		
		
		return accountObj;
	}

	public void updateAccountBalance(double balanceTemp, int accNo) {
		
       AccountDao dao = new AccountDao();
		
		dao. updateAccountBalance(balanceTemp,  accNo);
		
	}

}

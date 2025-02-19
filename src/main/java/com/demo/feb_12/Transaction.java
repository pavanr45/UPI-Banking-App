package com.demo.feb_12;

public class Transaction {
	boolean status = false;

	public void withdraw(double amount, Account pavanAcc) {
	    double currentBalance = pavanAcc.getBalance();
	    
	    if (currentBalance - amount >= 1000) {
	        double balanceTemp = currentBalance - amount;
	        
	        AccountDao dao = new AccountDao();
	        dao.updateAccountBalance(balanceTemp, pavanAcc.getAccNo());

	        System.out.println("Withdrawal Successful! New Balance: " + balanceTemp);
	        
	        status =true;
	    } else {
	        System.out.println("Insufficient funds! You have ₹" + currentBalance + ", but must keep ₹1000.");
	    }
	}


	public void deposite(double amount, Account nishaAcc) { 
		
	    double currentBalance = nishaAcc.getBalance();  // Get current balance
	    
	    double balanceTemp = currentBalance + amount;  // Add deposit amount
	    
	    AccountDao dao = new AccountDao();
	    dao.updateAccountBalance(balanceTemp, nishaAcc.getAccNo());  // Update DB

	    System.out.println("✅ Deposit Successful! New Balance: ₹" + balanceTemp);
	}

}
	
	



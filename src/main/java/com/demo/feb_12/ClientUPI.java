package com.demo.feb_12;

public class ClientUPI {
    public static void main(String[] args) {
        System.out.println("*** Welcome ***");

        Account pavanAcc = AccountController.getAccountDetailsByName("Pavan");
        if (pavanAcc != null) {
            System.out.println(" Account Found: " + pavanAcc.getCustName() + " | Balance: " + pavanAcc.getBalance());
        } else {
            System.out.println(" No account found for Pavan");
        }

        Account nishaAcc = AccountController.getAccountDetailsByName("Nisha");
        if (nishaAcc != null) {
            System.out.println("Account Found: " + nishaAcc.getCustName() + " | Balance: " + nishaAcc.getBalance());
        } else {
            System.out.println(" No account found for Nisha");
        }
        
        Transaction trFeb12 = new Transaction();
        
        double amountTransfer =2000;
       
        trFeb12.withdraw(amountTransfer, pavanAcc);

        
        trFeb12.deposite(amountTransfer, nishaAcc);

        System.out.println("*** Thanks ***");
    }
}

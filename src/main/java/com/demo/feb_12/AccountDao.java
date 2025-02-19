package com.demo.feb_12;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDao{
	public Account getAccountDetailsByName(String name) {
	    Account accountObj = null;
	    Connection cn = null;
	    PreparedStatement pst = null;
	    ResultSet rs = null;

	    try {
	        cn = MyDbConf.getMyDatabaseConnection();
	        cn.setAutoCommit(false);
	       

	        String query = "SELECT * FROM account WHERE cust_name = ?";
	        pst = cn.prepareStatement(query);
	        pst.setString(1, name);
	        rs = pst.executeQuery();

	        if (rs.next()) {
	            accountObj = new Account();
	            // Check correct column name
	            accountObj.setAccNo(rs.getInt("acc_no"));  // Use correct column name
	            accountObj.setCustName(rs.getString("cust_name"));
	            accountObj.setBalance(rs.getDouble("balance"));

	            System.out.println(" Account Found: " + accountObj.getCustName());
	        } else {
	            System.out.println(" No account found for: " + name);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (pst != null) pst.close();
	            if (cn != null) cn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return accountObj;
	}

	public void updateAccountBalance(double balanceTemp, int accNo) {
	    Connection cn = null;
	    PreparedStatement pst = null;

	    try {
	        cn = MyDbConf.getMyDatabaseConnection();
	        
	        // Disable auto-commit if necessary
	        if (!cn.getAutoCommit()) {
	            cn.setAutoCommit(false);
	        }

	        String query = "UPDATE account SET balance = ? WHERE acc_no = ?";
	        pst = cn.prepareStatement(query);
	        pst.setDouble(1, balanceTemp);
	        pst.setInt(2, accNo);

	        int rows = pst.executeUpdate();
	        
	        if (rows > 0) {
	            System.out.println("✅ Balance Updated Successfully!");
	            if (!cn.getAutoCommit()) {
	                cn.commit();  // Commit only if autoCommit is false
	            }
	        } else {
	            System.err.println("❌ SOMETHING WENT WRONG!!!!");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (pst != null) pst.close();
	            if (cn != null) cn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	   }
	}
}

	    
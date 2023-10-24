package com.kh.MVC.orders;

import java.util.Date;

public class BankDTO {
	private int account_id;
	private String account_number;
	private String account_name;
	private double balance;
	private String branch_name;
	private Date Last_transaction_date;
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	public void setLast_transaction_date(Date last_transaction_date) {
		Last_transaction_date = last_transaction_date;
	}
	public int getAccount_id() {
		return account_id;
	}
	public String getAccount_number() {
		return account_number;
	}
	public String getAccount_name() {
		return account_name;
	}
	public double getBalance() {
		return balance;
	}
	public String getBranch_name() {
		return branch_name;
	}
	public Date getLast_transaction_date() {
		return Last_transaction_date;
	}
	
	public BankDTO(double balance, int account_id) {
		this.balance = balance;
		this.account_id = account_id;
	}
	public BankDTO() {	}
	public BankDTO(int account_id, String account_number, String account_name, double balance, String branch_name,
			Date last_transaction_date) {
		this.account_id = account_id;
		this.account_number = account_number;
		this.account_name = account_name;
		this.balance = balance;
		this.branch_name = branch_name;
		Last_transaction_date = last_transaction_date;
	}

}

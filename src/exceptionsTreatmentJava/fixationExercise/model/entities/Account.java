package exceptionsTreatmentJava.fixationExercise.model.entities;

import exceptionsTreatmentJava.fixationExercise.model.exceptions.DomainException;

public class Account {
	
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account(Integer number, String holder, Double initialBalance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		balance = initialBalance;
		this.withdrawLimit = withdrawLimit;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Integer getNumber() {
		return number;
	}

	public Double getBalance() {
		return balance;
	}
	
	public Double getWithdrawLimit() {
		return withdrawLimit;
	}
	
	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withdraw(double amount) throws DomainException {
		if (amount > balance) {
			throw new DomainException("Insufficient balance!");
		}
		if (amount > withdrawLimit) {
			throw new DomainException("The amount exceeds withdraw limit!");
		}
		balance -= amount;
	}
}

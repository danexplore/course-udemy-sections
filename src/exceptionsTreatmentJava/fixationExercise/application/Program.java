package exceptionsTreatmentJava.fixationExercise.application;

import java.util.Locale;
import java.util.Scanner;

import exceptionsTreatmentJava.fixationExercise.model.exceptions.DomainException;
import exceptionsTreatmentJava.fixationExercise.model.entities.Account;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter account data");
			
			System.out.print("Number: ");
			int number = sc.nextInt();
			
			if (sc.hasNextLine()) sc.nextLine();
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			
			System.out.print("Initial balance: ");
			double initialBalance = sc.nextDouble();
			
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();
			System.out.println();
			
			Account account = new Account(number, holder, initialBalance, withdrawLimit);
			
			System.out.print("Enter amount to withdraw: ");
			account.withdraw(sc.nextDouble());
			
			System.out.println("New balance: " + String.format("%.2f", account.getBalance()));
		}
		catch (DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error! Look input values.");
		}
		
		sc.close();
	}

}

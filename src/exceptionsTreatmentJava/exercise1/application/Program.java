package exceptionsTreatmentJava.exercise1.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import exceptionsTreatmentJava.exercise1.model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat();
		
		System.out.print("Room Number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/mm/yyyy): ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/mm/yyyy): ");
		Date checkout = sdf.parse(sc.next());
		if(!checkout.after(checkin)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation reservation = new Reservation(number, checkin, checkout);
			System.out.println(reservation);
			System.out.println();
			
			System.out.println("Enter data to update the reservation:");
			System.out.print("Room Number: ");
			number = sc.nextInt();
			System.out.print("Check-in date (dd/mm/yyyy): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/mm/yyyy): ");
			checkout = sdf.parse(sc.next());
			
			Date now = new Date();
			if(checkin.before(now) || checkout.before(now)) {
				System.out.println("Error in reservation: Check-out date must be future dates");
			}
			else if (!checkout.after(checkin)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}
			else {
				reservation.updateDates(checkin, checkout);
				System.out.println(reservation);
			}
			
		}
		
		sc.close();
	}

}

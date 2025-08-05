package day14;


import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class lab12 {
	
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	        System.out.print("Enter the first date (dd-MM-yyyy): ");
	        String inputDate1 = scanner.nextLine();
	        LocalDate date1 = LocalDate.parse(inputDate1, formatter);

	        System.out.print("Enter the second date (dd-MM-yyyy): ");
	        String inputDate2 = scanner.nextLine();
	        LocalDate date2 = LocalDate.parse(inputDate2, formatter);

	        if (date2.isBefore(date1)) {
	            LocalDate temp = date1;
	            date1 = date2;
	            date2 = temp;
	        }

	        Period period = Period.between(date1, date2);

	        System.out.println("Duration from " + date1 + " to " + date2 + ":");
	        System.out.println(period.getYears() + " year(s), " + period.getMonths() + " month(s), " + period.getDays() + " day(s)");

	        scanner.close();
	    }
	}

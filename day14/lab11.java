package day14;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class lab11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a date (DD-MM-YYYY): ");
        String inputDate = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate enteredDate = LocalDate.parse(inputDate, formatter);
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(enteredDate, currentDate);
        System.out.println("Duration from " + enteredDate + " to " + currentDate + ":");
        System.out.println(period.getYears() + " year(s), " + period.getMonths() + " month(s), " + period.getDays() + " day(s)");
        scanner.close();
    }
}

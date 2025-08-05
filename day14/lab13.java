package day14;


		import java.time.LocalDate;
		import java.time.format.DateTimeFormatter;
		import java.util.Scanner;

		public class lab13 {
		    public static void main(String[] args) {
		        Scanner scanner = new Scanner(System.in);
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		        System.out.print("Enter product purchase date (dd-MM-yyyy): ");
		        String purchaseDateStr = scanner.nextLine();
		        LocalDate purchaseDate = LocalDate.parse(purchaseDateStr, formatter);

		        System.out.print("Enter warranty period in years: ");
		        int warrantyYears = scanner.nextInt();

		        System.out.print("Enter warranty period in months: ");
		        int warrantyMonths = scanner.nextInt();

		        LocalDate expiryDate = purchaseDate.plusYears(warrantyYears).plusMonths(warrantyMonths);

		        System.out.println("Warranty expires on: " + expiryDate.format(formatter));

		       
		    }
		}

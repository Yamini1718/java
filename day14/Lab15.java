package day14;



import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Lab15 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter First Name: ");
        String firstName = sc.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = sc.nextLine();

        System.out.print("Enter Date of Birth (yyyy-mm-dd): ");
        String dobInput = sc.nextLine();
        
     
        LocalDate dob = LocalDate.parse(dobInput);

        String fullName = getFullName(firstName, lastName);
        int age = calculateAge(dob);

        System.out.println("Person Details ");
        System.out.println("Full Name: " + fullName);
        System.out.println("Age      : " + age + " years");

        sc.close();
    }

    public static String getFullName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

    public static int calculateAge(LocalDate dob) {
        LocalDate today = LocalDate.now();
        return Period.between(dob, today).getYears();
    }
}

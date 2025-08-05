package day14;



import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class lab14 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a Zone ID (e.g., America/New_York, Europe/London, Asia/Tokyo, US/Pacific, Africa/Cairo, Australia/Sydney):");
        String zoneInput = sc.nextLine();

        printDateTimeWithZone(zoneInput);

        sc.close();
    }

    public static void printDateTimeWithZone(String zoneId) {
        try {
            ZoneId zone = ZoneId.of(zoneId);
            ZonedDateTime dateTime = ZonedDateTime.now(zone);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss z");
            String formatted = dateTime.format(formatter);
            System.out.println("Current date and time in " + zoneId + ": " + formatted);
        } catch (Exception e) {
            System.out.println("Invalid Zone ID. Please enter a valid one like Asia/Tokyo.");
        }
    }
}

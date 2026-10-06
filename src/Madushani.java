import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Madushani {
    public static void main(String[] args) {
        // Creating a CourtCase instance
        CourtCase courtCase= new CourtCase("123456",new Date(),"Judge Smith","Lawyer Johnson","Initial Verdict");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("__Court case Main Menu__");
            System.out.println("1.Displaying initial case details ");
            System.out.println("2.Updating case details ");
            System.out.println("3.Displaying updated case details");
            System.out.println("4.Scheduling a new court date");
            System.out.println("5. Providing a new verdict");
            System.out.println("6.Displaying final case details");
            System.out.println("7. Exit");
            System.out.print("Enter your choice:");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                // 1.Displaying initial case details
                System.out.println("Initial Case Details:");
                System.out.println(courtCase.getCaseDetails());
                    break;
                case 2:
                //2. Updating case details
                courtCase.updateCaseDetails("New Judge", "New Lawyer", "New Verdict");
                    break;
                case 3:
                // 3.Displaying updated case details
                System.out.println("\nUpdated Case Details:");
                System.out.println(courtCase.getCaseDetails());
                    break;
                case 4:
                // 4.Scheduling a new court date
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date newCourtDate = dateFormat.parse("2024-03-15");
                    courtCase.scheduleNewCourtDate(newCourtDate);

                    // Displaying case details after scheduling a new court date
                    System.out.println("\nCase Details After Scheduling a New Court Date:");
                    System.out.println(courtCase.getCaseDetails());
                } catch (ParseException e) {
                    System.out.println("Error parsing date: " + e.getMessage());
                }
                break;
                case 5:
                //5. Providing a new verdict
                courtCase.provideVerdict("Final Verdict");
                    break;
                case 6:
                // 6.Displaying final case details
                System.out.println("\nFinal Case Details:");
                System.out.println(courtCase.getCaseDetails());
                break;
                case 7:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }





    }
}
import java.util.Scanner;

public class Chalani {
    public static void main(String[] args) {
        // Example usage
        CrimeCategories theftCategory = new CrimeCategories(1, "Theft", "This category includes crimes such as burglary, robbery, and shoplifting");
        CrimeReports report1 = new CrimeReports(1, "Stolen car", "2024-02-11", "John Doe", "Open");

        // Create a Scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Display menu for user to choose the action
        while (true) {
            System.out.println("Crime category Details within a report");
            System.out.println("1. View Category Details");
            System.out.println("2. Generate Crime Report");
            System.out.println("3.Exit");
            System.out.println("Choose an option:");
            int choice = scanner.nextInt();

            // Execute action based on user choice using switch case
            switch (choice) {
                case 1:
                    theftCategory.viewCategoryDetails();
                    break;
                case 2:
                    report1.generateCrimeReport();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");

            }
        }
    }
}

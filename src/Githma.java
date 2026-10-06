import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Githma {
    public static void main(String[] args) {
        // Create an instance of CrimeRegisterDepartment
        CrimeDepartment policeStation01 = new CrimeDepartment(
                "Main Branch",
                001,
                112453678,
                Arrays.asList("Officer1", "Officer2")
        );

        // Create an instance of CrimeRecord
        CrimeRecord crimeRecord = new CrimeRecord();
        crimeRecord.setCaseNumber("#CR001");
        crimeRecord.getDate();
        crimeRecord.setLocation("Park Avenue");
        crimeRecord.setDescription("Burglary");
        crimeRecord.setStatus("Pending");


        Scanner scanner = new Scanner(System.in);

        // Add a switch case to handle different functions
        while (true) {
            System.out.println("___Crime Incidents add by Police Station___");
            System.out.println("1. Register Crime");
            System.out.println("2. Assign Officers");
            System.out.println("3. Track Case Progress");
            System.out.println("4. Generate Reports");
            System.out.println("5. Search Case");
            System.out.println("6. Exit");
            System.out.print("Enter your choice:");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    policeStation01.registerCrime(crimeRecord);
                    System.out.println();
                    break;
                case 2:
                    List<String> assignedOfficers = Arrays.asList("Officer3", "Officer4");
                    policeStation01.assignOfficers(crimeRecord, assignedOfficers);
                    System.out.println();
                    break;
                case 3:
                    policeStation01.trackCaseProgress(crimeRecord);
                    break;
                case 4:
                    policeStation01.generateReports(crimeRecord);
                    break;
                case 5:
                    CrimeRecord foundCrime1 = policeStation01.searchCase("#CR001");
                    // Print details of the found crime (if any)
                    if (foundCrime1 != null) {
                        System.out.println("Found Crime Record:");
                        System.out.println("Case Number: " + foundCrime1.getCaseNumber());
                        System.out.println("Date: " + foundCrime1.getDate());
                        System.out.println("Location: " + foundCrime1.getLocation());
                        System.out.println("Description: " + foundCrime1.getDescription());
                        System.out.println("Status: " + foundCrime1.getStatus());

                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Dewmi {

    public static void main(String[] args) {
        // Example usage
        List<CriminalPerson> personList = new ArrayList<>();

        // Create a new person
        CriminalPerson person1 = new CriminalPerson("123456789", "Dewmi Jayasooriya",
                new Date(), "123 Main St Colombo road", 03325, "Male");

        Scanner scanner = new Scanner(System.in);

        // Add a switch case to handle different functions
        while (true) {
            System.out.println("Add A criminal Person for system");
            System.out.println("1.Add crime records");
            System.out.println("2.Add the person to the list ");
            System.out.println("3. Search for a person by national ID");
            System.out.println("4.Witness and evidence details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice:");
            int num = scanner.nextInt();

            switch (num) {

                case 1:
                // 1.Add crime records
                person1.addCrimeRecord("Theft", new Date());
                person1.addCrimeRecord("Child abuse", new Date());
                    break;
                case 2:
                // 2.Add the person to the list
                personList.add(person1);
                    break;
                case 3:
                //3. Search for a person by national ID
                CriminalPerson foundPerson = CriminalPerson.searchPerson(personList, "123456");

                if (foundPerson != null) {
                    foundPerson.finalRecord();
                } else {
                    System.out.println("Person not found.");
                }
                break;
                case 4:
                    String Dep;
                    PoliceOfficer officer = new PoliceOfficer();
                    Witness witness = new Witness();
                    Evidence evidence = new Evidence();

                    WitnessesEvidence witnessesEvidence = new WitnessesEvidence("0001", "Description",
                            officer, "Central Park", witness, evidence);

                    // View details
                    witnessesEvidence.viewWitnessEvidence();

                    // Update details
                    witnessesEvidence.updateWitnessEvidence("New Depcription", "Kandy Park");

                    // View updated details
                    witnessesEvidence.viewWitnessEvidence();
                    String filePath = "Description.txt";

                    try (FileWriter writer = new FileWriter(filePath)) {

                        writer.write("This is Criminal Description Example for java Programme.");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                        // Reading content from the file
                        String line;
                        while ((line = reader.readLine()) != null) {
                            System.out.println(line);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        }

    }
}
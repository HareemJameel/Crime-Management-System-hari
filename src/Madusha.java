import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Madusha {
    public static void main(String[] args) {
        // Create an instance of Investigator
        Investigator investigator = new Investigator("John Doe", "Forensic Science", "Senior");

        // Testing functional requirements
        String analysisResult = investigator.analyseCrimeScene();
        System.out.println(analysisResult);

        investigator.submitReport("CASE123", "This is the investigation report for CASE123.");

        investigator.updateNewCases("CASE456");

        List<String> assignedOfficers = new ArrayList<>();
        assignedOfficers.add("Officer1");
        assignedOfficers.add("Officer2");
        investigator.assignCase("CASE789", assignedOfficers);
        ConcreteSuspectManager suspectManager = new ConcreteSuspectManager();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("___Suspect Details___");
            System.out.println("1.Adding suspects");
            System.out.println("2. Viewing suspects");
            System.out.println("3.Updating status of a suspect ");
            System.out.println("4..Arresting a suspect");
            System.out.println("5.Viewing updated list of suspects");
            System.out.println("6.Deleting a suspect");
            System.out.println("7.Viewing final list of suspects ");
            System.out.println("8. Exit");
            System.out.print("Enter your choice:");
            int choice4 = scanner.nextInt();

            switch (choice4) {
                case 1:
                // 01.Adding suspects
                suspectManager.addSuspect("123456789", "Nimal perera", "Description 1");
                suspectManager.addSuspect("987654321", "Nayana Hettiarchchi", "Description 2");
                break;
                case 2:
                //02. Viewing suspects
                System.out.println("Initial List of Suspects:");
                suspectManager.viewSuspects();
                break;
                case 3:
                // 03.Updating status of a suspect
                suspectManager.updateSuspectStatus("123456789", "Updated Status");
                break;
                case 4:
                // 04.Arresting a suspect
                suspectManager.arrestSuspect("987654321");
                break;
                case 5:
                //05. Viewing updated list of suspects
                System.out.println("\nUpdated List of Suspects:");
                suspectManager.viewSuspects();
                break;
                case 6:
                // 06.Deleting a suspect
                suspectManager.deleteSuspects("123456789");
                break;
                case 7:
                // 07.Viewing final list of suspects
                System.out.println("\nFinal List of Suspects:");
                suspectManager.viewSuspects();
                case 8:
                    System.out.println("______________________");
                    System.out.println("Exiting in this menu...");

                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

            if (choice4 == 8) {
                break;
            }
            }

        }
    }

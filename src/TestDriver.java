import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         while (true) {
            System.out.println("****** Welcome to Crime Record Management System *******");
            System.out.println("_______________________________________________________");
             System.out.println("             ********* MAIN MENU*********          ");
             System.out.println("_______________________________________________________");
            System.out.println("01.Add a criminal Person for system");
            System.out.println("02 Add a Crime Incidents for system by Police Station");
            System.out.println("03.View a Crime category Details within a report");
            System.out.println("04.Add a Court case for system ");
            System.out.println("05.Suspect Details");
            System.out.println("06.Exit");
            System.out.println("_______________________________________________________");
            System.out.print("Enter your path:");
            int choice = scanner.nextInt();

            switch (choice) {
                //01.Add a criminal Person for system
                case 1:
                    List<CriminalPerson> personList = new ArrayList<>();
                    // Create a new person
                    CriminalPerson person1 = new CriminalPerson("123456789", "Dewmi Jayasooriya",
                            new Date(), "123 Main St Colombo road", 03325, "Male");

                    // Add a switch case to handle different functions
                    while (true) {
                        System.out.println("Add A criminal Person for system");
                        System.out.println("_________________________________");
                        System.out.println("1.Add crime records");
                        System.out.println("2.Add the person to the list ");
                        System.out.println("3. Search for a person by national ID");
                        System.out.println("4.Witness and evidence details");
                        System.out.println("5. Exit");
                        System.out.println("_______________________________________");
                        System.out.print("Enter your choice:");
                        int num = scanner.nextInt();
                        switch (num) {
                            case 1:
                                // 1.Add crime records
                                person1.addCrimeRecord("Theft", new Date());
                                person1.addCrimeRecord("Assault", new Date());
                                System.out.println("______________________________________");
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
                                    System.out.println("_____________________________________________________");

                                break;
                            case 5:
                                System.out.println("Exiting in this menu...");
                                break;
                            default:
                                System.out.println("Invalid choice. Try again.");
                        }
                        if (num == 5) {
                         break;
                        }
                    }
                    break;
//02 Add a Crime Incidents for system by Police Station;
                case 2:
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

                    // Add a switch case to handle different functions
                    while (true) {
                        System.out.println("___Crime Incidents add by Police Station___");
                        System.out.println("_______________________________________________________");
                        System.out.println("1. Register Crime");
                        System.out.println("2. Assign Officers");
                        System.out.println("3. Track Case Progress");
                        System.out.println("4. Generate Reports");
                        System.out.println("5. Search Case");
                        System.out.println("6. Exit");
                        System.out.println("_______________________________________________________");
                        System.out.print("Enter your choice:");
                        int choice1 = scanner.nextInt();

                        switch (choice1) {
                            case 1:
                                System.out.println("______________________");
                                policeStation01.registerCrime(crimeRecord);
                                System.out.println();
                                break;
                            case 2:
                                System.out.println("______________________");
                                List<String> assignedOfficers = Arrays.asList("Officer3", "Officer4");
                                policeStation01.assignOfficers(crimeRecord, assignedOfficers);
                                System.out.println();
                                break;
                            case 3:
                                System.out.println("______________________");
                                policeStation01.trackCaseProgress(crimeRecord);
                                break;
                            case 4:
                                System.out.println("______________________");
                                policeStation01.generateReports(crimeRecord);
                                break;
                            case 5:
                                System.out.println("______________________");
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
                                System.out.println("______________________");
                                System.out.println("Exiting in this menu...");

                                break;
                            default:
                                System.out.println("Invalid choice. Try again.");
                        }

                        if (choice1 == 6) {
                            break;
                        }
                    }
                    break;
                    // 03.View a Crime category Details within a report;
                case 3:
                    CrimeCategories theftCategory = new CrimeCategories(1, "Theft", "This category includes crimes such as burglary, robbery, and shoplifting");
                    CrimeReports report1 = new CrimeReports(001, "Stolen car", "2024-02-11", "Dewmi Jayasooriya", "Open");

                    // Display menu for user to choose the action
                    while (true) {
                        System.out.println("Crime category Details within a report");
                        System.out.println("_______________________________________________________");
                        System.out.println("1. View Category Details");
                        System.out.println("2. Generate Crime Report");
                        System.out.println("3.Exit");
                        System.out.println("_______________________________________________________");
                        System.out.print("Choose an option:");
                        int choice2 = scanner.nextInt();

                        // Execute action based on user choice using switch case
                        switch (choice2) {
                            case 1:
                                theftCategory.viewCategoryDetails();
                                System.out.println("_______________________________________________________");
                                break;
                            case 2:
                                report1.generateCrimeReport();
                                System.out.println("_______________________________________________________");
                                break;
                            case 3:
                                System.out.println("Exiting in this menu...");
                                System.out.println("_______________________________________________________");

                                break;
                            default:
                                System.out.println("Invalid choice. Try again.");

                        }
                        if (choice2 == 3) {
                            break;
                        }
                    }
                    break ;
                    // 04.Add a Court case for system ;
                case 4:
                    CourtCase courtCase = new CourtCase("123456", new Date(), "Madusha Warnakulasooriya", "Lawyer Chalani", "Initial Verdict");
                    while (true) {
                        System.out.println("__Court case Main Menu__");
                        System.out.println("_______________________________________________________");
                        System.out.println("1.Displaying initial case details ");
                        System.out.println("2.Updating case details ");
                        System.out.println("3.Displaying updated case details");
                        System.out.println("4.Scheduling a new court date");
                        System.out.println("5. Providing a new verdict");
                        System.out.println("6.Displaying final case details");
                        System.out.println("7. Exit");
                        System.out.println("_______________________________________________________");
                        System.out.print("Enter your choice:");
                        int choice3 = scanner.nextInt();

                        switch (choice3) {
                            case 1:
                                // 1.Displaying initial case details
                                System.out.println("Initial Case Details:");
                                System.out.println(courtCase.getCaseDetails());
                                System.out.println("_______________________________________________________");
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
                                    System.out.println("_______________________________________________________");
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
                                System.out.println("_______________________________________________________");
                                break;
                            case 7:
                                System.out.println("Exiting in this menu...");
                                System.out.println("_______________________________________________________");

                                break;
                            default:
                                System.out.println("Invalid choice. Try again.");
                        }
                        if (choice3 == 7) {
                           break ;
                        }
                    }
                    break;
                case 5:
                    // Create an instance of Investigator
                    Investigator investigator = new Investigator("Mr.Perera", "Forensic Science", "Senior");

                    // Testing functional requirements
                    System.out.println("___Investigation Analysis and give a suspect details___");
                    String analysisResult = investigator.analyseCrimeScene();
                    System.out.println(analysisResult);

                    investigator.submitReport("CASE123", "This is the investigation report for CASE123.");

                    investigator.updateNewCases("CASE456");

                    List<String> assignedOfficers = new ArrayList<>();
                    assignedOfficers.add("Officer1");
                    assignedOfficers.add("Officer2");
                    investigator.assignCase("CASE789", assignedOfficers);
                    ConcreteSuspectManager suspectManager = new ConcreteSuspectManager();
                    while (true) {
                        System.out.println("___Suspect Details___");
                        System.out.println("_______________________________________________________");
                        System.out.println("1.Adding suspects");
                        System.out.println("2. Viewing suspects");
                        System.out.println("3.Updating status of a suspect ");
                        System.out.println("4..Arresting a suspect");
                        System.out.println("5.Viewing updated list of suspects");
                        System.out.println("6.Deleting a suspect");
                        System.out.println("7.Viewing final list of suspects ");
                        System.out.println("8. Exit");
                        System.out.println("_______________________________________________________");
                        System.out.print("Enter your choice:");
                        int choice4 = scanner.nextInt();

                        switch (choice4) {
                            case 1:
                                // 01.Adding suspects
                                suspectManager.addSuspect("123456789", "Nimal Perea", "Description 1");
                                suspectManager.addSuspect("987654321", "Nayana Hettiarachchi", "Description 2");
                                System.out.println("Added Successfully!");
                                System.out.println("_______________________________________________________");
                                break;
                            case 2:
                                //02. Viewing suspects
                                System.out.println("Initial List of Suspects:");
                                suspectManager.viewSuspects();
                                System.out.println("_______________________________________________________");
                                break;
                            case 3:
                                // 03.Updating status of a suspect
                                suspectManager.updateSuspectStatus("123456789", "Updated Status");
                                System.out.println("Update suspects Successfully!");
                                System.out.println("_______________________________________________________");
                                break;
                            case 4:
                                // 04.Arresting a suspect
                                suspectManager.arrestSuspect("987654321");
                                System.out.println("987654321 suspect id arrested");
                                System.out.println("_______________________________________________________");
                                break;
                            case 5:
                                //05. Viewing updated list of suspects
                                System.out.println("\nUpdated List of Suspects:");
                                suspectManager.viewSuspects();
                                System.out.println("_______________________________________________________");
                                break;
                            case 6:
                                // 06.Deleting a suspect
                                suspectManager.deleteSuspects("123456789");
                                System.out.println("Deleted suspect id 123456789");
                                break;
                            case 7:
                                // 07.Viewing final list of suspects
                                System.out.println("\nFinal List of Suspects:");
                                suspectManager.viewSuspects();
                                System.out.println("_______________________________________________________");
                            case 8:

                                System.out.println("Exiting in this menu...");
                                System.out.println("_______________________________________________________");
                                break;
                            default:
                                System.out.println("Invalid choice. Try again.");
                        }

                        if (choice4 == 8) {
                            break;
                        }
                    }

                    break;
                case 6:
                    System.out.println("Exiting in Main menu...");
                    System.out.println("_______________________________________________________");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");

            }
            }


        }
    }

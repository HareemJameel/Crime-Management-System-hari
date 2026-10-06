import java.util.ArrayList;
import java.util.List;

public class Investigator {

    // Data members
    private String name;
    private String specialization;
    private List<String> assignedCases;
    private String experienceLevel;

    // Constructor
    public Investigator(String name, String specialization, String experienceLevel) {

        this.name = name;
        this.specialization = specialization;
        this.experienceLevel = experienceLevel;
        this.assignedCases = new ArrayList<>();
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public List<String> getAssignedCases() {
        return assignedCases;
    }

    public String getExperienceLevel() {
        return experienceLevel;
    }

    //  Analyse Crime Scene
    public String analyseCrimeScene() {

        // For demonstration purposes, a simple message is returned.
        return "Observations based on crime scene analysis by Investigator " + name + ".";
    }

    //  Submit Report
    public void submitReport(String caseID, String report) {

        // For demonstration purposes, print the report.
        System.out.println("Report submitted for Case ID " + caseID + " by Investigator " + name + ":\n" + report);
    }

    // Update New Cases
    public void updateNewCases(String newCase) {
        // Logic to modify the assigned case attribute
        // For demonstration purposes, add the new case to the assigned cases list.
        assignedCases.add(newCase);
        System.out.println("Investigator " + name + " updated with a new case: " + newCase);
    }

    //  Assign Case
    public void assignCase(String caseID, List<String> policeOfficers) {
        // Logic to assign police officers and cases
        // For demonstration purposes, print the assigned case and officers.
        System.out.println("Case ID " + caseID + " assigned to Investigator " + name + ".");
        System.out.println("Police Officers assigned: " + policeOfficers);
    }


}

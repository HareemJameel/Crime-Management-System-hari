import java.util.List;
import java.util.ArrayList;


abstract class PoliceStation {
    //Create a data members of policeStation class
    String branch;
    int branchId;
    int contactNumber;
    private List<String> policeOfficers;
    CrimeRecord crime;

    //Make a constructor
    PoliceStation(String branch, int branchId, int contactNumber, List<String> policeOfficers) {
        this.branch = branch;
        this.branchId = branchId;
        this.contactNumber = contactNumber;
        this.policeOfficers = policeOfficers;


    }
    abstract  void registerCrime(CrimeRecord crime);
    abstract public void assignOfficers(CrimeRecord crime, List<String> officers);
    abstract void trackCaseProgress(CrimeRecord crime);
    abstract void generateReports(CrimeRecord crime);


}
 class CrimeDepartment extends PoliceStation{
        private List<CrimeRecord> CrimeRecords;

        // Constructor
        CrimeDepartment (String branch, int branchId, int contactInformation,
                              List<String> policeOfficers) {
            super(branch, branchId, contactInformation, policeOfficers);
            this.CrimeRecords = new ArrayList<>();
        }
        @Override
     public void registerCrime(CrimeRecord crime) {
         CrimeRecords.add(crime);
         System.out.println("Crime registered successfully. Case Number: " + crime.getCaseNumber());
     }
     @Override
     public void assignOfficers(CrimeRecord crime, List<String> officers) {
         // Find the corresponding CrimeRecord in the list
         for (CrimeRecord record : CrimeRecords) {
             if (record.getCaseNumber().equals(crime.getCaseNumber())) {
                 // Assign officers to the CrimeRecord
                 record.setAssignedOfficers(officers);
                 System.out.println("Officers assigned successfully to Case Number: " + crime.getCaseNumber());
                 return; // Exit the loop once the assignment is done
             }
         }
         // If the CrimeRecord is not found
         System.out.println("Error: Crime Record not found for Case Number: " + crime.getCaseNumber());
     }
     @Override
     public void trackCaseProgress(CrimeRecord crime) {
         // Find the corresponding CrimeRecord in the list
         for (CrimeRecord record : CrimeRecords) {
             if (record.getCaseNumber().equals(crime.getCaseNumber())) {
                 // Update the case progress status
                 record.setStatus("In Progress");
                 System.out.println("Case progress updated for Case Number: " + crime.getCaseNumber());
                 return; // Exit the loop once the update is done
             }
         }

         // If the CrimeRecord is not found

     }
     @Override
     public void generateReports(CrimeRecord crime) {

         for (CrimeRecord record : CrimeRecords) {
             if (record.getCaseNumber().equals(crime.getCaseNumber())) {
                 // Generate a report based on the CrimeRecord
                 String report = "Case Number: " + crime.getCaseNumber() +
                         "\nDate: " + crime.getDate() +
                         "\nLocation: " + crime.getLocation() +
                         "\nDescription: " + crime.getDescription() +
                         "\nStatus: " + crime.getStatus() +
                         "\nReport generated successfully.";
                 System.out.println(report);
                 return; // Exit the loop once the report is generated
             }
         }
         // If the CrimeRecord is not found
         System.out.println("Error: Crime Record not found for Case Number: " + crime.getCaseNumber());
     }


     public CrimeRecord searchCase(String caseNumber) {
         for (CrimeRecord record : CrimeRecords) {
             if (record.getCaseNumber().equals(caseNumber)) {
                 // Return the found CrimeRecord
                 return record;
             }
         }

         // If the CrimeRecord is not found
         System.out.println("Error: Crime Record not found for Case Number: " + caseNumber);
         return null;
     }

 }











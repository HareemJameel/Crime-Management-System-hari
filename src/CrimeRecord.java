import java.util.List;
import java.util.Date;

// CrimeRecord class definition
 class CrimeRecord {

   private String caseNumber;
   private String location;
   private String description;
   private String status;
    Date date;
    private List<String> assignedOfficers;


    CrimeRecord(){

}
    // Constructor
    public CrimeRecord(String caseNumber, Date date,String location, String description, String status) {
        this.caseNumber = caseNumber;
        this.date = date;
        this.location = location;
        this.description = description;
        this.status = status;
    }
//Getter and setter for Case Number
     String getCaseNumber() {
        return caseNumber;
    }
    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }
    //Getter and setter for Date
    public void setDate(){
        Date dateObj = new Date();
    }
     Date getDate(){
        return date;
    }
    //Getter and setter for location
     String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
//Getter and setter for Description
     String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
//Getter and setter for Status
     String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
        System.out.println(status);
    }

    // Getter and setter for assignedOfficers
    public List<String> getAssignedOfficers() {
        return assignedOfficers;
    }
    public void setAssignedOfficers(List<String> assignedOfficers) {
        this.assignedOfficers = assignedOfficers;
    }
}





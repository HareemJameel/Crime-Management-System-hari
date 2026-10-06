import java.util.Date;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

class PoliceOfficer {
    String name;
    int expetens;

    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
    private void setExpetens(int expetens){
        this.expetens=expetens;
    }

    public int getExpetens() {
        return expetens;
    }
}

class Witness {
}

class Evidence{
}

 class WitnessesEvidence extends PoliceOfficer{
    // Data Requirements
    String evidenceID;
    String description;
    PoliceOfficer collectedBy;
    String location;
    Witness Witness;
    Evidence associatedEvidence;

    // Constructor for WitnessesEvidence
    public WitnessesEvidence(String evidenceID, String description, PoliceOfficer collectedBy, String location, Witness Witness, Evidence associatedEvidence) {
        this.evidenceID = evidenceID;
        this.description = description;
        this.collectedBy = collectedBy;
        this.location = location;
        this.Witness = Witness;
        this.associatedEvidence = associatedEvidence;
    }
    private void setEvidenceID(String evidenceID){
        this.evidenceID=evidenceID;
    }

     public String getEvidenceID() {
         return evidenceID;
     }

     // Functional Requirement 1: getWitness

    public Witness getWitness() {
        return Witness;
    }

    // Functional Requirement 2: getEvidence
    public Evidence getEvidence() {
        return associatedEvidence;
    }

    // Functional Requirement 3: updateWitnessEvidence
    public void updateWitnessEvidence(String newDescription, String newLocation) {
        this.description = newDescription;
        this.location = newLocation;
    }

    // Functional Requirement 4: viewWitnessEvidence
    public void viewWitnessEvidence() {
        System.out.println("Witness Evidence Details:");
        System.out.println("Evidence ID: " + evidenceID);
        System.out.println("Description: " + description);
        // Assuming PoliceOfficer has getName() method
        System.out.println("Location: " + location);
        // Assuming Witness has getName() method
        // Assuming Evidence has getDescription() method
    }


}

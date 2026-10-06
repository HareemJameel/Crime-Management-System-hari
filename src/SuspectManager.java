import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Abstract SuspectManager class
public abstract class SuspectManager {

    // Data structure to store suspects
    protected List<Suspect> suspects;

    // Constructor
    public SuspectManager() {
        suspects = new ArrayList<>();
    }

    // Inner class representing a Suspect
    public static class Suspect {
        private String nationalID;
        private String name;
        private String description;
        private boolean arrested;

        // Constructor
        public Suspect(String nationalID, String name, String description) {
            this.nationalID = nationalID;
            this.name = name;
            this.description = description;
            this.arrested = false;
        }

        // Getters and Setters
        public String getNationalID() {
            return nationalID;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public boolean isArrested() {
            return arrested;
        }

        public void setArrested(boolean arrested) {
            this.arrested = arrested;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    // Abstract method to add a new suspect
    public abstract void addSuspect(String nationalID, String name, String description);

    // Functional Requirement 1: Marks the suspect as arrested
    public void arrestSuspect(String nationalID) {
        for (Suspect suspect : suspects) {
            if (suspect.getNationalID().equals(nationalID)) {
                suspect.setArrested(true);
                break;
            }
        }
    }

    // Functional Requirement 2: updateSuspectStatus
    public void updateSuspectStatus(String nationalID, String status) {
        for (Suspect suspect : suspects) {
            if (suspect.getNationalID().equals(nationalID)) {
                suspect.setDescription(status);
                break;
            }
        }
    }

    // Functional Requirement 3: viewSuspects
    public void viewSuspects() {
        for (Suspect suspect : suspects) {
            System.out.println("National ID: " + suspect.getNationalID());
            System.out.println("Name: " + suspect.getName());
            System.out.println("Description: " + suspect.getDescription());
            System.out.println("Arrested: " + (suspect.isArrested() ? "Yes" : "No"));
            System.out.println("-------------");
        }
    }

    // Functional Requirement 4: deleteSuspects
    public void deleteSuspects(String nationalID) {
        Iterator<Suspect> iterator = suspects.iterator();
        while (iterator.hasNext()) {
            Suspect suspect = iterator.next();
            if (suspect.getNationalID().equals(nationalID)) {
                iterator.remove();
                break;
            }
        }
    }
}
// Concrete implementation of SuspectManager
class ConcreteSuspectManager extends SuspectManager {

    // Concrete implementation of addSuspect
    @Override
    public void addSuspect(String nationalID, String name, String description) {
        Suspect newSuspect = new Suspect(nationalID, name, description);
        super.suspects.add(newSuspect);
    }
}

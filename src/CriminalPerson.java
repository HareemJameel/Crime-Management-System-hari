import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


    class CrimeRecord01 {

        String crimeType;
        Date crimeDate;
        // Constructor for CrimeRecord
        public CrimeRecord01(String crimeType, Date crimeDate) {
            this.crimeType = crimeType;
            this.crimeDate = crimeDate;
        }
    }

    class CriminalPerson {
        // Data Requirements
        String nationalID;
        String name;
        Date dateOfBirth;
        String address;
        int contactNumber;
        String gender;
        List<CrimeRecord01> criminalRecord;

        // Constructor for CriminalPerson
        public CriminalPerson(String nationalID, String name, Date dateOfBirth, String address, int contactNumber, String gender) {
            this.nationalID = nationalID;
            this.name = name;
            this.dateOfBirth = dateOfBirth;
            this.address = address;
            this.contactNumber = contactNumber;
            this.gender = gender;
            this.criminalRecord = new ArrayList<>();
        }
        private void setName(String name){
            this.name=name;
        }

        public String getName() {
            return name;
        }
        private void setNationalID(String nationalID){
            this.nationalID=nationalID;
        }

        public String getNationalID() {
            return nationalID;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getAddress() {
            return address;
        }

        public void setContactNumber(int contactNumber) {
            this.contactNumber = contactNumber;
        }

        public int getContactNumber() {
            return contactNumber;
        }

        public Date getDateOfBirth() {
            return dateOfBirth;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        // Functional Requirement 1: addCrimerecord
        public void addCrimeRecord(String crimeType, Date crimeDate) {
            CrimeRecord01 newCrimeRecord = new CrimeRecord01(crimeType, crimeDate);
            criminalRecord.add(newCrimeRecord);
            System.out.println("Criminal Person add successfully");
        }

        // Functional Requirement 2: viewCrimeHistory
        public void viewCrimeHistory() {
            System.out.println("Crime History for " + name + " (National ID: " + nationalID + "):");
            for (CrimeRecord01 record : criminalRecord) {
                System.out.println("Crime Type: " + record.crimeType + ", Date: " + record.crimeDate);
            }
        }

        // Functional Requirement 3: finalRecord
        public void finalRecord() {
            System.out.println("Final Report for " + name + " (National ID: " + nationalID + "):");
            // Display other information about the person if needed
            viewCrimeHistory(); // Display crime history
        }

        // Functional Requirement 4: searchPerson
        public static CriminalPerson searchPerson(List<CriminalPerson> personList, String nationalID) {
            for (CriminalPerson person : personList) {
                if (String.valueOf(person.getNationalID()).equals(String.valueOf(nationalID))) {
                    return person;
                }
            }
            return null;
        }

}

public class Booth {
    private int vaccineCount;
    private Patient people;
    private boolean patientadd;

    public Booth(int vaccineCount) {        //stock remain vaccine
        this.vaccineCount = vaccineCount;
        this.patientadd = false;
    }

    public Patient removePatient(){     //remove patient wh is in a booth
        this.patientadd = false;
        this.people = null;
        return getPatient();
    }

    public int getVaccineCount() {
        return vaccineCount;
    }

    public void setVaccineCount(int vaccineCount) {
        this.vaccineCount = vaccineCount;
    }

    public Patient getPatient() {
        return people;
    }

    public void setPatient(Patient patient) {
        this.people = patient;
        this.patientadd = true;
        this.vaccineCount--;
    }

    public boolean isPatientIn() {
        return patientadd;
    }

    @Override
    public String toString() {
        return "Booth{" +
                "vaccineCount=" + vaccineCount +
                ", patient=" + people +
                ", patientIn=" + patientadd +
                '}';
    }
}

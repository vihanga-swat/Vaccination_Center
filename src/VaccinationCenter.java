import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.*;

public class VaccinationCenter {
    public Booth[] booths;
    private LinkedList<Patient> waitingList;        //creat linked list as an array list


    public VaccinationCenter(){
        waitingList =  new LinkedList<>();
        booths = new Booth[6];
    }

    public void addPatientWaitingList(Patient patient){
        waitingList.add(patient);
    }       //add patient to the waiting list

    public void RemovePeople(int boothNumber){
        booths[boothNumber].removePatient();
        if (!waitingList.isEmpty()) {
            booths[boothNumber].setPatient(waitingList.removeFirst());
        }
    }

    public void AddPeople(Patient patient, int boothNum){
        booths[boothNum].setPatient(patient);
    }

    public void ShowAllBooths(){
        for (Booth booth: booths){
            System.out.println(booth);
        }
    }

    public void ViewEmpty(){
        for (Booth booth: booths) {
            if (!booth.isPatientIn()){
                System.out.println(booth);
            }
        }
    }

    public void PeopleSetupAlphabetical(){
        String[] patientsToSort = new String[waitingList.size()+6];
        int i = 0;
        for (Booth booth: booths){
            if (booth.getPatient() != null) {
                patientsToSort[i++] = booth.getPatient().getFirstName();
            } else {
                patientsToSort[i++] = "null";
            }
        }
        for (Patient patient: waitingList){
            if (patient != null) {
                patientsToSort[i++] = patient.getFirstName();
            } else {
                patientsToSort[i++] = "null";
            }
        }
        Arrays.sort(patientsToSort);
        System.out.println(Arrays.toString(patientsToSort));
    }

    public void Store() throws FileNotFoundException {
        Formatter file;
        file = new Formatter("src/saveData");
        Patient patient = booths[0].getPatient();
        for (int i = 0; i < booths.length; i++) {
            patient = booths[i].getPatient();
            if (patient != null) {
                file.format("%s%s%s%s%n", "Booth ", i, " occupied by ", patient.getFirstName());
                file.format("%s%s%n", "Surname : ", patient.getSurName());
                file.format("%s%s%n", "Age     : ", patient.getAge());
                file.format("%s%s%n", "City    : ", patient.getCity());
                file.format("%s%s%n", "NIC     : ", patient.getNic());
                file.format("%s%s%n", "Vaccine Type : ", patient.getVaccinationType());
                file.format("%s%n", "**************************************");
            }
        }
        file.format("%s%n","-------------------------------");
        for (int i = 0; i < booths.length; i++) {
            file.format("%s%s%s%s%n","Remaining Vaccine Count in Booth Number ",i," : ",booths[i].getVaccineCount());
        }
        file.close();
    }

    public void Load() throws FileNotFoundException {
        File storedData = new File("src/saveData");
        Scanner read = new Scanner(storedData);
        while (read.hasNext()) {
            String Data = read.nextLine();
            System.out.println(Data);
        }
        read.close();
    }

    public int AlertVaccinations(int boothNum){
        return booths[boothNum].getVaccineCount();
    }

    public void AddStock(int boothNum,int vaccineCount){
        booths[boothNum].setVaccineCount(vaccineCount);
    }

    public boolean boothsFull(){
        for (Booth booth: booths) {
            if (!booth.isPatientIn()){
                return false;
            }
        }
        return true;
    }
}

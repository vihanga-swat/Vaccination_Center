import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static Scanner inputChoice=new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException {
        VaccinationCenter vaccinationCenter = new VaccinationCenter();
        Boolean programRunPart=true;

        System.out.println("....................Vaccine Center..........................");
        System.out.println();
        for (int i = 0; i < 6; i++){
            System.out.print("Enter number of vaccines have in a booth number " + i +" - ");
            int vaccineCount = checkinteger();
            Booth booth = new Booth(vaccineCount);
            vaccinationCenter.booths[i] = booth;
        }
//ask from user for input selection
        while(programRunPart){      //run while user enter 'EXT' or '999'

            System.out.println("*************************************************************************");
            System.out.println("Enter '100' or 'VVB' to View all Booths");
            System.out.println("Enter '101' or 'VEB' to View all Empty Booths");
            System.out.println("Enter '102' or 'APB' to Add Patient");
            System.out.println("Enter '103' or 'RPB' to Remove Patient");
            System.out.println("Enter '104' or 'VPS' to Sort Patients in alphabetical order");
            System.out.println("Enter '105' or 'SPD' to Store Data into program");
            System.out.println("Enter '106' or 'LPD' to Load stored Data from program");
            System.out.println("Enter '107' or 'VRV' to View Remaining vaccines");
            System.out.println("Enter '108' or 'AVS' to stock new vaccinations");
            System.out.println("Enter '999' or 'EXT' to Exit from the Program !");
            System.out.println("*************************************************************************");
            System.out.print("What is your requirement :- ");   //get users choice
            String controlInput=inputChoice.nextLine().toUpperCase(Locale.ROOT);

            //call functions when user inputs their choice
            //when user input an value it will call suitable function among below
            if ("VVB".equals(controlInput) || "100".equals(controlInput)) {
                vaccinationCenter.ShowAllBooths();//when user inputs 'VVB' or '100' it will call to this function
            } else if ("VEB".equals(controlInput) || "101".equals(controlInput)) {
                vaccinationCenter.ViewEmpty();//when user inputs 'VEB' or '101' it will call to this function
            } else if ("APB".equals(controlInput) || "102".equals(controlInput)) {
                Patient patient = createpeople();
                if (vaccinationCenter.boothsFull()){
                    vaccinationCenter.addPatientWaitingList(patient);
                }else {
                    System.out.print("Enter booth number : ");
                    int boothNumber = checkinteger();
                    vaccinationCenter.AddPeople(patient, boothNumber);//when user inputs 'APB' or '102' it will call to this function
                    System.out.println();
                    System.out.println(patient.getFirstName()+" is added to "+boothNumber+" booth");
                    System.out.println();
                }
            } else if ("RPB".equals(controlInput) || "103".equals(controlInput)) {
                System.out.print("Enter booth number : ");
                int boothNumber = checkinteger();
                vaccinationCenter.RemovePeople(boothNumber);//when user inputs 'RPB' or '103' it will call to this function
                System.out.println();
                System.out.println("Patient Removed Successfully ! ");
                System.out.println();
            } else if ("VPS".equals(controlInput) || "104".equals(controlInput)) {
                vaccinationCenter.PeopleSetupAlphabetical();//when user inputs 'VPS' or '104' it will call to this function
            } else if ("SPD".equals(controlInput) || "105".equals(controlInput)) {
                vaccinationCenter.Store();//when user inputs 'SPD' or '105' it will call to this function
            } else if ("LPD".equals(controlInput) || "106".equals(controlInput)) {
                vaccinationCenter.Load();//when user inputs 'LPD' or '106' it will call to this function
            } else if ("VRV".equals(controlInput) || "107".equals(controlInput)) {
                System.out.print("Enter the booth number : ");
                int boothNumber = checkinteger();//when user inputs 'VRV' or '107' it will call to this function
                System.out.println(vaccinationCenter.AlertVaccinations(boothNumber));
            } else if ("AVS".equals(controlInput) || "108".equals(controlInput)) {
                System.out.print("Enter the booth number : ");
                int boothNumber = checkinteger();
                System.out.print("Enter the vaccination new vaccination count: ");
                int vaccinateCount = checkinteger();
                vaccinationCenter.AddStock(boothNumber, vaccinateCount);//when user inputs 'AVS' or '108' it will call to this function
            } else if ("EXT".equals(controlInput) || "999".equals(controlInput)) {
                programRunPart = false;//when user inputs 'EXT' or '999' it will call to this function
            }
        }
    }

    private static Patient createpeople(){  //creat patient details
        System.out.print("Please Enter Patients' First Name: ");
        String firstName = inputChoice.next();      //ask firstname
        System.out.print("Please Enter Patients' Last Name: ");
        String lastname = inputChoice.next();   //ask last name
        System.out.print("Enter patients' age : ");
        int age = inputChoice.nextInt();        //ask age
        System.out.print("Enter your City : ");
        String city = inputChoice.next();       //ask about city
        System.out.print("Enter Patients' NIC/Passport : ");
        String nicpass = inputChoice.next();        //ask NIC number
        System.out.println("Which vaccine do you need? (1.AstraZeneca  2.Pfizer  3.Scinopharm)");
        String vaccine = inputChoice.next();        //ask vaccine that patient vaccined

        return new Patient(firstName, lastname, age, city, nicpass, vaccine);       //return got values to the creat people method
    }

    private static int checkinteger(){      //check necessary input
        while(!inputChoice.hasNextInt()){
            System.out.print("Invalid Input !\nEnter an Integer ! - ");     //when user enter an string for integer value this massage will print
            inputChoice.next();
        }
        return inputChoice.nextInt();
    }

    private static boolean isBooth(int value){
        return 0 <= value && value<6;
    }
}

public class Patient {      //store patient details
    private String firstName;
    private String surName;
    private int age;
    private String city;
    private String nic;
    private String vaccinationType;

    public Patient(String firstName, String lastname, int age, String city, String nic, String vaccinationType) {
        this.firstName = firstName;
        this.surName = lastname;
        this.age = age;
        this.city = city;
        this.nic = nic;
        this.vaccinationType = vaccinationType;
    }

    public String getFirstName() {
        return firstName;
    }       //store firstname

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }       //store last name

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }       //store age

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }       //store city that entered

    public void setCity(String city) {
        this.city = city;
    }

    public String getNic() {
        return nic;
    }       //store nic number

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getVaccinationType() {
        return vaccinationType;
    }       //store vaccination type

    public void setVaccinationType(String vaccinationType) {
        this.vaccinationType = vaccinationType;
    }

    @Override
    public String toString() {
        return "Patient{" + "firstName='" + firstName + '\'' + ", surName='" + surName + '\'' + ", age=" + age + ", city='" + city + '\'' + ", nic='" + nic + '\'' + ", vaccinationType='" + vaccinationType + '\'' + '}';
    }
}
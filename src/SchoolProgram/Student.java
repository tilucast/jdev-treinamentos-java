package SchoolProgram;

import java.util.*;
import java.util.stream.Collectors;

public class Student {

    //fields, atrributes

    private String name;
    private int age;
    private String dateOfBirth;
    private String SSN;
    private String motherName;
    private String fatherName;
    private Date dateEnrollment;
    private double average;
    private List<Subject> subjects = new ArrayList();

    Student(){
        name = "Lulio";
        age = 15;
        dateOfBirth = "12-09-1967";
        SSN = "2844657";
        motherName = "Lulia";
        fatherName = "Lulião";
        dateEnrollment = new Date();
    }

    Student(String name, int age, String dateOfBirth, String SSN, String motherName, String fatherName){
        this.name = name;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.SSN = SSN;
        this.motherName = motherName;
        this.fatherName = fatherName;
        dateEnrollment = new Date();

        HandleListOfSubjects.populate(subjects);
        calculateAverage();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public Date getDateEnrollment() {
        return dateEnrollment;
    }

    public void setDateEnrollment(Date dateEnrollment) {
        this.dateEnrollment = dateEnrollment;
    }

    public List<Subject> getSubjects(){
        return subjects;
    }

    public void setSubjects(List<Subject> subjects){
        this.subjects = subjects;
    }

    public double getAverage(){
        return average;
    }

    public boolean isApproved(){
        return average >= 3.5;
    }

    private void calculateAverage(){
//        average =  subjects.stream().mapToDouble(n -> n.getScore()).average().orElse(Double.MIN_VALUE);

        //either of these yields to the same result. But apparently, average is using some sort of reduction under the hood.

        average = subjects.stream().reduce(0.0, (acc, subject) -> acc + subject.getScore(), Double::sum) / subjects.size();
    }

    @Override
    public String toString() {
        return "Student{\n" +
                " name='" + name + '\'' +
                ",\n age=" + age +
                ",\n dateOfBirth='" + dateOfBirth + '\'' +
                ",\n SSN='" + SSN + '\'' +
                ",\n motherName='" + motherName + '\'' +
                ",\n fatherName='" + fatherName + '\'' +
                ",\n dateEnrollment=" + dateEnrollment +
                ",\n average=" + average + '\'' +
                ",\n subjects=" + subjects + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Double.compare(student.average, average) == 0 && name.equals(student.name) && dateOfBirth.equals(student.dateOfBirth) && SSN.equals(student.SSN) && motherName.equals(student.motherName) && fatherName.equals(student.fatherName) && dateEnrollment.equals(student.dateEnrollment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, dateOfBirth, SSN, motherName, fatherName, dateEnrollment, average);
    }
}

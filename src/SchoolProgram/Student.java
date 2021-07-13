package SchoolProgram;

import java.util.*;
import java.util.stream.Collectors;

public class Student extends Person{

    //fields, atrributes

    private Date dateEnrollment;
    private double average;
    private List<Subject> subjects = new ArrayList();
    private String studentStatus;

    Student(){
        super("Lulio", 15, "12-09-1967", "2844657", "Lulia", "Lulião");
        dateEnrollment = new Date();

        //HandleListOfSubjects.populate(subjects);
        calculateAverage();
    }

    Student(String name, int age){
        super(name, age, "12-09-1967", "2844657", "Lulia", "Lulião");
        dateEnrollment = new Date();

        //HandleListOfSubjects.populate(subjects);
        calculateAverage();
    }

    Student(String name){
        super(name, 15, "12-09-1967", "2844657", "Lulia", "Lulião");
        dateEnrollment = new Date();

        //HandleListOfSubjects.populate(subjects);
        calculateAverage();
    }

    Student(String name, int age, String dateOfBirth, String SSN, String motherName, String fatherName){
        super(name, age, dateOfBirth, SSN, motherName, fatherName);

        //HandleListOfSubjects.populate(subjects);
        calculateAverage();
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

    private void calculateAverage(){
//        either of these yields to the same result. Apparently, average is using some sort of reduction under the hood.

//        average =  subjects.stream().mapToDouble(n -> n.getScore()).average().orElse(Double.MIN_VALUE);

        Double x = subjects.stream().reduce(0.0, (acc, subject) -> acc + subject.getAverage(), Double::sum) / subjects.size();
        average = x.isNaN() ? 0.0 : x;
        setStudentStatus();
    }

    public String getStudentStatus(){
        return studentStatus;
    }

    private void setStudentStatus(){
        double studentavg = this.average;

        if(studentavg >= 3 && studentavg < 3.5){
            studentStatus = STUDENT_STATUS.ON_SUMMER_SCHOOL;
        } else if(studentavg >= 3.5){
            studentStatus = STUDENT_STATUS.APPROVED;
        } else{
            studentStatus = STUDENT_STATUS.REPROVED;
        }
    }

    @Override
    public String toString() {
        return "Student{\n" +
                " name='" + super.getName() + '\'' +
                ",\n age=" + super.getAge() +
                ",\n dateOfBirth='" + super.getDateOfBirth() + '\'' +
                ",\n SSN='" + super.getSSN() + '\'' +
                ",\n motherName='" + super.getMotherName() + '\'' +
                ",\n fatherName='" + super.getFatherName() + '\'' +
                ",\n dateEnrollment=" + dateEnrollment +
                ",\n average=" + average +
                ",\n subjects=" + subjects +
                ",\n status=" + studentStatus + '\'' +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return super.getAge() == student.getAge() && Double.compare(student.average, average) == 0 && super.getName().equals(student.getName()) && super.getDateOfBirth().equals(student.getDateOfBirth()) && super.getSSN().equals(student.getSSN()) && super.getMotherName().equals(student.getMotherName()) && super.getFatherName().equals(student.getFatherName()) && dateEnrollment.equals(student.dateEnrollment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getName(), super.getAge(), super.getDateOfBirth(), super.getSSN(), super.getMotherName(), super.getFatherName(), dateEnrollment, average);
    }

    @Override
    public void doExists(){
        System.out.println("I am a student.");
    }
}

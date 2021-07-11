package SchoolProgram;

import java.util.Objects;

public abstract class Person {

    private String name;
    private int age;
    private String dateOfBirth;
    private String SSN;
    private String motherName;
    private String fatherName;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name) && dateOfBirth.equals(person.dateOfBirth) && SSN.equals(person.SSN) && motherName.equals(person.motherName) && fatherName.equals(person.fatherName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, dateOfBirth, SSN, motherName, fatherName);
    }
}

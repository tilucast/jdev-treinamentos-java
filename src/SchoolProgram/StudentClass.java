package SchoolProgram;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentClass {

    private List<Student> students = new ArrayList();

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void populate(){
        String size = JOptionPane.showInputDialog("How many students do you want to create?");
        for (int i = 0; i < Integer.parseInt(size); i++) {

            String name = JOptionPane.showInputDialog("Student name: ");
            int age = Integer.parseInt(JOptionPane.showInputDialog("Student age: "));
            String dateOfBirth = JOptionPane.showInputDialog("Student date of birth: ");
            String SSN = JOptionPane.showInputDialog("Student SSN");
            String motherName=  JOptionPane.showInputDialog("Student's mother's name");
            String fatherName=  JOptionPane.showInputDialog("Student's father's name");

            Student student = new Student(name, age, dateOfBirth, SSN, motherName, fatherName);
            students.add(student);
        }
    }

    public Student find(){
        String studentName = JOptionPane.showInputDialog("Search for a student by name: ");

        Student found = students.stream().filter(student -> student.getName().equalsIgnoreCase(studentName)).findAny().orElse(null);

        return found;
    }

    public void remove(){
        students.remove(this.find());
    }

    @Override
    public String toString() {
        return "" +
                "students=" + students +
                "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentClass that = (StudentClass) o;
        return students.equals(that.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(students);
    }
}

package SchoolProgram;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class StudentClass {

    private List<Student> students = new ArrayList();
    private HashMap<String, List<Student>> studentMap = new HashMap();

    StudentClass(){
        studentMap.put(STUDENT_STATUS.APPROVED, new ArrayList<Student>());
        studentMap.put(STUDENT_STATUS.REPROVED, new ArrayList<Student>());
        studentMap.put(STUDENT_STATUS.ON_SUMMER_SCHOOL, new ArrayList<Student>());
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public HashMap<String, List<Student>> getStudentMap() {
        return studentMap;
    }

    private void setStudentMap(HashMap<String, List<Student>> studentMap){
        this.studentMap = studentMap;
    }

    public void populate(){
        String size = JOptionPane.showInputDialog("How many students do you want to create?");
        for (int i = 0; i < Integer.parseInt(size); i++) {

            String name = JOptionPane.showInputDialog("Student name: ");
//            int age = Integer.parseInt(JOptionPane.showInputDialog("Student age: "));
//            String dateOfBirth = JOptionPane.showInputDialog("Student date of birth: ");
//            String SSN = JOptionPane.showInputDialog("Student SSN");
//            String motherName=  JOptionPane.showInputDialog("Student's mother's name");
//            String fatherName=  JOptionPane.showInputDialog("Student's father's name");
//
//            Student student = new Student(name, age, dateOfBirth, SSN, motherName, fatherName);
            Student student = new Student(name);
            students.add(student);
        }

        sort();
    }

    public Student find(){
        String studentName = JOptionPane.showInputDialog("Search for a student by name: ");

        Student found = students.stream().filter(student -> student.getName().equalsIgnoreCase(studentName)).findAny().orElse(null);

        return found;
    }

    public void remove(){
        students.remove(this.find());
    }


    // ----------

    //Both implementations of 'sort()' sort the students according to their averages.

    // The first is more flexible, being able to be called alone, using a forEach to sort the students.

    // The second one receives a Student object. Which would requires either a new instance of a Student, using find() to get a Student, or being called inside a list of students iteration.

    private void sort(){
        students.stream().forEach(student -> {
            switch(student.getStudentStatus()){
                case STUDENT_STATUS.APPROVED: studentMap.get(STUDENT_STATUS.APPROVED).add(student);
                    break;
                case STUDENT_STATUS.ON_SUMMER_SCHOOL: studentMap.get(STUDENT_STATUS.ON_SUMMER_SCHOOL).add(student);
                    break;
                default: studentMap.get(STUDENT_STATUS.REPROVED).add(student);
            }
        });
    }

    private void sort(Student student){
        switch(student.getStudentStatus()){
            case STUDENT_STATUS.APPROVED: studentMap.get(STUDENT_STATUS.APPROVED).add(student);
                break;
            case STUDENT_STATUS.ON_SUMMER_SCHOOL: studentMap.get(STUDENT_STATUS.ON_SUMMER_SCHOOL).add(student);
                break;
            default: studentMap.get(STUDENT_STATUS.REPROVED).add(student);
        }
    }

    // -------------


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

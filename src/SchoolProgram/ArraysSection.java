package SchoolProgram;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class ArraysSection {

    public static void main(String[] args) {

//        Student student = new Student("Dickus");
//        Student student1 = new Student("Biggus");
//        Student student2 = new Student("Incontinentia");
//        Student student3 = new Student("Naughtius");
//        Student[] students = {student, student1, student2, student3};
//
//        for (int i = 0; i < students.length; i++) {
//            System.out.println(students[i].getName());
//
//            for (Subject subj: students[i].getSubjects()) {
//                System.out.println(subj.getSubject());
//            }
//        }


        double[][] matrix = new double[2][3];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Math.ceil(Math.random() * 20);
            }
                //System.out.println(Arrays.toString(matrix[i]));
        }

        String sometext = "herro iam rundy adoube";
        String[] x = sometext.split(" ");

        List<String> xtolist = Arrays.asList(x);
        xtolist.forEach(System.out::println);
        String[] xtoarray = xtolist.toArray(new String[0]);
    }
}
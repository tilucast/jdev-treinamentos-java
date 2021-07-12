package SchoolProgram;

import SchoolProgram.Interfaces.AuthorizeAccess;
import SchoolProgram.utils.Authenticate;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

//        StudentClass studentclass = new StudentClass();
//        studentclass.populate();
//        System.out.println(studentclass.getStudentMap());

//        Person[] people = {new Student("Junior"), new Principal("Sir"), new Secretary("5aabc")};
//
//        for (Person person : people) {
//            person.doExists();
//        }

        AuthorizeAccess principal = new Principal("Sir");

        String login = JOptionPane.showInputDialog("Type the login: ");
        String password = JOptionPane.showInputDialog("Type the password: ");

//        if(!new Authenticate(principal).authenticate(login, password)){
//            System.out.println("Not authorized");
//            return;
//        }

        if(!principal.authenticate(login, password)){
            System.out.println("Not authorized.");
            return;
        }

        System.out.println("Private area");
    }
}

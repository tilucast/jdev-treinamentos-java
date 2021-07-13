package SchoolProgram;

import javax.swing.*;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

abstract public class HandleListOfSubjects {

    static public void populate(List<Subject> subjects){
        int size = Integer.parseInt(
                JOptionPane.showInputDialog("Type the number of subjects: "));

        for (int i = 0; i < size; i++) {

            Subject subject = new Subject();
            subjects.add(subject);
            subject.setSubject(JOptionPane.showInputDialog("Type the subject: "));

            for (int i1 = 0; i1 < subject.getScores().length; i1++) {
                double score = Double.parseDouble(JOptionPane.showInputDialog("Type the score (1-5)"));
                subject.setScore(i1, score);
            }

            subject.setAverage();

        }
    }

    static public void delete(List<Subject> subjects){
        //Neither of these implementations are actually handling any kind of errors.


        String toDelete = JOptionPane.showInputDialog("Name of the subject you want to delete: ");


        //The implementation below modifies the list in place. Change the return type to match the implementation preferred;
        subjects.remove(subjects.stream().filter(subj -> subj.getSubject().equalsIgnoreCase(toDelete)).findAny().orElse(null));


        //The implementation below returns a new modified list.
        //return subjects.stream().filter(subj -> !subj.getSubject().equalsIgnoreCase(toDelete)).collect(Collectors.toList());
    }

    //this method shouldn't exist, but anyways.
    // Also, this method modifies the param in place, which differs from the one above.
    static public void deleteMany(List<Subject> subjects){
        String option = JOptionPane.showInputDialog("1 - Delete a subject, 0 - exit.");

        while(Integer.parseInt(option) != 0){
            String toDelete = JOptionPane.showInputDialog("Name of the subject you want to delete: ");

            Iterator itr = subjects.iterator();

            while(itr.hasNext()){
                Subject x = (Subject) itr.next();
                if(x.getSubject().equals(toDelete)){
                    itr.remove();
                }
            }

            option = JOptionPane.showInputDialog("1 - Delete a subject, 0 - exit.");
        }
    }
}

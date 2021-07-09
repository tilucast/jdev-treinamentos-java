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
            subjects.add(new Subject());
            Subject subject = subjects.get(i);
            subject.setSubject(JOptionPane.showInputDialog("Type the subject: "));
            subject.setScore(
                    Double.parseDouble(JOptionPane.showInputDialog("Type the score (1-5)"))
            );
        }
    }

    static public List<Subject> delete(List<Subject> subjects){
        String toDelete = JOptionPane.showInputDialog("Name of the subject you want to delete: ");
        return subjects.stream().filter(subj -> !subj.getSubject().equals(toDelete)).collect(Collectors.toList());
    }

    //this method shouldn't exist, but anyways.
    // Also, this method modifies the param in place. Which differs from the two above.
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

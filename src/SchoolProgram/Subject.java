package SchoolProgram;

import javax.swing.*;
import java.util.Arrays;

public class Subject {

    private double[] scores = {0,0,0,0};
    private String[] subjects = {"","","",""};

    public void setScoresAndSubjects(){
        for (int i = 0; i < scores.length; i++) {
            subjects[i] = JOptionPane.showInputDialog("Type the subject name: ");

            scores[i] = Double.parseDouble(JOptionPane.showInputDialog("Type the score (1-5): "));
        }
    }

    public double[] getScores() {
        return scores;
    }

    public String[] getSubjects() {
        return subjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Arrays.equals(scores, subject.scores) && Arrays.equals(subjects, subject.subjects);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(scores);
        result = 31 * result + Arrays.hashCode(subjects);
        return result;
    }

    @Override
    public String toString() {
        return "Subject{\n" +
                " scores=" + Arrays.toString(scores) +
                ",\n subjects=" + Arrays.toString(subjects) +
                "}";
    }
}

package SchoolProgram;

import java.util.Arrays;
import java.util.Objects;

public class Subject {

    private double scores[] = new double[4];
    private String subject;
    private double average;

    Subject(){

    }

    Subject(double[] scores, String subject){
        this.scores = scores;
        this.subject = subject;
    }

    public double[] getScores() {
        return scores;
    }

    public void setScores(double[] scores) {
        this.scores = scores;
    }

    public void setScore(int index, double value){
        scores[index] = value;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getAverage(){
        return average;
    }

    public void setAverage(){
        average = Arrays.stream(scores).average().orElse(Double.MIN_VALUE);
    }

    @Override
    public String toString() {
        return "{" +
                "\n    scores=" + Arrays.toString(scores) +
                ",\n    subject='" + subject + '\'' +
                ",\n    average='" + average + '\'' +
                "\n}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject1 = (Subject) o;
        return Arrays.equals(scores, subject1.scores) && subject.equals(subject1.subject);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(subject);
        result = 31 * result + Arrays.hashCode(scores);
        return result;
    }
}
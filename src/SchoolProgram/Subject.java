package SchoolProgram;

import java.util.Objects;

public class Subject {

    private double score;
    private String subject;

    Subject(){

    }

    Subject(double score, String subject){
        this.score = score;
        this.subject = subject;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "{" +
                "\n    score=" + score +
                ",\n    subject='" + subject + '\'' +
                "\n}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject1 = (Subject) o;
        return Double.compare(subject1.score, score) == 0 && subject.equals(subject1.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, subject);
    }
}

package SchoolProgram;

import java.util.Objects;

public class Principal extends Person{

    private String directorCertificateRegistry;
    private double timeBeingADirector;
    private String Title;

    public String getDirectorCertificateRegistry() {
        return directorCertificateRegistry;
    }

    public void setDirectorCertificateRegistry(String directorCertificateRegistry) {
        this.directorCertificateRegistry = directorCertificateRegistry;
    }

    public double getTimeBeingADirector() {
        return timeBeingADirector;
    }

    public void setTimeBeingADirector(double timeBeingADirector) {
        this.timeBeingADirector = timeBeingADirector;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    @Override
    public String toString() {
        return "Principal{\n" +
                " directorCertificateRegistry='" + directorCertificateRegistry + '\'' +
                ",\n timeBeingADirector=" + timeBeingADirector +
                ",\n Title='" + Title + '\'' +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Principal principal = (Principal) o;
        return Double.compare(principal.timeBeingADirector, timeBeingADirector) == 0 && directorCertificateRegistry.equals(principal.directorCertificateRegistry) && Title.equals(principal.Title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), directorCertificateRegistry, timeBeingADirector, Title);
    }
}

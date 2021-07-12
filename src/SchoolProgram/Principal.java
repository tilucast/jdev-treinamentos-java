package SchoolProgram;

import SchoolProgram.Interfaces.AuthorizeAccess;

import java.util.Objects;

public class Principal extends Person implements AuthorizeAccess {

    private String directorCertificateRegistry;
    private double timeBeingADirector;
    private String title;

    Principal(String title){
        directorCertificateRegistry = "549aabc";
        timeBeingADirector = 5.5;
        this.title = title;
    }

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
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Principal{\n" +
                " directorCertificateRegistry='" + directorCertificateRegistry + '\'' +
                ",\n timeBeingADirector=" + timeBeingADirector +
                ",\n Title='" + title + '\'' +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Principal principal = (Principal) o;
        return Double.compare(principal.timeBeingADirector, timeBeingADirector) == 0 && directorCertificateRegistry.equals(principal.directorCertificateRegistry) && title.equals(principal.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), directorCertificateRegistry, timeBeingADirector, title);
    }

    @Override
    public void doExists(){
        System.out.println("I am a principal.");
    }

    @Override
    public boolean authenticate() {
        return true;
    }

    @Override
    public boolean authenticate(String login, String password) {
        return login.equals("admin") && password.equals("admin");
    }
}

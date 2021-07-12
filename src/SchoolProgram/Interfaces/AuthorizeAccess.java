package SchoolProgram.Interfaces;

public interface AuthorizeAccess {

    boolean authenticate();
    boolean authenticate(String login, String password);
}

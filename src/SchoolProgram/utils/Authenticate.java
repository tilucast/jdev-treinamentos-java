package SchoolProgram.utils;

import SchoolProgram.Interfaces.AuthorizeAccess;

// I'm still not sold on this pattern tho.

public class Authenticate {

    private AuthorizeAccess access;

    public Authenticate(AuthorizeAccess access){
        this.access = access;
    }

    public boolean authenticate(){
        return access.authenticate();
    }

    public boolean authenticate(String login, String password){
        return access.authenticate(login, password);
    }
}

package SchoolProgram;

import SchoolProgram.Interfaces.AuthorizeAccess;

import java.util.Objects;

public class Secretary extends Person implements AuthorizeAccess {

    private String registry;
    private String rankingLevel;
    private String experience;

    Secretary(String registry){
        this.registry = registry;
        rankingLevel = "5th";
        experience = "senior";
    }

    public String getRegistry() {
        return registry;
    }

    public void setRegistry(String registry) {
        this.registry = registry;
    }

    public String getRankingLevel() {
        return rankingLevel;
    }

    public void setRankingLevel(String rankingLevel) {
        this.rankingLevel = rankingLevel;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Secretary{\n" +
                " registry='" + registry + '\'' +
                ",\n rankingLevel='" + rankingLevel + '\'' +
                ",\n Experience='" + experience + '\'' +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Secretary secretary = (Secretary) o;
        return registry.equals(secretary.registry) && rankingLevel.equals(secretary.rankingLevel) && experience.equals(secretary.experience);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), registry, rankingLevel, experience);
    }

    @Override
    public void doExists(){
        System.out.println("I am a secretary.");
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

package SchoolProgram;

import java.util.Objects;

public class Secretary extends Person{

    private String registry;
    private String rankingLevel;
    private String Experience;

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
        return Experience;
    }

    public void setExperience(String experience) {
        Experience = experience;
    }

    @Override
    public String toString() {
        return "Secretary{\n" +
                " registry='" + registry + '\'' +
                ",\n rankingLevel='" + rankingLevel + '\'' +
                ",\n Experience='" + Experience + '\'' +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Secretary secretary = (Secretary) o;
        return registry.equals(secretary.registry) && rankingLevel.equals(secretary.rankingLevel) && Experience.equals(secretary.Experience);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), registry, rankingLevel, Experience);
    }
}

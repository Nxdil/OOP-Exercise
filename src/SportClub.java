import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Nadil on 01.07.2021
 * This class is responsible for keeping track
 * of the Cricket team name and the leader of the Cricket
 * team.
 */
public abstract class SportClub implements Serializable {
    private String teamName;            //  Name of the cricket team.
    private String teamLeader;          //  Name of the Cricket captain.


    /**
     * Constructor of the class with parameters teamName and teamLeader
     * @param teamName the name of the Cricket team
     * @param teamLeader the name of the Cricket captain.
     */
    public SportClub(String teamName, String teamLeader) {
        this.teamName = teamName;
        this.teamLeader = teamLeader;
    }

    /**
     * Default constructor for creating an
     * object without params.
     */
    public SportClub() {
    }

    public String getDescription() {
        return  teamName + " cricket club is being led by " + teamLeader;
    }


    @Override
    public String toString() {
        return "SportClub{" +
                "teamName='" + teamName + '\'' +
                ", teamLeader='" + teamLeader + '\'' +
                '}';
    }

    // Checks if two objects are equal to one another.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SportClub)) return false;
        SportClub sportClub = (SportClub) o;
        return Objects.equals(teamName, sportClub.teamName) &&
                Objects.equals(teamLeader, sportClub.teamLeader);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamName, teamLeader);
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }


    public String getTeamLeader() {
        return teamLeader;
    }

    public void setTeamLeader(String teamLeader) {
        this.teamLeader = teamLeader;
    }
}

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Nadil on 01.07.2021
 * This class is responsible for keeping track
 * of the Cricket team wins, losses, draws and club points.
 * This class inherits properties of the SportClub super class.
 */

public class CricketClub extends SportClub implements Serializable{
    private int seasonWins;             //  Number of wins.
    private int seasonDraws;            //  Number of Draws.
    private int seasonDefeats;          //  Number of Defeats.
    private int goalsScored;            //  Number of goals scored.
    private int currentClubScore;       //  The number of points that a club currently has.
    private int noOfMatchesPlayed;      //  The number of matches played should also be included.


    /**
     * Default constructor for creating an
     * object without params.
     */
    public CricketClub() {

    }
    /**
     * Constructor is overloaded.
     * The variables are inherited from
     * Super class SportClub.
     * @param teamName the name of the Cricket team.
     * @param teamLeader the name of the cricket captain.
     */
    public CricketClub(String teamName, String teamLeader) {
        super(teamName, teamLeader);
    }

    /**
     * Overloaded constructor.
     * Creates a new CricketClub object with parameters.
     * @param seasonWins Total number of Season wins
     * @param seasonDraws Total number of Season draws
     * @param seasonDefeats Total number of Season defeats
     * @param goalsScored Total number of season goals
     * @param currentClubScore Total number of points the club has
     * @param noOfMatchesPlayed Total number of matches played in the season
     */
    public CricketClub(int seasonWins, int seasonDraws, int seasonDefeats, int goalsScored, int currentClubScore, int noOfMatchesPlayed) {
        this.seasonWins = seasonWins;
        this.seasonDraws = seasonDraws;
        this.seasonDefeats = seasonDefeats;
        this.goalsScored = goalsScored;
        this.currentClubScore = currentClubScore;
        this.noOfMatchesPlayed = noOfMatchesPlayed;
    }

    /**
     * getDescription method of the SportsClub superclass has been overridden to include details specific to
     * the CricketClub class.
     */
    @Override
    public String getDescription() {
        // Get description from super class using team name and team leader
        String result = super.getDescription();

        // Update results with CricketClub specific results
        result += "The team was able to get " + seasonWins + " season wins, " + seasonDraws + " season draws and " +
                seasonDefeats + " season defeats while scoring a total of " + goalsScored + " goals.";

        return result;
    }

    @Override
    public String toString() {
        return this.getTeamName();
    }

    // Checks if two objects are equal to one another.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CricketClub)) return false;
        if (!super.equals(o)) return false;
        CricketClub that = (CricketClub) o;
        return seasonWins == that.seasonWins &&
                seasonDraws == that.seasonDraws &&
                seasonDefeats == that.seasonDefeats &&
                goalsScored == that.goalsScored &&
                currentClubScore == that.currentClubScore &&
                noOfMatchesPlayed == that.noOfMatchesPlayed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), seasonWins, seasonDraws, seasonDefeats, goalsScored, currentClubScore, noOfMatchesPlayed);
    }


    public int getSeasonWins() {
        return seasonWins;
    }

    public void setSeasonWins(int seasonWins) {
        this.seasonWins = seasonWins;
    }

    public int getSeasonDraws() {
        return seasonDraws;
    }

    public void setSeasonDraws(int seasonDraws) {
        this.seasonDraws = seasonDraws;
    }

    public int getSeasonDefeats() {
        return seasonDefeats;
    }

    public void setSeasonDefeats(int seasonDefeats) {
        this.seasonDefeats = seasonDefeats;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getCurrentClubScore() {
        return currentClubScore;
    }

    public void setCurrentClubScore(int currentClubScore) {
        this.currentClubScore = currentClubScore;
    }

    public int getNoOfMatchesPlayed() {
        return noOfMatchesPlayed;
    }

    public void setNoOfMatchesPlayed(int noOfMatchesPlayed) {
        this.noOfMatchesPlayed = noOfMatchesPlayed;
    }

}

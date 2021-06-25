import java.io.IOException;

/**
 * Implemented an interface with methods.
 * All the methods of the interface are public
 * and abstract.
 */
public interface LeagueManager {
    void addClub(String clubName, String clubLeader)throws IOException;
    void deleteClub(String clubName);
    void displayStats(String clubName);
    void displayTable();
    void save() throws IOException;
    void load();
    void addMatchDetails(Date datePlayed, CricketClub club1, int club1Score, CricketClub club2, int club2Score);
}

import java.io.Serializable;


/**
 * Created by Nadil on 01.07.2021
 * This class is responsible for keeping track
 * of the match details, when adding a match to
 * the Super League Table.
 */
public class MatchDetails implements Serializable {
    private Date datePlayed;   // Date played
    private CricketClub club1;  // Team one of the match
    private CricketClub club2;  // Team two of the match
    private int club1Score;     // Team one score
    private int club2Score;     // Team two score

    /**
     * Creates an MatchDetails Object where is used to
     * add matches to the Super League Table.
     * @param datePlayed Date the match was played
     * @param club1 Team one of the match
     * @param club2 Team two of the match
     * @param club1Score Team one score
     * @param club2Score Team two score
     */
    public MatchDetails(Date datePlayed, CricketClub club1, CricketClub club2, int club1Score, int club2Score) {
        this.datePlayed = datePlayed;
        this.club1 = club1;
        this.club2 = club2;
        this.club1Score = club1Score;
        this.club2Score = club2Score;
    }

    public Date getDatePlayed() {
        return datePlayed;
    }

    public void setDatePlayed(Date datePlayed) {
        this.datePlayed = datePlayed;
    }

    public CricketClub getClub1() {
        return club1;
    }

    public void setClub1(CricketClub club1) {
        this.club1 = club1;
    }

    public CricketClub getClub2() {
        return club2;
    }

    public void setClub2(CricketClub club2) {
        this.club2 = club2;
    }

    public int getClub1Score() {
        return club1Score;
    }

    public void setClub1Score(int club1Score) {
        this.club1Score = club1Score;
    }

    public int getClub2Score() {
        return club2Score;
    }

    public void setClub2Score(int club2Score) {
        this.club2Score = club2Score;
    }
}


import java.io.*;
import java.util.ArrayList;

/**
 * Created by Nadil on 01.07.2021
 * Implemented an interface with methods.
 * All the methods of the interface are public
 * and abstract.
 */
public class SuperLeagueManager implements LeagueManager {


    ArrayList<CricketClub> clubArrayList = new ArrayList<>();
    ArrayList<MatchDetails>playedMatchArrayList=new ArrayList<>();

    public ArrayList<CricketClub> getClubArrayList() {
        return clubArrayList;
    }

    // Method which creates a new club from input and adds it to the clubs list
    @Override
    public void addClub (String teamName, String teamLeader) {

        CricketClub cricketClub = new CricketClub(teamName,teamLeader);
        clubArrayList.add(cricketClub);
        System.out.println("Team "+cricketClub.getTeamName()+" Added Successfully !");

    }
    // Method which deletes a club, with the name passed as a parameter, from the clubs list
    @Override
    public void deleteClub(String teamName) {
        for(CricketClub club : clubArrayList){
                if(club.getTeamName().equals(teamName)){
                    clubArrayList.remove(club);
                        System.out.println("Team " + teamName + " Was Removed Successfully!");
                        return;
                }
            }

    }

    // Method which which displays all stats for a given cricket club
    @Override
    public void displayStats(String teamName) {

        for (CricketClub club : clubArrayList) {
            if (club.getTeamName().equals(teamName)){
                System.out.println(" Club Name: " + club.getTeamName());
                System.out.println(" Club Leader: " + club.getTeamLeader());
                System.out.println(" Club Season Wins: " + club.getSeasonWins());
                System.out.println(" Club Season Defeats: " + club.getSeasonDefeats());
                System.out.println(" Club Season Draws: " + club.getSeasonDraws());
                System.out.println(" Total Matches Played: " + club.getNoOfMatchesPlayed());
                System.out.println(" Total Season Match Score: " + club.getGoalsScored());
                System.out.println(" Total Club Points: " + club.getCurrentClubScore());
                return;
            }
        }
        System.out.println("Please Enter A Valid Club");
    }

    // Method which displays the super league table in the console with data from currently added clubs
    @Override
    public void displayTable() {
        System.out.println("                        ICC Men's Cricket World Cup Super League – Standings");
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.format("%-19s %-21s %-16s %-11s %-11s %-11s  %n", "Club Name    |", "Matches Played    |", "Wins    |", "Lost    |", " Tied    |", "Points    |");
        System.out.println("-----------------------------------------------------------------------------------------------");
        for (CricketClub club : clubArrayList) {
            System.out.format("%-24s %-17s %-17s %-12s %-11s %-14s  %n", club.getTeamName(), club.getNoOfMatchesPlayed(),club.getSeasonWins(),
                    club.getSeasonDefeats(), club.getSeasonDraws(), club.getCurrentClubScore());
        }
        System.out.println("\nEach team gets 10 points for a win, five for a tie/ no result/ abandoned match, and zero for a loss.");
    }

    // Method which saves serialized data to a file
    @Override
    public void save() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("SaveFile.ser");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(clubArrayList);
        outputStream.close();
        fileOutputStream.close();

        FileOutputStream MatchOutput = new FileOutputStream("MatchDetailsFile.ser");
        ObjectOutputStream output = new ObjectOutputStream(MatchOutput);
        output.writeObject(playedMatchArrayList);
        output.close();
        MatchOutput.close();

    }

    // Method which loads serialized data of a file
    @Override
    public void load() {
        try{
            FileInputStream fileInputStream = new FileInputStream("SaveFile.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object c = objectInputStream.readObject();
            clubArrayList = (ArrayList<CricketClub>) c;
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        try{
            FileInputStream MatchOutput = new FileInputStream("MatchDetailsFile.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(MatchOutput);
            Object d = objectInputStream.readObject();
            playedMatchArrayList = (ArrayList<MatchDetails>) d;
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    // Method which creates a played match and adds it to the matches list
    @Override
    public void addMatchDetails(Date datePlayed, CricketClub club1, int club1Score, CricketClub club2, int club2Score) {

        MatchDetails matchDetails = new MatchDetails(datePlayed, club1,club2,club1Score,club2Score);
        playedMatchArrayList.add(matchDetails);
        updateScore(matchDetails);



    }

    private void updateScore(MatchDetails matchDetails) {



        matchDetails.getClub1().setNoOfMatchesPlayed(matchDetails.getClub1().getNoOfMatchesPlayed() + 1);
        matchDetails.getClub2().setNoOfMatchesPlayed(matchDetails.getClub2().getNoOfMatchesPlayed() + 1);

        matchDetails.getClub1().setGoalsScored(matchDetails.getClub1().getGoalsScored() + matchDetails.getClub1Score());
        matchDetails.getClub2().setGoalsScored(matchDetails.getClub2().getGoalsScored() + matchDetails.getClub2Score());



        if (matchDetails.getClub1Score() > matchDetails.getClub2Score()) {
            matchDetails.getClub1().setSeasonWins(matchDetails.getClub1().getSeasonWins() + 1);
            matchDetails.getClub2().setSeasonDefeats(matchDetails.getClub2().getSeasonDefeats() + 1);
            matchDetails.getClub1().setCurrentClubScore(matchDetails.getClub1().getCurrentClubScore() + 10);
        } else if (matchDetails.getClub1Score() < matchDetails.getClub2Score()) {
            matchDetails.getClub2().setSeasonWins(matchDetails.getClub2().getSeasonWins() + 1);
            matchDetails.getClub1().setSeasonDefeats(matchDetails.getClub1().getSeasonDefeats() + 1);
            matchDetails.getClub2().setCurrentClubScore(matchDetails.getClub2().getCurrentClubScore() + 10);
        } else if (matchDetails.getClub1Score() == matchDetails.getClub2Score()) {
            matchDetails.getClub1().setSeasonDraws(matchDetails.getClub1().getSeasonDraws() + 1);
            matchDetails.getClub2().setSeasonDraws(matchDetails.getClub2().getSeasonDraws() + 1);
            matchDetails.getClub1().setCurrentClubScore(matchDetails.getClub1().getCurrentClubScore() + 5);
            matchDetails.getClub2().setCurrentClubScore(matchDetails.getClub2().getCurrentClubScore() + 5);

        }

    }



}

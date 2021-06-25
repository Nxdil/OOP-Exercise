import java.io.*;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Nadil on 01.07.2021
 * This class is the main class of the
 * program.
 */
public class Main{

    public static void main(String[] args) throws IOException {


        SuperLeagueManager PLM = new SuperLeagueManager();
        PLM.load();

        while (true) {
            Main.Ma(PLM);
        }
    }
        public static void Ma(SuperLeagueManager PLM) throws IOException{


            while (true) {
                System.out.println("\n-----------------------------------------------------------------------------");
                System.out.println("---------Welcome To ICC Men's Cricket World Cup Super League Manager---------");
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("----------------------------------Main Menu----------------------------------\n");
                System.out.println(
                                "Press 1 : To create a new club and add to Super League Table\n" +
                                "press 2 : To Delete an existing team from Super League Table\n" +
                                "press 3 : To Display Super League Table\n" +
                                "press 4 : To add a Match to Super League League  \n" +
                                "press 5 : To display Club Statistics\n" +
                                "press 6 : To save the data  \n"
                );
                try {

                    System.out.print("Enter your Choice : ");
                    Scanner sc = new Scanner(System.in);
                    int userOption = sc.nextInt();

                    switch (userOption) {
                        // Create new club and add to Super League Table
                        case 1: {
                            Scanner nameSc = new Scanner(System.in);
                            Scanner leaderSc = new Scanner(System.in);

                            // Team name
                            System.out.println("Enter the team : ");
                            String clubName = nameSc.nextLine();

                            // Team Captain
                            System.out.println("Enter the team captain :");
                            String clubLeader = leaderSc.nextLine();
                            PLM.addClub(clubName, clubLeader);

                            break;
                        }
                        case 2: {
                            // Delete existing Club
                            System.out.print("Please enter the Team Name to delete : ");
                            Scanner cn = new Scanner(System.in);
                            String clubName = cn.nextLine();
                            PLM.deleteClub(clubName);

                            break;
                        }
                        case 3:
                            PLM.displayTable();

                            break;
                        case 4:
                            Scanner scan = new Scanner(System.in);

                            // Entering Match Played date between the Clubs
                            // Date Played
                            System.out.println("Enter date played:");
                            Date datePlayed = getDateInput();
                            System.out.println(datePlayed);

                            System.out.println("\n---Please enter 2 teams that exist in the Super League table---");

                            // Entering Name and Score of the 1st Club.
                            System.out.println("Enter the 1st Team : ");
                            String club1Sc = scan.nextLine();
                            CricketClub club = null;
                            for (CricketClub clubs : PLM.getClubArrayList()) {
                                if (clubs.getTeamName().equals(club1Sc))
                                    club = clubs;
                            }
                            if (club == null) {
                                System.out.print("The club you entered does not Exist!");
                                return;
                            }
                            System.out.println("Enter Score of " + club1Sc + ":");
                            int club1ScoreSc = Integer.parseInt(scan.nextLine());

                            // Entering Name and Score of the 2nd Club.
                            System.out.println("Enter the 2nd Team : ");
                            String club2Sc = scan.nextLine();
                            CricketClub club2 = null;
                            for (CricketClub clubs2 : PLM.getClubArrayList()) {
                                if (clubs2.getTeamName().equals(club2Sc))
                                    club2 = clubs2;
                            }
                            if (club2 == null) {
                                System.out.print("The club you entered does not Exist!");
                                return;
                            }
                            System.out.println("Enter Score of " + club2Sc + ":");
                            int club2ScoreSc = scan.nextInt();
                            PLM.addMatchDetails(datePlayed, club, club1ScoreSc, club2, club2ScoreSc);

                            break;

                        // Display statistics for a selected Club
                        case 5: {
                            System.out.println("-------------------------------------------------------------------");
                            System.out.println("--------------------------Club Statistics--------------------------");
                            System.out.println("-------------------------------------------------------------------");
                            System.out.print("Please enter the Club Name : ");
                            Scanner dcn = new Scanner(System.in);
                            String clubName = dcn.nextLine();
                            PLM.displayStats(clubName);

                            break;
                        }

                        case 6:
                            //Saving the Program
                            PLM.save();
                            break;
                        default:
                            System.out.println("Invalid Input");
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a Valid Input");
                }
            }
        }
    // Method to get date input (reducing duplication)
    public static Date getDateInput() {
        Date date = new Date();
        Scanner scanner;
        String inputMismatchErrorMessage = "Invalid input. Please enter an integer.";

        // Get year input
        while (true) {
            scanner = new Scanner(System.in);
            try {
                System.out.print("Year: ");
                int year = scanner.nextInt();
                date.setYear(year);
                break;
            } catch (InputMismatchException e) {
                System.out.println(inputMismatchErrorMessage);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Please enter a valid year.");
            }
        }

        // Get month input
        while (true) {
            scanner = new Scanner(System.in);
            try {
                System.out.print("Month: ");
                int month = scanner.nextInt();
                date.setMonth(month);
                break;
            } catch (InputMismatchException e) {
                System.out.println(inputMismatchErrorMessage);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. " + e.getMessage());
            }
        }

        // Get day input
        while (true) {
            scanner = new Scanner(System.in);
            try {
                System.out.print("Day: ");
                int day = scanner.nextInt();
                date.setDay(day);
                break;
            } catch (InputMismatchException e) {
                System.out.println(inputMismatchErrorMessage);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. " + e.getMessage());
            }
        }

        return date;
    }



}





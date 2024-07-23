// Enter data for a cricket team of 11 players, where each player's runs are stored as a hash table value. Find out the rank number of a player based on the formula: `Runs % 11`. For example, if runs are 30, the index number is 8, and rank #8 is the rank of the team member. (Use HashTable ADT class)

import java.util.Hashtable;
import java.util.Scanner;

public class CricketTeamRanks {

    public static void main(String[] args) {
        Hashtable<Integer, Integer> playerRuns = new Hashtable<>();

        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= 11; i++) {
            System.out.print("Enter runs for player " + i + ": ");
            int runs = scanner.nextInt();
            playerRuns.put(i, runs);
        }

        System.out.println("\nPlayer Rankings based on Runs % 11:");
        for (int i = 1; i <= 11; i++) {
            int runs = playerRuns.get(i);
            int rank = runs % 11;
            System.out.println("Player " + i + " (Runs: " + runs + ") - Rank #" + rank);
        }

        scanner.close();
    }
}

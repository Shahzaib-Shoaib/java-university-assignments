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

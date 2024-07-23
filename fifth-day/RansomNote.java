import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public static void main(String[] args) {
        String magazine = "attack at dawn";
        String note = "Attack at dawn";

        boolean canReplicate = canReplicateRansomNoteUsingMagazine(magazine, note);
        System.out.println(canReplicate ? "Yes" : "No");
    }

    public static boolean canReplicateRansomNoteUsingMagazine(String magazine, String note) {
        Map<String, Integer> magazineWordCount = new HashMap<>();

        String[] magazineWords = magazine.split("\\s+");
        for (String word : magazineWords) {
            magazineWordCount.put(word, magazineWordCount.getOrDefault(word, 0) + 1);
        }

        String[] noteWords = note.split("\\s+");
        for (String word : noteWords) {
            if (!magazineWordCount.containsKey(word) || magazineWordCount.get(word) == 0) {
                return false;
            }
            magazineWordCount.put(word, magazineWordCount.get(word) - 1);
        }

        return true;
    }
}

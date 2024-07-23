// Harold, a kidnapper, is worried his ransom note might be traced back to him through his handwriting. He wants to know if he can cut out whole words from a magazine to replicate his ransom note exactly. The words in his note are case-sensitive, and he must use only whole words available in the magazine. He cannot use substrings or concatenation.
// Given the words in the magazine and the words in the ransom note, print "Yes" if he can replicate his ransom note exactly using whole words from the magazine; otherwise, print "No". For example: magazine = "attack at dawn" note = "Attack at dawn"
// The magazine has all the right words, but there is a case mismatch, so the answer is "No".

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

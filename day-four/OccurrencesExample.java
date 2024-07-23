import java.util.HashMap;
import java.util.Map;

public class OccurrencesExample {

    public static void main(String[] args) {
        int[] A = {28, 1, 0, 1, 0, 3, 4, 0, 0, 3};
        
        occurrences(A);
    }

    public static void occurrences(int[] A) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        
        for (int number : A) {
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}

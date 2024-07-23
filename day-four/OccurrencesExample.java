// Write a function called `occurrences` that, given an array of numbers `A`, prints all the distinct values in `A`, each followed by its number of occurrences. For example, if `A = (28, 1, 0, 1, 0, 3, 4, 0, 0, 3)`, the function should output: 
// 28 1
// 1 2
// 0 4
// 3 2 
// 4 1

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

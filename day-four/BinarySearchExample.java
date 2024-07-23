import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BinarySearchExample {

    public static void main(String[] args) {
        int size = 20;
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }

        Arrays.sort(array);

        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(array));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer to search: ");
        int target = scanner.nextInt();

        int result = binarySearch(array, target);

        if (result == -1) {
            System.out.println(target + " is not in the array.");
        } else {
            System.out.println(target + " is found at index " + result + ".");
        }

        scanner.close();
    }

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}

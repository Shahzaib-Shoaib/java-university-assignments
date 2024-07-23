// Write a program that takes an unordered list of integers (or any other objects, e.g., strings) and rearranges the list in natural order using merge sort.

import java.util.Arrays;

public class MergeSortExample {

    public static void main(String[] args) {
        int[] numbers = { 34, 7, 23, 32, 5, 62, 32, 90 };

        System.out.println("Unordered list:");
        System.out.println(Arrays.toString(numbers));

        mergeSort(numbers, 0, numbers.length - 1);

        System.out.println("\nOrdered list:");
        System.out.println(Arrays.toString(numbers));
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            merge(array, left, mid, right);
        }
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(array, left, L, 0, n1);
        System.arraycopy(array, mid + 1, R, 0, n2);

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }
}

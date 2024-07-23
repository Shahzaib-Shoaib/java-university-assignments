// Write a program that takes an array of real numbers of size 7 and calculates the sum and mean of all the elements. Also, depict the memory management of this task.
// Add a method in the same class that splits the existing array into two. The method should search for a key in the array and, if found, split the array from the index of the key.

public class ArraySumAndMean {

    public static void main(String[] args) {
        double[] numbers = new double[7];
        
        numbers[0] = 10.5;
        numbers[1] = 20.0;
        numbers[2] = 30.25;
        numbers[3] = 40.75;
        numbers[4] = 50.5;
        numbers[5] = 60.0;
        numbers[6] = 70.25;

        double sum = calculateSum(numbers);
        double mean = calculateMean(numbers, sum);
        
        System.out.println("Array Elements: ");
        for (double num : numbers) {
            System.out.println(num);
        }
        System.out.println("Sum: " + sum);
        System.out.println("Mean: " + mean);

        double key = 40.75; 
        splitArray(numbers, key);
    }

    public static double calculateSum(double[] array) {
        double sum = 0.0;
        for (double num : array) {
            sum += num;
        }
        return sum;
    }

    public static double calculateMean(double[] array, double sum) {
        return sum / array.length;
    }

    public static void splitArray(double[] array, double key) {
        int index = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Key not found in the array.");
            return;
        }

        double[] firstPart = new double[index];
        double[] secondPart = new double[array.length - index];

        for (int i = 0; i < index; i++) {
            firstPart[i] = array[i];
        }

        for (int i = index; i < array.length; i++) {
            secondPart[i - index] = array[i];
        }

        System.out.println("First Part:");
        for (double num : firstPart) {
            System.out.println(num);
        }

        System.out.println("Second Part:");
        for (double num : secondPart) {
            System.out.println(num);
        }
    }
}

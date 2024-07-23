// Write a Java program that takes 3 strings and demonstrates that strings are immutable.

public class StringImmutability {

    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "World";

        System.out.println("Original Strings:");
        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);

        str1 = str1.concat(" Java");
        System.out.println("\nAfter attempting to modify str1:");
        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);

        System.out.println("\nMemory addresses:");
        System.out.println("str1: " + System.identityHashCode(str1));
        System.out.println("str2: " + System.identityHashCode(str2));
    }
}

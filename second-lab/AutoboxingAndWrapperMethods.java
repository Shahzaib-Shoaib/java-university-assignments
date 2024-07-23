// Write a Java program to perform autoboxing and also implement different methods of the wrapper class.

public class AutoboxingAndWrapperMethods {

    public static void main(String[] args) {
        int primitiveInt = 10;
        Integer wrapperInt = primitiveInt;
        System.out.println("Autoboxed Integer: " + wrapperInt);

        double primitiveDouble = 15.75;
        Double wrapperDouble = primitiveDouble;
        System.out.println("Autoboxed Double: " + wrapperDouble);

        System.out.println("\nWrapper Class Methods:");

        int intValue = 42;
        Integer intObject = Integer.valueOf(intValue);
        System.out.println("Integer to String: " + intObject.toString());
        System.out.println("String to Integer: " + Integer.parseInt("123"));

        double doubleValue = 3.14;
        Double doubleObject = Double.valueOf(doubleValue);
        System.out.println("Double to String: " + doubleObject.toString());
        System.out.println("String to Double: " + Double.parseDouble("3.14159"));

        char charValue = 'A';
        Character charObject = Character.valueOf(charValue);
        System.out.println("Character to String: " + charObject.toString());
        System.out.println("Is 'A' a letter? " + Character.isLetter(charValue));
        System.out.println("Is '1' a digit? " + Character.isDigit('1'));
    }
}

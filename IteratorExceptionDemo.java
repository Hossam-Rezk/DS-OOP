import java.util.ArrayList;
import java.util.Iterator;

// ✅ Demonstrating Iterators and Exceptions
public class IteratorExceptionDemo {
    public static void main(String[] args) {
        // ✅ ITERATORS EXAMPLE
        ArrayList<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        System.out.println("Using Iterator to loop through names:");
        Iterator<String> iterator = names.iterator(); // Creating an iterator

        while (iterator.hasNext()) {
            System.out.println(iterator.next()); // Retrieves and moves to the next element
        }

        // ✅ EXCEPTION HANDLING EXAMPLE
        try {
            int result = divide(10, 0); // ❌ This will cause an exception (division by zero)
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught an exception: " + e.getMessage());
        }

        // ✅ CUSTOM EXCEPTION EXAMPLE
        try {
            checkAge(15); // ❌ Will throw an exception
        } catch (InvalidAgeException e) {
            System.out.println("Custom Exception Caught: " + e.getMessage());
        }
    }

    // ✅ Method demonstrating an exception (division by zero)
    public static int divide(int a, int b) {
        return a / b; // May throw ArithmeticException
    }

    // ✅ Custom Exception Class
    static class InvalidAgeException extends Exception {
        public InvalidAgeException(String message) {
            super(message);
        }
    }

    // ✅ Method that throws a custom exception
    public static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or older.");
        }
        System.out.println("Age is valid.");
    }
}

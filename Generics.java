// ✅ GENERIC CLASS EXAMPLE
class Box<T> {  // T is a placeholder for any data type
    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}

// ✅ GENERIC METHOD EXAMPLE
class Util {
    public static <T> void printItem(T item) {  // Generic method
        System.out.println("Item: " + item);
    }
}

// ✅ GENERIC INTERFACE
interface Container<T> {
    void add(T item);
    T get();
}

// ✅ CLASS IMPLEMENTING GENERIC INTERFACE
class Storage<T> implements Container<T> {
    private T storedItem;

    public void add(T item) {
        storedItem = item;
    }

    public T get() {
        return storedItem;
    }
}

// ✅ GENERIC CONSTRAINTS: Only accept Number types
class MathUtil<T extends Number> {
    private T number;

    public MathUtil(T number) {
        this.number = number;
    }

    public double getDoubleValue() {
        return number.doubleValue();
    }
}

// ✅ MAIN CLASS TO TEST EVERYTHING
public class GenericsDemo {
    public static void main(String[] args) {
        // ✅ Using the generic Box class
        Box<String> stringBox = new Box<>();
        stringBox.setItem("Hello, Generics!");
        System.out.println(stringBox.getItem());

        Box<Integer> intBox = new Box<>();
        intBox.setItem(42);
        System.out.println(intBox.getItem());

        // ✅ Using the generic method
        Util.printItem("Generic Method Example");
        Util.printItem(100);

        // ✅ Using a class that implements a generic interface
        Storage<Double> doubleStorage = new Storage<>();
        doubleStorage.add(9.99);
        System.out.println("Stored item: " + doubleStorage.get());

        // ✅ Using generic constraints (MathUtil)
        MathUtil<Integer> mathUtil = new MathUtil<>(10);
        System.out.println("Double value: " + mathUtil.getDoubleValue());
    }
}

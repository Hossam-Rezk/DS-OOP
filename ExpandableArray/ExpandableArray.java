public class ExpandableArray {

  // Private member variables
  private int size;  
  private int[] data;
    
  // Constructor which takes an initial capacity
  public ExpandableArray(int capacity) {
        this.size = 0;  
        this.data = new int[capacity];
  }
  
  // Insert method: adds an element to the end of the array.
  public void insert(int elem) {
        if (size == data.length) {
            expand(); // Expand the array if it's full.
        }
        data[size] = elem;
        size++;
  }

  // Get method: returns the element at the specified index.
  public int get(int idx) {
        return data[idx];
  }
  
  // Remove method: removes the element at the specified index.
  public void remove(int index) {
      // Shift elements left starting at the removal index.
      for (int i = index; i < size - 1; i++) {
          data[i] = data[i + 1];
      }
      size--; // Decrement the size after removal.
  }
  
  // Expand method: doubles the capacity of the internal array.
  public void expand() {
      int newCapacity = data.length * 2;
      int[] newData = new int[newCapacity];
      for (int i = 0; i < data.length; i++) {
          newData[i] = data[i];
      }
      data = newData;
  }

  // Print method: prints the current elements in the array.
  public void print() {
    System.out.println("Data:");
    for (int i = 0; i < size; i++) {
      System.out.println(data[i]);
    }
  }

  // Main method for testing the class functionality.
  public static void main(String[] args) {
    ExpandableArray e = new ExpandableArray(3);
    e.insert(100);
    e.insert(15);
    e.insert(3);
    
    // This insert will trigger expand() since the initial capacity is reached.
    e.insert(42);
    
    e.print();
    e.remove(1);
    e.print();
    System.out.println(e.get(0));
  }
}

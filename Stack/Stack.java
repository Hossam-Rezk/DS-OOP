import java.util.EmptyStackException;

class Stack {
    private int size;
    private int top;
    private int[] array;

    public Stack(int size) {
        this.size = size;
        this.top = -1;
        this.array = new int[size];
    }

    public void push(int x) {
        if (isFull()) {
            throw new StackOverflowError("Stack is full");
        }
        array[++top] = x;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array[top];
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void display() {
        for (int i = top; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

class ParenthesesValidator {
    private static char getOpenMatch(char ch) {
        if (ch == ')') return '(';
        if (ch == ']') return '[';
        return '{';
    }

    public static boolean isValid(String str) {
        Stack parentheses = new Stack(str.length());

        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                parentheses.push(ch);
            } else {
                if (parentheses.isEmpty() || parentheses.pop() != getOpenMatch(ch)) {
                    return false;
                }
            }
        }
        return parentheses.isEmpty();
    }
}

class StringUtils {
    public static String reverseSubwords(String line) {
        StringBuilder result = new StringBuilder();
        line += " "; // Add dummy space for processing
        Stack stack = new Stack(line.length());

        for (char ch : line.toCharArray()) {
            if (ch == ' ') {
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
                result.append(' ');
            } else {
                stack.push(ch);
            }
        }
        return result.toString().trim(); // Remove trailing space
    }
}

class NumberUtils {
    public static int reverseNum(int num) {
        if (num == 0)
            return 0;

        Stack stack = new Stack(25);
        while (num != 0) {
            stack.push(num % 10);
            num /= 10;
        }

        int reversedNum = 0, tens = 1;
        while (!stack.isEmpty()) {
            reversedNum += stack.pop() * tens;
            tens *= 10;
        }

        return reversedNum;
    }
}

public class Main {
    public static void main(String[] args) {
        Stack stk = new Stack(3);
        stk.push(10);
        stk.push(20);
        stk.push(30);

        if (!stk.isFull()) {
            stk.push(50);
        } else {
            System.out.println("Full Stack");
        }

        stk.display(); // Output: 30 20 10
        System.out.println(stk.peek()); // Output: 30

        while (!stk.isEmpty()) {
            System.out.print(stk.pop() + " ");
        }
        System.out.println(); // Output: 30 20 10

        // Testing ParenthesesValidator
        System.out.println(ParenthesesValidator.isValid("({[]})")); // true
        System.out.println(ParenthesesValidator.isValid("({[})"));  // false

        // Testing reverseSubwords
        System.out.println(StringUtils.reverseSubwords("hello world")); // Output: "olleh dlrow"

        // Testing reverseNum
        System.out.println(NumberUtils.reverseNum(12345)); // Output: 54321
    }
}

import java.util.Scanner;

class InfixToPostfix {
    private static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
        }
    }

    private Node head; // Top of the stack

    public boolean isEmpty() {
        return head == null;
    }

    public void push(char value) {
        Node item = new Node(value);
        item.next = head;
        head = item;
    }

    public char pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        char element = head.data;
        head = head.next;
        return element;
    }

    public char peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return head.data;
    }
}

public class InfixToPostfix {
    private static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        return 2; // For * /
    }

    public static String infixToPostfix(String infix) {
        Stack operators = new Stack();
        StringBuilder postfix = new StringBuilder();

        for (char ch : infix.toCharArray()) {
            if (Character.isDigit(ch)) {
                postfix.append(ch);
            } else {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(ch)) {
                    postfix.append(operators.pop());
                }
                operators.push(ch); // Push the current operator
            }
        }

        while (!operators.isEmpty()) { // Append remaining operators
            postfix.append(operators.pop());
        }

        return postfix.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter infix expression: ");
        String equation = scanner.next();
        System.out.println("Postfix: " + infixToPostfix(equation));
        scanner.close();
    }
}

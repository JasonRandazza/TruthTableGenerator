import java.util.*;

public class ExpressionParser {
    // Defining the precedence of operators
    private static int precedence(char op) {
        switch (op) {
            case '!' : return 3; // NOT
            case '*' : return 2; // AND
            case '+' : return 1; // OR
            default : return 0;
        }
    }
    // Check if the operator is left-associative
    private static boolean isLeftAssociative(char op) {
        return op == '+' || op == '*';
    }
    // Changing infix expressions into postfix
    public static String infixToPostfix(String infix) {
        Stack stack = new Stack();
        StringBuilder postfix = new StringBuilder();

        System.out.println("Starting conversion from infix to postfix...");
        for (int i =0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            // If the character is a latter A-Z, it gets added to the output
            if (Character.isLetter(ch)) {
                postfix.append(ch);
                System.out.println("Postfix so far: " + postfix);
                System.out.println("Added variable to postfix: " + ch);
            }
            // If the character is an operator
            else if (ch == '+' || ch =='*' || ch == '!') {
                System.out.println("Processing operator: " + ch);
                // Pops from the stack while the top of the stack has an operator of higher precedence or equal if they are left-associative
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch) && isLeftAssociative(stack.peek())){
                    postfix.append(stack.pop());
                    System.out.println("Postfix so far: " + postfix);
                }
                stack.push(ch);
                System.out.println("Pushed operator to stack: " + ch);
            }
            // If the character is an open parenthesis
            else if (ch == '(') {
                stack.push(ch);
            }
            // If the character is a closing parenthesis then pop until open parenthesis
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // Remove '(' from the stack
            }
        }
        // Pop the remaining operators out of the stack
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        System.out.println("Final postfix expression:" + postfix.toString());
        return postfix.toString();
    }
}

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input boolean expressions
        System.out.print("Please, enter a boolean expression: ");
        String infix = sc.nextLine();

        // Converting infix expression to postfix expression using the Shunting Yard algorithm
        String postfix = ExpressionParser.infixToPostfix(infix);
        System.out.println("Postfix Expression: " + postfix);

        // Extracting the variables from the expression
        char[] variables = VariableExtractor.extractVariables(infix);

        // Generating and printing the truth table
        TableGenerator.generateTable(postfix, variables);
    }
}
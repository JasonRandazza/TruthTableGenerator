public class TableGenerator {
    // Evaluates postfix expressions for the given variables
    private static boolean evalPostfix(String postfix, char[] variables, boolean[] values) {
        Stack stack = new Stack();
        for (char ch : postfix.toCharArray()) {
            if (Character.isLetter(ch)) {
                // Finding the index of the variable in the variables array
                int index = findVariableIndex(variables, ch);
                stack.push(values[index] ? 'T' : 'F');
            }
            else {
                if (ch == '!') {
                    boolean val = stack.pop() == 'T';
                    stack.push(!val ? 'T' : 'F');
                }
                else {
                    boolean val2 = stack.pop() == 'T';
                    boolean val1 = stack.pop() == 'T';
                    if (ch == '+') {
                        stack.push((val1 || val2) ? 'T' : 'F');
                    }
                    else if (ch == '*') {
                        stack.push((val1 && val2) ? 'T' : 'F');
                    }
                }
            }
        }
        return stack.pop() == 'T';
    }
    // Helper function that finds the index of a variable
    private static int findVariableIndex(char[] variables, char var) {
        for (int i = 0; i < variables.length; i++) {
            if (variables[i] == var) {
                return i;
            }
        }
        return -1;
    }
    // Generate the truth table
    public static void generateTable(String postfix, char[] variables) {
        int n = variables.length;
        int rows = (int) Math.pow(2, n);
        boolean[] values = new boolean[n];

        // Printing table header
        for (char var : variables) {
            System.out.print(var + " | ");
        }
        System.out.println("Result");
        System.out.println("-".repeat(n * 4 + 7));

        // Generate all combinations of variable assignments
        for (int i = 0; i < rows; i++) {
            // Assign truth values based on binary representation of i
            for (int j = 0; j < n; j++) {
                values[j] = (i & (1 << (n - j - 1))) != 0;
                System.out.print((values[j] ? 'T' : 'F') + " | ");
            }
            // Evaluates the expressions for the current combination
            boolean result = evalPostfix(postfix, variables, values);
            System.out.println(result ? 'T' : 'F');
        }
    }
}

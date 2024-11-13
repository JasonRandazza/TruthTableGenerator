public class VariableExtractor {
    // Method to extract the variables
    public static char[] extractVariables(String expression) {
        // Initialize an array with a maximum size for storing variables
        char[] variables = new char[10];
        int count = 0;

        // Loop through the expression in order to extract the variables
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (Character.isLetter(ch)) {
                // Check if variable is already in the list
                if (!isVariablePresent(variables, count, ch)) {
                    variables[count++] = ch;
                }
            }
        }
        // Copy the valid portion to a new array of the correct size
        char[] result = new char[count];
        for (int i = 0; i < count; i++) {
            result[i] = variables[i];
        }
        // Sorting the variables for consistent output using bubble sort
        bubbleSort(result);
        return result;
    }
    // Helper method to check if a character is already in the array
    private static boolean isVariablePresent(char[] variables, int count, char ch) {
        for (int i = 0; i < count; i++) {
            if (variables[i] == ch) {
                return true;
            }
        }
        return false;
    }
    // Bubble sort algorithm to sort variables alphabetically
    private static void bubbleSort(char[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    char temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}

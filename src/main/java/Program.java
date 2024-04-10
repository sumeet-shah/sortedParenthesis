import java.util.Stack;

public class Program {
    public static void main(String[] args) {
        String input = "{}[()]{()()()()(){[()[]]}}";
        Boolean isValid = checkParenthesisValidity(input);
        System.out.println(isValid);
    }

    /**
     * Checks if the input string has all the parenthesis in correct order or
     * not.
     * @param input string having parenthesis
     * @return returns true if all is fine else false.
     */
    private static Boolean checkParenthesisValidity(String input) {
        Boolean isValid = false;
        // maintain a stack to keep track of the open parenthesis
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            // take the current character
            char currentChar = input.charAt(i);
            // check if current char is opening one or not
            Boolean isOpening = checkIfCharOpening(currentChar);
            if (isOpening) {
                // add current char to the stack
                stack.push(currentChar);
            } else {
                // match the previous character
                boolean isPrevCharacterMatching = matchPrev(currentChar, stack);
                if (isPrevCharacterMatching) {
                    // if prev character matching then we pop the latest one.
                    stack.pop();
                }
            }
        }

        // if stack is empty then we are sorted else not
        return stack.isEmpty();

    }
    /**
     * For current character, if prev character is matching or not
     * @param currentChar current character
     * @param stack data structure to know what was the previous character
     * @return true if prev character is a correct opening for the current
     * character, otherwise false.
     */
    private static boolean matchPrev(char currentChar, Stack<Character> stack) {
        Character prevChar = stack.lastElement();
        if (currentChar == ')' && prevChar == '(') {
            return true;
        } else if (currentChar == '}' && prevChar == '{') {
            return true;
        } else if (currentChar == ']' && prevChar == '[') {
            return true;
        } else
            return false;
    }

    /**
     * Identify if current character is the opening parenthesis or not
     * @param currentChar current character to evaluate
     * @return true if is an opening type, otherwise false.
     */
    private static Boolean checkIfCharOpening(char currentChar) {
        return currentChar == '(' || currentChar == '{' || currentChar == '[';
    }
}

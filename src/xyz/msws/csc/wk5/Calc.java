package xyz.msws.csc.wk5;

/*
 * Isaac Boaz
 */

import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {
        boolean done = false;
        Scanner console = new Scanner(System.in);
        while (!done) {
            displayMenu();
            // We can combine the getUserSelection and processSelection into one line
            done = processSelection(getUserSelection(console), console);
        }
        System.out.println("Thank you for using this program.  Goodbye.");
    }

    private static boolean processSelection(String selection, Scanner console) {
        // We can use a switch statement here instead of an if...elseif... chain
        switch (selection.toLowerCase()) { // Lowercase for QOL
            case "e":
                // Return true here instead of tracking a boolean
                return true;
            case "c":
                calculateResults(console);
                break;
            case "h":
                displayCalculatorInstructions();
                break;
        }
        return false;
    }

    private static void calculateResults(Scanner console) {
        displayCalculatorInstructions(); // Not sure why this was commented out
        double operand1 = console.nextDouble();
        char operator = console.next().charAt(0);
        double operand2 = console.nextDouble(); // Double, not String

        double result = 0.0;

        // Converted if..elseif chain to switch
        switch (operator) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2; // * = multiply, - = subtract
                break;
            case '/':
                result = operand2 == 0 ? Double.NaN : operand1 / operand2;
                break;
            case '^':
                result = Math.pow(operand1, operand2); // Swap oper2 and oper1 placements
                break;
            default:
                // Unknown operator, return before printing out the result
                System.out.println("Invalid operator: " + operator);
                return;
        }
        System.out.printf("%.2f %s %.2f = %.2f\n", operand1, operator, operand2, result);
    }

    private static void displayCalculatorInstructions() {
        System.out.println("Enter a mathematical expression to evaluate.");
        System.out.println("Valid operations are: +, -, /, *, ^ (for exponents).");
        System.out.println("Input expression using spaces between the operands (numbers) "
                + "and the operator, followed by Enter.");
        System.out.println("Here is the valid format:");
        System.out.println("\t<operand1> <space> <operator> <space> <operand2> <Enter>");
        System.out.print("Your expression: ");
    }

    //The method header for getUserSelection has no errors.
    private static String getUserSelection(Scanner console) {
        return console.next(); // We need string, not int
    }

    private static void displayMenu() {
        System.out.println("Enter one of these options:");
        System.out.println("\tH for Help");
        System.out.println("\tC for using calculator");
        System.out.println("\tE for exiting this program");
        System.out.print("Your selection: ");
    }
}
package learn.hyperskill.practice.conditions;

import java.util.Scanner;

/**
 * Given a simple equation, you should output the correct value for variable "x".
 * The equation has two numbers greater than 0 and variable "x",
 * and between these can be "+", "-" or "=". Numbers, variable "x",
 * symbols "+", "-", "=" all separated by a space.
 *
 * It is guaranteed that the equation is correct. The result should be an integer.
 */
public class SimpleEquation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] tokens = line.split(" = ");
        if ("x".equals(tokens[0])) {
            System.out.println(calculateExpression(tokens[1]));
            return;
        } else if ("x".equals(tokens[1])) {
            System.out.println(calculateExpression(tokens[0]));
            return;
        }
        String exprStr;
        String resultStr;
        if (tokens[0].contains("x")) {
            exprStr = tokens[0];
            resultStr = tokens[1];
        } else {
            exprStr = tokens[1];
            resultStr = tokens[0];
        }
        int result = Integer.parseInt(resultStr);
        String[] exprTokens = exprStr.split(" ");
        String operandStr;
        if ("x".equals(exprTokens[0])) {
            operandStr = exprTokens[2];
        } else {
            operandStr = exprTokens[0];
        }
        int operand = Integer.parseInt(operandStr);
        String operator = exprTokens[1];
        int x;
        if ("+".equals(operator)) {
            x = result - operand;
        } else {
            if ("x".equals(exprTokens[0])) {
                x = result + operand;
            } else {
                x = operand - result;
            }
        }
        System.out.println(x);
    }

    private static int calculateExpression(String exprStr) {
        String[] tokens = exprStr.split(" ");
        int x;
        if ("+".equals(tokens[1])) {
            x = Integer.parseInt(tokens[0]) + Integer.parseInt(tokens[2]);
        } else {
            x = Integer.parseInt(tokens[0]) - Integer.parseInt(tokens[2]);
        }
        return x;
    }
}

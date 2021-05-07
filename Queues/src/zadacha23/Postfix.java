package zadacha23;

import java.util.Scanner;
import java.util.Stack;

public class Postfix {
	public static void main(String[] args) {
// Check number of arguments passed
		System.out.println("Enter an expression: ");
		Scanner sc = new Scanner(System.in);
		String expression = sc.nextLine();
		try {
			System.out.println(evaluateExpression(expression));
		} catch (Exception ex) {
			System.out.println("Wrong expression: " + args[0]);
		}

	}

	/** Evaluate an expression */
	public static int evaluateExpression(String expression) {
// Create operandStack to store operands
		Stack<Integer> operandStack = new Stack<Integer>();
//Create operatorStack to store operators
		//Stack<Character> operatorStack = new Stack<Character>();
		
//Insert blanks around (, ), +, -, /, and * ( 7 + 9  ) * 6
		expression = insertBlanks(expression);
//Extract operands and operators
		String[] tokens = expression.split(" ");
//Phase 1: Scan tokens
		for (String token : tokens) {
			if (token.length() == 0) // Blank space
				continue; // Back to the while loop to extract the next token
			
//Process all +, -, *, / in the top of the operator stack
				else if  (token.charAt(0) == '-' || token.charAt(0) == '+' ||token.charAt(0) == '^' 
						||token.charAt(0) == '/') {
					processAnOperator(operandStack, token.charAt(0));
		
			} else { // An operand scanned
////Push an operand to the stack
				operandStack.push(Integer.valueOf(token));
			}

		}
		
			return operandStack.pop(); // return the element in the stack // there must be one left 
		
	}

	/**
	 * Process one operator: Take an operator from operatorStack and apply it on the
	 * operands in the operandStack
	 */
	
	// an expression is instantly proceeded
	
	public static void processAnOperator(Stack<Integer> operandStack, char op) {
	// op is the only math operation to process // cause we ain't collecting them in a stack
		// an operator is instantly proceeded
		int op1 = operandStack.pop();
		int op2 = operandStack.pop();
		if (op == '+')
			operandStack.push(op2 + op1);
		else if (op == '-')
			operandStack.push(op2 - op1);
		else if (op == '*')
			operandStack.push(op2 * op1);
		else if (op == '/')
			operandStack.push(op2 / op1);
		else if (op == '^')  // adding the situation "^"
			operandStack.push((int)Math.pow(op2, op1));// the first element (op1) will be the second number to be taken out
													// pop takes the last element
	}
 // insert spaces between the elements
	public static String insertBlanks(String s) {
		String result = "";
		for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '(' || s.charAt(i) == ')' || s.charAt(i) == '+' || s.charAt(i) == '-'
					|| s.charAt(i) == '*' || s.charAt(i) == '/' || s.charAt(i) == '^')
				result += " " + s.charAt(i) + " ";
			else
				result += s.charAt(i);
		}
		return result;
	}
}

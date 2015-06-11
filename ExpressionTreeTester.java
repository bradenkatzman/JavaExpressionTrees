//***********************************************
//This is an ExpressionTreeTester
//It takes a postfix equation input from user,
//makes an expression tree, and evaluates
//Braden Katzman bmk2137
//***********************************************

import java.util.Scanner;

public class ExpressionTreeTester 
{	
	public static void main(String[] args) 
	{	
		ExpressionTree et = new ExpressionTree();
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a postfix expression, made up of single"
		+ " digit numbers and the +, -, *, and / operators, to have it "
		+ "evaluated using an Expression Tree: ");
		String s = input.next(); //input error checking?
		System.out.println("If program terminates with results: 'stack "
		+ "underflow -- stack is empty' the input is not a correct postfix"
		+ " expression. Rerun program with correct input.");
		System.out.println("Results: ");
		
		et.buildExpressionTree(s);
		et.showAllNotations();
		
		ExpressionTreeEvaluator x = new ExpressionTreeEvaluator();
		System.out.println(s + " = " + x.evaluate(s));
	}
}
//*************************************************
//This is an ExpressionTreeEvaluator
//It uses a stack to evaluate a postfix expression
//Braden Katzman bmk2137
//*************************************************

public class ExpressionTreeEvaluator
{
	MyStack<Integer> ms;

   public ExpressionTreeEvaluator()
   {
	   
   }

   public int evaluate (String s)
   {
	  //instantiates new stack based on length of postfix expression string 
	  ms = new MyStack<Integer>(s.length());
	  
	  int operation0;
      int operation1;
      int result = 0;
     
      for (int i = 0; i < s.length(); i++)
      {
         //if char is operator, pop numbers and evaluate, then push result
    	 if (isOperator(s.charAt(i)))
         {
        	operation0 = ms.pop();
            operation1 = ms.pop();
            
            result = evalSingleOp (s.charAt(i), operation0, operation1);
            ms.push(new Integer(result));
         }
         //if char is number, push it on the stack
    	 else
         {   
        	 ms.push(new Integer((int) (s.charAt(i) - '0')));
         }
      }
      return result;
   }

   private boolean isOperator (char ch)
   {
      //checks if a character is an operator
	   return (ch == '+' || ch == '-' || ch == '*' ||
    		  ch == '/');
   }

   private int evalSingleOp (char operation, int operation0, int operation1)
   {
      //evaluates single operations to be pushed back onto stack
	  int result = 0;

      if (operation == '+')
      {
    	  result = operation0 + operation1;
      }
      else if (operation == '-')
      {
    	  result = operation0 - operation1;
      }
      else if (operation == '*')
      {
    	  result = operation0 * operation1;
      }
      else
      {
    	  result = operation0 / operation1;
      }
      return result;
   }
}
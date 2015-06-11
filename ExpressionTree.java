//**********************************************
//This is an ExpressionTree Class
//It creates an expression tree from a string
//Braden Katzman bmk2137
//**********************************************

public class ExpressionTree 
{
		//nested helper class
		public class TreeNode
		{
			char data;
			TreeNode left;
			TreeNode right;
			
			public TreeNode(TreeNode left, TreeNode right, char data)
			{
				this.left = left;
				this.right = right;
				this.data = data;
			}
		}
		
	String postfixEquation;
	TreeNode root;
	MyStack<TreeNode> ms; 
	Character[] array;
	
	public ExpressionTree()
	{
		
	}
	
	public void buildExpressionTree(String postfixEquation)
	{
		//creates an array of characters from the input string
		this.postfixEquation = postfixEquation;
		toCharacterArray(this.postfixEquation);
		
		//instantiates a new stack based on size of char array
		ms = new MyStack<TreeNode>(array.length);
		
		int i = 0;
		while (i < array.length)
		{
			//pushes numbers onto stack
			if(array[i] >= '0' && array[i] <= '9')
			{
				TreeNode x = new TreeNode(null, null, array[i]);
				ms.push(x);
			}
			//pops numbers and sets them as children of operator pushed back on
			else
			{
				TreeNode right = ms.pop();
				TreeNode left = ms.pop();
				TreeNode x = new TreeNode(left, right, array[i]);
				ms.push(x);
			}
			i++;
		}
	}
	
	public void toPrefixNotation(TreeNode x)
	{
		if (x != null)
		{
			System.out.print(x.data);
			toPrefixNotation(x.left);
			toPrefixNotation(x.right);
		}
	}
	
	public void toInfixNotation(TreeNode x)
	{
		if (x != null)
		{
			if (x.left != null)
			{
				System.out.print("(");
				
				toInfixNotation(x.left);
				
				System.out.print(x.data);
				
				toInfixNotation(x.right);

				System.out.print(")");
			}
			else
			{
				System.out.print("(" + x.data + ")");
			}
		}
	}
	
	public void getPostfixNotation()
	{
		System.out.print(this.postfixEquation);
	}
	
	public void showAllNotations()
	{
		
		TreeNode x = ms.pop();
		toInfixNotation(x);
		System.out.println(" - infix notation");
		
		toPrefixNotation(x);
		System.out.println(" - prefix notation");
		
		getPostfixNotation();
		System.out.println(" - postfix notation");
		
	}
	
	public Character[] toCharacterArray(String s)
	{
		int length = s.length();
		array = new Character[length];
		
		//copies characters in a string into an array
		for (int i = 0; i < length; i++)
		{
			array[i] = new Character(s.charAt(i));
		}
		
		return array;
	}
}
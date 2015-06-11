
public class MyStack<AnyType> 
{
	AnyType[] array;
	int size;
	int top;
	private final static int defaultArraySize = 10;
	
	public MyStack()
	{
		//explicit constructor invocation
		this(defaultArraySize);
	}
	
	public MyStack(int s)
	{
		this.size = s;
		array = (AnyType[]) new Object[s];
		top = -1;
	}
	
	public void push(AnyType x)
	{
		if (top < size)
		{
			top++;
			array[top] = x;
		}
	}
	
	public AnyType pop()
	{
		if (top > -1)
		{
			AnyType x = array[top];
			top--;
			return x;
		}
		else
		{
			System.out.println("stack underflow -- stack is empty");
			System.exit(0);
		}
		return null;
	}

	public boolean isEmpty()
	{
		if (top == -1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public AnyType peek()
	{
		return array[top];
	}
}
package d0915;

class MyStackLinkedListVersion {
	private int numOfData;			// Stack �� ����� ������ ����
	private int stackArray[];		// Stack �� ������ ���� Array
	private final int ARRAY_SIZE;	// Stack ��� ������ ������
	
	MyStackLinkedListVersion(int argSizeOfArray) {
		ARRAY_SIZE = argSizeOfArray;
		stackArray= new int[ARRAY_SIZE];
	}
	
	// Stack �� �����Ͱ� Full���� Ȯ��
		boolean IsFull() {
			if(numOfData == ARRAY_SIZE)
				return true;
			
			return false;
		}
	
	// Stack �� �����Ͱ� Empty���� Ȯ��
	boolean IsEmpty() {
		if(numOfData == 0)
			return true;
		
		return false;
	}
	
	// Top�� ������ ����
	boolean push(int argValue) {
		if(IsFull())
			return false;
		
		stackArray[numOfData] = argValue;
		numOfData++;
		
		return true;
	}
		
	// Top�� ������ ���� �� ��ȯ
	int pop() {
		if(IsEmpty())
			return Integer.MAX_VALUE;
		
		int temp = stackArray[numOfData - 1];
		stackArray[numOfData - 1] = 0;
		numOfData--;
		
		return temp;
	}
	
	@Override
	public String toString() {
		String msg = "";
		for (int i = 0; i < stackArray.length; i++)
			msg += " " + stackArray[i];
		return msg;
	}
}

public class Stack_array {

	public static void main(String[] args) {
		MyStackLinkedListVersion myStack = new MyStackLinkedListVersion(5);
		
		myStack.push(5);
		myStack.push(6);
		myStack.push(7);
		myStack.push(8);
		myStack.push(9);
		myStack.push(10);
		System.out.println(myStack);
		
		System.out.println("POP : " + myStack.pop());
		System.out.println(myStack);
		
		System.out.println("POP : " + myStack.pop());
		System.out.println(myStack);

		System.out.println("POP : " + myStack.pop());
		System.out.println(myStack);
		
		System.out.println("POP : " + myStack.pop());
		System.out.println(myStack);
		
		System.out.println("POP : " + myStack.pop());
		System.out.println(myStack);
		
		myStack.push(10);
		System.out.println(myStack);

	}

}

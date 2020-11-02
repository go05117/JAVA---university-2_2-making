package d0915;

// Node
class Node {
	Node nextNode;
	int value;
	
	Node (int argValue, Node argNode) {
		value		= argValue;
		nextNode	= argNode;
	}
}

class MyStackLinkedListVersion2 {
	Node head, tail;
	int numOfData;
	
	MyStackLinkedListVersion2() {
		tail = new Node(0, null);
		head = new Node(0, tail);
	}
	
	// Stack �� �����Ͱ� Empty���� Ȯ��
	boolean IsEmpty() {
		if(numOfData == 0)
			return true;
		
		return false;
	}
	
	// Top�� ������ ����
	int push(int argValue) {
		Node newNode = new Node(argValue, head.nextNode);
		head.nextNode = newNode;
		return ++numOfData;
	}
	
	// Top�� ������ ���� �� ��ȯ
	int pop() {
		if(IsEmpty())
			return Integer.MAX_VALUE;
		
		Node temp = head.nextNode;
		int value = temp.value;
		head.nextNode = temp.nextNode;
		temp = null;
		numOfData--;
		
		return value;
	}
	
	@Override
	public String toString() {
		String msg = "";
		Node temp = head.nextNode;
		while(temp.nextNode != null) {
			msg += " " + temp.value;
			temp = temp.nextNode;
		}
		return msg;
	}
}

public class Stack_list {

	public static void main(String[] args) {
		MyStackLinkedListVersion2 myStack = new MyStackLinkedListVersion2();
		
		myStack.push(5);
		myStack.push(6);
		myStack.push(7);
		myStack.push(8);
		myStack.push(9);
		
		System.out.println(myStack);
		
		System.out.println("POP : " + myStack.pop());
		System.out.println("POP : " + myStack.pop());
		
		System.out.println(myStack);

	}

}

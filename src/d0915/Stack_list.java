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
	
	// Stack 내 데이터가 Empty인지 확인
	boolean IsEmpty() {
		if(numOfData == 0)
			return true;
		
		return false;
	}
	
	// Top에 데이터 삽입
	int push(int argValue) {
		Node newNode = new Node(argValue, head.nextNode);
		head.nextNode = newNode;
		return ++numOfData;
	}
	
	// Top에 데이터 삭제 후 반환
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

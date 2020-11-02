package d0915;

// Node
class Node2 {
	Node2 nextNode;
	String value;
	
	Node2 (String argValue, Node2 argNode) {
		value		= argValue;
		nextNode	= argNode;
	}
}

class StackLinkedList {
	Node2 head, tail;
	int numOfData;
	
	StackLinkedList() {
		tail = new Node2("0", null);
		head = new Node2("0", tail);
	}
	
	// ���ÿ� �� �����Ͱ� ������� Ȯ��
	boolean IsEmpty() {
		if(numOfData == 0)
			return true;
		
		return false;
	}
	
	// ���� �� �Է�
	void push(String argValue) {
		// ������ ���ο� ��� ����, ���ο� ����� ���� ���� ���� head ����� ���� ���
		Node2 newNode = new Node2(argValue, head.nextNode);
		// ��� ���� ���� ���ο� ��� ����
		head.nextNode = newNode;
		// ��ü ������ �� ����
		numOfData++;
	}
	
	// ���� �� ����
	void pop() {
		// ������ ������� Ȯ��
		if (IsEmpty()) {
			// ������ ������� ������ ��ȯ
			System.out.println("���� �����ϴ�.");
			return;
		}
		
		// �� ������ �ƴ϶��
		// ���ο� ��带 ��� ���� ���� ����
		Node2 temp = head.nextNode;
		// ���ο� ��� ���� ��带 ���� ��� ����� ���� ���� ����
		head.nextNode = temp.nextNode;
		// ��ü ������ �� ����
		numOfData--;
	}
	
	// ��ü�� ���ڷ� ǥ���ϴ� �޼ҵ� ���
	@Override
	public String toString() {
		String msg = "";
		Node2 temp = head.nextNode;
		while(temp.nextNode != null) {
			msg += " " + temp.value;
			temp = temp.nextNode;
		}
		return msg;
	}
}

public class Stack_list2 {

	public static void main(String[] args) {
		StackLinkedList stackll = new StackLinkedList();
		
		stackll.push("����");
		stackll.push("����");
		stackll.push("�ٴ�");
		stackll.push("���");
		stackll.push("����");
		System.out.println(stackll);
		
		stackll.pop();
		stackll.pop();
		System.out.println(stackll);
		
		stackll.pop();
		stackll.pop();
		System.out.println(stackll);
		
		stackll.pop();
		stackll.pop();
		System.out.println(stackll);
	}

}

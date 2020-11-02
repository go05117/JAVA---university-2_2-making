package d1020;

//Node
class Node {
	private int value;			// Data of Node : 데이터 값
	private Node nextNode;		// Indicate next node : 다음 노드 주소 가리키기
	
	Node (int argValue, Node argNode) {
		value		= argValue;
		nextNode	= argNode;
	}

	Node getNextNode() { return nextNode; }
	void setNextNode(Node argNode) { nextNode = argNode; }
	int getValue() { return value; }
	void setValue(int argValue) { value = argValue; }
	
}

//Linked List 설계
public class list_linked {
	Node headNode, tailNode;
	int numOfData;
	
	list_linked() {
		// head node, tail node
		tailNode = new Node(0, null);
		headNode = new Node(0, tailNode);
	}
	
	// 사용자가 선택한 인덱스가 유효값 안에 있는지 확인
	boolean isValidIndex(int argIndex) {
		if(argIndex < 0 && argIndex > numOfData)
			return false;
		return true;
	}

	// 리스트가 비었는지 확인
	boolean isEmpty() {
		if(numOfData == 0) {
			return true;
		}
		return false;
	}
	
	// 요소 추가 - 중간
	void add(int argIndex, int argValue) {
		
		if(isValidIndex(argIndex)) {
			Node head = headNode;
			// [0 1 4 2 3 4]
			for(int i = 0; i < argIndex; i++)
				head = head.getNextNode();
			
			Node newNode = new Node(argValue, head.getNextNode());
			head.setNextNode(newNode);
			
			numOfData++;
		}
	}
	
	// 요소 추가 - 마지막
	void add(int argValue) {
		add(numOfData, argValue);
	}
	
	// 요소 가져오기
	int get(int argIndex) {
		if(isValidIndex(argIndex)) {
			Node head = headNode;
			for(int i = 0; i <= argIndex; i++)
				head = head.getNextNode();
			
			return head.getValue();
		}
			
		return Integer.MAX_VALUE;
	}
	
	// 요소 변경
	void set(int argIndex, int argValue) {
		if(!isEmpty() && isValidIndex(argIndex)) {
			Node head = headNode;
			for(int i = 0; i <= argIndex; i++)
				head = head.getNextNode();
			
			head.setValue(argValue);
		}
	}
	
	// 요소 삭제
	void remove(int argIndex) {		
		if(!isEmpty() && isValidIndex(argIndex)) {
			Node head = headNode;
			Node previousNode = null;
			
			// [0 1 4 2 3 4]
			for(int i = 0; i <= argIndex; i++) {
				previousNode = head;
				head = head.getNextNode();
			}
			
			previousNode.setNextNode(head.getNextNode());
			numOfData--;
		}
	}
	
	public String toString() {
		String msg = "";
		Node head = headNode.getNextNode();
		
		while(head.getNextNode() != null) {
			msg += " " + head.getValue();
			head = head.getNextNode();
		}	
		return msg;
	}
	
	public static void main(String[] args) {
		list_linked myList = new list_linked();
		
		myList.add(4);
		myList.add(5);
		myList.add(6);
		myList.add(7);
		myList.add(8);
		System.out.println(myList);
		
		myList.add(1,20);
		myList.add(5,30);
		System.out.println(myList);
		
		myList.set(3, 40);
		System.out.println(myList);
		
		myList.remove(4);
		myList.remove(0);
		myList.remove(4);
		System.out.println(myList);
		
		System.out.println(myList.get(2));
	}	
}

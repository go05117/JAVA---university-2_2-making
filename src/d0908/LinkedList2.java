package d0908;

// Node
class Node3 {
	Node3 (String argValue, Node3 argNode) {
		value		= argValue;
		nextNode	= argNode;
	}

	Node3 getNextNode() { return nextNode; }
	void setNextNode(Node3 argNode) { nextNode = argNode; }
	String getValue() { return value; }
	void setValue(String argValue) { value = argValue; }
	private String value;		// Data of Node : 데이터 값
	private Node3 nextNode;		// Indicate next node : 다음 노드 주소 가리키기
}

// Linked List 설계
public class LinkedList2 {
	Node3 headNode, tailNode;
	
	LinkedList2() {
		// head node, tail node
		tailNode = new Node3("0", null);
		headNode = new Node3("0", tailNode);
	}
	
	// 리스트 원소 삽입
	void insertValue(String argValue) {
		Node3 temp = headNode;
		
		// 원소 삽입은 Tail node 전에 들어가야함
		while(temp.getNextNode() != tailNode)
			temp = temp.getNextNode();
		
		// 삽입할 노드 생성, 삽입된 노드의 Next Node는 무조건 Tail Node
		Node3 insertNode = new Node3(argValue, tailNode);
		
		// 이전 Tail node와 연결된 Node의 Next Node 값을
		// 새롭게 생성되는 노드로 수정
		temp.setNextNode(insertNode);
	}
	
	// 사용자가 입력한 값을 가진 노드 반환
	Node3 getNodeByValue(String argValue) {
		Node3 temp = headNode;
		
		// Head 노드에서 Tail 노드 전까지 순회하여 사용자가 입력한 값을 찾는다.
		while(temp.getNextNode() != null) {
			if(temp.getValue() == argValue)
				return temp;
			else
				temp = temp.getNextNode();
		}
		return null;
	}
	
	// 리스트 중간에 사용자가 입력한 값 삽입 시(삽입할 값이 넣을 위치 전에 있는 값, 삽입할 값)
	void insertMiddleNode(Node3 argNode, String argValue) {
		// 삽입할 노드 생성
		// 새로 삽입할 node의 다음 node는 기존 node의 nextNode
		Node3 newNode = new Node3(argValue, argNode.getNextNode());
		
		// 기존 node의 next node 값은 새로 추가한 노드
		argNode.setNextNode(newNode);
	}
	
	// 리스트에서 사용자가 입력한 값 삭제
	void deleteNode(String argValue) {
		Node3 temp = headNode;
		Node3 prevNode = headNode;		// 삭제할 노드를 찾는 변수
		
		// Head 노드에서 Tail 노드 전까지 순회하여 사용자가 입력한 값을 찾아 삭제 및 shift
		while(temp.getNextNode() != null) {
			if(temp.getValue() == argValue) {
				prevNode.setNextNode(temp.getNextNode());
				temp = null;
				
				return;
			}
			prevNode = temp;
			temp = temp.getNextNode();
		}
		return;
	}
}

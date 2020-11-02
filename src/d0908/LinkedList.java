package d0908;

public class LinkedList {

	LinkedList() {
		// Create Head and Tail Node
		tailNode = new Node(0, null);
		headNode = new Node(0, tailNode);
	}
	
	// 리스트 마지막에 원소 추가
	void insertValue(int argValue) {
		Node temp = headNode;
		
		// Head 노드에서 Tail 노드까지 순회
		while(temp.getNextNode() != tailNode)
			temp = temp.getNextNode();
		
		// 삽입할 노드 생성, 삽입된 노드의 Next Node는 TailNode
		Node newNode = new Node(argValue, tailNode);
		
		// 이전 Tail node와 연결된 Node의 Next Node 값을
		// 새롭게 생성되는 노드로 수정
		temp.setNextNode(newNode);
	}
	
	Node headNode, tailNode;	// Head and Tail Nodes
	
	// 입력 값과 같은 값을 가지는 노드 반환
	Node getNodeByValue(int argValue) {		
		Node temp = headNode;
		
		// Head 노드에서 Tail 노드까지 순회
		while(temp.getNextNode() != null) {
			if(temp.getValue() == argValue)
				return temp;
			
			temp = temp.getNextNode();
		}
		return null;
	}
	
	void insertAfterNode(Node argNode, int argValue) {
		// 삽입할 노드 생성, 삽입된 노드의 Next Node는 argNode의 next node
		Node newNode = new Node(argValue, argNode.getNextNode());
		
		// argNode node의 Next node 값을 새로 생성되는 노드로 수정
		argNode.setNextNode(newNode);
	}
	
	boolean deleteNodeByValue(int argValue) {
		Node temp = headNode;
		Node previousNode = headNode;
		
		// Head 노드에서 Tail 노드까지 순회
		while(temp.getNextNode() != null) {
			if(temp.getValue() == argValue) {
				previousNode.setNextNode(temp.getNextNode());
				temp = null;
				
				return true;
			}
			previousNode = temp;
			temp = temp.getNextNode();
		}
		return false;
	}
}

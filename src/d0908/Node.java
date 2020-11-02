package d0908;

// Node
public class Node {
	Node (int argValue, Node argNode) {
		value		= argValue;
		nextNode	= argNode;
	}

	Node getNextNode() { return nextNode; }
	void setNextNode(Node argNode) { nextNode = argNode; }
	int getValue() { return value; }
	void setValue(int argValue) { value = argValue; }
	private int value;		// Data of Node : 데이터 값
	private Node nextNode;	// Indicate next node : 다음 노드 주소 가리키기
}
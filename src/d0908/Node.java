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
	private int value;		// Data of Node : ������ ��
	private Node nextNode;	// Indicate next node : ���� ��� �ּ� ����Ű��
}
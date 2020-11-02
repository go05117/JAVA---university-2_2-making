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
	private String value;		// Data of Node : ������ ��
	private Node3 nextNode;		// Indicate next node : ���� ��� �ּ� ����Ű��
}

// Linked List ����
public class LinkedList2 {
	Node3 headNode, tailNode;
	
	LinkedList2() {
		// head node, tail node
		tailNode = new Node3("0", null);
		headNode = new Node3("0", tailNode);
	}
	
	// ����Ʈ ���� ����
	void insertValue(String argValue) {
		Node3 temp = headNode;
		
		// ���� ������ Tail node ���� ������
		while(temp.getNextNode() != tailNode)
			temp = temp.getNextNode();
		
		// ������ ��� ����, ���Ե� ����� Next Node�� ������ Tail Node
		Node3 insertNode = new Node3(argValue, tailNode);
		
		// ���� Tail node�� ����� Node�� Next Node ����
		// ���Ӱ� �����Ǵ� ���� ����
		temp.setNextNode(insertNode);
	}
	
	// ����ڰ� �Է��� ���� ���� ��� ��ȯ
	Node3 getNodeByValue(String argValue) {
		Node3 temp = headNode;
		
		// Head ��忡�� Tail ��� ������ ��ȸ�Ͽ� ����ڰ� �Է��� ���� ã�´�.
		while(temp.getNextNode() != null) {
			if(temp.getValue() == argValue)
				return temp;
			else
				temp = temp.getNextNode();
		}
		return null;
	}
	
	// ����Ʈ �߰��� ����ڰ� �Է��� �� ���� ��(������ ���� ���� ��ġ ���� �ִ� ��, ������ ��)
	void insertMiddleNode(Node3 argNode, String argValue) {
		// ������ ��� ����
		// ���� ������ node�� ���� node�� ���� node�� nextNode
		Node3 newNode = new Node3(argValue, argNode.getNextNode());
		
		// ���� node�� next node ���� ���� �߰��� ���
		argNode.setNextNode(newNode);
	}
	
	// ����Ʈ���� ����ڰ� �Է��� �� ����
	void deleteNode(String argValue) {
		Node3 temp = headNode;
		Node3 prevNode = headNode;		// ������ ��带 ã�� ����
		
		// Head ��忡�� Tail ��� ������ ��ȸ�Ͽ� ����ڰ� �Է��� ���� ã�� ���� �� shift
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

package d0908;

public class LinkedList {

	LinkedList() {
		// Create Head and Tail Node
		tailNode = new Node(0, null);
		headNode = new Node(0, tailNode);
	}
	
	// ����Ʈ �������� ���� �߰�
	void insertValue(int argValue) {
		Node temp = headNode;
		
		// Head ��忡�� Tail ������ ��ȸ
		while(temp.getNextNode() != tailNode)
			temp = temp.getNextNode();
		
		// ������ ��� ����, ���Ե� ����� Next Node�� TailNode
		Node newNode = new Node(argValue, tailNode);
		
		// ���� Tail node�� ����� Node�� Next Node ����
		// ���Ӱ� �����Ǵ� ���� ����
		temp.setNextNode(newNode);
	}
	
	Node headNode, tailNode;	// Head and Tail Nodes
	
	// �Է� ���� ���� ���� ������ ��� ��ȯ
	Node getNodeByValue(int argValue) {		
		Node temp = headNode;
		
		// Head ��忡�� Tail ������ ��ȸ
		while(temp.getNextNode() != null) {
			if(temp.getValue() == argValue)
				return temp;
			
			temp = temp.getNextNode();
		}
		return null;
	}
	
	void insertAfterNode(Node argNode, int argValue) {
		// ������ ��� ����, ���Ե� ����� Next Node�� argNode�� next node
		Node newNode = new Node(argValue, argNode.getNextNode());
		
		// argNode node�� Next node ���� ���� �����Ǵ� ���� ����
		argNode.setNextNode(newNode);
	}
	
	boolean deleteNodeByValue(int argValue) {
		Node temp = headNode;
		Node previousNode = headNode;
		
		// Head ��忡�� Tail ������ ��ȸ
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

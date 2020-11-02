package d0908;

// �ڷᱸ����
// Data�� �����ϰ� �����ϱ� ���� ������� �����ϰ� �̸� �й�ȭ�� ����

// Linked-List
// ���� : Node
// ���� Node�� �Ѿ�� ���� �ʿ��� ���� Reference Pointer
// ������ ���ٱ��� -> �츮�� ���ϴ� �����͸� ã�����ؼ��� ó���� ���� ������ Ÿ�� ������
// �׷��� ���ؼ��� linked-list�� ���� node�� head�� �ʿ�
// ������ ��带 �˷��ֱ� ���� tail�̶� node ���� �ʿ�

// Linked-List�� ���� ���� :
// �迭�� ����
// 1. ũ�� ������ �Ұ����ϴ�.
// 2. ����, ������ ���� ��ǻ�� �Ŀ��� ���� �Ҹ�ȴ�.


// Random access : �迭 a[] -> a[3]
// Sequential access : ó�� -> Target���� ��� ���Ҹ� Ÿ�� ����., ��) ī��Ʈ ������

class Node2 {
	Node2 (int argValue, Node2 argNextNode) {
		value		= argValue;
		nextNode	= argNextNode;
	}
	int value;
	Node2 nextNode;
}

public class aprof_said {
	public static void main(String[] args) {
		Node2 node_a = new Node2(1, null);
		Node2 node_b = new Node2(2, node_a);
		
		System.out.println(node_a);				// node_a ��ü�� �޸� �ּ�
		System.out.println(node_b.nextNode);	// node_b ��ü �� nextNode ��������� ��
	}
}
package d1020;

class MyCircularQueue {
	private final int MAX_QUEUE_SIZE;
	private int queueList[];
	private boolean isOWRMode;
	private int startIndex;
	private int endIndex;
	private int numOfData;
	
	MyCircularQueue(int argSizeOfQueue) {
		MAX_QUEUE_SIZE = argSizeOfQueue;
		queueList = new int[MAX_QUEUE_SIZE];
	}
	
	// ������ ���� : ť�� ���� ������ ��ġ�� �Է� ������ ����
	boolean enqueue(int argValue) {
		// ť�� ����� ���� á�� ���
		if(numOfData == MAX_QUEUE_SIZE)
			return false;
		
		// �� END Index ��ġ�� �Է� �� Queue�� ����
		// End Index�� ť�� ���Ӱ� ���Ե� �������� ���� ��ġ�� ��Ÿ��
		queueList[endIndex] = argValue;
		endIndex = (endIndex)
	}
}

class MyQueueListVersion {
	Node head, tail;
	int numOfData;
	
	MyQueueListVersion() {
		tail = new Node(0, null);
		head = new Node(0, tail);
	}
	
	// Queue �����Ͱ� Empty���� Ȯ��
	boolean IsEmpty() {
		if(numOfData == 0)
			return true;
		
		return false;
	}
	
	// Queue�� ���� ������ ��ġ�� ������ ����
	void enqueue(int argValue) {
		Node temp = head;
		while(temp.nextNode != tail)
			temp = temp.nextNode;
		numOfData++;
	}
	
	// Queue�� ����� ��ȯ
	int getSize() {
		return numOfData;
	}
	
	// Queue�� ���� ���� ������ ���� �� ��ȯ
	int dequeue() {
		// Queue ����� 0�̸�
		if(IsEmpty())
			return Integer.MAX_VALUE;
		
		Node deleteNode = head.nextNode;
		head.nextNode = deleteNode.nextNode;
		int value = deleteNode.value;
		deleteNode = null;
		numOfData--;
		
		return value;
	}
	
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

public class Circular_Queue {

	public static void main(String[] args) {
		MyQueueListVersion myQueue = new MyQueueListVersion();
		
		System.out.println("Enqueue : 1");	myQueue.enqueue(1);
		System.out.println("Enqueue : 2");	myQueue.enqueue(2);
		System.out.println("Enqueue : 3");	myQueue.enqueue(3);
		System.out.println(myQueue);
		
		System.out.println("Dequeue : ");	myQueue.dequeue();
		System.out.println(myQueue);
		System.out.println("Dequeue : ");	myQueue.dequeue();
		System.out.println(myQueue);
		
		System.out.println("Enqueue : 6");	myQueue.enqueue(6);
		System.out.println(myQueue);
		System.out.println("Dequeue : ");	myQueue.dequeue();
		System.out.println(myQueue);
		
	}

}

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
	
	// 데이터 삽입 : 큐의 제일 마지막 위치에 입력 데이터 삽입
	boolean enqueue(int argValue) {
		// 큐의 사이즈가 가득 찼을 경우
		if(numOfData == MAX_QUEUE_SIZE)
			return false;
		
		// 현 END Index 위치에 입력 값 Queue에 저장
		// End Index는 큐에 새롭게 삽입될 데이터의 저장 위치를 나타냄
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
	
	// Queue 데이터가 Empty인지 확인
	boolean IsEmpty() {
		if(numOfData == 0)
			return true;
		
		return false;
	}
	
	// Queue의 제일 마지막 위치에 데이터 삽입
	void enqueue(int argValue) {
		Node temp = head;
		while(temp.nextNode != tail)
			temp = temp.nextNode;
		numOfData++;
	}
	
	// Queue의 사이즈를 반환
	int getSize() {
		return numOfData;
	}
	
	// Queue의 제일 앞쪽 데이터 삭제 후 반환
	int dequeue() {
		// Queue 사이즈가 0이면
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

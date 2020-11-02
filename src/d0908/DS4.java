package d0908;

public class DS4 {

	public static void main(String[] args) {
		LinkedList myList = new LinkedList();
		
		myList.insertValue(2);
		myList.insertValue(3);
		myList.insertValue(4);
		myList.insertValue(5);
		
		// <-- myList 내 노드 값 출력
		Node temp = myList.headNode.getNextNode();
		
		while(temp != myList.tailNode) {
			System.out.println(temp.getValue());
			temp = temp.getNextNode();
		}
		// -->
		
		System.out.println("-------------------------------");
		LinkedList myList2 = new LinkedList();
		
		myList2.insertValue(2);
		myList2.insertValue(3);
		myList2.insertValue(4);
		myList2.insertValue(5);
		
		System.out.println(myList2.getNodeByValue(4).getValue());	// 4
		
		System.out.println("-------------------------------");
		LinkedList myList3 = new LinkedList();
		
		myList3.insertValue(2);
		myList3.insertValue(3);
		myList3.insertValue(4);
		myList3.insertValue(5);
		
		myList3.insertAfterNode(myList3.getNodeByValue(4), 20);
		
		// <<-- myList 내 노드 값 출력
		Node temp3 = myList3.headNode.getNextNode();
		
		while(temp3 != myList3.tailNode) {
			System.out.println(temp3.getValue());
			temp3 = temp3.getNextNode();
		}
		// -->>
		
		System.out.println("-------------------------------");
		LinkedList myList4 = new LinkedList();
		
		myList4.insertValue(2);
		myList4.insertValue(3);
		myList4.insertValue(4);
		myList4.insertValue(5);
		
		myList4.deleteNodeByValue(5);
		myList4.deleteNodeByValue(2);
		myList4.deleteNodeByValue(2);
		myList4.deleteNodeByValue(4);
		
		myList4.insertValue(1);
		
		// <<-- myList 내 노드 값 출력
		Node temp4 = myList4.headNode.getNextNode();
		
		while(temp4 != myList4.tailNode) {
			System.out.println(temp4.getValue());
			temp4 = temp4.getNextNode();
		}
		// -->>
	}
}

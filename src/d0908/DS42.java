package d0908;

public class DS42 {

	public static void main(String[] args) {
		LinkedList2 myList = new LinkedList2();
		
		myList.insertValue("가");
		myList.insertValue("나");
		myList.insertValue("다");
		myList.insertValue("롸");
		
		// <-- myList 내 노드 값 출력
		Node3 temp = myList.headNode.getNextNode();
		
		while(temp != myList.tailNode) {
			System.out.println(temp.getValue());
			temp = temp.getNextNode();
		}
		// -->
		
		System.out.println("-------------------------------");
		LinkedList2 myList2 = new LinkedList2();
		
		myList2.insertValue("가");
		myList2.insertValue("나");
		myList2.insertValue("다");
		myList2.insertValue("다");
		myList2.insertValue("라");
		
		System.out.println(myList2.getNodeByValue("다").getValue());	// 다
		
		System.out.println("-------------------------------");
		LinkedList2 myList3 = new LinkedList2();
		
		myList3.insertValue("가");
		myList3.insertValue("나");
		myList3.insertValue("다");
		myList3.insertValue("라");
		
		myList3.insertMiddleNode(myList3.getNodeByValue("다"), "바바예투");
		
		// <<-- myList 내 노드 값 출력
		Node3 temp3 = myList3.headNode.getNextNode();
		
		while(temp3 != myList3.tailNode) {
			System.out.println(temp3.getValue());
			temp3 = temp3.getNextNode();
		}
		// -->>
		
		System.out.println("-------------------------------");
		LinkedList2 myList4 = new LinkedList2();
		
		myList4.insertValue("가");
		myList4.insertValue("나");
		myList4.insertValue("다");
		myList4.insertValue("라");
		
		myList4.deleteNode("라");
		myList4.deleteNode("가");
		myList4.deleteNode("가");
		myList4.deleteNode("다");
		
		myList4.insertValue("봐밥");
		
		// <<-- myList 내 노드 값 출력
		Node3 temp4 = myList4.headNode.getNextNode();
		
		while(temp4 != myList4.tailNode) {
			System.out.println(temp4.getValue());
			temp4 = temp4.getNextNode();
		}
		// -->>
	}
}

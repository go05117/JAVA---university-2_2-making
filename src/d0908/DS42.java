package d0908;

public class DS42 {

	public static void main(String[] args) {
		LinkedList2 myList = new LinkedList2();
		
		myList.insertValue("��");
		myList.insertValue("��");
		myList.insertValue("��");
		myList.insertValue("��");
		
		// <-- myList �� ��� �� ���
		Node3 temp = myList.headNode.getNextNode();
		
		while(temp != myList.tailNode) {
			System.out.println(temp.getValue());
			temp = temp.getNextNode();
		}
		// -->
		
		System.out.println("-------------------------------");
		LinkedList2 myList2 = new LinkedList2();
		
		myList2.insertValue("��");
		myList2.insertValue("��");
		myList2.insertValue("��");
		myList2.insertValue("��");
		myList2.insertValue("��");
		
		System.out.println(myList2.getNodeByValue("��").getValue());	// ��
		
		System.out.println("-------------------------------");
		LinkedList2 myList3 = new LinkedList2();
		
		myList3.insertValue("��");
		myList3.insertValue("��");
		myList3.insertValue("��");
		myList3.insertValue("��");
		
		myList3.insertMiddleNode(myList3.getNodeByValue("��"), "�ٹٿ���");
		
		// <<-- myList �� ��� �� ���
		Node3 temp3 = myList3.headNode.getNextNode();
		
		while(temp3 != myList3.tailNode) {
			System.out.println(temp3.getValue());
			temp3 = temp3.getNextNode();
		}
		// -->>
		
		System.out.println("-------------------------------");
		LinkedList2 myList4 = new LinkedList2();
		
		myList4.insertValue("��");
		myList4.insertValue("��");
		myList4.insertValue("��");
		myList4.insertValue("��");
		
		myList4.deleteNode("��");
		myList4.deleteNode("��");
		myList4.deleteNode("��");
		myList4.deleteNode("��");
		
		myList4.insertValue("����");
		
		// <<-- myList �� ��� �� ���
		Node3 temp4 = myList4.headNode.getNextNode();
		
		while(temp4 != myList4.tailNode) {
			System.out.println(temp4.getValue());
			temp4 = temp4.getNextNode();
		}
		// -->>
	}
}

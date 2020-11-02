package d0915;

// Node
class Node2 {
	Node2 nextNode;
	String value;
	
	Node2 (String argValue, Node2 argNode) {
		value		= argValue;
		nextNode	= argNode;
	}
}

class StackLinkedList {
	Node2 head, tail;
	int numOfData;
	
	StackLinkedList() {
		tail = new Node2("0", null);
		head = new Node2("0", tail);
	}
	
	// 스택에 내 데이터가 비었는지 확인
	boolean IsEmpty() {
		if(numOfData == 0)
			return true;
		
		return false;
	}
	
	// 스택 값 입력
	void push(String argValue) {
		// 삽입할 새로운 노드 생성, 새로운 노드의 다음 노드는 기존 head 노드의 다음 노드
		Node2 newNode = new Node2(argValue, head.nextNode);
		// 헤드 다음 노드로 새로운 노드 지정
		head.nextNode = newNode;
		// 전체 데이터 수 증가
		numOfData++;
	}
	
	// 스택 값 삭제
	void pop() {
		// 스택이 비었는지 확인
		if (IsEmpty()) {
			// 스택이 비었으면 에러값 반환
			System.out.println("값이 없습니다.");
			return;
		}
		
		// 빈 스택이 아니라면
		// 새로운 노드를 헤드 다음 노드로 지정
		Node2 temp = head.nextNode;
		// 새로운 노드 다음 노드를 기존 헤드 노드의 다음 노드로 지정
		head.nextNode = temp.nextNode;
		// 전체 데이터 수 감소
		numOfData--;
	}
	
	// 객체를 문자로 표현하는 메소드 사용
	@Override
	public String toString() {
		String msg = "";
		Node2 temp = head.nextNode;
		while(temp.nextNode != null) {
			msg += " " + temp.value;
			temp = temp.nextNode;
		}
		return msg;
	}
}

public class Stack_list2 {

	public static void main(String[] args) {
		StackLinkedList stackll = new StackLinkedList();
		
		stackll.push("가다");
		stackll.push("나다");
		stackll.push("다다");
		stackll.push("라다");
		stackll.push("마다");
		System.out.println(stackll);
		
		stackll.pop();
		stackll.pop();
		System.out.println(stackll);
		
		stackll.pop();
		stackll.pop();
		System.out.println(stackll);
		
		stackll.pop();
		stackll.pop();
		System.out.println(stackll);
	}

}

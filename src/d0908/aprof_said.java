package d0908;

// 자료구조론
// Data를 저장하고 관리하기 위한 방법론을 제시하고 이를 학문화한 주제

// Linked-List
// 단위 : Node
// 다음 Node로 넘어가기 위해 필요한 것이 Reference Pointer
// 순차적 접근구조 -> 우리가 원하는 데이터를 찾기위해서는 처음의 시작 노드부터 타고 가야함
// 그러기 위해서는 linked-list의 시작 node인 head가 필요
// 마지막 노드를 알려주기 위한 tail이란 node 또한 필요

// Linked-List가 나온 이유 :
// 배열의 단점
// 1. 크기 변경이 불가능하다.
// 2. 삽입, 삭제에 대한 컴퓨팅 파워가 많이 소모된다.


// Random access : 배열 a[] -> a[3]
// Sequential access : 처음 -> Target까지 모든 원소를 타고 간다., 예) 카세트 테이프

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
		
		System.out.println(node_a);				// node_a 객체의 메모리 주소
		System.out.println(node_b.nextNode);	// node_b 객체 내 nextNode 멤버변수의 값
	}
}
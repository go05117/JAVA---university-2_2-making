package d0915;

// composite
// Array
// 1. 배열 생성 시 크기 고정
// 2. 배열 데이터 수정(삽입, 삭제)가 어려움

// List
// 단위 : Node
// Node 안에 value와 reference(다음 node를 가리키기위한 참조변수)가 있어야함
// 다음 Node로 넘어가기 위해 필요한 것이 Reference Pointer

// 단점 
// 1. 데이터를 저장하는데 저장공간을 손해 봄
// 2. 순차적 접근구조 -> 우리가 원하는 데이터를 찾기위해서는 처음의 시작 노드부터 타고 가야함

// 데이터를 접근하는 방법
//	=> Random Access(임의 접근)
//	=> Sequential access(순차 접근)
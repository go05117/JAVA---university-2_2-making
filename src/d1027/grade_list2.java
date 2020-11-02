package d1027;

import java.util.Scanner;

// 역순 출력 전

//Node
class Node {
	private Student value;		// Data of Node : 데이터 값
	private Node nextNode;		// Indicate next node : 다음 노드 주소 가리키기
	
	Node (Student argValue, Node argNode) {
		value		= argValue;
		nextNode	= argNode;
	}

	Node getNextNode() { return nextNode; }
	void setNextNode(Node argNode) { nextNode = argNode; }
	Student getValue() { return value; }
	void setValue(Student argValue) { value = argValue; }
}

//Linked List 설계
class LinkedList {
	Node headNode, tailNode;
	int numOfData;
	Student student = new Student();
	
	LinkedList() {
		// head node, tail node
		tailNode = new Node(null, null);
		headNode = new Node(null, tailNode);
	}
	
	// 사용자가 선택한 인덱스가 유효값 안에 있는지 확인
	boolean isValidIndex(int argIndex) {
		if(argIndex < 0 && argIndex > numOfData)
			return false;
		return true;
	}

	// 리스트가 비었는지 확인
	boolean isEmpty() {
		if(numOfData == 0) {
			return true;
		}
		return false;
	}
	
	// 요소 추가 - 중간
	void add(int argIndex, Student argObj) {
		
		if(isValidIndex(argIndex)) {
			Node head = headNode;
			// [0 1 4 2 3 4]
			for(int i = 0; i < argIndex; i++)
				head = head.getNextNode();
			
			Node newNode = new Node(argObj, head.getNextNode());
			head.setNextNode(newNode);
			
			numOfData++;
		}
	}
	
	// 요소 추가 - 마지막
	void add(Student argObj) {
		add(numOfData, argObj);
	}
	
	// 리스트의 객체 추가 및 삭제에 따른 랭크 변동
	void changeRank() {
		Node head1 = headNode.getNextNode();
		Node head2 = headNode.getNextNode();
		
		// 랭크 초기화
		for(int i = 0; i < numOfData; i++) {
			head1.getValue().setRank(1);
			head1 = head1.getNextNode();
		}
		
		head1 = headNode.getNextNode();
		for(int i = 0; i < numOfData; i++) {
			Student iCount = head1.getValue();
			for(int j = 0; j < numOfData; j++) {
				Student jCount = head2.getValue();
				int a = iCount.getSum();
				int b = jCount.getSum();
				if (a < b)
					iCount.setRank(iCount.getRank()+1);
				head2 = head2.getNextNode();
			}
			head1 = head1.getNextNode();
			head2 = headNode.getNextNode();
		}
	}
	
	// 학번에 따른 데이터 가져오기
	Student getStudentById(int argId) {
		Node head = headNode.getNextNode();
		for(int i = 0; i < numOfData; i++) {
			if(head.getValue().getId() == argId)
				return head.getValue();
			head = head.getNextNode();
		}
		return null;
	}
	
	// 학번에 따른 데이터 삭제
	boolean deleteStudentById(int argId) {
		if(!isEmpty()) {
			Node head = headNode;
			Node previousNode = null;
			
			for(int i = 0; i < numOfData; i++) {
				if(head.getNextNode().getValue().getId() == argId) {
					previousNode = head;
					head = head.getNextNode();
					previousNode.setNextNode(head.getNextNode());
					numOfData--;
					return true;
				}
				head = head.getNextNode();
			}
		}
		return false;
	}
	
	int size() {
		return numOfData;
	}
	
	public String toString() {
		String msg = "";
		Node head = headNode.getNextNode();
		
		while(head.getNextNode() != null) {
			msg += "\t" + head.getValue().getNum();
			msg += "\t" + head.getValue().getId();
			msg += "\t" + head.getValue().getKor();
			msg += "\t" + head.getValue().getEng();
			msg += "\t" + head.getValue().getMath();
			msg += "\t" + head.getValue().getSum();
			msg += "\t" + head.getValue().getAvg();
			msg += "\t" + head.getValue().getRank();
			
			head = head.getNextNode();
			msg += "\n";
		}
		return msg;
	}
}

class Student {
	private int num = 0;
	private int id = 0;
	private int kor = 0;
	private int eng = 0;
	private int math = 0;
	private int sum = 0;
	private int avg = 0;
	private int rank = 0;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public int getAvg() {
		return avg;
	}
	public void setAvg(int avg) {
		this.avg = avg;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public String toString(Student student) {
		String msg = "";
		
		msg += "\t" + student.getNum();
		msg += "\t" + student.getId();
		msg += "\t" + student.getKor();
		msg += "\t" + student.getEng();
		msg += "\t" + student.getMath();
		msg += "\t" + student.getSum();
		msg += "\t" + student.getAvg();
		msg += "\t" + student.getRank();
			
		msg += "\n";
		
		return msg;
	}
}


public class grade_list {
	static int num = 1;
	static LinkedList myList = new LinkedList();
	static Student student = new Student();

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int id = 0;								// 학번
		String msg = "";						// 출력 메세지
		
		int choose = 0;							// 사용자 선택
		String navi[] = new String [8];			// 네비게이션
		navi[0] = "입력순번";
		navi[1] = "학번";
		navi[2] = "국어";
		navi[3] = "영어";
		navi[4] = "수학";
		navi[5] = "총점";
		navi[6] = "평균";
		navi[7] = "순위";

		Outer_loop :
		while (true) {
			System.out.println("----------------------------------------");
			System.out.println("1. 성적 입력");
			System.out.println("2. 전체 학생 목록 출력 ( 입력 역순 )");
			System.out.println("3. 학생 조회 후 출력");
			System.out.println("4. 학생 삭제");
			System.out.println("5. 종료");
			System.out.println("----------------------------------------");
			System.out.print("메뉴 선택 : ");
			choose = scn.nextInt();
			
			switch (choose) {
			case 1 :
				student = inputGrade(navi);
				myList.add(student);
				myList.changeRank();
				break;
			case 2 :
				for (int i = 0; i < navi.length; i++)
					System.out.print('\t' + navi[i]);
				System.out.println();
				System.out.println(myList);
				break;
			case 3 :
				System.out.println("검색할 학생의 학번은?");
				find_del(navi, false);
				break;
			case 4 :
				System.out.println("삭제할 학생의 학번은?");
				find_del(navi, true);
				myList.changeRank();
				System.out.println("삭제 되었습니다.");
				break;
			case 5 :
				System.out.println("프로그램 종료");
				break Outer_loop;
			default :
				break;
			}
		}
		
	}
	
	// 학번 및 점수 넣기
	static Student inputGrade (String arg1[]) {
		Scanner scn = new Scanner(System.in);
		Student student = new Student();
		int[] grade = new int[8];
		
		student.setNum(num);
		num++;
		
		System.out.println("학번을 입력하세요.");
		student.setId(scn.nextInt());
		System.out.println("국어 성적을 입력하세요.");
		student.setKor(scn.nextInt());
		System.out.println("영어 성적을 입력하세요.");
		student.setEng(scn.nextInt());
		System.out.println("수학 성적을 입력하세요.");
		student.setMath(scn.nextInt());
		student.setSum(student.getKor() + student.getEng() + student.getMath());
		student.setAvg(student.getSum() / 3);
		student.setRank(1);
		
		grade[0] = student.getNum();
		grade[1] = student.getId();
		grade[2] = student.getKor();
		grade[3] = student.getEng();
		grade[4] = student.getMath();
		grade[5] = student.getSum();
		grade[6] = student.getAvg();
		grade[7] = student.getRank();
		for(int i = 1; i < arg1.length-1; i++)
			System.out.print(arg1[i] + " : " + grade[i] + " ");
		System.out.println();
		
		return student;
	}
	
	// 학번에 따른 검색 및 삭제까지 제공
	static void find_del(String[] arg1, boolean boo) {
		Scanner scn = new Scanner(System.in);
		int id = 0;
		String msg = "";
		
		while(true) {
			id = scn.nextInt();
			try {
				msg = student.toString(myList.getStudentById(id));
				break;
			} catch(Exception e) {
				System.out.println("존재하지 않는 학번입니다. 다시 입력해 주세요.");
			}
		}
		for (int i = 0; i < arg1.length; i++)
			System.out.print('\t' + arg1[i]);
		System.out.println("\n" + msg);
		
		if(boo) {
			myList.deleteStudentById(id);
		}
	}
}
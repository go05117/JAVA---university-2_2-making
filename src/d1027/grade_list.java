package d1027;

import java.util.Scanner;

import d1027.Node;

//Node
class Node {
	private Student value;		// Data of Node : ������ ��
	private Node nextNode;		// Indicate next node : ���� ��� �ּ� ����Ű��
	
	Node (Student argValue, Node argNode) {
		value		= argValue;
		nextNode	= argNode;
	}

	// ���� ��� �ּ�
	Node getNextNode() { return nextNode; }
	void setNextNode(Node argNode) { nextNode = argNode; }
	// �� ��� ��
	Student getValue() { return value; }
	void setValue(Student argValue) { value = argValue; }
}

//Linked List ����
class LinkedList {
	Node headNode, tailNode;			// ����� �� ó���� ��
	private int numOfData;						// �� value ����
	Student student = new Student();	// Student Ŭ���� ��ü
	
	// head, tail �ʱ�ȭ
	LinkedList() {
		// head node, tail node
		tailNode = new Node(null, null);
		headNode = new Node(null, tailNode);
	}
	
	// ����ڰ� ������ �ε����� ��ȿ�� �ȿ� �ִ��� Ȯ��
	boolean isValidIndex(int argIndex) {
		if(argIndex < 0 || argIndex > numOfData)
			return false;
		return true;
	}

	// ����Ʈ�� ������� Ȯ��
	boolean isEmpty() {
		if(numOfData == 0) {
			return true;
		}
		return false;
	}
	
	// ��� �߰� - �߰�
	void add(int argIndex, Student argObj) {
		
		// ��ȿ�� �ε��� �����ΰ�?
		if(isValidIndex(argIndex)) {
			Node head = headNode;
			for(int i = 0; i < argIndex; i++)
				head = head.getNextNode();
			
			Node newNode = new Node(argObj, head.getNextNode());
			head.setNextNode(newNode);
			
			numOfData++;
		}
	}
	
	// ��� �߰� - ������
	void add(Student argObj) {
		add(numOfData, argObj);
	}
	
	// ����Ʈ�� ��ü �߰� �� ������ ���� ��ũ ����
	void changeRank() {
		Node head1 = headNode.getNextNode();
		Node head2 = headNode.getNextNode();
		
		// ��ũ �ʱ�ȭ
		for(int i = 0; i < numOfData; i++) {
			head1.getValue().setRank(1);
			head1 = head1.getNextNode();
		}
		
		// ������ ����� head1 �ʱ�ȭ
		head1 = headNode.getNextNode();
		// ���Ӱ� �߰��� ������ ������ ���Ӱ� ������ ���� ��ũ �� �ٿ�
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
			// j �������� ����� head2 �ʱ�ȭ
			head2 = headNode.getNextNode();
		}
	}
	
	// �й��� ���� ������ ��������
	Student getStudentById(int argId) {
		Node head = headNode.getNextNode();
		for(int i = 0; i < numOfData; i++) {
			if(head.getValue().getId() == argId)
				return head.getValue();
			head = head.getNextNode();
		}
		return null;
	}
	
	// �й��� ���� ������ ����
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
	
	// ��� ��������
	Student get(int argIndex) {
		if(isValidIndex(argIndex)) {
			Node head = headNode;
			for(int i = 0; i <= argIndex; i++)
				head = head.getNextNode();
			
			return head.getValue();
		}
		return null;
	}
	
	// LinkedList Ŭ���� ��ü ��� �κ�
	public String toString() {
		String msg = "";
		
		// ���� ����� ���� �迭�� ��ũ�� ����Ʈ ���������� ���
		for (int i = numOfData-1; i >= 0; i--) {
			msg += "\t" + get(i).getNum();
			msg += "\t" + get(i).getId();
			msg += "\t" + get(i).getKor();
			msg += "\t" + get(i).getEng();
			msg += "\t" + get(i).getMath();
			msg += "\t" + get(i).getSum();
			msg += "\t" + get(i).getAvg();
			msg += "\t" + get(i).getRank();
			
			msg += "\n";
		}
		return msg;
	}
}

class Student {
	private int num = 0;	// �Է¼���
	private int id = 0;		// �й�
	private int kor = 0;	// ����
	private int eng = 0;	// ����
	private int math = 0;	// ����
	private int sum = 0;	// ��
	private int avg = 0;	// ���
	private int rank = 0;	// ��ŷ
	
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
	
	// ��û���� Student ��ü �ϳ��� ��ȯ
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
	static int num = 1;								// �Է� ����
	static LinkedList myList = new LinkedList();	// LinkedList ��ü ���� 
	static Student student = new Student();			// Student ��ü ����

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int id = 0;								// �й�
		String msg = "";						// ��� �޼���
		
		int choose = 0;							// ����� ����
		String navi[] = new String [8];			// �׺���̼�
		navi[0] = "�Է¼���";
		navi[1] = "�й�";
		navi[2] = "����";
		navi[3] = "����";
		navi[4] = "����";
		navi[5] = "����";
		navi[6] = "���";
		navi[7] = "����";

		Outer_loop :
		while (true) {
			System.out.println("----------------------------------------");
			System.out.println("1. ���� �Է�");
			System.out.println("2. ��ü �л� ��� ��� ( �Է� ���� )");
			System.out.println("3. �л� ��ȸ �� ���");
			System.out.println("4. �л� ����");
			System.out.println("5. ����");
			System.out.println("----------------------------------------");
			System.out.print("�޴� ���� : ");
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
				System.out.println("�˻��� �л��� �й���?");
				find_del(navi, false);
				break;
			case 4 :
				System.out.println("������ �л��� �й���?");
				find_del(navi, true);
				myList.changeRank();
				System.out.println("���� �Ǿ����ϴ�.");
				break;
			case 5 :
				System.out.println("���α׷� ����");
				break Outer_loop;
			default :
				System.out.println("�ùٸ� ���ڸ� �Է����ּ���");
				break;
			}
		}
		
	}
	
	// �й� �� ���� �ֱ�
	static Student inputGrade (String arg1[]) {
		Scanner scn = new Scanner(System.in);
		Student student = new Student();
		int[] grade = new int[8];	// ����ڷκ��� �Է¹��� ������ ������ �迭
		
		student.setNum(num);
		num++;
		
		System.out.println("�й��� �Է��ϼ���.");
		student.setId(scn.nextInt());
		System.out.println("���� ������ �Է��ϼ���.");
		student.setKor(scn.nextInt());
		System.out.println("���� ������ �Է��ϼ���.");
		student.setEng(scn.nextInt());
		System.out.println("���� ������ �Է��ϼ���.");
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
		
		// navigation ���
		for(int i = 1; i < arg1.length-1; i++)
			System.out.print(arg1[i] + " : " + grade[i] + " ");
		System.out.println();
		
		return student;
	}
	
	// �й��� ���� �˻� �� �������� ����
	static void find_del(String[] arg1, boolean boo) {
		Scanner scn = new Scanner(System.in);
		int id = 0;			// �й�
		String msg = "";	// ����� message
		
		// �й� �Է� �� ���� ���� �˻�
		while(true) {
			id = scn.nextInt();
			try {
				msg = student.toString(myList.getStudentById(id));
				break;
			} catch(Exception e) {
				System.out.println("�������� �ʴ� �й��Դϴ�. �ٽ� �Է��� �ּ���.");
			}
		}
		
		// ������ �� ���
		for (int i = 0; i < arg1.length; i++)
			System.out.print('\t' + arg1[i]);
		System.out.println("\n" + msg);
		
		// �й��� ���� ���� ��û�� ���Դٸ� ���� ����
		if(boo) {
			myList.deleteStudentById(id);
		}
	}
}
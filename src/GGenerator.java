import java.util.Scanner;
/* 1701149
 * �ŵ���
 * */
class RawData {
	String m_stdId[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
						"11", "12", "13", "14", "15", "16", "17", "18"};
	
	String m_stdName[] = { "�ڳ���",	"������",	"���켺",	"�豹��", "������", "��ȣ��",
			               "�̼���",	"�ǿ�",	"����",	"������", "������", "����",	
			               "������", "ä��", "��û", "�����", "������", "��â��"};
	
	double m_stdGrade[] = {15, 12, 11, 10, 9, 8, 7, 7, 7, 6, 6, 6, 6, 6, 5, 5, 4, 3};
	
	String m_stdGender[] = {"��", "��", "��", "��", "��", "��", "��", "��", "��",
							"��", "��", "��", "��", "��", "��", "��", "��", "��"};									
}

// �л� ���� ���� Ŭ���� (StdInfo ��ü �� ���� �� �� �л� ��Ÿ��)
class StdInfo {
	// �� �� �л��� �й�, �̸�, ����, ���� ����
	private String id;
	private String name;
	private double grade;
	private String sex;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
}

class Node {
	private StdInfo value;
	private Node nextNode;
	
	Node(StdInfo value, Node nextNode) {
		this.value = value;
		this.nextNode = nextNode;
	}

	public StdInfo getValue() {
		return value;
	}

	public void setValue(StdInfo value) {
		this.value = value;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
	
}

// Linked-List Version ����Ʈ 
class MyList {
	Node headNode, tailNode;
	private int numOfData = 0; 
	
	MyList() {
		tailNode = new Node(null, null);
		headNode = new Node(null, tailNode);
	}
	
	// index ��ȣ ��ȿ�� �˻�
	boolean isValidIndex(int argIndex) {
		if(argIndex < 0 || numOfData < argIndex)
			return false;
		return true;
	}
	
	// StdInfo getStdById(String argId) : List �� argID �Է� ���� ��Ī�Ǵ� �л� ��ü(StdInfo) ��ȯ
	//                                    ��Ī�Ǵ� �л��� ���� ��� Null ��ȯ
	StdInfo getStdById(String argId) {
		Node head = headNode.getNextNode();
		
		for(int i = 0; i < numOfData; i++) {
			if(head.getValue().getId() == argId)
				return head.getValue();
			head = head.getNextNode();
		}
		return null;
	}

	// StdInfo get(int argIndex) : List �� argIndex ������ �ش��ϴ� StdInfo ��ü ��ȯ
	//                             index �� ��ȿ�� �˻� �ǽ� [�Է� ���� -1 ���� �̰ų�, List �� ���� ������ ������ Ŭ���]
	StdInfo get(int argIndex) {
		if(isValidIndex(argIndex)) {
			Node head = headNode.getNextNode();
			
			for(int i = 0; i < argIndex; i++)
				head = head.getNextNode();
			
			return head.getValue();
		}
		return null;
	}

	// StdInfo remove(int argIndex) : List �� argIndex ������ �ش��ϴ� StdInfo ��ü�� List �� ���� �� �ش� ��ü ��ȯ
	//                                index �� ��ȿ�� �˻� �ǽ� [�Է� ���� -1 ���� �̰ų�, List �� ���� ������ ������ Ŭ���]
	StdInfo remove(int argIndex) {
		if(isValidIndex(argIndex)) {
			Node head = headNode;
			
			for(int i = 0; i < argIndex; i++)
				head = head.getNextNode();
			
			Node prevNode = head;
			head = head.getNextNode();
			
			prevNode.setNextNode(head.getNextNode());
			numOfData--;
		}
		return null;
	}
	
	// void add(StdInfo argStdInfo) : List ���� �������� argStdInfo ��ü ����
	void add(StdInfo argStdInfo) {
		Node head = headNode;
		
		for(int i = 0; i < numOfData; i++)
			head = head.getNextNode();
		
		Node newNode = new Node(argStdInfo, head.getNextNode());
		head.setNextNode(newNode);
		
		numOfData++;
	}
	
	// int size() : �� ����Ʈ �� ������ ���� ��ȯ
	int size() {
		return numOfData;
	}
	
	// int sizeOfFemaleStd() : �� ����Ʈ �� ���л� ��� ��ȯ
	int sizeOfFemaleStd() {
		Node head = headNode.getNextNode();
		
		int count = 0;
		for(int i = 0; i < numOfData; i++) {
			if(head.getValue().getSex() == "��")
				count++;
			head = head.getNextNode();
		}
		
		return count;
	}
	
	// int sizeOfMaleStd() : �� ����Ʈ �� ���л� ��� ��ȯ
	int sizeOfMaleStd() {
		Node head = headNode.getNextNode();
		
		int count = 0;
		for(int i = 0; i < numOfData; i++) {
			if(head.getValue().getSex() == "��")
				count++;
			head = head.getNextNode();
		}
		
		return count;
	}
	
	// ���л��� ����
	MyList maleStudent() {
		MyList mylist = new MyList();
		Node head = headNode.getNextNode();
		
		for(int i = 0; i < numOfData; i++) {
			if(head.getValue().getSex() == "��")
				mylist.add(head.getValue());
			head = head.getNextNode();
		}
		return mylist;
	}
	
	// ���л��� ����
	MyList femaleStudent() {
		MyList mylist = new MyList();
		Node head = headNode.getNextNode();
		
		for(int i = 0; i < numOfData; i++) {
			if(head.getValue().getSex() == "��")
				mylist.add(head.getValue());
			head = head.getNextNode();
		}
		return mylist;
	}
}

// �� �� Ŭ����
class GroupManager {
	int		m_numOfGroup;   // ������ �׷� �� : �����(CLI)�κ��� �Է�
	MyList	rawDataList = new MyList(); 	// �л� ���� ��ü(StdInfo)���� �����ϴ� ����Ʈ
	StdInfo stdinfo = new StdInfo();	// stdInfo ��ü
	RawData rawdata = new RawData();	// RawData ��ü
	Scanner scn = new Scanner(System.in);
	// �������, ����޼��� �߰� ���� : ��) ���л� ��ü ���� MyList �߰�
	
	// ������
	GroupManager() {
		// rawDataList ����Ʈ�� �л�(StdInfo)��ü �Է�
		LoadData();
	}
	
	// �л� ���� ��üȭ �� ����Ʈ�� ����
	void LoadData() {
		// RawData Ŭ���� ��� ������ �ڷ����
		// �� StdInfo ��ü�� ���� �� rawDataList ����Ʈ�� �߰� 
		for(int i = 0; i < rawdata.m_stdGender.length; i++) {
			stdinfo = new StdInfo();
			stdinfo.setName(rawdata.m_stdName[i]);
			stdinfo.setId(rawdata.m_stdId[i]);
			stdinfo.setSex(rawdata.m_stdGender[i]);
			stdinfo.setGrade(rawdata.m_stdGrade[i]);
			
//			System.out.println(stdinfo.getName());
//			System.out.println(stdinfo.getId());
//			System.out.println(stdinfo.getSex());
//			System.out.println(stdinfo.getGrade());
			
			rawDataList.add(stdinfo);
		}
		
		// ����Ʈ rawDataList�� �Է� �� �л� ���� ȭ�鿡 ���
		PrtStdList();
	}
	
	// rawDataList �� �л� ����(StdInfo ��ü)�� ȭ�鿡 ���
	void PrtStdList() {
		// ȭ�� ��� ���� : �̸�, �й�, ����, ���� ������ ��� (�Ʒ� ����)
		// 1) �ڳ���, 1, "��", 10
		// 2) ������, 2, "��", 10
		
		for(int i = 0; i < rawDataList.size(); i++) {
			System.out.println((i+1) + ") " + rawDataList.get(i).getName() + ", " + rawDataList.get(i).getId() + ", "
					+ "\"" + rawDataList.get(i).getSex() + "\"" + ", "+ rawDataList.get(i).getGrade() + ", ");
		}
	}
	
	// �������� �׷��� �����Ͽ� ȭ�鿡 ���
	void GenerateGroup() {
		MyList maleList = new MyList();
		MyList femaleList = new MyList();
		
		maleList = rawDataList.maleStudent();
		femaleList = rawDataList.femaleStudent();
		
		// ���� �׷� ����  ����ڷκ��� �Է�
		System.out.println("\n\n <<-- ���ϴ� �׷� ���� �Է����ּ��� -->>");
		int group = scn.nextInt();
		
		

		// �Ʒ� ��Ģ�� �����Ͽ� �׷� ����
		// 1) ���л� �� ���� ������ �� �׷쿡 �����ϰ� ���� :    
		//    ��) ���� �׷� : 3, ���������� 1~3���� �л����� �����ϰ� 1, 2, 3���� ��
		//    Math.Random() �޼��� �̿� : 0~2 ���� �� ���� : (int)(Math.Random() * 3)
		
		// 2) ��� ���л��� ���� �ɶ����� 1) �ݺ�
		
		
		// 3) ���л� ���ڰ� ���� �׷� ���� �¾� �������� ���� ���, ���� �л����� �� ���� ������ ���� ������ ����
		//    ��) �� �л� �� : 9��, ���� �׷� : 2, 8����� ���� �� ���� ���� ���� -> 1�� ���� : 80��, 2�� ���� : 90��
		//       -> 1�� �л����� �� ������ �������� ������ 1����  1���� ����
		
		
		// 4) ���л��� ��� 1������ ���ʴ�� Round Robin ������� ����
        //    ��) ���� �׷� 3, ���л� �� 5�� : 1, 2, 3, 1, 2�� ������ ����
		
		
		// ���� ��� ȭ�� ���
		System.out.println("���� �׷� ���� : " + group + "\n");
		System.out.println("���л� �� : " + rawDataList.sizeOfMaleStd());
		System.out.println("���л� �� : " + rawDataList.sizeOfFemaleStd());
		System.out.println("�� �л� �� : " + rawDataList.size());
		// ��� ������ ������ ����
		System.out.println("---------------------------------\n");
		System.out.println("---------------------------------");
		System.out.println("�� �� ���");
		System.out.println("---------------------------------");
		
		for(int k = 0; k < group; k++) {
			int count = 1;
			System.out.println(k+1 + "�� ��� ���");
			for(int i = 0; i < maleList.size()/group; i++) {
				System.out.println("\t" + count + ") " + maleList.get(i).getName() + ", " + maleList.get(i).getId() + ", "
						+ "\"" + maleList.get(i).getSex() + "\"" + ", "+ maleList.get(i).getGrade() + ", ");
				count++;
			}
			for(int i = 0; i < femaleList.size()/group; i++) {
				System.out.println("\t" + count + ") " + femaleList.get(i).getName() + ", " + femaleList.get(i).getId() + ", "
						+ "\"" + femaleList.get(i).getSex() + "\"" + ", "+ femaleList.get(i).getGrade() + ", ");
				count++;
			}
		}
	}
}

public class GGenerator {
	public static void main(String args[]) {
		GroupManager myGrpMgr = new GroupManager();
		
		// �� �� ���α׷� ����
		myGrpMgr.GenerateGroup();
	}
}

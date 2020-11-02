import java.util.Scanner;
/* 1701149
 * 신동협
 * */
class RawData {
	String m_stdId[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
						"11", "12", "13", "14", "15", "16", "17", "18"};
	
	String m_stdName[] = { "박나래",	"이정재",	"정우성",	"김국진", "하춘하", "강호동",
			               "이수근",	"피오",	"공유",	"곽도원", "고은아", "규현",	
			               "전지현", "채연", "김청", "김수지", "전영록", "구창모"};
	
	double m_stdGrade[] = {15, 12, 11, 10, 9, 8, 7, 7, 7, 6, 6, 6, 6, 6, 5, 5, 4, 3};
	
	String m_stdGender[] = {"여", "남", "남", "남", "여", "남", "남", "남", "남",
							"남", "여", "남", "여", "여", "여", "여", "남", "남"};									
}

// 학생 정보 저장 클래스 (StdInfo 객체 한 개가 한 명 학생 나타냄)
class StdInfo {
	// 한 명 학생의 학번, 이름, 점수, 성별 저장
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

// Linked-List Version 리스트 
class MyList {
	Node headNode, tailNode;
	private int numOfData = 0; 
	
	MyList() {
		tailNode = new Node(null, null);
		headNode = new Node(null, tailNode);
	}
	
	// index 번호 유효성 검사
	boolean isValidIndex(int argIndex) {
		if(argIndex < 0 || numOfData < argIndex)
			return false;
		return true;
	}
	
	// StdInfo getStdById(String argId) : List 내 argID 입력 값과 매칭되는 학생 객체(StdInfo) 반환
	//                                    매칭되는 학생이 없을 경우 Null 반환
	StdInfo getStdById(String argId) {
		Node head = headNode.getNextNode();
		
		for(int i = 0; i < numOfData; i++) {
			if(head.getValue().getId() == argId)
				return head.getValue();
			head = head.getNextNode();
		}
		return null;
	}

	// StdInfo get(int argIndex) : List 내 argIndex 순서에 해당하는 StdInfo 객체 반환
	//                             index 값 유효성 검사 실시 [입력 값이 -1 이하 이거나, List 내 저장 데이터 값보다 클경우]
	StdInfo get(int argIndex) {
		if(isValidIndex(argIndex)) {
			Node head = headNode.getNextNode();
			
			for(int i = 0; i < argIndex; i++)
				head = head.getNextNode();
			
			return head.getValue();
		}
		return null;
	}

	// StdInfo remove(int argIndex) : List 내 argIndex 순서에 해당하는 StdInfo 객체를 List 내 삭제 후 해당 객체 반환
	//                                index 값 유효성 검사 실시 [입력 값이 -1 이하 이거나, List 내 저장 데이터 값보다 클경우]
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
	
	// void add(StdInfo argStdInfo) : List 제일 마지막에 argStdInfo 객체 삽입
	void add(StdInfo argStdInfo) {
		Node head = headNode;
		
		for(int i = 0; i < numOfData; i++)
			head = head.getNextNode();
		
		Node newNode = new Node(argStdInfo, head.getNextNode());
		head.setNextNode(newNode);
		
		numOfData++;
	}
	
	// int size() : 현 리스트 내 데이터 개수 반환
	int size() {
		return numOfData;
	}
	
	// int sizeOfFemaleStd() : 현 리스트 내 여학생 명수 반환
	int sizeOfFemaleStd() {
		Node head = headNode.getNextNode();
		
		int count = 0;
		for(int i = 0; i < numOfData; i++) {
			if(head.getValue().getSex() == "여")
				count++;
			head = head.getNextNode();
		}
		
		return count;
	}
	
	// int sizeOfMaleStd() : 현 리스트 내 남학생 명수 반환
	int sizeOfMaleStd() {
		Node head = headNode.getNextNode();
		
		int count = 0;
		for(int i = 0; i < numOfData; i++) {
			if(head.getValue().getSex() == "남")
				count++;
			head = head.getNextNode();
		}
		
		return count;
	}
	
	// 남학생만 빼기
	MyList maleStudent() {
		MyList mylist = new MyList();
		Node head = headNode.getNextNode();
		
		for(int i = 0; i < numOfData; i++) {
			if(head.getValue().getSex() == "남")
				mylist.add(head.getValue());
			head = head.getNextNode();
		}
		return mylist;
	}
	
	// 여학생만 빼기
	MyList femaleStudent() {
		MyList mylist = new MyList();
		Node head = headNode.getNextNode();
		
		for(int i = 0; i < numOfData; i++) {
			if(head.getValue().getSex() == "여")
				mylist.add(head.getValue());
			head = head.getNextNode();
		}
		return mylist;
	}
}

// 조 편성 클래스
class GroupManager {
	int		m_numOfGroup;   // 생성할 그룹 수 : 사용자(CLI)로부터 입력
	MyList	rawDataList = new MyList(); 	// 학생 정보 객체(StdInfo)들을 저장하는 리스트
	StdInfo stdinfo = new StdInfo();	// stdInfo 객체
	RawData rawdata = new RawData();	// RawData 객체
	Scanner scn = new Scanner(System.in);
	// 멤버변수, 멤버메서드 추가 가능 : 예) 여학생 객체 저장 MyList 추가
	
	// 생성자
	GroupManager() {
		// rawDataList 리스트에 학생(StdInfo)객체 입력
		LoadData();
	}
	
	// 학생 정보 객체화 후 리스트에 저장
	void LoadData() {
		// RawData 클래스 멤버 변수의 자료들을
		// 각 StdInfo 객체로 생성 후 rawDataList 리스트에 추가 
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
		
		// 리스트 rawDataList에 입력 된 학생 정보 화면에 출력
		PrtStdList();
	}
	
	// rawDataList 내 학생 정보(StdInfo 객체)를 화면에 출력
	void PrtStdList() {
		// 화면 출력 포맷 : 이름, 학번, 성별, 점수 순으로 출력 (아래 참조)
		// 1) 박나래, 1, "여", 10
		// 2) 이정재, 2, "남", 10
		
		for(int i = 0; i < rawDataList.size(); i++) {
			System.out.println((i+1) + ") " + rawDataList.get(i).getName() + ", " + rawDataList.get(i).getId() + ", "
					+ "\"" + rawDataList.get(i).getSex() + "\"" + ", "+ rawDataList.get(i).getGrade() + ", ");
		}
	}
	
	// 랜덤으로 그룹을 생성하여 화면에 출력
	void GenerateGroup() {
		MyList maleList = new MyList();
		MyList femaleList = new MyList();
		
		maleList = rawDataList.maleStudent();
		femaleList = rawDataList.femaleStudent();
		
		// 생성 그룹 개수  사용자로부터 입력
		System.out.println("\n\n <<-- 원하는 그룹 수를 입력해주세요 -->>");
		int group = scn.nextInt();
		
		

		// 아래 규칙을 적용하여 그룹 생성
		// 1) 남학생 중 성적 순으로 각 그룹에 랜덤하게 배정 :    
		//    예) 생성 그룹 : 3, 성적순으로 1~3위의 학생들을 랜덤하게 1, 2, 3조에 편성
		//    Math.Random() 메서드 이용 : 0~2 랜덤 값 생성 : (int)(Math.Random() * 3)
		
		// 2) 모든 남학생이 배정 될때까지 1) 반복
		
		
		// 3) 남학생 숫자가 생성 그룹 수와 맞아 떨어지지 않을 경우, 남은 학생들은 각 조별 총점이 낮은 순으로 배정
		//    예) 총 학생 수 : 9명, 생성 그룹 : 2, 8명까지 배정 후 조별 점수 총합 -> 1조 총점 : 80점, 2조 총점 : 90점
		//       -> 1조 학생들의 총 점수가 낮음으로 나머지 1명을  1조에 배정
		
		
		// 4) 여학생의 경우 1조부터 차례대로 Round Robin 방식으로 배정
        //    예) 생성 그룹 3, 여학생 수 5명 : 1, 2, 3, 1, 2조 순으로 배정
		
		
		// 조편성 결과 화면 출력
		System.out.println("생성 그룹 갯수 : " + group + "\n");
		System.out.println("남학생 수 : " + rawDataList.sizeOfMaleStd());
		System.out.println("여학생 수 : " + rawDataList.sizeOfFemaleStd());
		System.out.println("총 학생 수 : " + rawDataList.size());
		// 출력 포맷은 시험지 참조
		System.out.println("---------------------------------\n");
		System.out.println("---------------------------------");
		System.out.println("조 편성 결과");
		System.out.println("---------------------------------");
		
		for(int k = 0; k < group; k++) {
			int count = 1;
			System.out.println(k+1 + "조 멤버 목록");
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
		
		// 조 편성 프로그램 실행
		myGrpMgr.GenerateGroup();
	}
}

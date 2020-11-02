package d0901;

public class prof_1 {
	// 자료 구조론 : 자료를 메모리상에 어떻게 집어넣을지 결정하는 것
	// 알고리즘 : 문제를 해결하기 위한 절차를 유한한 명령어로 구성하는 것

	public static void main(String[] args) {
		int myListByArray[] = { 10, 9 ,8, 7, 6 };
		
		// 1. 현 배열에서 20을 추가하고 싶다면?
		int size = myListByArray.length;
		int array1[] = new int[size + 1];
		
		for(int i = 0; i < size+1; i++) {
			if (i == size)
				array1[i] = 20;
			else
				array1[i] = myListByArray[i];
		}
		
		for(int i = 0; i < size+1; i++) {
			System.out.print(array1[i] + " ");
		}
		
		System.out.println("\n-------------------------------");
		
		// 2. 1번 인덱스의 값을 삭제하고 싶다면?
		int size2 = myListByArray.length;
		int array2[] = new int[size - 1];
		
		for(int i = 0; i < size2-1; i++) {
			if (i < 1)
				array2[i] = myListByArray[i];
			else
				array2[i] = myListByArray[i+1];
		}
		
		for(int i = 0; i < size2-1; i++) {
			System.out.print(array2[i] + " ");
		}
		
		System.out.println("\n-------------------------------");
		
		// 3. 3번, 4번 인덱스 사이에 새로운 값을 추가하고 싶다면?
		int size3 = myListByArray.length;
		int array3[] = new int[size3 + 1];
		
		for(int i = 0; i < size3+1; i++) {
			if (i < 4)
				array3[i] = myListByArray[i];
			else if (i == 4)
				array3[i] = 20;
			else
				array3[i] = myListByArray[i-1];
		}
		
		for(int i = 0; i < size3+1; i++) {
			System.out.print(array3[i] + " ");
		}
	}
}
package d0901;

import java.util.*;

public class q1 {
	
	static void prtEdgeOfArray(int argMyArray[]) {
		// 입력 받은 배열의 양 끝부분 값을 연속적으로 출력하라.
		// 예) argMyArray = { 1, 2, 3, 4, 5}
		// 결과 값 :  1, 5, 2, 4, 3
		
		int size = argMyArray.length;	// 입력받은 배열 크기
		
		// 배열 크기가 0일 경우
		if (size < 1) {
			System.out.println("잘못된 배열입니다.");
			return;
		}
		
		int ln = size;	// last number, 배열의 마지막 인덱스 값
		int allCount = (size >= 2 && size % 2 == 0) ? size / 2 : size / 2 + 1;	// 홀수 및 짝수일 때 중간 값
		
		for (int i = 0; i < allCount; i++) {
			if (size >= 2 && size % 2 == 0) {
				System.out.print(i < allCount-1 ?
								argMyArray[i] + ", " + argMyArray[ln - 1] + ", "
								: argMyArray[i] + ", " + argMyArray[ln - 1]);
				ln--;
			} else {
				System.out.print(i < allCount-1 ?
						argMyArray[i] + ", " + argMyArray[ln - 1] + ", " : argMyArray[i]);
				ln--;
			}
		}
	}

	public static void main(String[] args) {
		// 테스트용
		int[] array1 = { 1, 2, 3, 4, 5 };
		prtEdgeOfArray(array1);
		System.out.println("\n------------------------------");
		
		int[] array2 = { 1, 2, 3, 4, 5, 6 };
		prtEdgeOfArray(array2);
		System.out.println("\n------------------------------");
		
		// 입력 단
		Scanner sc = new Scanner(System.in);
		
		// 숫자 입력 받기
		System.out.println("원하는만큼 숫자를 입력하되 각 숫자 사이를 띄우시오");
		String num = sc.nextLine();
		
		// ' '를 기준으로 나눠 string 배열에 담은 뒤 int 배열로 형변환
		String[] strArray = num.split(" ");
		int[] array3 =  Arrays.asList(strArray).stream().mapToInt(Integer::parseInt).toArray();
		prtEdgeOfArray(array3);
		
	}

}

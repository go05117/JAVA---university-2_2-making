package d0901;

import java.util.*;

public class q1 {
	
	static void prtEdgeOfArray(int argMyArray[]) {
		// �Է� ���� �迭�� �� ���κ� ���� ���������� ����϶�.
		// ��) argMyArray = { 1, 2, 3, 4, 5}
		// ��� �� :  1, 5, 2, 4, 3
		
		int size = argMyArray.length;	// �Է¹��� �迭 ũ��
		
		// �迭 ũ�Ⱑ 0�� ���
		if (size < 1) {
			System.out.println("�߸��� �迭�Դϴ�.");
			return;
		}
		
		int ln = size;	// last number, �迭�� ������ �ε��� ��
		int allCount = (size >= 2 && size % 2 == 0) ? size / 2 : size / 2 + 1;	// Ȧ�� �� ¦���� �� �߰� ��
		
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
		// �׽�Ʈ��
		int[] array1 = { 1, 2, 3, 4, 5 };
		prtEdgeOfArray(array1);
		System.out.println("\n------------------------------");
		
		int[] array2 = { 1, 2, 3, 4, 5, 6 };
		prtEdgeOfArray(array2);
		System.out.println("\n------------------------------");
		
		// �Է� ��
		Scanner sc = new Scanner(System.in);
		
		// ���� �Է� �ޱ�
		System.out.println("���ϴ¸�ŭ ���ڸ� �Է��ϵ� �� ���� ���̸� ���ÿ�");
		String num = sc.nextLine();
		
		// ' '�� �������� ���� string �迭�� ���� �� int �迭�� ����ȯ
		String[] strArray = num.split(" ");
		int[] array3 =  Arrays.asList(strArray).stream().mapToInt(Integer::parseInt).toArray();
		prtEdgeOfArray(array3);
		
	}

}

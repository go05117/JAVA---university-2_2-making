package d0901;

public class prof_1 {
	// �ڷ� ������ : �ڷḦ �޸𸮻� ��� ��������� �����ϴ� ��
	// �˰��� : ������ �ذ��ϱ� ���� ������ ������ ��ɾ�� �����ϴ� ��

	public static void main(String[] args) {
		int myListByArray[] = { 10, 9 ,8, 7, 6 };
		
		// 1. �� �迭���� 20�� �߰��ϰ� �ʹٸ�?
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
		
		// 2. 1�� �ε����� ���� �����ϰ� �ʹٸ�?
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
		
		// 3. 3��, 4�� �ε��� ���̿� ���ο� ���� �߰��ϰ� �ʹٸ�?
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
package d1020;

public class list_array {
	
	static class MyList {
		private int list[];
		private int numOfData;
		private final int size;
		
		MyList(int size) {
			this.size = size;
			list = new int[size];
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

		// 리스트가 꽉 찼는지 확인
		boolean isFull() {
			if(numOfData == size) {
				return true;
			}
			return false;
		}
		
		// 요소 추가 - 중간
		void add(int argIndex, int argValue) {
			int addList[] = new int[list.length - argIndex]; 
			int count = 0;
			
			// ????/
			if(!isFull() && isValidIndex(argIndex)) {
				for(int i = argIndex; i < list.length; i++) {
					addList[count] = list[i];
					count++;
				}
				list[argIndex] = argValue;
				
				count = 0;
				for(int i = argIndex+1; i < list.length; i++) {
					list[i] = addList[count];
					count++;
				}
			}
				
			numOfData++;
		}
		
		// 요소 추가 - 마지막
		void add(int argValue) {
			add(numOfData, argValue);
		}
		
		// 요소 가져오기
		int get(int argIndex) {
			if(isValidIndex(argIndex))
				return list[argIndex];
			return Integer.MAX_VALUE;
		}
		
		// 요소 변경
		void set(int argIndex, int argValue) {
			if(!isEmpty() && isValidIndex(argIndex))
				list[argIndex] = argValue;
		}
		
		// 요소 삭제
		void remove(int argIndex) {
			int removeList[] = new int[list.length - argIndex]; 
			int count = 0;
			
			// ???
			if(!isEmpty() && isValidIndex(argIndex)) {
				for(int i = argIndex+1; i < list.length; i++) {
					removeList[count] = list[i];
					count++;
				}
				
				count = 0;
				for(int i = argIndex; i < list.length; i++) {
					list[i] = removeList[count];
					count++;
				}
			}
			
			numOfData--;
		}
		
		public String toString() {
			String msg = "";
			for (int i = 0; i < list.length; i++)
				msg += " " + list[i];
			return msg;
		}
	}

	public static void main(String[] args) {
		MyList myList = new MyList(10);
		
		myList.add(0, 1);
		myList.add(0, 3);
		myList.add(1, 5);
		myList.add(10);
		myList.add(11);
		myList.set(1, 78);
		System.out.println(myList);	// 3, 78, 1, 10, 11
		
		myList.remove(1);
		System.out.println(myList); // 3, 1, 10, 11
		
		myList.remove(0);
		System.out.println(myList);	// 1, 10, 11
		
		System.out.println(myList.get(2)); // 11

	}

}
package d0915;

import java.util.*;

public class Stack_java_collection {

	public static void main(String[] args) {
		LinkedList myList = new LinkedList();
		
		myList.add(4);
		myList.add(5);
		myList.add(6);
		myList.add(7);
		myList.add(8);
		System.out.println(myList);	// 4, 5, 6, 7, 8
		
		myList.add(1, 20);
		myList.add(5, 30);
		System.out.println(myList);	// 4, 20, 5, 6, 7, 30, 8
		
		myList.set(3, 40);
		System.out.println(myList);	// 4, 20, 5, 40, 7, 30, 8
		
		myList.remove(4);
		myList.remove(0);
		myList.remove(4);
		System.out.println(myList);	// 20, 5, 40, 30
		
		System.out.println(myList.get(2));	// 40
		
	}

}

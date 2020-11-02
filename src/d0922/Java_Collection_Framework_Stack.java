package d0922;

import java.util.*;

public class Java_Collection_Framework_Stack {

	public static void main(String[] args) {
		Stack<Integer> myStack = new Stack<Integer>();
		Stack<String> myStack2 = new Stack<String>();
		
		myStack.push(5);
		myStack.push(6);
		myStack.push(7);
		myStack.push(8);
		
		myStack2.push("°¡");
		myStack2.push("³ª");
		myStack2.push("´Ù");
		
		while(!myStack.empty())
			System.out.println("POP : " + myStack.pop());
	}

}

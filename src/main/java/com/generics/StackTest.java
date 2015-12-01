package com.generics;

public class StackTest {

	public static void main(String[] args) throws EmptyStackException {
		//Stack s=new Stack();
		Stack<String> stack = new Stack<String>();
		for (String arg : args)
		stack.push(arg);
		while (!stack.isEmpty())
		System.out.println(stack.pop().toUpperCase());
	}
}

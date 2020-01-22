package com.algo;

public class Stack {

	class Node {
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	private Node top;

	public boolean isEmpty() {
		return top == null;
	}

	public void push(int data) {
		Node node = new Node(data);

		node.next = top;
		top = node;
	}

	public int pop() {
		if(isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		int data = top.data;
		top = top.next;
		return data;
	}

	public int peek() {
		if(isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		return top.data;
	}

	public void traverse() {
		Node node = top;

		while(node != null) {
			System.out.print(node.data+" ");
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Stack stack = new Stack();

		stack.push(5);
		stack.push(4);
		stack.push(3);

		stack.traverse();

		stack.pop();
		stack.traverse();

		System.out.println(stack.peek());
	}
}

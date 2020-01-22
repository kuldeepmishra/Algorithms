package com.algo;

public class Queue {

	class Node {
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	private Node head;
	private Node tail;

	public void insert(int data) {
		Node node = new Node(data);

		if(tail != null) {
			tail.next = node;
		}

		tail = node;

		if(head == null) {
			head = node;
		}
	}

	public int remove() {
		int data = head.data;
		head = head.next;

		if(head == null) {
			tail = null;
		}

		return data;
	}

	public void traverse() {
		Node node = head;

		while(node != null) {
			System.out.print(node.data+" ");
			node = node.next;
		}
		System.out.println(); 
	}

	public int peek() {
		return head.data;
	}

	public static void main(String[] args) {
		Queue queue = new Queue();

		queue.insert(5);
		queue.insert(4);
		queue.insert(3);

		queue.traverse();

		queue.remove();
		queue.traverse();

		System.out.println(queue.peek());
	}


}

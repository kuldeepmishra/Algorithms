package com.aed.algo;

public class BinaryTree {

	public static class Node<T> {
		T data;
		Node<T> left;
		Node<T> right;
		Node<?> sibling;

		public Node(T data) {
			this.data = data;
		}

		@Override
		public String toString() {
			String msg = "Node{" +
					"data=" + data;
			if (left != null) {
				msg += ", left=" + left;
			}

			if (right != null) {
				msg += ", right=" + right;
			}

			if (sibling != null) {
				msg += ", sibling=" + sibling;
			}
			return msg+"}";
		}
	}

	public static Node create() {
		Node node1  = new Node('a');
		node1.left = new Node('b');
		node1.left.left = new Node('d');
		node1.left.right = new Node('e');

		node1.right = new Node('c');
		node1.right.left = new Node('f');
		node1.right.right = new Node('h');
		return node1;
	}

	public static Node create2() {
		Node node2  = new Node('a');
		node2.left = new Node('c');
		node2.left.left = new Node('h');
		node2.left.right = new Node('f');

		node2.right = new Node('b');
		node2.right.left = new Node('e');
		node2.right.right = new Node('d');
		return node2;
	}

	public static Node create3() {
		Node node1  = new Node('a');
		node1.left = new Node('b');
		node1.left.left = new Node('d');
		node1.left.left.left = new Node('h');
		node1.left.left.right = new Node('i');
		node1.left.right = new Node('e');


		node1.right = new Node('c');
		node1.right.left = new Node('f');
		node1.right.left.left = new Node('j');
		node1.right.left.right = new Node('k');
		node1.right.right = new Node('g');
		return node1;
	}

	public static Node create4() {
		Node node1  = new Node(1);
		node1.left = new Node(2);
		node1.left.left = new Node(4);
		node1.left.right = new Node(5);
		node1.left.left.left = new Node(8);
		node1.left.left.right = new Node(9);

		node1.right = new Node(3);
		node1.right.left = new Node(6);
		node1.right.right = new Node(7);
		node1.right.right.left = new Node(10);
		node1.right.right.right = new Node(11);
		return node1;
	}

	public static Node<Integer> create5() {
		Node<Integer> node1  = new Node<>(1);
		node1.left = new Node(2);
		node1.left.left = new Node(2);
		node1.left.right = new Node(2);

		node1.right = new Node(2);
		return node1;
	}


	public static Node<Character> create6() {
		Node<Character> node1  = new Node<>('a');
		node1.left = new Node('b');
		node1.left.left = new Node('d');
		node1.left.left.left = new Node('h');
		node1.left.left.right = new Node('i');
		node1.left.left.right.left = new Node('m');
		node1.left.left.right.right = new Node('n');
		node1.left.right = new Node('e');
		node1.left.right.left = new Node('r');
		node1.left.right.right = new Node('s');


		node1.right = new Node('c');
		node1.right.left = new Node('f');
		node1.right.left.left = new Node('j');
		node1.right.left.right = new Node('k');
		node1.right.right = new Node('g');
		node1.right.right.right = new Node('l');
		node1.right.right.right.left = new Node('p');
		node1.right.right.right.right = new Node('q');
		return node1;
	}

	public static Node<Integer> create7() {
		Node<Integer> node1  = new Node<>(1);
		node1.left = new Node(2);
		node1.left.left = new Node(4);
		node1.left.right = new Node(5);
		node1.left.left.left = new Node(8);
		node1.left.left.right = new Node(9);

		node1.right = new Node(3);
		node1.right.left = new Node(6);
		node1.right.right = new Node(7);
		node1.right.right.left = new Node(10);
		node1.right.right.right = new Node(11);
		return node1;
	}
}

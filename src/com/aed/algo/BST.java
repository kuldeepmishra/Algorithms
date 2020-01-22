package com.aed.algo;

public class BST {

	Node root;

	public void add(int data) {
		root = add(root, data);
	}

	private Node add(Node root, int data) {
		if (root == null) {
			root = new Node(data);
			return root;
		}

		if(data < root.data) {
			root.left = add(root.left, data);
		} else if(data > root.data) {
			root.right = add(root.right, data);
		}
		return root;
	}

	public static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}
	}

	public void inorder(Node root) {
		if(root == null) {
			return;
		}
		inorder(root.left);
		System.out.println(root.data);
		inorder(root.right);
	}
}

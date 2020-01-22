package com.aed.algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

import com.aed.algo.BinaryTree.Node;

public class TreeOperations {

	public static void main(String[] args) {
		Node<?> node1 = BinaryTree.create();
		Node<?> node2 = BinaryTree.create2();

		System.out.println("Checking mirror tree");
		System.out.println(isMirror(node1, node2));

		Node<Character> node3 = BinaryTree.create3();
		System.out.println("Printing Node at K Distance");
		printKDistanceNode(node3, 2);

		System.out.println("Printing All Ancestors");
		printAllAncestors(node3, 'h');

		Node<?> node4 = BinaryTree.create4();
		connectSibling(node4);

		Node<Integer> node5 = BinaryTree.create5();
		System.out.println("Checking Sum Tree : "+checkSumTree(node5));

		System.out.println("Printing Root to Leaf Path");
		printRootToLeafPath(node3);

		System.out.println("Printing Level by Level Order");
		printLevelOrderByLevel(node3);

		System.out.println("Printing Vertical Order");
		printVerticalOrder(node3);

		System.out.println("Printing Top View");
		printTopView(node3);


		Node<Character> node6 = BinaryTree.create6();
		System.out.println("LCA of 'm', 'r' is "+ LCA(node6, 'm', 'r').data);
		System.out.println("LCA of 'm', 'd' is "+ LCA(node6, 'm', 'd').data);
		System.out.println("LCA of 'f', 'c' is "+ LCA(node6, 'f', 'c').data);
		System.out.println("LCA of 'g', 'p' is "+ LCA(node6, 'g', 'p').data);
		System.out.println("LCA of 'q', 'p' is "+ LCA(node6, 'q', 'p').data);

		System.out.println("Converting Tree to DLL");
		convertToDLLAndPrint(node1);

		BST bst = new BST();
		bst.add(20);
		bst.add(10);
		bst.add(5);
		bst.add(15);
		bst.add(50);
		bst.add(30);
		bst.add(70);
		bst.add(25);
		bst.add(40);
		bst.add(35);
		bst.add(33);
		bst.add(45);

		bst.inorder(bst.root);
		System.out.println("Successor in BST for 5 is : "+ successorInBST(bst.root, 5).data);
		System.out.println("Successor in BST for 15 is : "+ successorInBST(bst.root, 15).data);
		System.out.println("Successor in BST for 30 is : "+ successorInBST(bst.root, 30).data);
		System.out.println("Successor in BST for 70 is : "+ successorInBST(bst.root, 70));

		System.out.println("Predecessor in BST for 5 is : "+ predecessorInBST(bst.root, 5));
		System.out.println("Predecessor in BST for 15 is : "+ predecessorInBST(bst.root, 15).data);
		System.out.println("Predecessor in BST for 30 is : "+ predecessorInBST(bst.root, 30).data);
		System.out.println("Predecessor in BST for 33 is : "+ predecessorInBST(bst.root, 33).data);

	}

	private static boolean checkSumTree(Node<Integer> root) {
		return sum(root) != -1;
	}

	private static int sum(Node<Integer> root) {
		if (root == null)
			return 0;
		if (root.data == -1)
			return -1;
		if (root.left == null && root.right == null)
			return root.data;
		int left = sum(root.left);
		int right = sum(root.right);
		if (left != -1 && right != -1 && root.data == left+right) {
			return root.data * 2;
		}
		return -1;
	}

	private static boolean printAllAncestors(Node<Character> node, char h) {
		if(node == null) {
			return false;
		}
		if (node.data == h) {
			return true;
		}

		if (printAllAncestors(node.left, h) || printAllAncestors(node.right, h)) {
			System.out.println(node.data);
			return true;
		}
		return false;
	}

	public static void printKDistanceNode(Node<?> node, int k) {
		if (node == null) {
			return;
		}
		if (k == 0) {
			System.out.println(node.data);
		} else {
			printKDistanceNode(node.left, k-1);
			printKDistanceNode(node.right, k-1);
		}
	}

	public static boolean isMirror(Node<?> root1, Node<?> root2) {
		if(root1 == null && root2 == null) {
			return true;
		}

		if (root1 == null || root2 == null) {
			return false;
		}

		if(root1.data == root2.data) {
			if(isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left)) {
				return true;
			}
		}

		return false;
	}

	public static void connectSibling(Node<?> root) {
		if (root == null) {
			return;
		}

		if (root.left != null && root.left.sibling == null) {
			root.left.sibling = findSibling(root, false);
			connectSibling(root.left.sibling);
		}

		if (root.right != null && root.right.sibling == null) {
			root.right.sibling = findSibling(root, true);
		}

		connectSibling(root.left);
		connectSibling(root.right);
	}

	private static Node<?> findSibling(Node<?> root, boolean isRight) {
		if (root.right != null && !isRight) {
			return root.right;
		}
		if (root.sibling != null) {
			if (root.sibling.left != null) {
				return root.sibling.left;
			} else if (root.sibling.right != null) {
				return root.sibling.right;
			}
			return findSibling(root.sibling, false);
		}
		return null;
	}

	static Stack<Character> stack = new Stack<>();
	public static void printRootToLeafPath(Node<Character> root) {
		if(root == null) {
			return;
		}

		stack.push(root.data);
		printRootToLeafPath(root.left);
		if (root.left == null && root.right == null) {
			System.out.println(stack);
		}
		printRootToLeafPath(root.right);
		stack.pop();
	}

	public static void printLevelOrderByLevel(Node<?> root) {
		if (root == null) {
			return;
		}

		Queue<Node<?>> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);

		boolean isConsecutive = false;

		while (!queue.isEmpty()) {
			Node<?> node = queue.poll();
			if (node != null) {
				System.out.print(node.data+",");

				if (node.left != null) {
					queue.add(node.left);
				}

				if (node.right != null) {
					queue.add(node.right);
				}
				isConsecutive = false;
			} else {
				if (isConsecutive) {
					break;
				}
				isConsecutive = true;
				System.out.println();
				queue.add(null);
			}
		}
	}

	public static <T> void printVerticalOrder(Node<T> root) {
		if(root == null) {
			return;
		}
		Map<Integer, List<T>> map = new TreeMap<>();
		verticalOrder(root, 0, map);
		for (Map.Entry<Integer, List<T>> entry : map.entrySet()) {
			System.out.println(entry.getKey() +"==>"+ entry.getValue());
		}
	}

	private static <T> void verticalOrder(Node<T> root, int hd, Map<Integer, List<T>> map) {
		if(root == null) {
			return;
		}
		List<T> list = map.getOrDefault(hd, new ArrayList<>());
		list.add(root.data);
		map.put(hd, list);

		verticalOrder(root.left, hd-1, map);
		verticalOrder(root.right, hd+1, map);
	}

	public static <T> void printTopView(Node<T> root) {
		if(root == null) {
			return;
		}
		Set<Integer> set = new HashSet<>();
		printTopView(root, 0, set);
	}

	private static <T> void printTopView(Node<T> root, int hd, Set<Integer> set) {
		if(root == null) {
			return;
		}

		if(!set.contains(hd)) {
			set.add(hd);
			System.out.println(root.data);
		}
		printTopView(root.left, hd-1, set);
		printTopView(root.right, hd+1, set);
	}

	public static <T> Node<T> LCA(Node<T> root, T m, T n) {
		if(root == null) {
			return null;
		}

		if(root.data == m || root.data == n) {
			return root;
		}

		Node<T> left = LCA(root.left, m, n);
		Node<T> right = LCA(root.right, m, n);

		if(left != null && right != null) {
			return root;
		}

		return left != null ? left : right;
	}

	public static void convertToDLLAndPrint(Node<?> root) {
		Node<?> head = convertToDLL(root, null);
		while(head != null) {
			System.out.println(head.data);
			head = head.right;
		}
	}

	static Node prev = null;

	private static Node<?> convertToDLL(Node<?> root, Node<?> head) {
		if(root == null) {
			return head;
		}
		head = convertToDLL(root.left, head);
		if(prev == null) {
			head = root;
		} else {
			prev.right = root;
			root.left = prev;
		}
		prev = root;
		head = convertToDLL(root.right, head);
		return head;
	}

	public static com.aed.algo.BST.Node successorInBST(com.aed.algo.BST.Node root, int elem) {
		if(root == null) {
			return root;
		}
		com.aed.algo.BST.Node succ = null;
		while(root != null && root.data != elem) {
			if(elem < root.data) {
				succ = root;
				root = root.left;
			} else {
				root = root.right;
			}
		}

		if(root.right != null) {
			root = root.right;
			while(root.left != null) {
				root = root.left;
			}
			return root;
		}
		return succ;
	}

	public static com.aed.algo.BST.Node predecessorInBST(com.aed.algo.BST.Node root, int elem) {
		if(root == null) {
			return root;
		}
		com.aed.algo.BST.Node pred = null;
		while(root.data != elem) {
			if(elem > root.data) {
				pred = root;
				root = root.right;
			} else {
				root = root.left;
			}
		}

		if(root.left != null) {
			root = root.left;
			while(root.right != null) {
				root = root.right;
			}
			return root;
		}
		return pred;
	}
}

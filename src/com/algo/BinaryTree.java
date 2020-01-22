package com.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {

	static class Values {
		int max,min;
	}

	static class QItem {
		Node node;
		int hd;

		public QItem() {
		}

		public QItem(Node node, int hd) {
			this.node = node;
			this.hd = hd;
		}

		@Override
		public String toString() {
			return node.data + "hd : "+hd;
		}
	}

	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}

		public void add(int value){
			if(value <= data) {
				if(left == null) {
					left = new Node(value);
				} else {
					left.add(value);
				}
			} else {
				if(right == null) {
					right = new Node(value);
				} else {
					right.add(value);
				}
			}
		}

		public boolean contains(int value) {
			if(data == value){
				return true;
			} else if(value < data) {
				if(left == null) {
					return false;
				} else {
					return left.contains(value);
				}
			} else {
				if(right == null){
					return false;
				} else {
					return right.contains(value);
				}
			}
		}

		public void inorder() {
			if(left != null) {
				left.inorder();
			}
			System.out.println(data);
			if(right != null) {
				right.inorder();
			}
		}

		public void preorder() {
			System.out.println(data);
			if(left != null) {
				left.preorder();
			}
			if(right != null) {
				right.preorder();
			}
		}

		public void postorder(){
			if(left != null){
				left.postorder();
			}
			if(right != null){
				right.postorder();
			}
			System.out.println(data);
		}

		public void levelOrderUsingQueue() {
			Queue<Node> queue = new LinkedList<>();
			queue.add(this);

			while(!queue.isEmpty()) {
				Node node = queue.poll();
				System.out.println(node.data);

				if(node.left != null) {
					queue.add(node.left);
				}
				if(node.right != null) {
					queue.add(node.right);
				}
			}
		}

		public int height() {
			int lh = 0, rh = 0;
			if(left != null) {
				lh += left.height();
			}
			if(right != null) {
				rh += right.height();
			}
			return (lh > rh) ? lh+1 : rh+1;
		}

		public int height(Node root) {
			if (root == null)
				return 0;
			/* compute height of each subtree */
			int lheight = height(root.left);
			int rheight = height(root.right);

			/* use the larger one */
			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}

		public void levelOrder() {
			int h = height();
			for (int i = 1; i <= h; i++) {
				printGivenLevel(this, i);
			}
		}

		private void printGivenLevel(Node root, int level) {
			if(root == null) {
				return;
			}
			if(level == 1){
				System.out.println(root.data);
			} else if (level > 1) {
				printGivenLevel(root.left, level-1);
				printGivenLevel(root.right, level-1);
			}
		}

		public void topView(Node root) {
			if (root == null) {
				return;
			}
			printLeft(root.left);
			System.out.print(root.data + " ");
			printRight(root.right);
			System.out.println();
		}

		private void printLeft(Node node) {
			if (node == null) {
				return;
			}
			printLeft(node.left);
			System.out.print(node.data + " ");
		}

		private void printRight(Node node) {
			if (node == null) {
				return;
			}
			System.out.print(node.data + " ");
			printRight(node.right);
		}

		public void rightSideView(Node root) {
			List<Integer> result = new ArrayList<>();
			rightView(root, result, 0);
			System.out.println(result);
		}

		private void rightView(Node curr, List<Integer> result, int currDepth){
			if(curr == null){
				return;
			}
			if(currDepth == result.size()){
				result.add(curr.data);
			}

			rightView(curr.right, result, currDepth + 1);
			rightView(curr.left, result, currDepth + 1);
		}

		public void leftSideView(Node root) {
			List<Integer> result = new ArrayList<>();
			leftView(root, result, 0);
			System.out.println(result);
		}

		private void leftView(Node root, List<Integer> result, int currDepth) {
			if(root == null) {
				return;
			}

			if(currDepth == result.size()) {
				result.add(root.data);
			}

			leftView(root.left, result, currDepth+1);
			leftView(root.right, result, currDepth+1);
		}

		private void findMinMax(Node node, Values val, int hd) {
			if(node == null) {
				return;
			}
			if(hd < val.min){
				val.min = hd;
			} else if(hd > val.max){
				val.max = hd;
			}

			findMinMax(node.left, val, hd-1);
			findMinMax(node.right, val, hd+1);
		}

		private void printVerticalOrder(Node node, int line_no, int hd) {
			if(node == null) {
				return;
			}
			if(line_no == hd) {
				System.out.print(node.data+" ");
			}

			printVerticalOrder(node.left, line_no, hd-1);
			printVerticalOrder(node.right, line_no, hd+1);
		}

		Values val = new Values();
		public void verticalOrder(Node root) {

			findMinMax(root, val, 0);

			for (int i = val.min; i <= val.max; i++) {
				printVerticalOrder(root, i, 0);
				System.out.println();
			}
		}

		public void verticalSum(Node root) {
			if(root == null) {
				return;
			}

			HashMap<Integer, Integer> map = new HashMap<>();

			verticalSumUtil(root,map,0);

			System.out.println(map);
		}

		private void verticalSumUtil(Node root, HashMap<Integer, Integer> map, int hd) {
			if(root == null) {
				return;
			}

			if(map.containsKey(hd)) {
				int prev = map.get(hd);
				map.put(hd, root.data+prev);
			} else {
				map.put(hd, root.data);
			}

			verticalSumUtil(root.left, map, hd-1);
			verticalSumUtil(root.right, map, hd+1);
		}

		public void topViewCorrected(Node root) {
			if(root == null) {
				return;
			}

			QItem item = new QItem();
			item.node = root;
			item.hd = 0;

			Queue<QItem> queue = new LinkedList<>();
			queue.add(item);

			HashSet<Integer> visited = new HashSet<>();

			while(!queue.isEmpty()) {
				QItem q = queue.poll();
				int hd = q.hd;
				Node node = q.node;

				if(!visited.contains(hd)){
					visited.add(hd);
					System.out.print(node.data+" ");
				}

				if(node.left != null) {
					queue.add(new QItem(node.left, hd-1));
				}
				if(node.right != null) {
					queue.add(new QItem(node.right, hd+1));
				}
			}

			System.out.println();
		}

		public Node lca(Node root, int n1, int n2) {
			if (root == null) {
				return null;
			}

			if (root.data > n1 && root.data > n2) {
				return lca(root.left, n1, n2);
			}

			if (root.data < n1 && root.data < n2) {
				return lca(root.right, n1, n2);
			}

			return root;
		}

		public Node lcaItr(Node root, int n1, int n2) {
			if (root == null) {
				return null;
			}

			while (root != null) {
				if (root.data > n1 && root.data > n2) {
					root = root.left;
				} else if (root.data < n1 && root.data < n2) {
					root = root.right;
				} else {
					break;
				}
			}
			return root;
		}



		public static void main(String[] args) {
			Node root = new Node(50);

			root.add(30);
			root.add(20);
			root.add(40);
			root.add(35);
			root.add(70);
			root.add(60);
			root.add(80);


			/*System.out.println(root.contains(8));
			System.out.println(root.contains(9));

			System.out.println("Height of Tree");
			System.out.println(root.height());
			System.out.println(root.height(root));


			System.out.println("InOrder");
			root.inorder();

			System.out.println("PreOrder");
			root.preorder();

			System.out.println("PostOrder");
			root.postorder();

			System.out.println("LevelOrder Using Queue");
			root.levelOrderUsingQueue();

			System.out.println("LevelOrder");
			root.levelOrder();


			System.out.println("Vertical Order");
			root.verticalOrder(root);


			System.out.println("Vertical Sum");
			root.verticalSum(root);*/


			System.out.println("Left Side View");
			root.leftSideView(root);

			System.out.println("Right Side View");
			root.rightSideView(root);

			System.out.println("Top View");
			root.topView(root);

			System.out.println("Top View Corrected");
			root.topViewCorrected(root);

			/*System.out.println("LCA");
			Node lca = root.lca(root, 14, 8);
			System.out.println(lca.data);


			System.out.println("LCA I");
			Node lca1 = root.lcaItr(root, 10, 14);
			System.out.println(lca1.data);*/

		}
	}

}

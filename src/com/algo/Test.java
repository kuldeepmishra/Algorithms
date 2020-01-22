package com.algo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Test {

	public static void main(String[] args) throws IOException {
		System.out.println(KFrequency("aaaabbccd", 2));
	}

	static class Item {
		Character value;
		int frequency;

		public Item(Character value, int frequency) {
			this.value = value;
			this.frequency = frequency;
		}

	}

	static String KFrequency(String S, int K) {
		// Write your code here

		Map<Character, Integer> map = new HashMap<>();
		for(Character c : S.toCharArray()) {
			map.putIfAbsent(c, 0);

			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}
		}


		PriorityQueue<Item> maxHeap = new PriorityQueue<>((o1, o2) -> {

			if(o1.frequency > o2.frequency) {
				return -1;
			} else if(o1.frequency < o2.frequency) {
				return 1;
			} 
			return o1.value.compareTo(o2.value);
		});

		Set<Character> set = map.keySet();
		for (Character character : set) {
			maxHeap.add(new Item(character, map.get(character)));
		}


		for (int i = 1; i <= K-1; i++) {
			Item item = maxHeap.poll();
			while(!maxHeap.isEmpty() && maxHeap.peek().frequency == item.frequency) {
				maxHeap.poll();
			}
		}

		return maxHeap.isEmpty() ? "-1" : maxHeap.poll().value.toString();
	}

	static int calculate(char[][] K, String S, int n, int m) {
		Map<Character, String> map = new HashMap<>();

		for (int i = 0; i < K.length; i++) {
			for (int j = 0; j < K[i].length; j++) {
				map.put(K[i][j], i+"-"+j);
			}
		}

		Set<Character> set = map.keySet();

		String prev = "0-0";

		for (Character character : set) {
			String s = map.get(character);
			if(s == null) {
				return -1;
			}
			String arr[] = s.split("-");
			int x1= Integer.valueOf(arr[0]), y1 = Integer.valueOf(arr[1]);
		}
		return -1;
	}
}

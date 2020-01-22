package com.algo;

import java.util.Arrays;
import java.util.List;

public class MaxArraysSteps {

	public static void main(String[] args) {

		List<Integer> path = Arrays.asList(10, 2, -10, 5, 20);
		//List<Integer> path = Arrays.asList(3, -4, -3, -5, 0);

		System.out.println(journey(path, 2));

	}



	public static long journey(List<Integer> path, int maxStep) {

		long max = path.get(0);

		long resultMax = Long.MIN_VALUE;

		for (int i = 0; i < path.size()-maxStep; i++) {
			long newMax = Long.MIN_VALUE;
			for (int j = 0; j < maxStep; j++) {
				long a = max + path.get(i+j+1);

				if(newMax < a) {
					newMax = a;
				}
			}

			max = newMax;
			if(resultMax < max) {
				resultMax = max;
			}
		}

		return resultMax;
	}


}

package com.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution2 {

	/*
	 * Complete the 'awardTopKHotels' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY.
	 * The function accepts following parameters:
	 *  1. STRING positiveKeywords
	 *  2. STRING negativeKeywords
	 *  3. INTEGER_ARRAY hotelIds
	 *  4. STRING_ARRAY reviews
	 *  5. INTEGER k
	 */

	public static void main(String[] args) {
		String positiveKeywords = "beach fabulous very good awesome";
		String negativeKeywords = "not bad";
		List<Integer> hotelIds = Arrays.asList(1,2,1,1,2,3);
		List<String> reviews = new ArrayList<>();
		reviews.add("this hotel was very fantastic");
		reviews.add("very good hotel");
		reviews.add("beach was very awesome");
		reviews.add("not so good stay");
		reviews.add("bad choice of hotels");
		reviews.add("bad hotel");
		int k = 2;

		List<Integer> list = awardTopKHotels(positiveKeywords, negativeKeywords, hotelIds, reviews, k);
		System.out.println(list);

	}

	public static List<Integer> awardTopKHotels(String positiveKeywords, String negativeKeywords, List<Integer> hotelIds, List<String> reviews, int k) {
		String[] postiveList = positiveKeywords.split(" ");
		String[] negativeList = negativeKeywords.split(" ");


		Map<Integer, List<String>> map = new HashMap<>();

		for (int i = 0; i < hotelIds.size(); i++) {
			List<String> list = map.getOrDefault(hotelIds.get(i), new ArrayList<>());
			list.add(reviews.get(i));
			map.put(hotelIds.get(i), list);
		}


		Map<Integer, Map<String, Integer>> reviewMap = new HashMap<>();

		for(Map.Entry<Integer, List<String>> entry : map.entrySet()) {
			Map<String, Integer> countMap = new HashMap<>();
			for (String line : entry.getValue()) {
				for(String word : line.split(" ")) {
					countMap.put(word, countMap.getOrDefault(word, 0)+1);
				}
			}

			reviewMap.put(entry.getKey(), countMap);
		}

		Map<Integer, Integer> scoreMap = calculateReviews(reviewMap, postiveList, negativeList);
		Map<Integer, Integer> sortedMap = sortByValue(scoreMap);

		Set<Integer> topHotelIds = sortedMap.keySet();

		List<Integer> result = new ArrayList<>();
		int i = 1;
		for (Integer hotelId : topHotelIds) {
			result.add(hotelId);
			if(i == k) {
				break;
			}
			i++;
		}

		return result;
	}

	public static HashMap<Integer, Integer> sortByValue(Map<Integer, Integer> scoreMap) {
		List<Map.Entry<Integer, Integer>> list = new LinkedList<>(scoreMap.entrySet());

		Collections.sort(list, (o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));

		HashMap<Integer, Integer> temp = new LinkedHashMap<>();
		for (Map.Entry<Integer, Integer> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		return temp;
	}

	private static Map<Integer, Integer> calculateReviews(Map<Integer, Map<String, Integer>> map, String[] postiveList,
			String[] negativeList) {

		Map<Integer, Integer> scoreMap = new HashMap<>();

		for (Map.Entry<Integer, Map<String, Integer>> entry : map.entrySet()) {
			Integer key = entry.getKey();
			Map<String, Integer> wordMap = entry.getValue();

			int score = 0;
			int positiveWeight = 3;

			for (String positive : postiveList) {
				score += wordMap.getOrDefault(positive, 0) * positiveWeight;
			}

			int negativeWeight = -1;
			for (String negative : negativeList) {
				score += wordMap.getOrDefault(negative, 0) * negativeWeight;
			}

			scoreMap.put(key, score);
		}

		return scoreMap;
	}

}

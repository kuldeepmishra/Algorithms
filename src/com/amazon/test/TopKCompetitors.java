package com.amazon.test;

import java.util.*;

public class TopKCompetitors {

    public static void main(String[] args) {
        TopKCompetitors topKCompetitors = new TopKCompetitors();
        int numberOfCompetitors = 5;
        int kTopCompetitors = 3;
        List<String> competitors = Arrays.asList("Target", "Walmart", "BestBuy", "Costco", "Lowes");
        int numberOfReviews = 7;
        List<String> reviews = Arrays.asList("Target is been amazing target",
                "Walmart is so cool",
                "BestBuy offers best deals",
                "Costco is offering cheap macs",
                "Target CEO tops",
                "Walmart deals is huge",
                "Target offers one day delivery");;

        List<String> kTopCompetitorList = topKCompetitors.getTopKCompetitors(numberOfCompetitors, kTopCompetitors, competitors, numberOfReviews, reviews);
        System.out.println(kTopCompetitorList);
    }

    public List<String> getTopKCompetitors(int numberOfCompetitors, int kTopCompetitors, List<String> competitors, int numberOfReviews, List<String> reviews) {
        HashMap<String, Integer> reviewCountMap = new HashMap<>();
        for (String review : reviews) {
            String[] words = review.split(" ");
            Set<String> set = new HashSet<>();
            for (String word : words) {
                set.add(word.toLowerCase());
            }

            for (String word : set) {
                reviewCountMap.put(word, reviewCountMap.getOrDefault(word, 0)+1);
            }
        }

        PriorityQueue<Competitor> maxHeap = new PriorityQueue<>((o1, o2) -> (-1 * o1.numberOfTimeOccurred.compareTo(o2.numberOfTimeOccurred)));
        for (String competitor : competitors) {
            maxHeap.add(new Competitor(competitor, reviewCountMap.getOrDefault(competitor.toLowerCase(), 0)));
        }

        List<String> kTopCompetitorList = new ArrayList<>();
        kTopCompetitors = Math.min(numberOfCompetitors, kTopCompetitors);
        for (int i = 0; i < kTopCompetitors; i++) {
            kTopCompetitorList.add(maxHeap.poll().name);
        }
        return kTopCompetitorList;
    }

    private static class Competitor {
        String name;
        Integer numberOfTimeOccurred;

        public Competitor(String name, Integer numberOfTimeOccurred) {
            this.name = name;
            this.numberOfTimeOccurred = numberOfTimeOccurred;
        }
    }
}

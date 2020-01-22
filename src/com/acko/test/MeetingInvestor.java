package com.acko.test;

import java.util.*;

public class MeetingInvestor {

    public static void main(String[] args) {
        System.out.println(countMeetings(Arrays.asList(1,2,3,3,3), Arrays.asList(2,2,3,4,4)));
    }

    private static final Comparator<Investor> INVESTOR_COMPARATOR = (o1, o2) -> {
        if(o1.departureDay == o2.departureDay) {
            return o1.arrivalDay.compareTo(o2.arrivalDay);
        }
        return o1.departureDay.compareTo(o2.departureDay);
    };

    private static int countMeetingsThroughMap(List<Investor> investorList) {
        Map<Integer, Set<Investor>> map = new HashMap<>();
        for (Investor investor : investorList) {
            for (int i = investor.arrivalDay; i <= investor.departureDay ; i++) {
                 Set<Investor> investorSet = map.getOrDefault(i, new TreeSet<>(INVESTOR_COMPARATOR));
                 investorSet.add(investor);
                 map.put(i, investorSet);
            }
        }

        printMap(map);

        Set<Investor> finishedMeeting = new LinkedHashSet<>();

        for (Integer day : map.keySet()) {
            if(!map.containsKey(day)) {
                continue;
            }

            for (Investor investor : map.get(day)) {
                if(finishedMeeting.contains(investor)) {
                    continue;
                }
                finishedMeeting.add(investor);
                break;
            }
        }

        System.out.println(finishedMeeting);

        return finishedMeeting.size();

    }

    private static void printMap(Map<Integer, Set<Investor>> map) {

        for (Map.Entry<Integer, Set<Investor>> entry : map.entrySet()) {
            System.out.println(entry.getKey()+" == "+entry.getValue());
        }
    }

    public static int countMeetings(List<Integer> arrival, List<Integer> departure) {
        List<Investor> investorList = new ArrayList<>(arrival.size());
        for (int i = 0; i < arrival.size(); i++) {
            investorList.add(new Investor("Investor"+(i+1), arrival.get(i), departure.get(i)));
        }

        return countMeetingsThroughMap(investorList);
    }

    private static class Investor {
        private Integer arrivalDay;
        private Integer departureDay;
        private String name;

       public Investor(String name, Integer arrivalDay, Integer departureDay) {
           this.name = name;
           this.arrivalDay = arrivalDay;
           this.departureDay = departureDay;
       }

        @Override
        public String toString() {
            return name+"{" +
                    "arrivalDay=" + arrivalDay +
                    ", departureDay=" + departureDay +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Investor investor = (Investor) o;
            return Objects.equals(arrivalDay, investor.arrivalDay) &&
                    Objects.equals(departureDay, investor.departureDay);
        }

        @Override
        public int hashCode() {
            return Objects.hash(arrivalDay, departureDay);
        }
    }
}

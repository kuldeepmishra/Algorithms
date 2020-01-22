package com.codelity.test;

public class Codelity4 {

    public static void main(String[] args) {
        Codelity4 codelity4 = new Codelity4();
        System.out.println(codelity4.solution(new int[] {2, -2, 3, 0, 4, -7}));
    }

    public int solution(int[] A) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            int sum = 0;
            for (int j = i; j < A.length; j++) {
                sum = sum+A[j];
                if(sum == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}

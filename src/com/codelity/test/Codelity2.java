package com.codelity.test;

public class Codelity2 {

    public static void main(String[] args) {
        Codelity2 codelity2 = new Codelity2();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(codelity2.solution(21, 29));
    }

    public int solution(int A, int B) {

        int j = 0, k = 0;
        int count = 0;
        for (int i = A/2-1; i < B; i++) {
            j = i+1;
            k = i * j;
            if(k >= A && k <= B) {
                count++;
            }
            if(k > B) {
                break;
            }
        }

        return count;
    }

}

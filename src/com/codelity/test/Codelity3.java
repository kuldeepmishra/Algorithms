package com.codelity.test;

import java.util.ArrayList;
import java.util.Arrays;

public class Codelity3 {

    public static void main(String[] args) {

        Codelity3 codelity3 = new Codelity3();
        System.out.println(Arrays.toString(codelity3.solution(5, 6)));

    }

    public String[] solution(int N, int K) {
        if (N == 0) {
            return new String[] {""};
        }
        ArrayList<String> result = new ArrayList<String>();
        for (String p : solution(N - 1, K)) {
            for (char l : new char[] {'a', 'b', 'c'}) {
                int pLen = p.length();
                if (pLen == 0 || p.charAt(pLen - 1) != l) {
                    result.add(p + l);
                }
            }
        }

        int prefSize = Math.min(result.size(), K);
        return result.subList(0, prefSize).toArray(new String[prefSize]);
    }
}

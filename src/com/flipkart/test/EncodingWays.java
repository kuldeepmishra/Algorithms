package com.flipkart.test;

public class EncodingWays {
    public static void main(String[] args) {
        EncodingWays encodingWays = new EncodingWays();
        System.out.println(encodingWays.encode("123123"));
    }

    public int encode(String s) {
        //return encode(s, s.length()-1);
        //return encode(s, s.length()-1, new int[s.length()]);
        return encodeDP(s);
    }

    private int encode(String s, int n) {
        if(n <= 0) {
            return 1;
        }

        int count = 0;

        if (s.charAt(n) != '0') {
            count = encode(s, n-1);
        }

        if((s.charAt(n - 1) == '1' || s.charAt(n - 1) == '2') && s.charAt(n) < '7') {
            count += encode(s, n-2);
        }

        return count;
    }

    private int encode(String s, int n, int[] memo) {
        if(n <= 0) {
            return 1;
        }

        if(memo[n] != 0) {
            return memo[n];
        }

        int count = 0;

        if (s.charAt(n) != '0') {
            count = encode(s, n-1, memo);
        }

        if((s.charAt(n-1) == '1' || s.charAt(n-1) == '2') && s.charAt(n) < '7') {
            count += encode(s, n-2, memo);
        }
        memo[n] = count;
        return count;
    }

    private int encodeDP(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            if(s.charAt(i-1) > '0') {
                dp[i] = dp[i-1];
            }
            if((s.charAt(i-2) == '1' || s.charAt(i-2) == '2') && s.charAt(i-1) < '7') {
                dp[i] = dp[i] + dp[i-2];
            }
        }

        return dp[n];
    }
}

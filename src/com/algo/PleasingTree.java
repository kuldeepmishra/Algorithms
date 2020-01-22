package com.algo;

public class PleasingTree {

    public static void main(String[] args) {
        PleasingTree p = new PleasingTree();
        int a[] = new int[] {3,4,5,3,7};
        System.out.println(p.solution(a));

        int b[] = new int[] {1,2,3,4};
        System.out.println(p.solution(b));

        int c[] = new int[] {1,3,1,2};
        System.out.println(p.solution(c));
    }

    public int solution(int[] a) {
        if(checkTrees(a)) {
            return 0;
        }
        int count = 0;
        boolean isPossible = false;
        for (int i = 0; i < a.length; i++) {
            int[] b = new int[a.length-1];
            int index = 0;
            for (int j = 0; j < a.length; j++) {
                if(j == i) {
                    continue;
                }
                b[index++] = a[j];
            }

            if(checkTrees(b)) {
                isPossible = true;
                count++;
            }
        }
        if(!isPossible) {
            return -1;
        }
        return count;
    }

    public boolean checkTrees(int[] a) {
        if (a.length <= 2) {
            return true;
        }

        int smaller = a[0], bigger = a[1];
        if(smaller == bigger) {
            return true;
        }

        if(smaller < bigger) {
            return checkSmallerBigger(a, smaller, bigger);
        } else {
            return checkBiggerSmaller(a, smaller, bigger);
        }
    }

    private boolean checkSmallerBigger(int[] a, int smaller, int bigger) {
        for (int i = 2; i < a.length; i++) {
            if(i % 2 == 0 && a[i] < bigger) {
               smaller = a[i];
            } else if(i%2 != 0 && a[i] > smaller) {
                bigger = a[i];
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean checkBiggerSmaller(int[] a, int smaller, int bigger) {
        for (int i = 2; i < a.length; i++) {
            if(i % 2 == 0 && a[i] > bigger) {
                smaller = a[i];
            } else if(i%2 != 0 && a[i] < smaller) {
                bigger = a[i];
            } else {
                return false;
            }
        }
        return true;
    }
}

//출처 : https://github.com/EugeneChung/algorithm-training/blob/master/src/programmers/binarysearch/%EC%98%88%EC%82%B0.java

import java.util.*;

class Solution {
    public int solution(int[] budgets, int M) {
        // long sum = (long)Arrays.stream(budgets).sum();
        // int max = Arrays.stream(budgets).max().getAsInt();

        long sum = 0L;
        int max = 0;
        for(int budget : budgets) {
            if( budget > max)
                max = budget;
            sum += budget;
        }

        if( sum <= M) return max;

        int left = 0, right = max;
        int finalLimit = 0;
        int finalTotal = Integer.MIN_VALUE;

        while( left <= right) {
            int mid = (left + right) / 2;
            int midTotal = check(budgets, mid);

            if( midTotal == M){
                return mid;
            } else if( midTotal < M) {
                left = mid + 1;
                if(finalTotal < midTotal){
                    finalTotal = midTotal;
                    finalLimit = mid;
                }
            } else right = mid - 1;
        }

        return finalLimit;
    }

    static int check(int[] budgets, int limit ){
        int total = 0;
        for(int budget : budgets){
            if(budget > limit)
                budget = limit;
            total += budget;
        }

        return total;
    }
}

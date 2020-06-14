import java.util.*;

class Solution {
    public int[] sortedSquares(int[] A) {
        int[] ans = new int[A.length];
        int start = 0;
        int end = A.length-1;
        int num = A.length;
        while(--num >= 0){
            if(Math.abs(A[start]) < Math.abs(A[end])){
                ans[num] = A[end] * A[end];
                end--;
            } else {
                ans[num] = A[start] * A[start];
                start++;
            }
        }

        return ans;
    }

    // public int[] sortedSquares(int[] A) {
    //     return Arrays.stream(A).map(n -> n*n).sorted().toArray();
    // }
}

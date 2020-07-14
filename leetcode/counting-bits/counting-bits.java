class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];

        for(int i = 1 ; i <= num ; i++){
            int r = i & (i-1);
            ans[i] = ans[r]+1;
        }

        return ans;
    }
}

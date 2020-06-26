class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int left = 0, right = n-1, start = 1;
        while(left < right){
            ans[left++] = start;
            ans[right--] = -start;
            start++;
        }

        return ans;
    }
}

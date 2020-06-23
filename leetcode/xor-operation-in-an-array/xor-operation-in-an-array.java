class Solution {
    public int xorOperation(int n, int start) {
        int i = 0, ans = 0;
        while(i < n)
            ans ^= start + 2*i++;

        return ans;
    }
}

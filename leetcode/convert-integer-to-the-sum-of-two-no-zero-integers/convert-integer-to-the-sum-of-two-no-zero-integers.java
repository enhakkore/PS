class Solution {
    public int[] getNoZeroIntegers(int n) {
        int[] ans = new int[2];
        for(int i = 1 ; i < n ; i++){
            int j = n - i;
            if(check(i) && check(j)){
                ans[0] = i;
                ans[1] = j;
                break;
            }
        }

        return ans;
    }

    public boolean check(int num){
        while(num > 0){
            if(num % 10 == 0)
                return false;
            num /= 10;
        }

        return true;
    }
}

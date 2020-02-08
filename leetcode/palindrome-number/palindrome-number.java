class Solution {
    public boolean isPalindrome(int x) {
        if( x < 0 ) return false;

        int tmpX = x;
        int reverse_x = 0;
        int digit = 0;
        while(tmpX > 0){
            reverse_x = reverse_x * 10 + tmpX%10;
            tmpX /= 10;
            digit++;
        }

        for(int i = 1 ; i <= digit/2 ; i++){
            int xx = x % 10;
            int rx = reverse_x % 10;
            if(xx != rx) return false;
            x /= 10;
            reverse_x /= 10;
        }

        return true;
    }
}

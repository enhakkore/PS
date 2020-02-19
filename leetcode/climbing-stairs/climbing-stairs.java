// 시간 초과 나오는 코드

class Solution {
    static int count = 0;

    public int climbStairs(int n) {

        check(1, n);
        check(2, n);

        return count;
    }

    public void check(int num, int stop){
        if(num == stop){
            count++;
            return;
        }

        if(num > stop) return;

        if(num < stop){
            check(num+1, stop);
            check(num+2, stop);
        }
    }
}

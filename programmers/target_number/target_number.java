class Solution {
    static int limit = 0;
    static int target = 0;
    static int ans = 0;
    static int[] numbers;

    static int[] r = {1, -1};

    public void sol1(int order, int order1, int value){
        if(order == limit) {
            if(target == value){
                ans++;
            }
            return ;
        }

        int tmp = numbers[order]*r[order1];
        tmp += value;

        if(order1 == 0){
            sol1(order+1, order1, tmp);
            sol1(order, order1+1, value);
        }
        else {
            sol1(order+1, order1-1, tmp);
        }
    }

    public int solution(int[] numbers, int target) {
        limit = numbers.length;
        this.target = target;
        this.numbers = numbers;

        sol1(0, 0, 0);

        return ans;
    }
}

class Solution {
    public int subtractProductAndSum(int n) {
        return product(n)-sum(n);
    }

    public int product(int n){
        int result = 1;
        while(n > 0){
            int tmp = n % 10;
            result *= tmp;
            n /= 10;
        }

        return result;
    }

    public int sum(int n){
        int result = 0;
        while(n > 0){
            int tmp = n % 10;
            result += tmp;
            n /= 10;
        }

        return result;
    }
}

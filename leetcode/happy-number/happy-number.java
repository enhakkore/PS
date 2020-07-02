class Solution {
    public boolean isHappy(int n) {
        Set<Integer> stock = new HashSet<>();

        while(stock.add(n)){
            int tn = 0;
            while(n > 0){
                tn += (int)Math.pow(n%10, 2);
                n /= 10;
            }
            n = tn;
        }

        return n == 1;
    }
}

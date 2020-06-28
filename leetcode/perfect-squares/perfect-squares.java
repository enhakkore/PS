class Solution {
    public int numSquares(int n) {
        int[] stock = new int[n+1];
        return getMinSquare(n, stock);
    }

    public int getMinSquare(int tn, int[] stock){
        if(tn <= 3) return tn;

        int res = tn;

        for(int x = 1 ; x <= tn ; x++){
            int tmp = x*x;
            if(tmp > tn)
                break;
            else{
                int val = 0;

                if(stock[tn-tmp] == 0){
                    stock[tn-tmp] = 1+getMinSquare(tn-tmp, stock);
                }

                val = stock[tn-tmp];

                res = Math.min(res, val);
            }
        }

        stock[tn] = res;
        return res;
    }
}

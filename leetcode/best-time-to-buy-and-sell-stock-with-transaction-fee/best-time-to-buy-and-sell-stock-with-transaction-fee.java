// 출처 : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solution/

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int cash = 0; // 주식을 팔 때, 최대 이익
        int hold = -prices[0]; // 주식을 살 때, 최대 이익

        // 첫 번째날 주식을 팔 때의 최대 이익은 0이고(갖고 있는 주식이 없어서 팔지 못하므로),
        // 첫 번째날 주식을 살 때의 최대 이익은 0-prices[0] 이다.
        // 따라서 cash의 초기값은 0, hold의 초기값은 -pricesp[0] 이다.


        //두 번째 날부터 이익을 따진다.
        for(int i = 1 ; i < prices.length ; i++ ){
            cash = Math.max(cash, hold + prices[i] - fee); // 주식을 팔 때의 최대 이익
            hold = Math.max(hold, cash - prices[i]); // 주식을 살 때의 최대이익
        }

        // 하루에 살 수 있는 주식은 최대 한 주이다.
        // 갖고 있는 주식이 있다면 같은날 사는것과 파는것을 동시에 할 수 있다.
        // 그러나 주식을 사기 전에 주식을 파는 것을 먼저 해야한다.

        return cash;
    }
}

//bottomUp 방법
// 출처 : https://leetcode.com/submissions/detail/358483208/
//
// class Solution {
//     public int maxProfit(int[] prices, int fee) {
//         return bottomUp1(prices,fee);
//     }
//
//     private int bottomUp2(int[] prices,int fee){
//         if(prices.length < 2)
//             return 0;
//         int[] buy = new int[prices.length];
//         int[] sell = new int[prices.length];
//
//         buy[0] = -prices[0];
//         for(int i=1; i < prices.length; i++){
//             buy[i] = Math.max(buy[i-1],sell[i-1] - prices[i]);
//             sell[i] = Math.max(sell[i-1],buy[i-1] + prices[i] - fee);
//         }
//         return sell[prices.length-1];
//     }
//
//     private int bottomUp1(int[] prices,int fee){
//         if(prices.length < 2)
//             return 0;
//         int b0 = -prices[0],s0=0;
//         for(int i=1; i < prices.length; i++){
//             int temp = Math.max(s0,b0 + prices[i] - fee);
//             b0 = Math.max(b0,s0 - prices[i]);
//             s0 = temp;
//         }
//         return s0;
//     }
//
//
//
//
// }

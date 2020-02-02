class Solution {
    public int solution(int n) {
        int answer = 0;

        for(int start = 1; start <= n ; start++){
            if(start == n){
                answer++;
                break;
            }
            int mid_sum = start;
            for(int end = start+1 ; end < n ; end++ ){
                mid_sum += end;
                if(mid_sum == n){
                    answer++;
                    break;
                } else if(mid_sum > n){
                    break;
                }
            }
        }

        return answer;
    }
}

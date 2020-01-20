class Solution {
    public int[] solution(int brown, int red) {
        int[] answer = new int[2];
        int n = brown + red;

        for(int i = 3; i*i <= n ; i++){
            if(n % i == 0){
                int x = n/i;
                int y = i;

                if(check(x, y, red)){
                    answer[0] = x;
                    answer[1] = y;
                    break;
                }
            }
        }

        return answer;
    }

    public boolean check(int x, int y, int red){
        boolean flag = false;
        boolean anyway_no = false;

        for(int i = 2; x - i >= 1 ; i += 2){
            int i_tmp = x-i;
            for(int j = 2; y - j >= 1; j += 2){
                int tmp = i_tmp*(y-j);
                if(tmp == red) {
                    flag = true;
                    break;
                } else if( tmp < red) {
                    anyway_no = true;
                    break;
                }
            }
            if(flag || anyway_no) break;
        }

        return flag;
    }
}

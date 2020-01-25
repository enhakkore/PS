class Solution {
    public int solution(int n) {
        int n_count = check(Integer.toBinaryString(n));
        int subject = n + 1;
        while(true){
            int tmp_count = check(Integer.toBinaryString(subject));
            if(tmp_count == n_count)
                break;
            else subject++;
        }

        return subject;
    }

    public int check(String num){
        int count = 0;
        for(char tmp : num.toCharArray())
            if(tmp == '1') count++;

        return count;
    }
}

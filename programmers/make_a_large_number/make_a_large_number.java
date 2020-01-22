class Solution {

    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        char[] num = number.toCharArray();
        boolean[] visited = new boolean[number.length()];
        int startIndex = 0;
        int _k = number.length() - k;

        for(int i = number.length()-_k ; i < number.length() ; i++ ){
            int max = Integer.MIN_VALUE;
            for(int j = startIndex ; j <= i ; j++){
                if(!visited[j] && num[j] > max){
                    max = num[j];
                    startIndex = j;
                }
            }
            visited[startIndex] = true;
            answer.append((char)max);
        }

        return answer.toString();
    }
}

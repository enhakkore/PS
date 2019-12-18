class Solution {
    static int ans = Integer.MAX_VALUE;

    public void sol(int count, int index, int[][] link, String target, String[] words, boolean[] visited){
        visited[index] = true;

        if(words[index].equals(target)) {
            ans = Math.min(ans, count);
            return;
        }

        for(int i = 0 ; i < link.length ; i++){
            if(link[index][i] == 1 && visited[i] == false){
                sol(count+1, i, link, target, words, visited);
                visited[i] = false;
            }
        }
    }

    public boolean compare(String a, String b) {
        int count = 0;

        for(int i = 0 ; i < a.length() ; i++){
            if(a.charAt(i) != b.charAt(i))
                count++;
            if(count > 1) break;
        }

        if (count == 1) return true;
        else return false;
    }

    public int solution(String begin, String target, String[] words) {
        int n = words.length;
        boolean[] visited = new boolean[n];
        int[] beginTmp = new int[n];
        int[][] linkInfo = new int[n][n];

        for(int i = 0; i < words.length ; i++) {
            if(compare(begin, words[i]))
                beginTmp[i] = 1;
        }

        for(int i = 0 ; i < n ; i++){
            String tmp = words[i];
            for(int j = 0 ; j < n ; j++){
                String tmp1 = words[j];
                if(compare(tmp, tmp1))
                    linkInfo[i][j] = 1;
            }
        }

        for(int i = 0 ; i < n ; i++){
            if(beginTmp[i] == 1)
                sol(1, i, linkInfo, target, words, visited);
        }

        int answer = 0;
        if(ans != Integer.MAX_VALUE) answer = ans;

        return answer;
    }
}

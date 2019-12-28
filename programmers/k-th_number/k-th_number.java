import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int n = commands.length;
        int[] ans = new int[n];

        for(int i = 0 ; i < n ; i++){
            int[] tmp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(tmp);
            ans[i] = tmp[commands[i][2]-1];
        }

        return ans;
    }
}

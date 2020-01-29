import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] ans;

        if(arr.length > 1){
            int min = Arrays.stream(arr).min().getAsInt();
            ans = new int[arr.length-1];
            for(int i = 0, j=0 ; i < arr.length ; i++){
                if(min != arr[i]){
                    ans[j++] = arr[i];
                }
            }
        } else {
            ans = new int[1];
            ans[0] = -1;
        }

        return ans;
    }
}

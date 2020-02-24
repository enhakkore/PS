class Solution {
    public int[] dailyTemperatures(int[] T) {
        for(int i = 0 ; i < T.length ; i++){
            int days = 0;
            boolean flag = false;
            for(int j = i+1 ; j < T.length ; j++){
                if(T[i] >= T[j])
                    days++;
                else {
                    days++;
                    flag = true;
                    break;
                }
            }

            T[i] = flag ? days : 0;
        }

        return T;
    }
}

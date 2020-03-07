class Solution {
    public int findSpecialInteger(int[] arr) {
        HashMap<Integer, Integer> info = new HashMap<>();

        double stand = arr.length / 4.0;
        for(int num : arr){
            info.put(num, info.getOrDefault(num, 0)+1);
        }

        int ans = 0;
        for(int num : info.keySet()){
            double tmp = info.get(num);
            if(tmp > stand){
                ans = num;
                break;
            }
        }

        return ans;
    }
}

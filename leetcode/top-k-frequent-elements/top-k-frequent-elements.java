class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> stock = new LinkedHashMap<>();
        for(int n : nums){
            stock.put(n, stock.getOrDefault(n, 0)+1);
        }

        List<Integer> keyList = new ArrayList<>(stock.keySet());
        keyList.sort((n1, n2) -> {
            int v = stock.get(n2)-stock.get(n1);
            if(v == 0) return n1-n2;
            return v;
        });

        int[] ans = new int[k];
        for(int i = 0 ; i < k ; i++){
            ans[i] = keyList.get(i);
        }

        return ans;
    }
}

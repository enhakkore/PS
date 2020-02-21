class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] tmp = Arrays.copyOf(arr, arr.length);
        Arrays.sort(tmp);

        HashMap<Integer, Integer> info = new HashMap<>();

        int rank = 1;
        for(int e : tmp){
            if(!info.containsKey(e))
                info.put(e, rank++);
        }

        int[] ans = new int[arr.length];
        for(int i = 0 ; i < ans.length ; i++){
            ans[i] = info.get(arr[i]);
        }

        return ans;
    }
}

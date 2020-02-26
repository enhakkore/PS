class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        HashMap<Integer, Integer> info = new HashMap<>();

        for(int r = 0 ; r < mat.length ; r++){
            for(int c = 0; c < mat[r].length ; c++){
                if(mat[r][c] == 0){
                    info.put(r, c);
                    break;
                } else if(c == mat[r].length-1) info.put(r, c+1);
            }
        }

        List<Integer> keys = new ArrayList<>();
        keys.addAll(info.keySet());

        Collections.sort(keys, (k1, k2) -> {
            return info.get(k1).compareTo(info.get(k2));
        });

        int[] ans = new int[k];
        for(int i = 0 ; i < k ; i++){
            ans[i] = keys.get(i);
        }

        return ans;
    }
}

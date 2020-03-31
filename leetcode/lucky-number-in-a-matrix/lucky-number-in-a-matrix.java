class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        for(int[] row : matrix){
            int row_min_val = 100001;
            int target_index = 0;
            for(int i = 0 ; i < row.length ; i++){
                if(row_min_val > row[i]){
                    row_min_val = row[i];
                    target_index = i;
                }
            }

            int col_max_val = 0;
            for(int r = 0 ; r < matrix.length ; r++){
                col_max_val = Math.max(col_max_val, matrix[r][target_index]);
            }

            if(col_max_val == row_min_val){
                ans.add(col_max_val);
                break;
            }

        }

        return ans;
    }
}

class Solution {
    static int[] tr = {0, 0, 1, -1};
    static int[] tc = {1, -1, 0, 0};

    public int countServers(int[][] grid) {
        int ans = 0;

        for(int r = 0 ; r < grid.length ; r++){
            for(int c = 0 ; c < grid[r].length ; c++){
                if(grid[r][c] == 1){
                    int tmp = dfs(grid, r, c);
                    ans += tmp > 1 ? tmp : 0;
                }
            }
        }

        return ans;
    }

    public static int dfs(int[][] grid, int r, int c){
        grid[r][c] = 0;

        int val = 1;
        for(int i = 0; i < 4 ; i++){
            int R = r, C = c;
            
            while(true){
                R += tr[i];
                C += tc[i];

                if(R < 0 || R >= grid.length || C < 0 || C >= grid[R].length) break;

                if(grid[R][C] == 1){
                    val += dfs(grid, R, C);
                }
            }
        }

        return val;
    }
}

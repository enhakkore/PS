class Solution {
    int[] tr = {0, 0, 1, -1};
    int[] tc = {1, -1, 0, 0};

    int perimeter = 0;

    public int islandPerimeter(int[][] grid) {
        boolean isStarted = false;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int r = 0 ; r < grid.length ; r++){
            for(int c = 0; c < grid[r].length ; c++){
                if(grid[r][c] == 1){
                    isStarted = true;
                    visited[r][c] = true;
                    dfs(grid, r, c, visited);
                    break;
                }
            }
            if(isStarted) break;
        }

        return perimeter;
    }

    public void dfs(int[][] grid, int r, int c, boolean[][] visited){
        for(int i = 0 ; i < 4; i++){
            int R = r + tr[i];
            int C = c + tc[i];

            if( R >= grid.length || R < 0 || C >= grid[R].length || C < 0) {
                perimeter++;
                continue;
            }

            if(grid[R][C] == 0) perimeter++;
            else if(!visited[R][C]){
                visited[R][C] = true;
                dfs(grid, R, C, visited);
            }
        }
    }
}

class Solution {
    int[] tr = {0, 0, 1, -1};
    int[] tc = {1, -1, 0, 0};

    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;

        for(int r = 0 ; r < grid.length ; r++){
            for(int c = 0 ; c < grid[r].length ; c++){
                if(grid[r][c] == 0) continue;

                for(int i = 0 ; i < 4 ; i++){
                    int R = r + tr[i];
                    int C = c + tc[i];

                    if(R == -1 || R == grid.length) perimeter++;
                    else if(C == -1 || C == grid[R].length) perimeter++;
                    else if(grid[R][C] == 0) perimeter++;
                }
            }
        }

        return perimeter;
    }
}

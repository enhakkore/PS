import java.util.*;

class Solution {
    public int solution(int[][] land) {

        for(int r = 1; r < land.length ; r++){
            for(int c = 0 ; c < 4 ; c++){
                int maxV = 0;
                for(int pc = 0; pc < 4 ; pc++){
                    if(pc != c && maxV < land[r-1][pc])
                        maxV = land[r-1][pc];
                }

                land[r][c] += maxV;
            }
        }

        return Arrays.stream(land[land.length-1]).max().getAsInt();
    }
}

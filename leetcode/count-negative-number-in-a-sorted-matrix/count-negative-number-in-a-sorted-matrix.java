class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;

        for(int[] tmp1 : grid){
            int index = tmp1.length-1;
            while(index >= 0 && tmp1[index] < 0){
                index--;
            }
            count += tmp1.length - index - 1;
        }

        return count;

    }
}

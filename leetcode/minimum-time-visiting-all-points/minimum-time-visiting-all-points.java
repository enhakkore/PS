class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int len = 0;

        for(int i = 0; i < points.length-1 ; i++){
            int r = Math.abs(points[i][0]-points[i+1][0]);
            int c = Math.abs(points[i][1]-points[i+1][1]);
            len += Math.max(r, c);
        }

        return len;
    }
}

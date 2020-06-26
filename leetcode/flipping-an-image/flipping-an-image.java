class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for(int r = 0 ; r < A.length ; r++){
            int cLen = A[r].length;
            int cLimit = cLen/2;
            for(int c = 0 ; c < cLimit ; c++){
                int temp = A[r][c];
                A[r][c] = A[r][cLen - 1 - c];
                A[r][cLen - 1 - c] = temp;
            }

            for(int c = 0 ; c < cLen ; c++)
                A[r][c] = A[r][c] == 1 ? 0 : 1;
        }

        return A;
    }
}

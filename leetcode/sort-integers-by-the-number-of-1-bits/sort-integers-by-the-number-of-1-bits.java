class Solution {
    public int[] sortByBits(int[] arr) {
        int[][] info = new int[arr.length][2];
        for(int i = 0 ; i < arr.length ; i++){
            info[i][0] = Integer.bitCount(arr[i]);
            info[i][1] = arr[i];
        }

        Arrays.sort(info, (a, b) -> {
            return a[0] != b[0] ? a[0]-b[0] : a[1]-b[1] ;
        });

        int[] ans = new int[arr.length];
        for(int i = 0; i < arr.length ; i++){
            ans[i] = info[i][1];
        }

        return ans;
    }
}

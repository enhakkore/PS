class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);

        int diff = arr[0] - arr[1];
        for(int i = 1; i < arr.length-1 ; i++){
            int tDiff = arr[i]-arr[i+1];
            if(diff != tDiff) return false;
        }

        return true;
    }
}

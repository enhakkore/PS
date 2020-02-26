class Solution {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        for(int index = 0; index < arr.length ; index++){
            int isThere = Arrays.binarySearch(arr, arr[index]*2);
            if(isThere >= 0 && index != isThere) return true;
        }

        return false;
    }
}

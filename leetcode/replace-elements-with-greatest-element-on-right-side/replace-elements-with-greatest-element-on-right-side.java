class Solution {
    public int[] replaceElements(int[] arr) {
        helper(arr, arr.length -1, -1);
        return arr;
    }

    public void helper(int[] arr, int i, int max){
        int temp = arr[i];
        arr[i] = max;

        if( i == 0) return;
        else helper(arr, --i, Math.max(max, temp));
    }

//     public int[] replaceElements(int[] arr) {
//         int[] ans = new int[arr.length];
//         int max = -1;
//         ans[ans.length-1] = -1;

//         for(int i = arr.length-2 ; i >= 0 ; i--){
//             max = Math.max(max, arr[i+1]);
//             ans[i] = max;
//         }

//         return ans;
//     }
}

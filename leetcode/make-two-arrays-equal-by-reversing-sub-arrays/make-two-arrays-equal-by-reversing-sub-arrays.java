class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] info = new int[1001];

        for(int i = 0 ; i < target.length ; i++){
            info[target[i]]++;
            info[arr[i]]--;
        }

        for(int n : info){
            if(n < 0) return false;
        }

        return true;
    }

//     public boolean canBeEqual(int[] target, int[] arr) {
//         for(int i = 0 ; i < target.length ; i++){
//             boolean flag = true;
//             int idx;
//             for(idx = i ; idx < arr.length ; idx++){
//                 if(target[i] == arr[idx]){
//                     flag = false;
//                     break;
//                 }
//             }

//             if(flag) return false;

//             int tmp = arr[i];
//             arr[i] = arr[idx];
//             arr[idx] = tmp;
//         }

//         return true;
//     }
}

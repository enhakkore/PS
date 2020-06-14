class Solution {
    public boolean isMonotonic(int[] A) {
        boolean increase = true;
        boolean decrease = true;

        for(int i = 0 ; i < A.length-1 ; i++){
            if(A[i] < A[i+1]){
                decrease = false;
            } else if(A[i] > A[i+1]){
                increase = false;
            }
        }

        return increase || decrease;
    }
//     public boolean isMonotonic(int[] A) {
//         boolean increase = false;
//         boolean flag = true;
//         boolean result = true;

//         for(int i = 0 ; i < A.length-1 ; i++){
//             if(A[i] < A[i+1]){
//                 if(flag){
//                     increase = true;
//                     flag = false;
//                 } else if(!increase){
//                     result = false;
//                     break;
//                 }
//             } else if(A[i] > A[i+1]){
//                 if(flag){
//                     increase = false;
//                     flag = false;
//                 } else if(increase){
//                     result = false;
//                     break;
//                 }
//             }
//         }

//         return result;
//     }
}

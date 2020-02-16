class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int stand = 0;
        for(int j = 0 ; j < n ; j++){
            for(int i = stand; i <= m ; i++){
                if( i == m || nums2[j] < nums1[i]){
                    toRight(nums1, m, i);
                    nums1[i] = nums2[j];
                    m++;
                    stand = i+1;
                    break;
                }
            }
        }
    }

    public void toRight(int[] num, int m, int index){
        for(int i = m ; i > index ; i--){
            num[i] = num[i-1];
        }
    }
}

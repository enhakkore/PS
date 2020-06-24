class Solution {
    public String toLowerCase(String str) {
        char[] arr = str.toCharArray();

        int diff = 'a'-'A';
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] <= 'Z' && arr[i] >= 'A')
               arr[i] = (char)(arr[i]+diff);
        }

        return new String(arr);
    }
}

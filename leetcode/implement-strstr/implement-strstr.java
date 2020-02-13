class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;

        int index = 0;
        for(int i = 0 ; i < haystack.length() ; i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                index = i;
                if(needle.length() == 1) return index;
                for(int j = 1 ; j < needle.length() ; j++){
                    if(i+j >= haystack.length() || haystack.charAt(i+j) != needle.charAt(j))
                        break;
                    if(j == needle.length()-1) return index;
                }
            }
        }

        return -1;
    }
}

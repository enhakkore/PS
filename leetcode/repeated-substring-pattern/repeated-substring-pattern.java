class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for(int i = 0 ; i < s.length()/2 ; i++){
            int j = i+1;
            if(s.length() % j != 0) continue;
            String sub = s.substring(0, j);
            int k = j;
            while(j < s.length() && s.startsWith(sub, j)){
                    j += k;
            }

            if(j == s.length()) return true;
        }

        return false;
    }
}

// 출처 : https://leetcode.com/problems/increasing-decreasing-string/submissions/

class Solution {
    public String sortString(String s) {
        int[] info = new int[26];
        for(char c : s.toCharArray()){
            info[c-'a']++;
        }

        StringBuilder ans = new StringBuilder();

        while(ans.length() != s.length()){
            for(int i = 0 ; i < 26 ; i++){
                if(info[i]-- > 0){
                    char cur = (char)('a'+i);
                    ans.append(cur);
                }
            }

            if(ans.length() == s.length()) break;

            for(int i = 25 ; i > -1 ; i--){
                if(info[i]-- > 0){
                    char cur = (char)('a'+i);
                    ans.append(cur);
                }
            }
        }

        return ans.toString();
    }
}

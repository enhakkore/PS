class Solution {
    public String removeOuterParentheses(String S) {
        ArrayDeque<Character> outer = new ArrayDeque<>();
        ArrayDeque<Character> prim = new ArrayDeque<>();
        StringBuilder ans = new StringBuilder();

        char[] s = S.toCharArray();

        int left = 0;
        for(int i = 0 ; i < s.length ; i++){
            char cur = s[i];
            if(cur == '('){
                if(outer.isEmpty()){
                    outer.push(cur);
                    left = i;
                } else prim.push(cur);
            } else {
                if(prim.isEmpty()){
                    for(int j = left+1 ; j < i ; j++)
                        ans.append(s[j]);
                    outer.pop();
                } else prim.pop();
            }

        }

        return ans.toString();
    }
}

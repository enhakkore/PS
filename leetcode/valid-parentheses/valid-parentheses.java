class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> st = new ArrayDeque<>();

        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                st.push(c);
            }

            if(c == ')' || c == '}' || c == ']'){
                char tmp;
                try{
                    tmp = st.peek();
                } catch(Exception e){
                    return false;
                }

                if(tmp+2 >= c && tmp < c )
                    st.pop();
                else return false;
            }
        }

        if(st.size() != 0) return false;
        return true;
    }
}

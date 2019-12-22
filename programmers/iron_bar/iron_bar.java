import java.util.*;

class Solution {

    public int solution(String arrangement) {
        Stack<Character> st = new Stack<>();
        int answer = 0;

        boolean flag = false;
        for(int i = 0 ; i < arrangement.length() ; i++) {
            char tmp = arrangement.charAt(i);

            if(tmp == '('){
                st.push(tmp);
                flag = true;
            }
            else if(tmp == ')'){
                if(flag) {
                    st.pop();
                    answer += st.size();
                    flag = false;
                }
                else {
                    st.pop();
                    answer += 1;
                }
            }
        }

        return answer;
    }
}

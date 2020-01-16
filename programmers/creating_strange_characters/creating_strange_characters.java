import java.util.*;

class Solution {
    public String solution(String s) {
        String[] sArray = s.split(" ", -1);
        List<String> ans = new ArrayList<>();

        for(String tmp : sArray){
            String tmp1 = new String();
            int d = 'a'-'A';
            for(int index = 0; index < tmp.length() ; index++){
                char tmp2 = tmp.charAt(index);
                if(index % 2 == 0 && tmp2 >= 'a'){
                    tmp1 += (char)(tmp2 - d);
                } else if(index % 2 != 0 && tmp2 <= 'Z'){
                    tmp1 += (char)(tmp2 + d);
                } else tmp1 += tmp2;
            }
            ans.add(tmp1);
        }

        return String.join(" ", ans);
    }
}

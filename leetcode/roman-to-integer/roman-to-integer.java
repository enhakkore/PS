import java.util.*;

class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> roman = new HashMap<>(Map.of('I',1,'V',5,'X',10,'L',50,'C',100,'D',500,'M',1000));

        int final_value = 0;
        int before_v = 1000;
        for(char tmp_s : s.toCharArray()){
            int v = roman.get(tmp_s);
            final_value += before_v >= v ? v : v - before_v*2;
            before_v = v;
        }

        return final_value;
    }
}

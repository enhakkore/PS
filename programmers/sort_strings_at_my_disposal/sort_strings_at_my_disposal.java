import java.util.*;

class Solution {
  public String[] solution(String[] strings, int n) {
      Arrays.sort(strings, (o1, o2) -> {
          char a = o1.charAt(n);
          char b = o2.charAt(n);
          if( a == b) return o1.compareTo(o2);
          else return a-b;
      });

      return strings;
  }
}

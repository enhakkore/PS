import java.util.*;

class Solution {
  public String solution(String s) {
      StringBuilder ans = new StringBuilder();

      int min = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).min().getAsInt();
      ans.append(min);
      ans.append(" ");
      int max = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).max().getAsInt();
      ans.append(max);

      return ans.toString();
  }
}

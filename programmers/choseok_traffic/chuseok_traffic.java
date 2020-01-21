// 미완, 테스트 케이스가 이해 안된다.... 문제를 정확히 이해하지 못한 것 같다.

import java.util.*;

class Solution {
  public int solution(String[] lines) {
      int answer = 0;
      Map<Integer, Integer> info = new HashMap<>();

      for(String line : lines){
          String[] _line = line.split(" "); // line을 공백으로 나눠 배열로 만든다
          String[] time = _line[1].split("[:]"); // 시간 부분을 :로 나눠 배열로 만든다
          String _mid = _line[2].replace("s",""); // 처리시간에서 s를 공백으로 바꾼다
          double finalSec = Double.parseDouble(time[2]);
          int allSec = Integer.parseInt(time[0])*3600 + Integer.parseInt(time[1])*60; // 시간과 분을 초로 바꾼다
          finalSec += allSec;
          double mid = Double.parseDouble(_mid);
          double startSec = finalSec - mid + 0.001;

          System.out.println("start : "+startSec+" , final : "+finalSec+" , mid : " + mid);
          double i = 0.0;
          do {
              int tmp = (int)(startSec += i);
              if(startSec < 0) tmp -= 1;
                System.out.print("tmp : "+tmp+ " , startSec : " + startSec +" , i : " + i +"\n" );
              info.put(tmp, info.getOrDefault(tmp, 0)+1);
              i = 1.0;
          } while(startSec <= finalSec);
          // System.out.println();

      }

      List<Integer> keySet = new ArrayList<>(info.keySet());
      Collections.sort(keySet, (o1, o2) -> {
          return info.get(o2) - info.get(o1);
      });

      answer = info.get(keySet.get(0));

      return answer;
  }
}

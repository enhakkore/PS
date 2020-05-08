// https://programmers.co.kr/learn/courses/30/lessons/64065

import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String s) {
        String[] tuple = s.substring(2, s.length()-2).split("\\},\\{");

        List<List<Integer>> stock = new ArrayList<>();
        for(String tmp : tuple){
            List<Integer> mid = Arrays.stream(tmp.split(",")).map(Integer::valueOf).collect(Collectors.toList());
            stock.add(mid);
        }

        stock.sort(Comparator.comparing(e -> e.size()));
        Set<Integer> ans = new HashSet<>();
        List<Integer> ans2 = new ArrayList<>();
        for(List<Integer> tmp : stock ){
            tmp.stream().forEach(n -> {
                    if(ans.add(n))
                        ans2.add(n);
                });
        }

        return ans2.stream().mapToInt(Integer::intValue).toArray();
    }
}

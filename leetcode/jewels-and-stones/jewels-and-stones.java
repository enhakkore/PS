import java.util.*;
import java.util.stream.*;

class Solution {
    public int numJewelsInStones(String J, String S) {
        List<Integer> jList = J.chars().mapToObj(Integer::new).collect(Collectors.toList());
        return (int)S.chars().filter(jList::contains).count();
    }
}

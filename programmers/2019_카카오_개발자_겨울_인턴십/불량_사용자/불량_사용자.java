import java.util.*;
import java.util.stream.*;

class Solution {

    private static Set<List<String>> ans = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        Map<String, List<String>> info = new HashMap<>();

        for(String ban : banned_id){
            if(info.containsKey(ban)) continue;

            List<String> list = new LinkedList<>();
            for(String user : user_id){
                if(check(user, ban)){
                    list.add(user);
                }
            }

            info.put(ban, list);
        }

        Map<String, Boolean> visited = new HashMap<>();
        for(String user : user_id)
            visited.put(user, false);

        Deque<String> mid = new ArrayDeque<>();
        count(0, banned_id, mid, visited, info);

        return ans.size();
    }

    public void count(int level, String[] banned_id, Deque<String> mid, Map<String, Boolean> visited, Map<String, List<String>> info){
        if(level == banned_id.length){
            List<String> mid_res = mid.stream().sorted().collect(Collectors.toList());
            ans.add(mid_res);
            return;
        }

        String cur_ban = banned_id[level];
        List<String> list = info.get(cur_ban);
        for(String user : list){
            if(!visited.get(user)){
                mid.push(user);
                visited.put(user, true);

                count(level+1, banned_id, mid, visited, info);

                mid.pop();
                visited.put(user, false);
            }
        }
    }

    public boolean check(String user, String ban){
        if(user.length() != ban.length())
            return false;

        boolean flag = true;

        for(int i = 0 ; i < user.length() ; i++){
            if(ban.charAt(i) == '*') continue;
            if(ban.charAt(i) != user.charAt(i)){
                flag = false;
                break;
            }
        }

        return flag;
    }
}

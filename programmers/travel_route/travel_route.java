import java.util.*;

class Solution {
    class Flag {
        boolean flag = false;
    }

    public void sol(String airport, int count, String[][] tickets, boolean[] used, ArrayList<String> path, Flag flag){
        if(!flag.flag) path.add(airport);

        if(count == tickets.length){
            flag.flag = true;
            return;
        }

        HashMap<String, Integer> tmp = new HashMap<>();
        for(int i = 0 ; i < tickets.length ; i++){
            if(used[i] == false && tickets[i][0].equals(airport)){
                tmp.put(tickets[i][1], i);
            }
        }

        if(!tmp.isEmpty()){
            String[] stops = tmp.keySet().toArray(new String[tmp.size()]);

            for(int i = 0 ; i < stops.length ; i++){
                used[tmp.get(stops[i])] = true;
                sol(stops[i], count+1, tickets, used, path, flag);
                if(flag.flag) break;
                used[tmp.get(stops[i])] = false;
                path.remove(path.size()-1);


            }
        }
    }

    public String[] solution(String[][] tickets) {
        boolean[] used = new boolean[tickets.length];
        ArrayList<String> path = new ArrayList<>();
        Flag flag = new Flag();

        sol("ICN", 0, tickets, used, path, flag);

        String[] answer = path.toArray(new String[path.size()]);
        return answer;
    }
}

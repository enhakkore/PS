import java.util.*;

class Solution {
    static String midPath = new String();

    public void sol(String airport, int count, String[][] tickets, boolean[] used, ArrayList<String> path){

        midPath += airport + ",";

        if(count == tickets.length){
            path.add(midPath.substring(0, midPath.length()-1));
            // for(int i = 0 ; i < path.size() ; i++)
            //     System.out.print(path.get(i) + " ");
            // System.out.println();
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
                sol(stops[i], count+1, tickets, used, path);
                used[tmp.get(stops[i])] = false;
                midPath = midPath.substring(0, midPath.length()-4);
            }
        }
    }

    public String[] solution(String[][] tickets) {
        boolean[] used = new boolean[tickets.length];
        ArrayList<String> path = new ArrayList<>();

        sol("ICN", 0, tickets, used, path);

        Collections.sort(path);
        String[] answer = path.get(0).split(",");
        return answer;
    }
}

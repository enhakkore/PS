// 출처 : https://baihuqian.github.io/2018-08-11-reconstruct-itinerary/

class Solution {
    Map<String, PriorityQueue<String>> stock;
    LinkedList<String> path;

    public List<String> findItinerary(List<List<String>> tickets) {
        stock = new HashMap<>();
        path = new LinkedList<>();

        for(List<String> ticket : tickets){
            stock.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            stock.get(ticket.get(0)).offer(ticket.get(1));
        }

        dfs("JFK");

        return path;
    }

    public void dfs(String from){
        PriorityQueue<String> tmp = stock.get(from);
        while(tmp != null && !tmp.isEmpty()){
            dfs(tmp.poll());
        }
        path.addFirst(from);
    }

}

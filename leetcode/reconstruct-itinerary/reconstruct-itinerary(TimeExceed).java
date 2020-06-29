class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> ans = new LinkedList<>();
        reconstruct(tickets, "JFK", "", new boolean[tickets.size()], 0, ans);
        ans.sort(Comparator.naturalOrder());
        return Arrays.stream(ans.get(0).split(" ")).collect(Collectors.toList());
    }

    public void reconstruct(List<List<String>> tickets, String from ,String path, boolean[] visited, int count, List<String> ans){
        path += from + " ";

        if(count == tickets.size()){
            ans.add(path);
            return;
        }

        for(int i = 0 ; i < tickets.size() ; i++){
            if(!visited[i] && tickets.get(i).get(0).equals(from)){
                visited[i] = true;
                reconstruct(tickets, tickets.get(i).get(1), path, visited, count+1, ans);
                visited[i] = false;
            }
        }
    }
}

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(graph, 0, paths, path);

        return paths;
    }

    public void dfs(int[][] graph, int node, List<List<Integer>> paths, List<Integer> path){
        path.add(node);

        if(path.get(path.size()-1) == graph.length-1){
            paths.add(new ArrayList<>(path));
            return;
        }

        int[] next = graph[node];
        for(int i = 0 ; i < next.length ; i++){
            dfs(graph, next[i], paths, path);
            path.remove(path.size()-1);
        }
    }
}

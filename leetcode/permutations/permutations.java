class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        List<Integer> stock = new ArrayList<>();

        for(int start = 0; start < nums.length ; start++){
            visited[start] = true;
            permutation(nums, start, visited, stock);
            visited[start] = false;
            stock.remove(stock.size()-1);
        }

        return ans;
    }

    public void permutation(int[] nums, int cur, boolean[] visited, List<Integer> stock){
        stock.add(nums[cur]);

        if(stock.size() == nums.length){
            ans.add(new ArrayList<>(stock));
            return;
        }

        for(int next = 0; next < nums.length ; next++){
            if(!visited[next]){
                visited[next] = true;
                permutation(nums, next, visited, stock);
                visited[next] = false;

                stock.remove(stock.size()-1);
            }
        }
    }
}

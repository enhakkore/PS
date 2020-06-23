class Solution {
    public List<String> buildArray(int[] target, int n) {
        final String push = "Push";
        final String pop = "Pop";
        List<String> ans = new ArrayList<>();

        int i = 0, num = 1;
        while( i < target.length){
            int cur = num++;
            ans.add(push);

            if(target[i] == cur){
                i++;
            } else {
                ans.add(pop);
            }
        }

        return ans;
    }
}

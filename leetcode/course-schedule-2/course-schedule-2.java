class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> info = new HashMap<>();

        for(int i = 0 ; i < numCourses ; i++){
            info.put(i, new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            info.get(pre[0]).add(pre[1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        Integer start = findZero(info);
        if(start == null) return new int[]{};
        queue.offer(start);

        Queue<Integer> ans = new LinkedList<>();
        while(true){
            Integer cur = queue.poll();

            removeEdge(info, cur);
            ans.offer(cur);

            Integer next = findZero(info);
            if(next == null){
                if(info.isEmpty()) break;
                else return new int[]{};
            }

            queue.offer(next);
        }

        int[] ans1 = new int[ans.size()];

        for(int i = 0 ; i < ans1.length ; i++){
            ans1[i] = ans.poll().intValue();
        }

        return ans1;

    }

    public Integer findZero(Map<Integer, List<Integer>> info){
        Integer target = null;
        for(Integer key : info.keySet()){
            if(info.get(key).isEmpty()){
                target = key;
                break;
            }
        }

        if(target == null) return null;

        info.remove(target);
        return target;
    }

    public void removeEdge(Map<Integer, List<Integer>> info, Integer node){
        for(Integer key : info.keySet()){
            info.get(key).remove(node);
        }
    }
}

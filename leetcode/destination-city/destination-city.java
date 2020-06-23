class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, String> info = new HashMap<>();

        for(List<String> path : paths){
            info.put(path.get(0), path.get(1));
        }

        String start = paths.get(0).get(0);

        while(info.containsKey(start)){
            start = info.get(start);
        }

        return start;
    }
}

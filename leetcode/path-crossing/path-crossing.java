class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> trace = new HashSet<>();

        int x = 0, y = 0;
        trace.add("0 0");
        for(char c : path.toCharArray()){
            if(c == 'N') x++;
            else if(c == 'S') x--;
            else if(c == 'E') y++;
            else if(c == 'W') y--;

            String pos = x + " " + y;
            if(!trace.add(pos)) return true;
        }

        return false;
    }
}

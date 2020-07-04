// 출처 : https://leetcode.com/submissions/detail/361822661/

class Solution {
    class Pair {
        public int x;
        public int y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o){
            if(o == this) return true;
            if( !(o instanceof Pair)) return false;

            Pair p = (Pair)o;
            return p.x == this.x && p.y == this.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public boolean isPathCrossing(String path) {
        int x = 0, y = 0;

        Set<Pair> set = new HashSet<>();
        set.add(new Pair(x, y));

        for(char c : path.toCharArray()){
            if(c == 'N') x++;
            else if(c == 'S') x--;
            else if(c == 'E') y++;
            else if(c == 'W') y--;

            Pair p = new Pair(x, y);
            if(set.contains(p)) return true;
            set.add(p);
        }

        return false;
    }
}

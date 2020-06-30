class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;

        for(char c : moves.toCharArray()){
            switch(c){
                case 'R':
                    y++;
                    break;
                case 'L':
                    y--;
                    break;
                case 'U':
                    x++;
                    break;
                case 'D':
                    x--;
                    break;
            }
        }

        return x == 0 && y == 0;
    }
}

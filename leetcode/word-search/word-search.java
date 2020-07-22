class Solution {
    private int[] tr = {0, 0, 1, -1};
    private int[] tc = {1, -1, 0, 0};

    public boolean exist(char[][] board, String word) {
        boolean result = false;

        for(int r = 0 ; r < board.length ; r++){
            for(int c = 0 ; c < board[r].length ; c++){
                if(board[r][c] == word.charAt(0))
                    result |= search(board, word, r, c, 1, new boolean[board.length][board[r].length]);
                if(result) return result;
            }
        }

        return result;
    }

    public boolean search(char[][] board, String word, int r, int c, int index, boolean[][] visited){
        visited[r][c] = true;

        if(index == word.length() && index == word.length()){
            return true;
        }

        boolean result = false;

        for(int i = 0 ; i < 4 ; i++){
            int R = r + tr[i];
            int C = c + tc[i];

            if(R < 0 || R >= board.length || C < 0 || C >= board[0].length) continue;

            if(!visited[R][C] && board[R][C] == word.charAt(index)){
                result |= search(board, word, R, C, index+1, visited);
                visited[R][C] = false;
            }

            if(result) break;
        }

        return result;
    }
}

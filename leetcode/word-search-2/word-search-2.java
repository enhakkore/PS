class Solution {
    static int[] tr = { 0, 0, 1, -1};
    static int[] tc = { 1, -1, 0, 0};

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> ans = new TreeSet<>();

        for(String word : words){
            char[] wordArr = word.toCharArray();
            boolean result = false;

            for(int r = 0 ; r < board.length ; r++){
                for(int c = 0 ; c < board[r].length ; c++){
                    if(wordArr[0] == board[r][c]){
                        boolean[][] visited = new boolean[board.length][board[r].length];
                        visited[r][c] = true;
                        result = findWord(board, wordArr, r, c, 0, visited);
                        if(result) break;
                    }
                }
                if(result){
                    ans.add(word);
                    break;
                }
            }
        }

        return ans.stream().collect(Collectors.toList());
    }

    public boolean findWord(char[][] board, char[] word, int r, int c, int p, boolean[][] visited){
        if(p == word.length-1) return true;

        boolean result = false;

        for(int i = 0 ; i < 4 ; i++){
            int R = r + tr[i];
            int C = c + tc[i];

            if(R >= board.length || R < 0 || C >= board[0].length || C < 0) continue;
            if(!visited[R][C] && board[R][C] == word[p+1]){
                visited[R][C] = true;
                result |= findWord(board, word, R, C, p+1, visited);
                if(result) return result;

                visited[R][C] = false;
            }
        }

        return result;
    }
}

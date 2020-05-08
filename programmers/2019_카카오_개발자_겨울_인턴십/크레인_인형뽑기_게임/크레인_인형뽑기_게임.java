import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Deque<Integer> stack = new ArrayDeque<>();
        int count = 0;

        for(int target_c : moves){
            for(int r = 0; r < board.length ; r++ ){
                int target = board[r][target_c-1];
                if(target != 0){
                    if(!stack.isEmpty()){
                        int top = stack.peek();
                        if(top == target){
                            stack.pop();
                            count += 2;
                        } else
                            stack.push(target);
                    } else
                        stack.push(target);

                    board[r][target_c-1] = 0;
                    break;
                }
            }
        }

        return count;
    }
}

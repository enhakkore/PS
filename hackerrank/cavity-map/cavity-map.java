import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the cavityMap function below.
    static String[] cavityMap(int n, String[] grid) {
        int[] tr = { 0, 0, 1, -1};
        int[] tc = { 1, -1, 0, 0};

        char[][] board = Arrays.stream(grid).map(r -> r.toCharArray()).toArray(char[][]::new);
        ArrayDeque<Integer> stock = new ArrayDeque<>();

        for(int r = 1 ; r < n-1 ; r++ ){
            for(int c = 1; c < n-1 ; c++){
                int stand = board[r][c];

                boolean flag = true;
                for(int i = 0; i < 4 ; i++){
                    if(stand <= board[r+tr[i]][c+tc[i]]){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    stock.offer(r);
                    stock.offer(c);
                }
            }
        }

        while(!stock.isEmpty()){
            int r = stock.poll();
            int c = stock.poll();

            board[r][c] = 'X';
        }

        String[] ans = Arrays.stream(board).map(String::valueOf).toArray(String[]::new);

        Arrays.stream(ans).forEach(System.out::println);
        return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] result = cavityMap(n, grid);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

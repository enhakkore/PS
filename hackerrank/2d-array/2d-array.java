import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int max_sum = Integer.MIN_VALUE;
        for(int r = 0 ; r < 4 ; r++){
            for(int c = 0 ; c < 4 ; c++){
                max_sum = Math.max(max_sum, slide(arr, r, c));
            }
        }

        return max_sum;
    }

    static int slide(int[][] arr, int x, int y){
        return arr[x][y] + arr[x][y+1] +arr[x][y+2]
        + arr[x+1][y+1]
        + arr[x+2][y] + arr[x+2][y+1] +arr[x+2][y+2];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the surfaceArea function below.
    static int surfaceArea(int[][] A, int H, int W) {
        int[] tr = { 0, 0, 1, -1};
        int[] tc = { 1, -1, 0, 0};

        int surface_num = H * W * 2;
        for(int i = 1 ; i < A.length-1 ; i++){
            for(int j = 1 ; j < A[0].length-1 ; j++){
                for(int k = 0 ; k < 4 ; k++){
                    if(A[i][j] > A[i+tr[k]][j+tc[k]]){
                        surface_num += A[i][j] - A[i+tr[k]][j+tc[k]];
                    }
                }
            }
        }

        return surface_num;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] HW = scanner.nextLine().split(" ");

        int H = Integer.parseInt(HW[0]);

        int W = Integer.parseInt(HW[1]);

        int[][] A = new int[H+2][W+2];

        for (int i = 1; i <= H; i++) {
            String[] ARowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 1; j <= W; j++) {
                int AItem = Integer.parseInt(ARowItems[j-1]);
                A[i][j] = AItem;
            }
        }

        int result = surfaceArea(A, H, W);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

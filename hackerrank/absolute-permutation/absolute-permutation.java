import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the absolutePermutation function below.
    static int[] absolutePermutation(int n, int k) {
        ArrayDeque<Integer> stock = new ArrayDeque<>();

        boolean[] check = new boolean[n+1];

        for(int i = 1 ; i <= n ; i++){
            int candi1 = i-k;
            int candi2 = i+k;

            if(candi1 > 0 && candi1 <= n && !check[candi1]){
                stock.addLast(candi1);
                check[candi1] = true;
            } else if(candi2 > 0 && candi2 <= n && !check[candi2]){
                stock.addLast(candi2);
                check[candi2] = true;
            } else {
                int[] ans = {-1};
                return ans;
            }
        }

        return stock.stream().mapToInt(Integer::intValue).toArray();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[] result = absolutePermutation(n, k);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

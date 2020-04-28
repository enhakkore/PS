import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the stones function below.

    static int[] stones(int n, int a, int b) {
        Set<Integer> ans = new TreeSet<>();

        for(int i = 0 ; i < n ; i++){
            int mid = a*i + b*(n-1-i);
            ans.add(mid);
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    // dfs로 하면 시간초과
    // static int[] stones(int n, int a, int b) {
    //     int[] diff = {a, b};
    //     Set<Integer> ans = new TreeSet<>();

    //     check(1, n, 0, diff, ans);

    //     return ans.stream().mapToInt(Integer::intValue).toArray();
    // }

    // static void check(int level, int n, int result, int[] diff, Set<Integer> ans){
    //     if(level == n){
    //         ans.add(result);
    //         return;
    //     }

    //     for(int d : diff){
    //         check(level+1, n, result+d, diff, ans);
    //     }
    // }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int a = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int b = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] result = stones(n, a, b);

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

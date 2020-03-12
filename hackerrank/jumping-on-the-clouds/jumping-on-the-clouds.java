import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int[] info = new int[c.length];
        boolean[] visited = new boolean[c.length];

        for(int current = 0 ; current < c.length ; current++){
            if(c[current] != 1)
                for(int j = 1; j <= 2 ; j++){
                    int next = current + j;
                    if(next < c.length && c[next] != 1){
                        if(!visited[next]){
                            info[next] = info[current] + 1;
                            visited[next] = true;
                        } else {
                            int tmp = info[current] + 1;
                            info[next] = info[next] < tmp ? info[next] : tmp;
                        }
                    }
                }
        }

        return info[c.length-1];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

// This code has a time-out on 6, 8, 9, 10, 11 test case.

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the maximumPerimeterTriangle function below.
    static int[] maximumPerimeterTriangle(int[] sticks) {
        List<int[]> stock = new ArrayList<>();

        int[] mid = new int[3];
        boolean[] visited = new boolean[sticks.length];
        for(int i = 0 ; i < sticks.length ; i++){
            visited[i] = true;
            dfs(0, mid, sticks, stock, visited);
            visited[i] = false;
        }

        if(stock.isEmpty()) return new int[1];

        Comparator<int[]> cc = (a, b) -> {
            long asum = Arrays.stream(a).sum();
            long bsum = Arrays.stream(b).sum();

            long val = asum-bsum;
            if(val == 0L){
                int val2 = a[2]-b[2];
                if(val2 == 0){
                    int val3 = a[1]-b[1];
                    if(val2 == 0){
                        return a[0]-b[0];
                    }
                    return val3;
                }
                return val2;
            }
            return (int)val;
        };

        stock.sort(cc);

        return stock.get(stock.size()-1);
    }

    static void dfs(int level, int[] mid, int[] sticks, List<int[]> stock, boolean[] visited){
        if(level == 3){
            if(check(mid)){
                int[] sub = Arrays.copyOf(mid, 3);
                sub = Arrays.stream(sub).sorted().toArray();
                stock.add(sub);
            }

            return;
        }

        for(int i = 0 ; i < sticks.length ; i++){
            if(!visited[i]){
                visited[i] = true;
                mid[level] = sticks[i];
                dfs(level+1, mid, sticks, stock, visited);
                visited[i] = false;
            }
        }
    }

    static boolean check(int[] arr){
        boolean result = false;

        if( arr[0] + arr[1] > arr[2]){
            if(arr[0] + arr[2] > arr[1]){
                if(arr[1] + arr[2] > arr[0])
                    result = true;
            }
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] sticks = new int[n];

        String[] sticksItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int sticksItem = Integer.parseInt(sticksItems[i]);
            sticks[i] = sticksItem;
        }

        int[] result = maximumPerimeterTriangle(sticks);
        if(result.length == 1)
            bufferedWriter.write("-1");
        else
            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

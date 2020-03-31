// this code invoked time out at all of test case excepting basic test case.

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countInversions function below.
    static long countInversions(int[] arr) {

        long ans = 0L;
        List<Integer> sorted = new ArrayList<>();
        sorted.add(arr[0]);
        for(int cur = 1 ; cur < arr.length ; cur++){
            if(sorted.get(cur-1) > arr[cur]){
                int index = Collections.binarySearch(sorted, arr[cur]) + 1;

                index = index >= 0 ? index : Math.abs(index);
                ans += sorted.size() - index;

                sorted.add(arr[cur]);
                Collections.sort(sorted);
            } else {
                sorted.add(arr[cur]);
            }
        }

        return ans;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            long result = countInversions(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

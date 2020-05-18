// This code has a time out on test case 7, 11, 12, 13.

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the insertionSort function below.
    static long insertionSort(int[] arr) {
        long count = 0L;

        for(int i = 1 ; i < arr.length ; i++){
            if(arr[i] < arr[i-1]){
                int target = arr[i];
                int p = findPosition(arr, 0, i-1, target);
                for(int k = i ; k > p ; k--){
                    arr[k] = arr[k-1];
                }
                arr[p] = target;
                count += i - p;
            }
        }

        return count;
    }

    static int findPosition(int[] arr, int left, int right, int target){
        while(left < right){
            int mid = left + (right - left)/2;
            if(arr[mid] > target) right = mid;
            else if(arr[mid] <= target) left = mid+1;
        }

        return left;
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

            long result = insertionSort(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

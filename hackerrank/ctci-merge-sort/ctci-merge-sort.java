import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int[] sorted;
    static long count;

    // Complete the countInversions function below.
    static long countInversions(int[] arr) {
        mergeSort(arr, 0, arr.length-1);
        return count;
    }

    static void mergeSort(int[] arr, int left, int right){
        if(left<right){
            int mid = (left+right)/2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right){
        int i = left, j = mid+1, k=left;

        while(i <= mid && j <= right){
            if(arr[i] <= arr[j]){
                sorted[k++] = arr[i++];
                if(i-k > 0) count += i-k;
            } else {
                sorted[k++] = arr[j++];
                if(j-k > 0) count += j-k;
            }
        }

        if(i > mid){
            while(j <= right)
                sorted[k++] = arr[j++];
        } else {
            while(i <= mid)
                sorted[k++] = arr[i++];
        }

        for(i = left ; i <= right ; i++){
            arr[i] = sorted[i];
        }
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
            sorted = new int[n];
            count = 0L;

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

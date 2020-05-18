import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static long count;

    // Complete the insertionSort function below.
    static long insertionSort(int[] arr) {
        count = 0L;
        mergeSort(arr, 0, arr.length-1);
        return count;
    }

    static void mergeSort(int[] arr, int left, int right){
        if(left < right){
            int mid = left + (right - left)/2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid+1, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right){
        int[] temp = new int[right-left+1];
        int i = left, j = mid, k = 0;

        while( i < mid && j <= right){
            if(arr[i] <= arr[j]) {
                if(i-(k+left) > 0) count += i-(k+left);
                temp[k++] = arr[i++];
            }
            else {
                if(j-(k+left) > 0) count += j-(k+left);
                temp[k++] = arr[j++];
            }
        }

        if(i < mid){
            while(i < mid)
                temp[k++] = arr[i++];
        } else {
            while(j <= right)
                temp[k++] = arr[j++];
        }

        for( int c = 0 ; c < k ; c++){
            arr[left+c] = temp[c];
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

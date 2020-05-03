import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.*;

public class Solution {

    // Complete the insertionSort1 function below.
    static void insertionSort1(int n, int[] arr) {
        int stand = arr[arr.length-1];

        boolean flag = false;
        int i;
        for(i = arr.length-1; i > 0 ; i--){
            if(arr[i-1] < stand){
               arr[i] = stand;
               flag = true;
            } else {
                arr[i] = arr[i-1];
            }

            print(arr);

            if(i == 1 && !flag){
                arr[0] = stand;
                print(arr);
            }

            if(flag) break;
        }

        return;
    }

    static void print(int[] arr){
        String mid = Arrays.stream(arr).mapToObj(Integer::toString).collect(Collectors.joining(" "));
        System.out.println(mid);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        insertionSort1(n, arr);

        scanner.close();
    }
}

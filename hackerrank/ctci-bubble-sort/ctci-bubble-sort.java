import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countSwaps function below.
    static void countSwaps(int[] a) throws IOException {
        int count = 0;
        for(int i = 0 ; i < a.length ; i++){
            for(int j = 0 ; j < a.length-1 ; j++){
                if(a[j] > a[j+1]){
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    count++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Array is sorted in ");
        sb.append(count);
        sb.append(" swaps.\n");
        sb.append("First Element: ");
        sb.append(a[0]);
        sb.append("\n");
        sb.append("Last Element: ");
        sb.append(a[a.length-1]);
        sb.append("\n");

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        countSwaps(a);

        scanner.close();
    }
}

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        int count = 0;
        int[] freq = new int[201];

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i = 0 ; i < d ; i++){
            queue.offer(expenditure[i]);
            freq[expenditure[i]]++;
        }

        for(int cur = d ; cur < expenditure.length ; cur++ ){
            double m = median(freq, d);
            if(expenditure[cur] >= 2.0 * m) count++;

            freq[queue.poll()]--;
            queue.offer(expenditure[cur]);
            freq[expenditure[cur]]++;
        }

        return count;

    }

    static double median(int[] freq, int d){
       int count = 0;
       int median = 0;
       if(d % 2 == 0){
           int first = -1, second = -1;
           for(int i = 0 ; i < freq.length ; i++){
               for(int j = 1; j <= freq[i] ; j++){
                   count += 1;
                   if(count == d/2) first = i;
                   if(count > d/2) second = i;
                   if(first != -1 && second != -1){
                       return (first + second)/2.0;
                   }
               }
           }
       } else{
            for(int i = 0; i < freq.length ; i++){
                count += freq[i];

                if(count > d/2){
                    median = i;
                    break;
                }
            }
        }

       return median;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

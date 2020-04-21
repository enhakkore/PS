import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the acmTeam function below.
    static int[] acmTeam(String[] topic) {
        int[][] stock = Arrays.stream(topic).map( s -> s.chars().map( c -> c-'0').toArray()).toArray(int[][]::new);

        int[] info = new int[501];

        for(int i = 0 ; i < topic.length-1 ; i++){
            for(int j = i+1 ; j < topic.length ; j++){
                int[] temp = new int[topic[i].length()];

                for(int k = 0; k < topic[i].length() ; k++){
                    temp[k] = stock[i][k] | stock[j][k];
                }

                int count = (int)Arrays.stream(temp).filter( n -> n == 1).count();
                info[count]++;
            }
        }

        int[] ans = new int[2];
        for(int i = 500 ; i > 0 ; i--){
            if(info[i] != 0){
                ans[0] = i;
                ans[1] = info[i];
                break;
            }
        }

        return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        int[] result = acmTeam(topic);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    static int birthday(List<Integer> s, int d, int m){
        ArrayDeque<Integer> stock = new ArrayDeque<>();

        int ans = 0;
        int mid_sum = 0;
        for(int i = 0 ; i < m-1 ; i++){
            mid_sum += s.get(i);
            stock.offer(s.get(i));
        }

        for(int i = m-1 ; i < s.size() ; i++){
            mid_sum += s.get(i);
            stock.offer(s.get(i));
            if(mid_sum == d) ans++;
            int temp = stock.poll();
            mid_sum -= temp;
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        String[] dm = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(dm[0]);

        int m = Integer.parseInt(dm[1]);

        int result = birthday(s, d, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

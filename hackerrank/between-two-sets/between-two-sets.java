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

class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int lcmOfA = lcm(a); // a의 최소공배수
        int gcdOfB = gcd(b); // b의 최대공약수
        int ans = 0;
        for(int i = lcmOfA, j = 2 ; i <= gcdOfB ; i = lcmOfA * j, j++){
            if(gcdOfB % i == 0) ans++;
        }

        return ans;
    }

    private static int gcd(int a, int b){
        while(b > 0){
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    private static int gcd(List<Integer> a){
        int result = a.get(0);
        for(int i = 1; i < a.size() ; i++){
            result = gcd(result, a.get(i));
        }

        return result;
    }

    private static int lcm(int a, int b){
        return a * (b / gcd(a, b));
    }

    private static int lcm(List<Integer> b){
        int result = b.get(0);
        for(int i = 1 ; i < b.size() ; i++){
            result = lcm(result, b.get(i));
        }

        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

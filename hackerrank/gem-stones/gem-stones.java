import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.*;

public class Solution {

    // Complete the gemstones function below.
    static int gemstones(String[] arr) {
        Optional<String> res = Arrays.stream(arr).map(s -> s.chars().distinct().mapToObj(n -> Character.toString((char)n)).collect(Collectors.joining())).reduce((s1, s2) -> {
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < s1.length() ; i++){
                char base = s1.charAt(i);
                for(int j = 0 ; j < s2.length(); j++){
                    if(base == s2.charAt(j)){
                        sb.append(base);
                        break;
                    }
                }
            }

            return sb.toString();
        });

        return res.get().length();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            String arrItem = scanner.nextLine();
            arr[i] = arrItem;
        }

        int result = gemstones(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

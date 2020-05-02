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

    // Complete the superReducedString function below.
    static String superReducedString(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()){
            if(stack.isEmpty()){
                stack.push(c);
            } else {
                char tmp = stack.peek();
                if(tmp == c){
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        if(stack.isEmpty())
            return "Empty String";

        List<Character> ans = stack.stream().collect(Collectors.toList());
        Collections.reverse(ans);
        return ans.stream()
            .map( c -> c.toString())
            .collect(Collectors.joining());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

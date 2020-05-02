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

    // Complete the alternate function below.
    static int alternate(String s) {
        List<Integer> consist = s.chars().distinct().mapToObj(Integer::valueOf).collect(Collectors.toList());

        if(consist.size() == 1) {
            return 0;
        }

        List<List<Integer>> combi = new ArrayList<>();
        for(int i = 0 ; i < consist.size() - 1 ; i++){
            Deque<Integer> combi_res = new ArrayDeque<>();
            createCombi(consist, i, 2, combi_res, combi);
        }

        TreeSet<Integer> ans = new TreeSet<>();
        IntStream.range(0, combi.size()).forEach( i -> {
            List<Integer> com = combi.get(i);

            String result = s.chars().filter(n -> {
                return com.contains(n);
            })
            .mapToObj(n3 -> Character.toString((char)n3))
            .collect(Collectors.joining());

            if(check(result)){
                ans.add(result.length());
            }
        });

        if(ans.isEmpty()) return 0;
        return ans.last();
    }

    static boolean check(String result){
        boolean veri = true;
        char[] arr = result.toCharArray();
        int stand = arr[0];
        for(int i = 1 ; i < arr.length ; i++){
            if(stand == arr[i]){
                veri = false;
                break;
            }

            stand = arr[i];
        }

        return veri;
    }

    static void createCombi(List<Integer> consist, int start, int N, Deque<Integer> temp, List<List<Integer>> combi){

        temp.push(consist.get(start));

        if(temp.size() == 2){
            List<Integer> res = temp.stream().collect(Collectors.toList());
            combi.add(res);
            return;
        }

        for(int i = start+1 ; i < consist.size(); i++){
            createCombi(consist, i, N, temp, combi);
            temp.pop();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

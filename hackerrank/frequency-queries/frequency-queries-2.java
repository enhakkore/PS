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

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        HashMap<Integer, Integer> stock = new HashMap<>();
        HashMap<Integer, Integer> freq = new HashMap<>();
        List<Integer> ans = new LinkedList<>();

        for(List<Integer> query : queries){
            int op = query.get(0);
            int val = query.get(1);
            switch(op){
                case 1 :
                /*
                어떤 수 a가 추가 되면 a의 빈도수 f는 f+1이 된다.
                따라서 f의 value는 value-1, f+1의 value는 value+1 된다.
                */
                    int count = stock.getOrDefault(val, 0);
                    int new_count = count+1;
                    stock.put(val, new_count);

                    freq.put(new_count, freq.getOrDefault(new_count, 0)+1);
                    freq.put(count, freq.getOrDefault(count, 1)-1);

                    break;
                case 2:
                /*
                어떤 수 a가 제거되면, a의 빈도수 f는 f-1이 된다.
                따라서 f의 value는 value-1, f-1의 value는 value+1 된다.
                */
                    count = stock.getOrDefault(val, 0);
                    if(count > 0){
                        new_count = count-1;
                        stock.put(val, new_count);

                        freq.put(count, freq.getOrDefault(count, 1)-1);
                        freq.put(new_count, freq.getOrDefault(new_count, 0)+1);
                    }

                    break;
                case 3:
                    int freq_val = freq.getOrDefault(val, 0);
                    if(freq_val > 0) ans.add(1);
                    else ans.add(0);
                    break;
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
            ans.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

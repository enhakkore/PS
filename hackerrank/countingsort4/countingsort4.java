// This Solution has a time out on test case 5.

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import java.util.Comparator.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the countSort function below.
    static void countSort(List<List<String>> arr) throws IOException {
        // Collections.sort(arr, (e1, e2) -> e1.get(0).compareTo(e2.get(0)));
        // arr.sort(Comparator.comparing(e -> e.get(0)));

        int half = arr.size()/2;
        // List[] stock = new List[Integer.parseInt(arr.get(arr.size()-1).get(0))];
        TreeMap<Integer, List<String>> stock = new TreeMap<>();

        for(int i = 0 ; i < arr.size() ; i++){
            int idx = Integer.parseInt(arr.get(i).get(0));
            List<String> tmp = stock.getOrDefault(idx, new ArrayList<>());
            if(i < half){
                tmp.add("-");
            } else {
                String e = arr.get(i).get(1);
                tmp.add(e);
            }
            stock.put(idx, tmp);
        }

        String res = stock.keySet().stream()
                        .map( list -> stock.get(list).stream().collect(joining(" ")))
                        .collect(joining(" "));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(res);
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        countSort(arr);

        bufferedReader.close();
    }
}

/*
* following code invoked "Terminated due to timeout" on test case 11 only.
*/

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
    static StringBuilder freqQuery(List<int[]> queries) {
        StringBuilder willBePrinted = new StringBuilder();
        HashMap<Integer, Integer> stock = new HashMap<>();

        for(int[] each_querie : queries){
            switch(each_querie[0]){
                case 1 :
                    stock.put(each_querie[1], stock.getOrDefault(each_querie[1], 0)+1);
                    break;

                case 2 :
                    if(stock.containsKey(each_querie[1])){
                        int value = stock.get(each_querie[1]);
                        if(--value > 0 ) stock.put(each_querie[1], value);
                        else stock.remove(each_querie[1]);
                    }
                    break;

                case 3 :
                    int v = stock.containsValue(each_querie[1]) ? 1 : 0;
                    willBePrinted.append(v);
                    willBePrinted.append("\n");
                    break;
            }
        }

        return willBePrinted;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int q = Integer.parseInt(bufferedReader.readLine().trim());

            List<int[]> queries = new LinkedList<>();
            while(q-- > 0){
                String[] tmp = bufferedReader.readLine().trim().split(" ");
                int[] tmp2 = new int[2];
                tmp2[0] = Integer.parseInt(tmp[0]);
                tmp2[1] = Integer.parseInt(tmp[1]);
                queries.add(tmp2);
            }

            StringBuilder ans = freqQuery(queries);
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {
                bufferedWriter.write(ans.toString());
            }
        }
    }
}

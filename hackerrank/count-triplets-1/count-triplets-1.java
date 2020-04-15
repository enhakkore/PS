// This code fail on Test case 3 and has a time out on Test case 10.

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

    static long countTriplets(List<Long> arr, long r){
        HashMap<Long, List<Integer>> stock = new HashMap<>();

        for(int i = 0 ; i < arr.size() ; i++){
            if(stock.containsKey(arr.get(i))){
                stock.get(arr.get(i)).add(i);
            } else {
                stock.put(arr.get(i), new ArrayList<>(Arrays.asList(i)));
            }
        }

        long ans = 0L;

        if(r == 1L){
            arr = arr.stream().distinct().collect(Collectors.toList());
            for(Long e : arr){
                int val = stock.getOrDefault(e, new ArrayList<>()).size();
                if(val >= 3){
                    for(int i = 2 ; i < val ; i++){
                        int mid = (i-1)*(val-i);
                        ans += mid;
                    }
                }
            }
        } else {
            for(int i = 0 ; i < arr.size() ; i++){
                long base = arr.get(i);
                long base2 = base*r;
                long base3 = base2*r;

                if(stock.containsKey(base2) && stock.containsKey(base3)){
                    List<Integer> temp2 = stock.get(base2);
                    List<Integer> temp3 = stock.get(base3);

                    int k = 0;
                    for(int j = 0 ; j < temp2.size() ; j++){
                        if(temp2.get(j) > i){
                            for( ; k < temp3.size() ; k++){
                                if(temp3.get(k) > temp2.get(j)){
                                    ans += temp3.size()-k;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

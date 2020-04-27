import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.*;

public class Solution {

    // Complete the flatlandSpaceStations function below.
    static int flatlandSpaceStations(int n, List<Integer> c) {
        Collections.sort(c);
        TreeSet<Integer> stock = new TreeSet<>();
        stock.add(c.get(0));
        for(int i = 0 ; i < c.size() ; i++){
            int j = i+1;

            if(j >= c.size()){
                if(j == 1){
                    int max = Math.max(c.get(i), n-1-c.get(i));
                    stock.add(max);
                } else{
                    stock.add(n-1-c.get(i));
                }
            }else {
                int mid = (c.get(j) - c.get(i))/2;
                stock.add(mid);
            }
        }

        return stock.last();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        List<Integer> c = new ArrayList<>();

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c.add(cItem);
        }

        int result = flatlandSpaceStations(n, c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

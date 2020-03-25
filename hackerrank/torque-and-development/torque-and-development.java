import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.regex.*;

public class Solution {

    // Complete the roadsAndLibraries function below.
    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
        if(c_lib <= c_road) return (long)n*(long)c_lib;

        HashMap<Integer, ArrayList<Integer>> info = new HashMap<>();
        for(int i = 1 ; i <= n ; i++){
            ArrayList<Integer> list = new ArrayList<>();
            info.put(i, list);
        }

        for(int[] tmp : cities){
            info.get(tmp[0]).add(tmp[1]);
            info.get(tmp[1]).add(tmp[0]);
        }

        boolean[] visited = new boolean[n+1];

        ArrayList<Long> num_cities = new ArrayList<>();

        for(int i = 1 ; i <= n ; i++){
            if(visited[i] == false){
                AtomicInteger num = new AtomicInteger();
                dfs(i, info, visited, num);
                num_cities.add(num.longValue());
            }
        }

        long total = 0L;
        for(long tmp : num_cities){
            total += (tmp-1)*c_road;
        }
        total += num_cities.size()*(long)c_lib;

        return total;
    }

    static void dfs(int city, HashMap<Integer, ArrayList<Integer>> info, boolean[] visited, AtomicInteger num){
        if(visited[city]) return;

        visited[city] = true;
        num.incrementAndGet();

        for(int next : info.get(city)){
            dfs(next, info, visited, num);
        }

        return;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nmC_libC_road = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmC_libC_road[0]);

            int m = Integer.parseInt(nmC_libC_road[1]);

            int c_lib = Integer.parseInt(nmC_libC_road[2]);

            int c_road = Integer.parseInt(nmC_libC_road[3]);

            int[][] cities = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] citiesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int citiesItem = Integer.parseInt(citiesRowItems[j]);
                    cities[i][j] = citiesItem;
                }
            }

            long result = roadsAndLibraries(n, c_lib, c_road, cities);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

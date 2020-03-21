import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the swapNodes function below.
     */
    static int[][] swapNodes(int[][] indexes, int[] queries) {
        /*
         * Write your code here.
         */

        int[][] ans = new int[queries.length][indexes.length];

        int i = 0;
        for(int querie : queries){

            swap(0, indexes, querie, 1);

            boolean[][] visited = new boolean[indexes.length][2];
            ArrayList<Integer> path = new ArrayList<>();

            walk(0, indexes, path);

            ans[i++] = path.stream().mapToInt(Integer::intValue).toArray();
        }

        return ans;
    }

    static void swap(int node, int[][] indexes, int querie, int cur_depth){
        if(cur_depth % querie == 0){
            int tmp = indexes[node][0];
            indexes[node][0] = indexes[node][1];
            indexes[node][1] = tmp;
        }

        if(indexes[node][0] != -1) swap(indexes[node][0]-1, indexes, querie, cur_depth+1);
        if(indexes[node][1] != -1) swap(indexes[node][1]-1, indexes, querie, cur_depth+1);
    }

    static void walk(int node, int[][] indexes, ArrayList<Integer> path){
        if(indexes[node][0] != -1){
            walk(indexes[node][0]-1, indexes, path);
        }

        path.add(node+1);

        if(indexes[node][1] != -1){
            walk(indexes[node][1]-1, indexes, path);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        int[][] result = swapNodes(indexes, queries);

        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));

                if (resultColumnItr != result[resultRowItr].length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (resultRowItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}

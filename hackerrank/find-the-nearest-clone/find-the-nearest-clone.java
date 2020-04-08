// This code has a time out to 10 test case.

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the findShortest function below.

    /*
     * For the unweighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] to <name>To[i].
     *
     */
    static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {
        // solve here
        // 주어진 색깔 노드에서 시작해서, 자신과 같은 색깔을 만나는 가장 짧은 길이를 찾아라.

        HashMap<Integer, List<Integer>> info = new HashMap<>();
        for(int i = 1; i <= graphNodes ; i++){
            info.put(i, new ArrayList<>());
        }

        for(int i = 0 ; i < graphFrom.length ; i++){
            info.get(graphFrom[i]).add(graphTo[i]);
            info.get(graphTo[i]).add(graphFrom[i]);
        }

        boolean[] visited = new boolean[graphNodes+1];
        TreeSet<Integer> ans = new TreeSet<>();

        for(int cur = 1 ; cur <= graphNodes ; cur++){
            if(ids[cur] == val) {
                visited[cur] = true;
                check(info, cur, 0, val, ids, visited, ans);
                visited[cur] = false;
            }
        }

        if(ans.isEmpty()) return -1;
        return ans.first();
    }

    static void check(Map<Integer, List<Integer>> info, int cur_node, int path_len, int target_color, long[] ids, boolean[] visited, TreeSet<Integer> ans){
        if(path_len != 0 && ids[cur_node] == target_color){
            ans.add(path_len);
            return;
        }

        for(int go : info.get(cur_node)){
            if(!visited[go]){
                visited[go] = true;
                check(info, go, path_len+1, target_color, ids, visited, ans);
                visited[go] = false;
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] graphNodesEdges = scanner.nextLine().split(" ");
        int graphNodes = Integer.parseInt(graphNodesEdges[0].trim());
        int graphEdges = Integer.parseInt(graphNodesEdges[1].trim());

        int[] graphFrom = new int[graphEdges];
        int[] graphTo = new int[graphEdges];

        for (int i = 0; i < graphEdges; i++) {
            String[] graphFromTo = scanner.nextLine().split(" ");
            graphFrom[i] = Integer.parseInt(graphFromTo[0].trim());
            graphTo[i] = Integer.parseInt(graphFromTo[1].trim());
        }

        long[] ids = new long[graphNodes+1];

        String[] idsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 1; i <= graphNodes; i++) {
            long idsItem = Long.parseLong(idsItems[i-1]);
            ids[i] = idsItem;
        }

        int val = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int ans = findShortest(graphNodes, graphFrom, graphTo, ids, val);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

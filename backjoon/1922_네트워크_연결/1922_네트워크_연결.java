import java.io.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Main {

    static class Edge {
        int[] nodes = new int[2];
        int c;

        public Edge(int n1, int n2, int c){
            nodes[0] = n1;
            nodes[1] = n2;
            this.c = c;
        }
    }

    public static int getParent(int[] cycle, int a){
        if(cycle[a] == a) return a;
        else return cycle[a] = getParent(cycle, cycle[a]);
    }

    public static void unionParent(int[] cycle, int a, int b){
        int a1 = getParent(cycle, a);
        int b1 = getParent(cycle, b);
        if(a1 >= b1) cycle[a1] = b1;
        else cycle[b1] = a1;
    }

    public static boolean findParent(int[] cycle, int a, int b){
        return getParent(cycle, a) == getParent(cycle, b) ? true : false;
    }

    public static void main(String... args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<Edge> info = new LinkedList<>();
        while(m-- > 0){
            String[] line = br.readLine().split(" ");
            int n1 = Integer.parseInt(line[0]);
            int n2 = Integer.parseInt(line[1]);
            int c = Integer.parseInt(line[2]);

            Edge e = new Edge(n1, n2, c);
            info.add(e);
        }

        info.sort(Comparator.comparingInt(a -> a.c));

        int[] cycle = new int[n+1];
        for(int i = 1 ; i <= n ; i++) cycle[i] = i;

        long cost = 0L;
        for(Edge cur : info){
            if(!findParent(cycle, cur.nodes[0], cur.nodes[1])){
                unionParent(cycle, cur.nodes[0], cur.nodes[1]);
                cost += cur.c;
            }
        }

        bw.write(String.valueOf(cost));
        bw.flush();

        bw.close();
        br.close();
    }
}

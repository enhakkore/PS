import java.io.*;

public class Main {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] store = new int[n+1];
        int result = cal(store, n);

        bw.write(String.valueOf(result));
        bw.flush();

        bw.close();
        br.close();
    }

    public static int cal(int[] store, int n){
        if(n == 0) return 1;
        if(n == 1) return 0;
        if(n == 2) return 3;
        if(store[n] != 0) return store[n];

        int result = 3 * cal(store, n-2);
        for(int i = 3 ; i <= n ; i++){
            if( i % 2 == 0)
                result += 2 * cal(store, n-i);
        }

        return store[n] = result;
    }
}

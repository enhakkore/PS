import java.util.*;
import java.io.*;

public class Main{

    public static class Trie{
        public boolean isDone;
        public Map<Character, Trie> stock;
        
        public Trie() {
            stock = new HashMap<>();
            isDone = false;
        }
    }

    public static boolean check(String[] numbers){
        boolean result = false;
        Trie root = new Trie();

        for(String number : numbers){
            Trie trie = root;
            for(char c : number.toCharArray()){
                trie = trie.stock.computeIfAbsent(c, C -> new Trie());
                if(trie.isDone) return false;
            }
            trie.isDone = true;
        }

        return true;
    }

    public static void main(String... args) {
        int T, t;
        String[] phoneNumbers;
        String[] ans;

        try(
           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ){
            T = Integer.parseInt(br.readLine());
            ans = new String[T];
            int limit = 0;
            while(limit != T){
                t = Integer.parseInt(br.readLine());
                phoneNumbers = new String[t];
                while(t-- > 0){
                    phoneNumbers[t] = br.readLine();
                }

                Arrays.sort(phoneNumbers, (s1, s2) -> s1.length()-s2.length());
                boolean result = check(phoneNumbers);
                ans[limit++] = result ? "YES" : "NO";
            }

            bw.write(String.join("\n", ans));
            bw.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

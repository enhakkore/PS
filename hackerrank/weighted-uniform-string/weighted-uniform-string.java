import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the weightedUniformStrings function below.
    static String[] weightedUniformStrings(String s, int[] queries) {
        List<String> ans = new ArrayList<>();
        Set<Integer> U = new HashSet<>();

        char[] sArr = s.toCharArray();
        char base = ' ';
        int val = 0;
        for(int i = 0, j = 0; i < s.length() ; i++){
            if(sArr[i] != base){
                base = sArr[i];
                val = base-'a'+1;
                U.add(val);
                j = 1;
            } else {
                j++;
                U.add(val*j);
            }
        }

        for(int query : queries){
            if(U.contains(query))
                ans.add("Yes");
            else ans.add("No");
        }

        return ans.stream().toArray(String[]::new);
    }

    // 아래 메서드는 문제를 제대로 안봐서 시도하게된 방법.
    // 문제에서 정의한 uniform string은 주어진 s에 속한 어떤 문자 c가 한 개 이상 연속으로 이어진 문자열이고 s의 substring인 문자열을 말한다.
    static String[] weightedUniformStrings2(String s, int[] queries) {
        List<String> ans = new ArrayList<>();
        HashMap<Integer, Integer> info = new HashMap<>();

        s.chars().forEach( c -> {
            int key = c-'a'+1;
            info.put(key, info.getOrDefault(key, 0)+1 );
        });

        Set<Integer> keyInfo = info.keySet();

        for( int query : queries) {
            boolean flag = true;
            for(int key : keyInfo){
                int value = info.get(key);
                if((query == key || query == value*key ) || (query % key == 0 && query <= value*key)){
                    ans.add("Yes");
                    flag = false;
                    break;
                }
            }

            if(flag) ans.add("No");
        }

        return ans.stream().toArray(String[]::new);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] queries = new int[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        String[] result = weightedUniformStrings(s, queries);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the bigSorting function below.
    static String[] bigSorting(String[] unsorted) {

        Arrays.sort(unsorted, (s1, s2) -> {
            int len1 = s1.length();
            int len2 = s2.length();

            if(len1 == len2){
                int i = 0;
                while(i < len1){
                    char n1 = s1.charAt(i);
                    char n2 = s2.charAt(i);

                    if(n1 != n2)
                        return n1 - n2;

                    i++;
                }
            }

            return len1-len2;
        });

        return unsorted;
    }

    //방법2. mergeSort를 이용한 풀이(test case 6만 시간초과가 나서 mergeSort로 풀었는데, 그래도 시간초과가 났다. 알고보니 빠른 입력으로 바꾸면 해결되는 문제였다.)
    // static String[] bigSorting(String[] unsorted) {
    //     mergeSort(unsorted, 0, unsorted.length-1);

    //     return unsorted;
    // }

    // static int customCompare(String s1, String s2){
    //     int len1 = s1.length();
    //     int len2 = s2.length();

    //     if(len1 == len2){
    //         int i = 0;
    //         while(i < len1){
    //             char n1 = s1.charAt(i);
    //             char n2 = s2.charAt(i);

    //             if(n1 != n2)
    //                 return n1 - n2;

    //             i++;
    //         }
    //     }

    //     return len1-len2;
    // }

    // static void mergeSort(String[] target, int left, int right){
    //     if(left < right){
    //         int mid = left+(right-left)/2;
    //         mergeSort(target, left, mid);
    //         mergeSort(target, mid+1, right);
    //         coreSort(target, left, mid, right);
    //     }
    // }

    // static void coreSort(String[] target, int left, int mid, int right){
    //     String[] temp = new String[right-left+1];

    //     int p = 0, i = left, j = mid+1;
    //     while(i <= mid && j <= right){

    //         int res = customCompare(target[i], target[j]);
    //         if(res >= 0){
    //             temp[p++] = target[j++];
    //         } else {
    //             temp[p++] = target[i++];
    //         }
    //     }

    //     if(i <= mid){
    //         while(i <= mid){
    //             temp[p++] = target[i++];
    //         }
    //     } else {
    //         while( j <= right){
    //             temp[p++] = target[j++];
    //         }
    //     }

    //     for(int k = left ; k <= right ; k++){
    //         target[k] = temp[k-left];
    //     }
    // }

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(br.readLine());

        String[] unsorted = new String[n];

        for (int i = 0; i < n; i++) {
            unsorted[i] = br.readLine();
        }

        String[] result = bigSorting(unsorted);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
        br.close();
    }
}

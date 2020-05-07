import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    /*
    pivot 요소인 p를 선택합니다. 그리고 정렬되어있지 않은 배열 arr을 크기가 더 작은 left, right, equal로 분할합니다.
    p보다 작은 요소들은 left로, p보다 큰 요소들은 right로, p와 같은 요소들은 equal로 분할합니다.
    예를들어 {5,7,4,3,8}로 구성된 배열 arr이 있다고 하자.
    index = 0 에 있는 5를 pivot 요소로 선택합니다.
    위에서 제시한 분할방법에 따라 left={4,3}, equal={5}, right={7, 8}로 분할합니다.
    left, equal, right를 합쳐서 {4,3,5,7,8}을 얻습니다. 다른 유효한 조합으로 {3,4,5,8,7}도 가능합니다.

    배열 arr이 주어지고 arr[0]를 pivot 요소로 했을 때, 위의 Divide instructions을 이용해 arr을 left, right 그리고 equal로 분할합니다. 그리고나서 한 줄로 left, equal 그리고 right 순으로 각 요소를 출력합니다. 각 요소는 space로 분리되어있어야 하고 세 개의 카테고리 안에 요소들은 순서를 유지하지 말아야합니다.
    */

    // Complete the quickSort function below.
    static int[] quickSort(int[] arr) {
        List<Integer> left = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        final int p = arr[0];
        Arrays.stream(arr).forEach( n -> {
            if(p > n){
                left.add(n);
            } else if(p < n){
                right.add(n);
            } else {
                equal.add(n);
            }
        });

        left.addAll(equal);
        left.addAll(right);

        return left.stream().mapToInt(Integer::intValue).toArray();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = quickSort(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

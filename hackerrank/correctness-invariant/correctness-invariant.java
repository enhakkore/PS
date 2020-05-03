import java.io.*;
import java.util.*;

/*

1. initialization
    subArr는 주어진 배열의 첫 번째 요소로 시작하며, 요소가 하나일 때는 명백히 정렬된 상태이다.

2. Maintenance
    루프를 반복할 때마다 subArr는 "정렬되어있다"는 특성을 유지한채로 크기를 늘려간다.
    어떤 요소 V의 왼쪽 요소보다 V가 클때 V는 subArr에 삽입된다.
    왼쪽 요소는 이미 정렬되어있기때문에, V는 V의 왼쪽에 있는 모든 요소들보다 크다.
    따라서 subArr는 정렬된 상태로 유지된다.

3. Termination
    루프의 i요소가 주어진 배열의 마지막 요소에 도달하면 루프는 끝나게 된다.
    이것은 정렬된 subArr가 주어진 배열 전체를 아우르면서 크기를 늘려왔다는 것을 의미한다.
    배열은 이제 완전히 정렬되었다.
*/

public class Solution {

    public static void insertionSort(int[] A){
        for(int i = 1; i < A.length; i++){
            int value = A[i];
            int j = i - 1;
            while(j >= 0 && A[j] > value){
                A[j + 1] = A[j];
                j = j - 1;
            }
            A[j + 1] = value;
        }

        printArray(A);
    }


    static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i]=in.nextInt();
        }
        insertionSort(ar);
    }
}

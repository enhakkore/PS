import java.util.*;

public class App
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = sc.nextInt();
        int[] x = new int[num];

        for( int i = 0 ; i < num ; i++) {
            System.out.print("x["+i+"] : ");
            x[i] = sc.nextInt();
        }

        Arrays.sort(x);

        System.out.print("검색할 값 : ");
        int key = sc.nextInt();

        int ans = Arrays.binarySearch(x, key);

        if(ans < 0) System.out.print("찾는 값이 없습니다.\n삽입포인트는 "+ans+"입니다.");
        else {
            System.out.print(key+"은(는) x["+ans+"]에 있습니다.");
        }
    }
}

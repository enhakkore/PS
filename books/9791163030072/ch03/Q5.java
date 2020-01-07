import java.util.*;

public class App
{
    static int binSearchX(int[] a, int n, int key) {
        int left = 0, right = n-1;
        int ans = -1;

        do {
            int center = (left + right) / 2;
            if( a[center] == key) {
                ans = center;
                break;
            } else if( a[center] > key ) {
                right = center - 1;
            } else if( a[center] < key) {
                left = center + 1;
            }
        }while( left <= right);

        if (ans != -1 ) {
            for(int i = ans - 1 ; i >= 0 ; i--){
                if( a[i] == key )
                    ans = i;
                else break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = sc.nextInt();
        int[] x = new int[num];

        for( int i = 0 ; i < num ; i++) {
            System.out.print("x["+i+"] : ");
            x[i] = sc.nextInt();
        }

        System.out.print("검색할 값 : ");
        int key = sc.nextInt();

        int ans = binSearchX(x, num, key);

        if(ans == -1) System.out.print("찾는 값이 없습니다.");
        else {
            System.out.print(key+"은(는) x["+ans+"]에서 먼저 발견되었습니다.");
        }
    }
}

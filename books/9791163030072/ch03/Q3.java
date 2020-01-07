import java.util.*;

public class App
{
    static int searchIdx(int[] a, int n, int key, int[] idx) {
        int count = 0;

        for(int i = 0; i < n ; i++){
            if(a[i] == key){
                idx[count++] = i;
            }
        }

        return count;
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

        int[] idx = new int[num];
        int count = searchIdx(x, num, key, idx);

        if(count == 0) System.out.print("찾는 값이 없습니다.");
        else {
            System.out.print(key+"은(는) ");
            for(int i = 0 ; i < count ; i++)
                System.out.print("x["+idx[i]+"] ");
            System.out.print("에 있습니다.");
        }
    }
}

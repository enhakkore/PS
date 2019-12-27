import java.util.Scanner;

public class App
{
    static void printAll(int[] a){
        for(int i = 0 ; i < a.length ; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    static void swap(int[] a, int index1, int index2) {
        int tmp = a[index1];
        a[index1] = a[index2];
        a[index2] = tmp;
    }

    static void reverse(int[] a) {
        for(int i = 0 ; i < a.length/2 ; i++){
            printAll(a);
            System.out.println(a[i]+"과 "+a[a.length-i-1]+"을 교환합니다.");
            swap(a, i, a.length - i - 1);
        }
    }

    public static void main( String[] args ) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요숏수 : ");
        int num = stdIn.nextInt();

        int[] x = new int[num];

        for ( int i = 0 ; i < num ; i++){
            System.out.print("x["+i+"] : ");
            x[i] = stdIn.nextInt();
        }

        reverse(x);

        System.out.println("요소를 역순으로 정렬했습니다.");
        for(int i = 0 ; i < num ; i++){
            System.out.println("x[" + i + "] : " + x[i]);
        }
    }
}

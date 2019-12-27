import java.util.Scanner;

public class App
{
    static void rcopy(int[] a, int[] b) {
        for(int i = 0 ; i < b.length ; i++){
            a[i] = b[b.length - i - 1];
        }
    }

    static void printAll(int[] x) {
        for(int i = 0 ; i < x.length ; i++){
            System.out.print(x[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = sc.nextInt();

        int[] b = new int[num];
        int[] a = new int[num];

        for(int i = 0 ; i < num ; i++){
            System.out.print("b["+i+"] : ");
            b[i] = sc.nextInt();
        }

        System.out.println("배열 b의 모든 요소를 배열 a에 역순으로 복사합니다.");
        rcopy(a, b);

        System.out.println("배열 a의 모든 요소를 출력합니다.");
        printAll(a);

    }
}

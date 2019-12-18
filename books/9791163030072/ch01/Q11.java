import java.util.Scanner;

public class App
{
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);

        System.out.print("양의 정수를 입력하세요 : ");
        int n = sc.nextInt();

        while( n <= 0){
            System.out.print("양의 정수를 입력하세요 : ");
            n = sc.nextInt();
        }

        int digits = 0;

        while( n > 0){
            digits++;
            n /= 10;
        }

        System.out.print("그 수는 "+digits+"자리입니다.");

    }
}

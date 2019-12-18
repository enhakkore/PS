import java.util.Scanner;

public class App
{
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        System.out.print("사각형을 출력합니다.\n단 수 : ");
        int n = sc.nextInt();

        for(int i = 1; i <= n ; i++){
            for(int j = 1; j <= n ; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}

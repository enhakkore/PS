import java.util.Random;

public class App
{
    static int maxOf(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length ; i++){
            if(max < a[i]) max = a[i];
        }

        return max;
    }

    public static void main( String[] args ) {
        Random rand = new Random();

        System.out.println("키의 최대값을 구합니다.");

        int num = 1 + rand.nextInt(20);
        int[] height = new int[num];

        System.out.print("사람의 수 : ");
        System.out.println("키 값은 아래와 같습니다.");
        for(int i = 0 ; i < num ; i++){
            height[i] = 100 + rand.nextInt(90);
            System.out.println("height["+i+"] : " + height[i]);
        }

        System.out.println("최댓값은 " + maxOf(height) + "입니다.");
    }
}

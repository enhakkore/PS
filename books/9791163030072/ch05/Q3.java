public class App
{
    static int gcd(int x, int y) {
        while(true){
            if(y == 0)
                return x;
            int tmp = y;
            y = x % y;
            x = tmp;
        }
    }

    static int gcdArray(int[] a) {
        if(a.length <= 1) return -1;

        int tmp = a[0];
        for(int i = 1; i < a.length ; i++){
            tmp = gcd(tmp, a[i]);
        }

        return tmp;
    }

    public static void main(String[] args) {

        int[] a = { 24, 120, 72};
        System.out.println(gcdArray(a));
    }
}

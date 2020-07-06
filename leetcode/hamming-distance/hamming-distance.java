class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x^y;
        int count = 0;

        do{
            if(xor % 2 == 1) count++;
            xor /= 2;
        }while(xor > 0);

        return count;
    }
}

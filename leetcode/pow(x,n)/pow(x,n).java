// 출처 : https://leetcode.com/problems/powx-n/discuss/739779/Java-5-liner-Recursion

class Solution {
    public double myPow(double x, int n) {
        if (n==Integer.MIN_VALUE) return x==1||x==-1 ? 1 : 0;
        if (n<0) return 1/myPow(x, -n);
        if (n==0) return 1;
        if (n%2==0) return myPow(x * x, n/2);
        return x * myPow(x, n - 1);
    }
}

/*
예를들어 pow(3, 4)를 생각해보자.
3을 4번 곱하는 것은 3x3을 2번 곱하는 것과 같다.

pow(a, b) 에서
b가 짝수일 경우, a가 있는 자리에서 연산이 이루어 지고
b가 홀수일 경우, pow(a, b-1)의 결과와 a를 곱해 연산을 한다.
*/

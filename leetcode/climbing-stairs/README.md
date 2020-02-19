### Climbing Stairs  
* [문제](https://leetcode.com/problems/climbing-stairs/)  
* 간단한 문제 설명  
    양의 정수 n이 주어질 때, 1과 2로 n을 만들 수 있는 경우의 수를 구하는 문제.  
* [내 코드](climbing-staris.java)  
* 내 코드 설명  
    처음에 풀었을 때 브루트 포스 접근으로 풀었는데 n이 별로 크지 않는데도 시간 초과가 났다....

    [출처](https://leetcode.com/problems/climbing-stairs/solution/)를 참고함.  
    * 첫 번째, 브루트 포스  
        재귀 호출을 사용해 0부터 시작해서 1과 2로 n을 만들면 1을 반환하는 방식.  
        ```java
        public class Solution{
            public int climbStairs(int n){
                return check(0, n);
            }

            public int check(int num, int n){
                if(num == n) return 1;
                if(num > n) return 0;

                return check(num + 1, n) + check(num + 2, n);
            }
        }
        ```  
    * 두 번째, 메모이제이션  
        첫 번째 방법을 살펴보면 중복 계산을 하는 것을 볼 수 있다. 첫 번째 로직을 보면 check 메서드의 num이 n이 될 때까지 check는 재귀호출된다. 예를 들어 n = 3 일때, num = 0은 한 번, num = 1은 한 번, num = 2은 두 번, num = 3은 세 번, num = 4은 네 번 호출된다. num = 4은 n보다 크기때문에 0을 반환하고 결과에 사용되지 않는다. 한 번의 check 호출은 두 번의 check를 호출하기 때문에 O(2^n)의 시간 복잡도가 걸린다. 따라서 check를 호출할 때 각 num에 대한 결과를 저장하고 어떤 num이 두 번 이상 호출될 때 저장된 결과를 사용하면 중복 계산을 피할 수 있다.  
        ```java
        public class Solution{
            public int climbStairs(int n){
                int[] memo = new int[n+1];
                return check(memo, 0, n);
            }

            public int check(int[] memo, int num, int n){
                if(num == n) return 1;
                if(num > n) return 0;

                if(memo[num] > 0) return memo[num];
                memo[num] = check(memo, num+1, n) + check(memo, num+2, n);
                return memo[num];
            }
        }
        ```  
    * 세 번째, 다이나믹  
        ```java
        public class Solution{
            public int climbStairs(int n){
                int[] dp = new int[n+2];

                dp[1] = 1;
                dp[2] = 2;
                if(n == 1 || n == 2) return dp[n];

                for(int i = 3; i <= n ; i++)
                    dp[i] = dp[i-1] + dp[i-2];

                return dp[n];
            }
        }
        ```  

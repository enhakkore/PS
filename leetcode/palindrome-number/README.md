### Palindrome Number  
* [문제](https://leetcode.com/problems/palindrome-number/)  
* 간단한 문제 설명   
    주어진 32비트 정수가 거꾸로 뒤집어도 같은 숫자인지 확인하는 문제.    
* [내 코드](palindrome-number.java)  
* 내 코드 설명  
    주어진 숫자가 음수이면 false를 반환한다. 예를들어 `-121`을 거꾸로하면 `121-`이고 같은 숫자가 아니다.  
    주어진 숫자를 거꾸로 만들면서 자리수를 확인한다. 주어진 정수와 거꾸로 만든 정수를 자리수의 1/2 길이까지만 서로 같은지 확인한다. 중간에 서로 같지 않은 숫자가 확인되면 false를 반환한다.  

    leetcode에서 제공된 솔루션은 반복문에서 주어진 정수를 10으로 나눠가며 새로운 정수로 거꾸로 만드는데, 새로운 정수가 주어진 정수와 같거나 커지면 반복문을 종료한다. 그리고 주어진 정수와 새로운 정수가 같은지 확인하는데, 주어진 정수의 원래 길이가 홀수이면 반복문을 종료한 뒤 새로운 정수의 길이가 주어진 정수보다 길이가 하나 더 길기 때문에 새로운 정수를 10으로 나눈 결과 주어진 정수가 같은지도 확인한다.  
    ```java
    public Soultion{
        public boolean isPalindrome(int x){
            if( x < 0 || ( x % 10 = 0 && x != 0)) return false;

            int reverse_x = 0;
            while( x > reverse_x){
                reverse_x = reverse_x * 10 + x % 10;
                x /= 10;
            }

            return x == reverse_x || x == reverse_x/10;
        }
    }
    ```  

### Convert a number to hexadecimal  
* [문제](https://leetcode.com/problems/convert-a-number-to-hexadecimal/)  
* 간단한 문제 설명  
    32bit로 표현할 수 있는 정수가 주어질 때, 주어진 정수를 16진수로 표현하는 문제. 라이브러리 사용 금지.  
* [내 코드](convert-a-number-to-hexadecimal.java)  
*  내 코드 설명  
    * 첫 번째  
        10진수를 16진수로 표현하는 일반적인 로직은 다음과 같다.  
        ```bash
        1. 10진수를 2진수로 표현한다.  
        2. 2진수의 각 4비트의 값을 16진수에 해당하는 기호로 표현한다.
        3. 만약 주어진 수가 음수라면 주어진 정수를 양수로 바꾸고 위의 1번을 수행 후 0을 1로, 1을 0으로 바꾸고 1을 더해 2번을 수행한다.
        ```  
        32비트 정수의 최솟값을 Math.abs()를 이용해 양수를 얻으려고 하면 잘못된 값이 나오기 때문에, 입력값을 long으로 형변환해서 로직을 수행했다.  
    * 두 번째, 비트 연산자 이용  
        ```java
        class Solution {
            static String[] B = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};

            public String toHex(int num) {
                if(num == 0) return "0";

                StringBuilder sb = new StringBuilder();
                while(num != 0){
                    int tmp = num & 15;
                    sb.append(B[tmp]);
                    num = num >>> 4;
                }

                return sb.reverse().toString();
            }
        }
        ```  
        주어진 정수가 32비트이기에 주어진 정수와 15(0000 0000 0000 0000 0000 0000 0000 1111)를 & 해서 맨 오른쪽 4개 비트만을 뽑아낼 수 있다. 뽑아낸 4개 비트의 값에 해당하는 16진수 표현 기호를 StringBuilder에 append하고 주어진 정수를 unsigned right shift operator를 사용해 모든 비트를 오른쪽으로 4번 옮긴다. 이렇게 주어진 정수가 0이 될 때까지 앞 과정을 반복한다. StringBuilder의 값을 reverse()하고 toString()으로 반환한다.  

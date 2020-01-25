### 다음 큰 숫자  
* [문제](https://programmers.co.kr/learn/courses/30/lessons/12911)  
* 간단한 문제 설명  
    어떤 자연수가 주어질 때, 주어진 자연수보다 크고 2진수로 변환했을 때 1의 개수가 같은 숫자를 반환하는 문제.  
* [내 코드](the_next_big_number.java)  
* 내 코드 설명  
    주어진 자연수를 Integer.toBinaryString으로 2진수 문자열로 바꾸고, 문자열에서 '1'의 개수를 카운트 하고 기준 카운트 변수로 저장한다. 주어진 자연수보다 하나씩 큰 수를 2진수 문자열로 바꿔 '1'의 개수를 카운해 기준 카운트 변수와 비교하여 같으면 그 수를 반환한다.  

    다른 분들의 코드를 보다가 Integer.bitCount(int n) 기능을 알게되었다. 이 기능은 정수 n을 2진수로 바꿨을 때 1의 개수를 반환해준다. 이 기능을 사용하면 굳이 2진수 문자열로 바꿔 '1'의 개수를 카운트하지 않아도 된다.  

    ```java
    class Solution {
        public int solution(int n) {
            int n_count = Integer.bitCount(n);
            int subject = n + 1;
            while(true){
                int subject_count = Integer.bitCount(subject);
                if(subject_count == n_count)
                    break;
                else subject++;
            }

            return subject;
        }
    }
    ```

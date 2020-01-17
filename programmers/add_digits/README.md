### 자릿수 더하기  
* [문제](https://programmers.co.kr/learn/courses/30/lessons/12931)  
* 간단한 문제 설명   
    정수 N이 주어질 때, 각 자릿수를 더한 값을 반환하는 문제. `N = 123` 이면 `1 + 2 + 3 = 6` 을 반환하는 문제.  
* [내 코드](add_digits.java)  
* 내 코드 설명  
    ```java  
    while(n>0){
        answer += n % 10;
        n /= 10;
    }
    ```
    이렇게 하면 되는 매우 간단한 문제이지만 자바에서 사용할 수 있는 스트림을 이용하고 싶었다.  
    ```java
    int answer = (int)String.valueOf(n).chars()
                    .map( c -> c -= '0' )
                    .sum();
    ```
    주어진 n을 문자열로 바꾼 후 char 메서드를 이용해 IntStream으로 바꾼다. 스트림의 각 원소는 문자에 해당하는 유니코드 10진수값이기에 정수값으로 바꿔준다. 그리고 다 바꾼 원소들의 합을 반환한다.  

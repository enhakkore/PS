### 이상한 문자 만들기
* [문제](https://programmers.co.kr/learn/courses/30/lessons/12930)  
* 간단한 문제 설명   
    여러 문자열들이 하나 이상의 공백으로 연결된 하나의 문자열이 주어질 때, 각 문자열의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾸고, 각 문자열을 하나의 공백으로 구분된 하나의 문자열로 반환하는 문제.  
* [내 코드](creating_strange_characters.java)  
* 내 코드 설명  
    String.split(regex, limit) -> [참고글](https://stackoverflow.com/questions/47552729/java-how-splitregex-limit-method-actually-works)  
    입력으로 주어지는 문자열이 하나 이상의 공백으로 구분되어 있기때문에 String.split(" ")만으론 완벽하게 문자열을 분할 할 수 없다. 두 번째 매개변수로 -1을 넣었는데, 이 매개변수가 음수이면 가능한 많이 분할 한다. 이 뜻은 문자열에 포함된 공백을 전부 없애고 공백으로 분할 할 수 있는 만큼 분할된 결과를 얻을 수 있다는 뜻이다. 만약 a와 b 사이 공백 두 개, b 뒤에 공백 두 개인 문자열을  
    ```java
    "a  b  ".split(" ", -1)
    ```
    하면
    ```java
    [a, , b, , ]
    ```
    이렇게 5개의 원소가 생기며, a와 b를 제외한 나머지는 빈 문자열이다.  
    공백으로 나눠진 각 문자열을 문제의 조건대로 바꾸고 List에 추가한다. 모든 문자열을 조건대로 바꾼 후 String.join(" ", List)을 이용해 공백으로 문자열을 하나의 문자열로 만든 후 반환한다.  

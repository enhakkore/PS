## 문자열 내 마음대로 정렬하기  
* [문제](https://programmers.co.kr/learn/courses/30/lessons/12915)  
* 간단한 문제 설명  
    문자열 배열과 정수 n이 주어질 때 문자열들을 n번째 문자를 기준으로 오름차순 정렬해 반환하는 문제.
* [내 코드](target_number.java)  
* 내 코드 설명  
    정렬은 Arrays.sort() 라이브러리를 사용했으며, 두 번째 매개변수로 Comparator를 람다식으로 만들어 넘겼다.  
    Comparator 안에서는 각 문자열의 n-index의 문자를 char 타입의 변수로 꺼내고, char 변수가 서로 같다면 기존에 정렬하던 방식으로 반환하고, 같지 않다면 Comparator의 첫 번째 문자열 매개변수의 n-index char 변수에서 두 번째 문자열 매개변수의 n-index char 변수를 뺀 값을 반환한다. 이렇게 정렬한 문자열 배열을 반환한다.  

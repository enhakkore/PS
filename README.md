# PS  

### 프로그래머스  
* [타켓 넘버](https://programmers.co.kr/learn/courses/30/lessons/43165) - [MySolution](programmers/target_number)  
* [네트워크](https://programmers.co.kr/learn/courses/30/lessons/43162) - [MySolution](programmers/network)  
* [단어 변환](https://programmers.co.kr/learn/courses/30/lessons/43163) - [MySolution](programmers/word_change)  
* [여행 경로](https://programmers.co.kr/learn/courses/30/lessons/43164) - [MySolution](programmers/travel_route)  
* [쇠막대기](https://programmers.co.kr/learn/courses/30/lessons/42585) - [MySolution](programmers/iron_bar)  
* [K번째 수](https://programmers.co.kr/learn/courses/30/lessons/42748) - [MySolution](programmers/k-th_number)  
* [더 맵게](https://programmers.co.kr/learn/courses/30/lessons/42626) - [MySolution](programmers/more_spice)  
* [모의고사](https://programmers.co.kr/learn/courses/30/lessons/42840) - [MySolution](programmers/mock_test)  
* [소수 찾기](https://programmers.co.kr/learn/courses/30/lessons/42839) - [MySolution](programmers/finding_prime)  
* [체육복](https://programmers.co.kr/learn/courses/30/lessons/42862) - [MySolution](programmers/gym_clothes)  
---
### 알고리즘 관련 책 정리 [Book](https://book.naver.com/bookdb/book_detail.nhn?bid=13560672)  
* [연습문제 풀이](books/9791163030072)
* 개념 정리  
    * 여러 문장이 순차적으로 실행되는 구조를 __순차적 구조__(concatenation structure)라고 한다.  
    * **알고리즘**이란?  
        문제를 해결하기 위한 것으로, 명확하게 정의되고 순서가 있는 유한 개의 규칙으로 이루어진 집합  
    * __사전 판단 반복__(while(){}, for(;;){})과 __사후 판단 반복__(do{}while())의 차이점  
        사전 판단 반복은 조건문의 결과가 true일 때만 {}에 진입하여 반복하지만 사후 판단 반복은 일단 {}에 한 번 진입하고 조건문의 결과에 따라 반복할 지를 결정한다. 사후 판단 반복은 {}에 무조건 한 번은 진입한다.  
    * __논리 연산자의 단축 평가__(short circuit evaluation)  
        예를 들어 (num < 10 || num > 99)의 경우, 왼쪽 피연산자의 결과가 true이면 오른쪽 피연산자의 결과에 관계 없이 전체 결과는 true가 된다. (num < 10 && num > 99)의 경우 왼쪽 피연산자의 결과가 false이며 오른쪽 피연산자의 결과에 관계 없이 전체 결과는 false이다. 이처럼 왼쪽 피연산자의 결과만으로 전체 결과가 확정될 때 오른쪽 피연산자를 평가하지 않으며 이를 단축 평가라고 한다.  
    * __드모르간 법칙__  
        각 조건을 부정하고 논리곱을 논리합으로, 논리합을 논리곱으로 바꾸고 다시 전체를 부정하면 원래의 조건과 같다.  
    * **자료구조**란?  
        데이터 단위와 데이터 자체 사이의 물리적 또는 논리적인 관계, 쉽게 말해 자료를 효율적으로 이용할 수 있도록 컴퓨터에 저장하는 방법    
        데이터 단위 : 데이터를 구성하는 한 덩어리  
    * __배열__ : 같은 자료형의 구성 요소들이 하나의 집합으로 모여있는 자료구조.  
    * __java.util.Random__  
        Random 클래스는 선형 합동법이라는 계산법으로 48비트의 seed를 특정 수(난수)로 바꾼다.  
    * **String 클래스**  
        ```java
        String r = "ABC";
        ```  
        초기자의 "ABC"는 문자열 리터럴이다. 문자열 리터럴은 단순히 문자가 늘어서 있는 것이 아니라 String형 인스턴스에 대한 참조이다. String 클래스는 문자열을 넣어두기 위한 private final char[], 문자 수를 나타내는 private final int가 있으며 이외에도 field, constructor, method가 있다.  
    * **소수**  
        1. 자신과 1 이외의 정수로 나누어떨어지지 않는 정수. 그러므로 어떤 정수 n에 대하여 2부터 n-1까지의 어떤 정수로도 나누어떨어지지 않으면 n이 소수임을 알수있다.  
        2. 그런데 만약 n이 2와 3으로 나누어떨어지지 않으면 2\*2인 4와 2\*3인 6으로도 나누어떨어지지 않는 것을 알 수 있다. **따라서 정수 n이 2부터 n-1까지의 어떤 소수로도 나누어떨어지지 않으면 n이 소수임을 알 수 있다.** 그리고 4이상의 짝수는 2로 나누어떨어지므로 2를 제외한 나머지 짝수는 소수가 될 수 있는 조건을 만족하지 않는다.  
        3. 100의 약수는 아래와 같다.  
        ① 2\*50  
        ② 4\*25  
        ③ 5\*20  
        ④ 10\*10  
        ⑤ 20\*5  
        ⑥ 25\*4  
        ⑧ 50\*2  
        100의 약수들을 통해 만약 100이 5로 나누어떨어지지 않으면 20으로도 나누어 떨어지지 않는 것을 알 수 있다. 이러한 성질은 ① ~ ④까지만 확인하면 된다. 이후는 반복되기 때문이다. 따라서 정수 100은 2부터 100의 제곱근인 10이하의 어떤 양의 정수로도 나누어떨어지지 않으면 소수이다. 그리고 위의 2번 조건에 따라 10이하의 어떤 소수로도 나누어떨어지지 않으면 소수임을 알 수 있다.  
        4. 1~3번 조건으로 어떤 정수 n이 n 제곱근 이하의 소수로 나누어떨어지지 않으면 n은 소수임을 알 수 있다. n 제곱근 이하의 소수를 p라 했을 때 `p <= sqrt(n)`을 만족해야 하고, 제곱근을 구하는 것보다 제곱의 결과를 구하는 것이 더 빠르기 때문에 `p^2 <= n`을 사용하는 것이 낫다.

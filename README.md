# PS  
### 프로그래머스  
* [타켓 넘버](https://programmers.co.kr/learn/courses/30/lessons/43165) - [MySolution](programmers/target_number)  
* [네트워크](https://programmers.co.kr/learn/courses/30/lessons/43162) - [MySolution](programmers/network)
---
### 알고리즘 관련 책 정리 [Book](https://book.naver.com/bookdb/book_detail.nhn?bid=13560672)  
* [연습문제 풀이](books/9791163030072)
* 개념 정리  
    * 여러 문장이 순차적으로 실행되는 구조를 __순차적 구조__(concatenation structure)라고 한다.  
    * __알고리즘__이란?  
        문제를 해결하기 위한 것으로, 명확하게 정의되고 순서가 있는 유한 개의 규칙으로 이루어진 집합  
    * __사전 판단 반복__(while(){}, for(;;){})과 __사후 판단 반복__(do{}while())의 차이점  
        사전 판단 반복은 조건문의 결과가 true일 때만 {}에 진입하여 반복하지만 사후 판단 반복은 일단 {}에 한 번 진입하고 조건문의 결과에 따라 반복할 지를 결정한다. 사후 판단 반복은 {}에 무조건 한 번은 진입한다.  
    * __논리 연산자의 단축 평가__(short circuit evaluation)  
        예를 들어 (num < 10 || num > 99)의 경우, 왼쪽 피연산자의 결과가 true이면 오른쪽 피연산자의 결과에 관계 없이 전체 결과는 true가 된다. (num < 10 && num > 99)의 경우 왼쪽 피연산자의 결과가 false이며 오른쪽 피연산자의 결과에 관계 없이 전체 결과는 false이다. 이처럼 왼쪽 피연산자의 결과만으로 전체 결과가 확정될 때 오른쪽 피연산자를 평가하지 않으며 이를 단축 평가라고 한다.  
    * __드모르간 법칙__  
        각 조건을 부정하고 논리곱을 논리합으로, 논리합을 논리곱으로 바꾸고 다시 전체를 부정하면 원래의 조건과 같다.  
    * 

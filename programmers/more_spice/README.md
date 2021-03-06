## 더 맵게
* [문제](https://programmers.co.kr/learn/courses/30/lessons/42626)  
* 간단한 문제 설명  
    scoville 지수가 담겨져 있는 배열에서 가장 낮은 지수와 두 번째로 낮은 지수로 새로운 scoville 지수를 만들면서 모든 scoville 지수가 입력으로 제시된 K보다 높아지는 횟수를 구하는 문제.
* [내 코드1](more_spice.java), [내 코드2](more_spice2.java)  
* 내 코드 설명  
    (정확성 테스트는 모두 통과했지만 효율성 테스트는 모두 실패)  
    입력으로 주어지는 scoville 지수 배열을 PriorityQueue(pq)에 넣어 우선순위 큐(힙 자료구고)를 활용한다.  
    while 반복문을 시작한다.  
    pq의 모든 원소가 K이상인지 확인하고 모든 원소가 K이상이면 반복문을 빠져나온다.  
    모든 원소의 개수가 두 개 이상인지 확인하고 두 개 미만이면 횟수를 -1로 하고 반복문을 빠져나온다.
    두 개 이상이면 첫 번째와 두 번째 원소를 pq에서 꺼내 새로운 scoville 지수를 만들어 pq에 넣는다.
    while 반복문 끝.
    횟수를 리턴하고 solution 끝.  

    효율성 테스트를 통과하지 못해서 효율성 테스트를 통과할 수 있도록 로직을 다시 만들었다.  
    이전 코드에서 스트림 연산을 사용을 많이 해서 최대한 스트림 연산을 사용하지 않고 문제를 해결할 수 있도록 했다.  
    scoville 지수를 만들기 위해서는 pq에 최소 두 개 이상의 요소가 있어야 하고, 요소가 없는데 pq.poll()을 하면 null을 반환한다. null 객체를 이용해서 pq의 요소 개수가 몇개 인지 확인하고, pq.poll()을 하면 pq의 요소들 중에서 최솟값을 확인할 수 있기 때문에 최솟값이 K 이상이면 pq의 모든 요소가 K 이상이라는 것을 확인할 수 있다.   

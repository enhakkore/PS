## 모의 고사
* [문제](https://programmers.co.kr/learn/courses/30/lessons/42840)  
* 간단한 문제 설명  
    1번, 2번, 3번 학생은 각각 똑같은 패턴으로 문제를 찍는다. 문제의 정답이 주어졌을 때 가장 많은 문제를 맞춘 학생 번호를 배열에 담아 반환한다. 가장 많은 문제를 맞춘 학생이 2명 이상이면 학생 번호를 오름차순으로 정렬해 반환한다.   
* [내 코드](mock_test.java)  
* 내 코드 설명  
    문제의 정답과 각 학생의 패턴을 비교해 맞은 개수를 파악해 HashMap<학생 번호, 맞은 개수>에 저장한다. 맞은 개수를 파악하면서 가장 많이 맞춘 개수도 파악한다.  
    HashMap의 keySet을 List에 저장한 후 맞은 개수에 따라 내림차순으로 정렬, 맞은 개수가 중복이면 학생 번호에 따라 오름차순으로 정렬한다.  
    List를 스트림으로 만들어 filter를 이용해 가장 많이 맞춘 학생 번호만 배열로 만들어 반환한다.  

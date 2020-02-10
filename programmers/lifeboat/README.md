### 구명보트  
* [문제](https://programmers.co.kr/learn/courses/30/lessons/42885)  
* 간단한 문제 설명  
    사람들의 몸무게 정보가 들어있는 정수형 1차원 배열과 보트의 무게 제한 정수가 주어질 때, 한 번에 최대 2명까지 탈 수 있는 구명보트로 사람들을 옮길 수 있는 최소 횟수를 구하는 문제.    
* [내 코드](lifeboat.java)  
* 내 코드 설명  
    보트를 옮길 수 있는 횟수를 최소로 하려면 보트에 2명이 탈 수 있는 경우를 최대로 해야한다. 따라서 사람들의 몸무게 정보를 나타내는 배열을 오름차순으로 정렬하고 가장 무거운 사람부터 보트에 실은 후 가장 가변운 사람부터 탐색해서 보트에 탈 수 있는지 확인했다. 무거운 사람의 인덱스를 i로, 가벼운 사람의 인덱스를 j로 표현해서 j가 i와 같아지거나 커지면 모든 사람을 구출한 것으로 보고 반복문을 종료했다.  
### 방의 개수  
* [문제](https://programmers.co.kr/learn/courses/30/lessons/12931)  
* 간단한 문제 설명   
    (0,0)에서 시작해서 8방향 중 하나의 방향으로 크기 1씩 가면서 선을 그릴 때, 생기는 면의 개수를 반환하는 문제.  
* [실패 코드](a_number_of_room_failed.java), [실패 코드2](a_number_of_room_failed2.java)  
* 내 코드 설명  
    처음에는 방문했던 노드에 다시 방문하면 면이 생기는 것으로 체크했지만, 간선이 교차하는 경우와 경로를 반복하는 경우를 생각하지 못했다.    
    그러다가 오일러의 다면체 정리를 활용해서 노드의 개수와 간선의 개수를 구해서 면의 개수를 구하려고 했지만(1-v+e=f) 오일러의 2차원 정리를 적용하려면 간선이 교차하지 않는 평면 그래프이어야 했다...  
    결국 해결하지 못했다. 간선이 교차하는 경우와 경로를 반복하는 경우를 처리할 수 있는 로직을 생각해봐야겠다.  
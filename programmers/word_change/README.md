## 단어 변환 MySolution
* [문제](https://programmers.co.kr/learn/courses/30/lessons/43163)
* 간단한 문제 설명  
    문자열 begin, target과 문자열 배열 words[]이 주어질 때, begin으로 시작해서 words[]를 거쳐 target이 될 수 있는 최단 경로를 구하는 문제. 단, 문자열은 한 번에 하나의 글자만 바꿀 수 있다.  
* [내 코드](word_change.java)  
* 내 코드 설명  
    문자열끼리 비교해서 하나의 글자만 다르면 true를 출력하는 compare 함수를 만듭니다.  
    begin을 기준으로 words[] 중에서 하나의 글자만 다른 관계 정보를 나타내는 beginTmp 배열을 만듭니다. 이 배열 원소가 1이면 해당 인덱스의 원소와 begin은 서로 하나의 글자만 다른 관계.  
    words[] 원소들끼리 하나의 글자만 다르다는 관계 정보를 나타내는 2차원 배열 linkInfo를 만듭니다. 예를들어 words[0]과 words[2]가 하나의 글자만 다른 관계라면 linkInfo[0][2]와 linkInfo[2][0]은 1입니다.  
    words[] 원소들을 노드로 봤을 때 방문여부를 체크하는 visited 배열을 만듭니다. 방문한 노드의 인덱스가 가리키는 원소의 값은 true입니다.  
    beginTmp 배열의 값을 기반으로 원소의 값이 1이면 해당 인덱스로 sol함수를 호출하는 for문을 만듭니다. sol함수는 linkInfo의 정보를 가지고 연결된 words를 노드로 취급하여 각 words 인덱스로 sol함수를 재귀호출합니다.  
    sol함수는  
    매개변수 index로 현재 방문한 노드 정보를 visited에 반영합니다.
    현재 노드가 target과 일치하면 매개변수 count를 저장하는데, 이미 저장된 값과 비교하여 작은 값을 저장하고 함수를 종료합니다.  
    linkInfo에 따라 현재 노드와 연결된 노드를 방문하지 않았다면 연결된 노드와 count+1로 재귀호출합니다. 이 재귀호출의 작업이 끝나고 호출한 함수로 돌아오면 재귀호출했던 노드의 방문여부를 false로 바꿔줍니다. 이렇게 하면 DFS와 같게 되어 하나의 노드로 시작해서 여러 갈래로 연결된 모든 경로를 다 탐색할 수 있습니다.  

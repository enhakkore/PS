### Fraudulent activity notifications  
* [문제](https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting)  
* 간단한 문제 설명  
    출금 정보를 나타내는 정수형 1차원 배열과 기간 d가 주어진다. 은행은 모든 고객마다 어떤 날의 출금액이 바로 이전 d 기간 동안의 median 출금액보다 2배 이상 같거나 클 경우 부정 활동일 수 있다는 알람을 보낸다. 이때 알람을 보낸 횟수를 계산하는 문제.
* [내 코드](fraudulent-activity-notifications.java)  
* 내 코드 설명  
    median은 오름차순으로 정렬된 수 중에서 가운데 위치한 수를 말한다.  
    처음에는 주어진 배열에서 d 길이 만큼의 부분 배열을 만들고 정렬한 후에 가운데 위치한 값을 찾았다. 이렇게 했을 때 시간 초과가 났다.  
    부분 배열을 만들고 정렬하지 않고도 median 값을 찾는 방법이 알아냈다.  
    문제 조건에 출금 금액이 0보다 크거나 같고 200보다 작거나 같다는 조건이 있다. 이를 활용해, 201 크기의 배열(freq)을 만들고 d 기간 동안의 출금액을 출금액 별로 카운트 한다. 예들 들어 출금액이 150이라면 freq[150]++ 이렇게 카운트한다. 카운트한 후, freq의 각 요소 값들을 하나씩 더하면서 median 값을 나타내는 d/2인 위치를 알아낸다.  

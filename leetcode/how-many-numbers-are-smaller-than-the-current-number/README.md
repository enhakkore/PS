### How many numbers are smaller then the current number  
* [문제](https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/)  
* 간단한 문제 설명  
    정수형 배열이 주어질 때, 각 원소보다 작은 원소의 개수를 나타내는 배열을 반환하는 문제.  
* [내 코드](how-many-numbers-are-smaller-than-the-current-number.java)  
* 내 코드 설명  
    주어진 배열을 복사해 오름차순으로 정렬한다. 주어진 배열의 각 원소는 정렬된 배열에도 당연히 있는데, 정렬된 배열에 위치한 인덱스가 해당 원소보다 작은 원소의 개수를 나타낸다. 주어진 배열의 각 원소가 오름차순으로 정렬된 배열에 있는 위치를 알아내기 위해서 이진탐색을 활용했다. 원래 이진탐색을 사용하면 중복된 원소의 있을 경우 어떤 위치가 반환되는지 보장하지 않기 때문에 문제에 맞게 변형했다. 중복된 원소가 있을 경우 맨 왼쪽에 있는 위치를 알아내기 위해서 찾고자 하는 원소를 찾았더라도 로직을 끝내지 않고 찾은 위치를 탐색 범위의 맨 오른쪽 값으로 할당하여 탐색 범위의 크기가 1이 될 때 로직을 끝내도록 했다.  

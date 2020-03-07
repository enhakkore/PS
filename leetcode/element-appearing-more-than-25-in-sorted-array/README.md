### Element appearing more than 25% in sorted array  
* [문제](https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/)  
* 간단한 문제 설명  
    오름차순으로 정렬된 정수형 배열이 주어질 때, 배열 크기의 25% 보다 많이 나타난 수를 찾는 문제.  
* [내 코드](element-appearing-more-than-25-in-sorted-array.java)  
* 내 코드 설명  
    * 첫 번째  
        주어진 배열에 있는 각 원소가 몇 번 나타나있는지 HashMap에 저장하고 HashMap의 value들 중 주어진 배열 크기의 25% 보다 많이 나타난 key를 반환한다.  
    * 두 번째  
        ```java
        class Solution {
            public int findSpecialInteger(int[] arr) {
                double stand = arr.length / 4.0;

                int now = -1;
                int count = 0;
                for(int num : arr){
                    if(num != now){
                        now = num;
                        count = 1;
                    } else {
                        count++;
                    }

                    if(count > stand)
                        break;
                }

                return now;
            }
        }
        ```  
        문제 조건을 보면 주어진 배열 크기의 25% 보다 크게 나타난 수는 단 하나이다. 따라서 오름차순으로 정렬된 주어진 배열을 첫 번째 원소부터 탐색하면서 조건에 맞는 수를 찾으면 나머지를 탐색할 필요없이 찾은 수를 반환하고 모든 로직을 끝내면 된다.   

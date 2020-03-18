### Minimum Absolute Difference in an Array  
* [문제](https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem)  
* 간단한 문제 설명  
    1차원 정수형 배열이 주어질 때, 위치가 서로 같지 않은 원소들의 `|차이|`들 중에서 최솟값을 찾는 문제.   
* [내 코드](minimum-absolute-difference-in-an-array.java)    
* 내 코드 설명  
    [출처](https://www.geeksforgeeks.org/find-minimum-difference-pair/)를 참고했다.  
    ```java
    int minimumAbsoluteDifference(int[] arr) {
        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        for(int i = 1 ; i < arr.length ; i++){
            min = Math.min(min, Math.abs(arr[i]-arr[i-1]));
            if(min == 0)
                return 0;
        }

        return min;
    }
    ```  
    매우 쉬운 문제이지만 O(n^2)으로 로직을 만들어 제출하면 몇몇 테스트 케이스는 시간초과가 난다.  
    그렇다면 O(n^2)까지 시간비용을 들이지 않고 풀 수 있는 방법이 있다는 것일까?  
    주어진 배열을 오름차순 또는 내림차순으로 정렬하지 않는다면 각 원소의 차이가 어떤지 알 수 없기 때문에 두 개의 반목문을 중첩시켜 각 원소의 차이를 알아낼 수 밖에 없다. 하지만 정렬을 한다면 나란한 원소들의 차이를 최소로 보장할 수 있다. 예를 들어 정렬된 배열의 원소 a, b, c, d, e가 있다고 하자. c의 정확한 값을 알지 못하더라도 c와의 차이를 최소를 보장하는 원소는 b와 d뿐이다. 따라서 주어진 배열을 정렬하고 각 원소를 나란한 원소들과의 차이를 탐색하면 차이가 가장 작은 값을 찾을 수 있다. 이렇게 탐색하면 O(n)이 걸리고, 앞서 정렬했기에 O(n log n)이 걸리기에 총 O(n log n)이 걸려 O(n^2)보다 빠르게 풀 수 있다.  

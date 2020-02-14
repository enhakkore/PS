### Frist Bad Version  
* [문제](https://leetcode.com/problems/first-bad-version/)  
* 간단한 문제 설명  
    어떤 제품의 버전이 1부터 n까지일 때, 모든 버전은 이전 버전을 기반으로 만들어지기 때문에 오류가 발생한 버전 이후의 모든 버전은 Bad 버전이다. 이때 첫 번째 Bad 버전을 찾아 반환하는 문제.  
* [내 코드](first-bad-version.java)  
* 내 코드 설명  
    [출처](https://leetcode.com/problems/first-bad-version/solution/)를 참고했다.  
    버전 1부터 선형을 탐색으로 문제를 해결하려고 하면 시간 초과가 발생한다. 따라서 이진 탐색으로 첫 번째 Bad 버전을 찾아 반환했다.  

    이진 탐색을 할 때 left와 right가 해당 변수 타입의 유효한 범위에 속하더도 오버플로가 발생할 수 있다. mid 값을 얻기 위해 left와 right 값을 더하고 2로 나누는데, left와 right를 더하면서 오버플로가 발생할 수 있다. 따라서 `mid = (left + right) / 2`을 대신해 `mid = left + (right - left) / 2`로 하면 오버플로를 예방할 수 있다.  
    ```java
    public boolean binarySearch(int[] nums, int target){
        int left = 0, right = nums.length - 1, mid = 0;

        while(left < right){
            mid = left + (right - left) / 2;
            if(nums[mid] == target) return true;
            else if(nums[mid] > target) left = mid + 1;
            else if(nums[mid] < target) right = mid - 1;
        }

        return false;
    }
    ```  

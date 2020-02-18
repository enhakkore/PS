### Maximum Subarray  
* [문제](https://leetcode.com/problems/maximum-subarray/)  
* 간단한 문제 설명  
    정수형 배열이 주어질 때, 부분 배열들의 합 중에서 최대 값을 구하는 문제.  
* [내 코드](maximum-subarray.java) -> 분할 정복으로 해결한 코드  
* 내 코드 설명  
    * 첫 번째, 브루트 포스  
        ```java
        class Solution {
            public int maxSubArray(int[] nums) {
                int length = nums.length;
                if(length == 0 ) return Integer.MIN_VALUE;

                long maxSum = Long.MIN_VALUE;
                for(int i = 0 ; i < length ; i++){
                    for(int j = i+1; j <= length ; j++ ){
                        long tmpSum = IntStream.range(i, j).map(index -> nums[index]).sum();
                        maxSum = Math.max(maxSum, tmpSum);
                    }
                }

                return (int)maxSum;
            }
        }
        ```  
        브루트 포스로 해결하는 방법은 두 개의 반복문을 중첩시켜 해결하는 방법이다. outer loop에서 부분 배열의 시작 인덱스를 배열의 첫 번째 인덱스부터 마지막 인덱스까지, inner loop에서는 부분 배열의 마지막 인덱스를 시작 인덱스+1 부터 배열의 길이까지 지정한다. 이렇게 부분 배열의 시작 인덱스와 마지막 인덱스로 만들 수 있는 부분 배열을 전부 만들어 부분 배열의 최대 합을 구한다.  
    * 두 번째, 분할 정복  
        최대 부분 합을 분할 정복으로 해결하는 방법은 하나의 배열을 반으로 나눠 왼쪽 배열과 오른쪽 배열로 나눠졌을 때, 왼쪽 배열의 원소들 중 최댓값(1)과 오른쪽 배열의 원소들 중 최댓값(2), 나눠지기 전 하나의 배열에서의 가운데 원소를 기준으로 왼쪽으로 하나씩 더해갔을 때의 최댓값과 오른쪽으로 하나씩 더해갔을 때의 최댓값의 합(3), 이렇게 세 개의 값 중에서 최댓값을 구해 부분 배열의 최대 합을 구한다. 분할 정복이기 때문에 나눠진 배열의 길이가 1이 될 때까지 나누면서 재귀 호출을 하게 되고, 길이 1일 때 해당 원소를 반환하는 base case를 만든다.  
    * 세 번째, 다이나믹(카데인 알고리즘)  
        ```java
        class Solution {
            public int maxSubArray(int[] nums) {
                int max = nums[0];
                int preMax = nums[0];
                for(int i = 1 ; i < nums.length ; i++){
                    preMax = Math.max(nums[i], preMax+nums[i]);
                    max = Math.max(preMax, max);
                }

                return max;
            }
        }
        ```  
        첫 번재 방법에서는 시작 인덱스를 기준으로 만들 수 있는 부분 배열을 만들었는데 관점을 살짝 바꿔 부분 배열의 끝나는 인덱스를 기준으로 부분 배열을 만들 수 있다. 배열 nums에서 첫 번째 인덱스로 끝나는 부분 배열은 {nums[0]} 한 개이다. 두 번째 인덱스로 끝나는 부분 배열은 {nums[1]}, {nums[0], nums[1]} 이다. 세 번째 인덱스로 끝나는 부분 배열은 {nums[2]}, {nums[1], nums[2]}, {nums[0], nums[1], nums[2]} 이다. 이렇게 봤을 때 n번째 인덱스로 끝나는 부분 배열은 n-1번째 인덱스로 끝나는 부분 배열에 nums[n]을 더한 것과 같은 것을 알 수 있다. 이 성질을 이용해서 n번째로 끝나는 각 부분 배열의 합 중에서 최댓값은 num[n]\(4\)과 n-1번째로 끝나는 각 부분 배열의 합 중에서의 최댓값과 num[n]을 더한 값(4), 즉 (3)과 (4) 중에서 큰 값이 n번째로 끝나는 각 부분 배열의 합 중에서 최댓값이 된다. 이렇게 최댓값을 구하면 모든 인덱스 마다 해당 인덱스를 기준으로 끝나는 각 부분 배열의 합 중에서의 최댓값을 알 수 있으며. 길이가 n인 배열일 경우 n개의 최댓값을 구할 수 있다. 이렇게 구한 n개 중에서 제일 큰 값이 주어진 배열의 최대 부분 합이다.  

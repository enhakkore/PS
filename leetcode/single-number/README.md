### Single number  
* [문제](https://leetcode.com/problems/single-number/)  
* 간단한 문제 설명  
    정수형 배열이 주어는데 이 배열은 하나의 원소를 제외하고 나머지 원소들은 두 개씩 배열에 있다. 이때 하나만 존재하는 원소를 찾는 문제.  
* [내 코드](singlr-number.java)    
* 내 코드 설명  
    * 첫 번째  
        ```java
        class Solution {
            public int singleNumber(int[] nums) {
                for(int i = 0; i < nums.length ; i++){
                    boolean flag = true;
                    for(int j = 0 ; j < nums.length ; j++){
                        if(i != j && nums[i] == nums[j]){
                            flag = false;
                            break;
                        }
                    }
                    if(flag) return nums[i];
                }

                return 0;
            }
        }
        ```  
        배열의 첫 번째 원소부터 해당 원소를 기준으로 같은 위치 외에 같은 값이 있는지 확인한다.  
    * 두 번째  
        ```java
        class solution{
            public int singleNumber(int[] nums){
                Arrays.sort(nums);
                for(int i = 0; i < nums.length ; i++){
                    int index = Arrays.binarySearch(nums, i+1, nums.length, nums[i]);
                    if(index < 0) return nums[i];
                }

                return 0;
            }
        }
        ```  
        배열을 정렬한 후에 어떤 원소를 기준으로 다음 위치부터 마지막 위치까지 이진탐색으로 기준 원소가 있는 탐색한다.  
    * 세 번째
        ```java
        class Solution {
            public int singleNumber(int[] nums) {
                Arrays.sort(nums);
                for(int i = 0; i < nums.length ; i += 2){
                    if(i == nums.length - 1 || nums[i] != nums[i+1]) return nums[i];
                }
                return 0;
            }
        }
        ```
        두 번째처럼 정렬 후에 같은 원소는 위치상 붙어있기 때문에 어떤 원소와 바로 옆 원소를 비교해서 다른 값이면 하나만 존재하는 원소로 간주하고 해당 원소를 반환한다.
    * 네 번째, [출처](https://leetcode.com/problems/single-number/solution/)를 참고함.  
        ```java
        class Solution{
            public int singleNumber(int[] nums){
                int ans = 0;
                for(int num : nums){
                    ans ^= num;
                }

                return ans;
            }
        }
        ```  
        1과 0을 가지고 배타적 논리합을 했을 때 두 값이 같으면 0, 다르면 1의 결과값을 얻을 수 있다. 이 성질을 문제 해결에 적용하면, 0과 어떤 수를 배타적 논리합 연산을 하면 결과는 어떤 수이다. 따라서 주어진 배열의 모든 원소와 0을 배타적 논리합 연산을 하면 두 개씩 있던 원소들은 연산 과정에서 0이 되고 하나만 있던 원소가 0과의 연산을 통해 결과로 나오게 된다.   

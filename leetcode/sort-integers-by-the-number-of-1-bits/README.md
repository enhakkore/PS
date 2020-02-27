### Sort integers by the number of 1 bits  
* [문제](https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/)  
* 간단한 문제 설명  
    정수형 배열이 주어질 때, 각 정수를 2진수로 표현했을 때 1의 개수를 기준으로 주어진 배열을 오름차순으로 정렬하는 문제.  
* [내 코드](sort-integers-by-the-number-of-1-bits.java)  
* 내 코드 설명  
    * 첫 번째  
        주어진 배열의 크기만큼 row를 갖는 2차원 배열을 만들고, 주어진 배열에 있는 원소들의 순서대로 각 row에 값을 넣는다. row[0]에는 원소를 2진수로 표현했을 때 1의 개수를 row[1]에는 원소를 넣는다. 입력을 다 하고 2차원 배열을 각 row의 [0]를 기준으로 오름차순 정렬한다. 주어진 배열의 크기만큼 새로운 배열을 만들어 2차원 배열의 각 row에서 [1]의 값을 새로운 배열에 넣어 반환한다.  
    * 두 번째  
        ```java
        class Solution {
            public int[] sortByBits(int[] arr) {
                Integer[] tmp = Arrays.stream(arr).boxed().toArray(Integer[]::new);

                Arrays.sort(tmp, (a, b) -> {
                    int _a = Integer.bitCount(a);
                    int _b = Integer.bitCount(b);

                    return _a != _b ? _a-_b : a-b;
                });

                int[] ans = Arrays.stream(tmp).mapToInt(Integer::intValue).toArray();

                return ans;
            }
        }
        ```  
        주어진 배열을 사용자 정의 Comparator를 이용해 정렬하려면 주어진 배열의 원소들이 래퍼타입이어야 한다. 따라서 주어진 배열을 스트림을 이용해 Integer[]을 만들고, Integer[]을 사용자 정의 Comparator를 이용해 정렬한다. 사용자 정의 Comparator는 나란한 원소 2개를 각각 2진수로 표현했을 때, 1의 개수를 기준으로 오름차순 정렬한다. 정렬을 끝낸 후 Integer[]를 int[]로 만들어 반환한다.  
    * 세 번째, 퀵 정렬 활용하기  
        ```java
        class Solution {
            public int[] sortByBits(int[] arr) {
                quickSort(arr, 0, arr.length - 1);
                return arr;
            }

            public void quickSort(int[] arr, int left, int right){
                if(left >= right) return;

                int pivot = arr[right];
                int pivotCount = Integer.bitCount(arr[right]);
                int idx = left - 1;
                for(int i = left ; i < right ; i++){
                    int stand = Integer.bitCount(arr[i]);
                    if(stand < pivotCount || (stand == pivotCount && arr[i] < pivot)){
                        int tmp = arr[++idx];
                        arr[idx] = arr[i];
                        arr[i] = tmp;
                    }
                }

                arr[right] = arr[++idx];
                arr[idx] = pivot;

                quickSort(arr, left, idx-1);
                quickSort(arr, idx+1, right);
            }
        }
        ```  
        퀵 정렬을 활용해 각 원소를 2진수로 표현했을 때 1의 개수를 기준으로 정렬할 수 있다. pivot 원소를 2진수로 표현했을 때 1의 개수를 기준으로 배열을 탐색하는데, 이보다 작은 원소는 왼쪽으로 0번째 인덱스부터 차곡차곡 swap한다. 탐색이 끝나면 왼쪽으로 몰린 원소들의 마지막 인덱스+1의 원소와 pivot 원소를 swap한다. 왼쪽으로 몰린 원소들의 마지막 인덱스+1을 기준으로 왼쪽 구간과 오른쪽 구간으로 퀵 정렬을 재귀호출한다.  

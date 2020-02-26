### The k weakest rows in a matrix  
* [문제](https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/)  
* 간단한 문제 설명  
    1과 0으로 채워진 2차원 배열이 주어질 때, 각 row에 있는 1의 개수를 세고 1의 개수가 가장 적은 row의 인덱스를 k개 반환하는 문제. 각 row에 있는 1은 모든 0보다 앞에 있다.  
* [내 코드](the-k-weakest-rows-in-a-matrix.java)  
* 내 코드 설명  
    * 첫 번째, HashMap 사용하기  
        key에 row index, value에 각 row에 있는 1의 개수를 넣는다. key를 value 기준으로 오름차순으로 정렬하기 위해서 HashMap.keySet()으로 Set<Integer>을 만들어 ArrayList에 넣는다. 이 ArrayList를 사용자 정의 Comparator를 이용해 HashMap의 value 기준으로 오름차순 정렬한다. 정렬된 ArrayList의 첫 번째 원소부터 k-번째 원소까지 new int[k]에 넣어 반환한다.  
    * 두 번째, 2차원 배열 사용하기  
        ```java
        class Solution {
            public int[] kWeakestRows(int[][] mat, int k) {
                int[][] info = new int[mat.length][2];

                for(int r = 0; r < mat.length ; r++){
                    int c;
                    for(c = 0; c < mat[r].length ; c++){
                        if(mat[r][c] == 0)
                            break;
                    }
                    info[r][0] = c;
                    info[r][1] = r;
                }

                Arrays.sort(info, (a, b) -> {
                    return a[0] != b[0] ? a[0]-b[0] : a[1]-b[1];
                });

                int[] ans = new int[k];
                for(int i = 0 ; i < k ; i++){
                    ans[i] = info[i][1];
                }

                return ans;
            }
        }
        ```  
        첫 번째 방법과 다르게 Map 자료구조를 사용하는 것이 아니라 2차원 배열을 사용했다. 2차원 배열을 사용하면 Arrays.sort()를 사용해서 2차원 배열 자체적으로 정렬할 수 있다.  
    * 세 번째, PriorityQueue 사용하기  
        ```java
        class Solution {
            public int[] kWeakestRows(int[][] mat, int k) {
                PriorityQueue<int[]> info = new PriorityQueue<>((a, b) -> {
                    return a[0] != b[0] ? a[0] - b[0] : a[1] - b[1] ;
                });

                for(int r = 0 ; r < mat.length ; r++){
                    int c;
                    for(c = 0; c < mat[r].length ; c++){
                        if(mat[r][c] == 0)
                            break;
                    }
                    int[] tmp = {c, r};
                    info.offer(tmp);
                }

                int[] ans = new int[k];
                for(int i = 0; i < k ; i++){
                    ans[i] = info.poll()[1];
                }

                return ans;
            }
        }
        ```  
        PriorityQueue 자료구조를 사용하면, 처음 PriorityQueue를 생성할 때 사용자 정의 Comparator를 매개변수로 받을 수 있다. 따라서 offer()나 poll()이 동작될 때마다 사용자 정의에 따른 정렬 방식으로 PriorityQueue 내부 구조를 힙 구조로 만족시킨다. 오름차순일 경우 poll()의 반환값이 최솟값임을 보장한다.  
    * 네 번째, 이진탐색 사용하기  
        ```java
        class Solution {
            public int[] kWeakestRows(int[][] mat, int k) {
                PriorityQueue<int[]> info = new PriorityQueue<>((a, b) -> {
                    return a[0] != b[0] ? a[0] - b[0] : a[1] - b[1] ;
                });

                for(int r = 0 ; r < mat.length ; r++){
                    int c = countOne(mat[r]);
                    int[] tmp = {c, r};
                    info.offer(tmp);
                }

                int[] ans = new int[k];
                for(int i = 0; i < k ; i++){
                    ans[i] = info.poll()[1];
                }

                return ans;
            }

            public int countOne(int[] tmp){
                int left = 0;
                int right = tmp.length;

                while(left < right){
                    int mid = left + (right - left)/2;

                    if(tmp[mid] == 1)
                        left = mid + 1;
                    else right = mid;
                }

                return left;
            }
        }
        ```  
        전체 구조은 세 번째 방법과 같지만 각 row의 1의 개수를 세는 방법으로 이진탐색으로 사용했다. 문제 조건에 따라 각 row에 있는 1은 모든 0보다 앞에 있기 때문에 1의 마지막 위치가 1의 개수를 나타낸다. 따라서 이진탐색을 1의 마지막 위치를 찾는데 사용해 1의 개수를 파악하는 시간을 줄였다.  

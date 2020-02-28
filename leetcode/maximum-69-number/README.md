### Maximum 69 number  
* [문제](https://leetcode.com/problems/maximum-69-number/)  
* 간단한 문제 설명  
    9와 6으로만 이루어진 숫자가 주어질 때, 한 자리의 숫자만 바꿔서 만들 수 있는 제일 큰 숫자를 반환하는 문제.  
* [내 코드](maximum-69-number.java)  
* 내 코드 설명  
    * 첫 번째  
        주어진 숫자를 char형 배열로 만들고, 배열의 첫 번째 원소 부터 마지막 원소까지 탐색하는데, 6이면 9로 바꿔 TreeSet에 넣는다. 탐색을 마치고 TreeSet의 마지막 원소를 반환한다.  
    * 두 번째, 스택 이용  
        ```java
        class Solution {
            public int maximum69Number (int num) {
                ArrayDeque<Integer> stock = new ArrayDeque<>();

                while(num > 0){
                    stock.push(num % 10);
                    num /= 10;
                }

                while(!stock.isEmpty()){
                    num = num*10 + 9;
                    if(stock.pop() != 9) break;
                }

                while(!stock.isEmpty()){
                    num = num*10 + stock.pop();
                }

                return num;
            }
        }
        ```  
        주어진 숫자가 0과 같거나 작아질 때까지 10으로 나눈 나머지를 스택에 넣고 10으로 나눠간다. 스택의 맨 위 원소는 주어진 숫자의 맨 왼쪽 첫 번째 자리의 숫자이다. 스택의 원소가 빌때까지 반복문 안에 있는데, 스택에서 원소를 꺼내면서 주어진 숫자 변수에 9를 더하고 꺼낸 값이 9가 아니면 반복문을 끝냅니다. 스택에 원소가 남아 있을 수 있기 때문에 반복문을 한 번 더 만들어 숫자 변수에 스택의 나머지 원소를 더한다. 이렇게 하면 주어진 숫자의 왼쪽에서 처음으로 9가 아닌 6을 만난 자리만 숫자를 바꾼 값을 얻을 수 있다.  

## 타켓 넘버 MySolution  
* [문제](https://programmers.co.kr/learn/courses/30/lessons/43165)  
* 간단한 문제 설명  
    주어지는 2개 이상, 20개 이하 자연수들끼리 더하거나 빼서 타켓 넘버를 만들 수 있는 방법의 수를 구하는 문제.
* [내 코드](target_number.java)  
* 내 코드 설명  
    재귀함수(아래 sol1 함수)를 만들어 주어진 정수 배열(numbers)의 첫 번째 원소부터 마지막 원소까지 더하거나 빼서 만들 수 있는 모든 경우의 수를 확인한다.  
    ```java
    static int[] r = {1, -1};

    public void sol1(int order, int order1, int value){
        if(order == limit) {
            if(target == value){
                ans++;
            }
            return ;
        }

        int tmp = numbers[order]*r[order1];
        tmp += value;

        if(order1 == 0){
            sol1(order+1, order1, tmp);
            sol1(order, order1+1, value);
        }
        else {
            sol1(order+1, order1-1, tmp);
        }
    }
    ```  
    sol1 함수의 매개변수는 세 개이며, order는 numbers의 인덱스를 나타내며 order가 numbers 길이이면 세 번째 파라미터가 타겟 넘버인지 확인하고 더 이상 자신을 호출하지 않고 끝냅니다.    
    order1은 r의 인덱스를 나타냅니다. numbers[order]에 r[order1]를 곱한 값을 이전 결과값인 세 번째 파라미터 value와 더해 재귀호출시 세 번재 파라미터로 넘깁니다.  
    order1이 0일 때, 즉 r의 첫 번째 원소를 가리킬 때는 현재 numbers 인덱스의 다음 인덱스와 현재 r의 인덱스로 재귀호출을 합니다. 그리고 현재 numbers 인덱스와 현재 r의 인덱스의 다음 인덱스로 재귀호출을 하는데, 이 때 세 번째 파라미터는 계산된 값이 아닌 현재 함수의 세 번째 파라미터를 그대로 세 번째 파라미터로 넘깁니다.  
    order1이 1일 때, 즉 r의 마지막 원소를 가리킬 때는 현재 numbers 인덱스의 다음 인덱스와 r의 첫 번째 인덱스로 재귀호출을 합니다.  
    이렇게 재귀함수를 구성하면 numbers 원소들끼리 더하거나 빼서 타켓 넘버를 만들 수 있는 방법의 수를 모두 확인할 수 있습니다.

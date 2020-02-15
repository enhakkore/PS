### Symmetric Tree  
* [문제](https://leetcode.com/problems/symmetric-tree/)  
* 간단한 문제 설명  
    주어진 이진 트리가 root를 중심으로 대칭인지 확인하는 문제.  
* [내 코드](symmetric-tree.java)  
* 내 코드 설명  
    root를 중심으로 왼쪽에 있는 모든 노드를 왼쪽 우선 방문으로, 오른쪽에 있는 모든 노드를 오른쪽 우선 방문으로 각각 다른 ArrayDeque에 값을 저장한다. 각 ArrayDeque에서 요소를 꺼내 비교하면서 대칭인지 확인한다. 대칭이라면 각 ArrayDeque에 있는 모든 요소들의 순서과 값이 같다. 각 ArrayDeque의 전체 요소 개수가 같지 않거나, 요소가 같은 순서에 다른 값이라면 대칭이 아니다.  

    아래 풀이는 [출처](https://leetcode.com/problems/symmetric-tree/solution/)를 참고했다.  
    * **재귀**로 풀기  
        이진 트리가 root를 중심으로 대칭이라면 어떤 노드의 left와 right가 둘 다 null이거나 아니며, 각 노드의 값이 같다.  
        ```java
        public boolean isSymmetric(TreeNode root){
            return isMirror(root, root);
        }

        public boolean isMirror(TreeNode t1, TreeNode t2){
            if(t1 == null && t2 == null) return true;
            if(t1 == null || t2 == null) return false;
            return t1.val == t2.val
                && isMirror(t1.left, t2.right)
                && isMirror(t1.right, t2.left);
        }
        ```  
    * **반복**으로 풀기  
        ```java
        public boolean isSymmetric(TreeNode root){
            Queue<TreeNode> stock = new LinkedList();

            stock.add(root);
            stock.add(root);

            while(!stock.isEmpty()){
                TreeNode t1 = stock.poll();
                TreeNode t2 = stock.poll();

                if(t1 == null && t2 == null) continue;
                if(t1 == null || t2 == null) return false;
                if(t1.val != t2.val) return false;

                stock.add(t1.left);
                stock.add(t2.right);
                stock.add(t1.right);
                stock.add(t2.left);
            }

            return true;
        }
        ```  
        * 반복으로 풀면서 `Queue<T> que = new LinkedList<>()`를 사용한 이유는 LinkedList가 null element를 허용하기 때문이다.  

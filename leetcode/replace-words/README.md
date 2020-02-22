### Replace words  
* [문제](https://leetcode.com/problems/replace-words/)  
* 간단한 문제 설명  
    sentence 문자열은 여러 문자열이 공백으로 이어져 한 문장을 이루고 있다. sentence에 속한 어떤 문자열 A가 dict 리스트에 속한 문자열 B로 시작한다면 A를 B로 바꾼 sentence를 반환하는 문제.   
* [내 코드](replace-words.java)  
* 내 코드 설명  
    * 첫 번째, 내 코드  
        sentence를 공백 기준으로 문자열 베열로 만들고 각 문자열 A가 dict에 속한 문자열 B로 시작하는지 확인하는데, dict에 속한 문자열 B로 시작하면 B를, 그렇지 않으면 A를 stock 리스트에 추가한다. 문자열 배열을 모두 확인하고 stock 리스트의 모든 문자열을 공백으로 join하여 반환한다.  

    * 두 번째, 트라이 자료구조, [출처](https://leetcode.com/problems/replace-words/solution/)를 참고함.  
        TrieNode 클래스를 만든다. 이 클래스는 TrieNode 배열과 문자열을 변수로 갖는다. dict의 모든 문자열을 하나의 TrieNode를 기준으로 TrieNode 자료구조에 넣는다. 이렇게 만든 TrieNode로 sentence를 공백으로 쪼개 만든 모든 문자열을 확인한다. sentence의 문자열이 dict의 문자열로 시작한다면 하나의 TrieNode를 루트에 가지처럼 이어진 TrieNode 중에 문자열 변수가 null이 아닌 TrieNode를 만나게 된다. 이렇게 확인하여 StringBuilder로 문자열을 만들어 반환한다.   
        ```java
        class Solution {
            public String replaceWords(List<String> dict, String sentence) {
                TrieNode trie = new TrieNode();

                for(String root : dict){
                    TrieNode node = trie;
                    for(char c : root.toCharArray()){
                        if(node.children[c-'a'] == null)
                            node.children[c-'a'] = new TrieNode();
                        node = node.children[c-'a'];
                    }
                    node.word = root;
                }

                StringBuilder ans = new StringBuilder();
                for(String sen : sentence.split("\\s+")){
                    TrieNode node = trie;
                    for(char s : sen.toCharArray()){
                        if(node.children[s-'a'] == null || node.word != null)
                            break;
                        node = node.children[s-'a'];
                    }
                    String tmp = node.word == null ? sen : node.word;
                    ans.append(tmp);
                    ans.append(" ");
                }

                return ans.toString().trim();
            }
        }

        class TrieNode{
            TrieNode[] children;
            String word;
            public TrieNode(){
                children = new TrieNode[26];
            }
        }
        ```  

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null) return null;

        childNodeProcess(head);
        return head;
    }

    public Node childNodeProcess(Node node){
        while(node.next != null || node.child != null){

            if(node.child != null){
                Node nextNode = node.next;
                Node childNode = node.child;

                node.child = null;
                node.next = childNode;
                childNode.prev = node;

                node = childNodeProcess(childNode);

                node.next = nextNode;
                if(nextNode != null) nextNode.prev = node;
                else break;
            }

            node = node.next;
        }

        return node;
    }
}

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        if (head == null )return null;

        HashMap<Node, Node> hm = new HashMap<Node, Node>();

        Node temp = head;

        // Pass 1: Create a copy of each node and store mapping:
        while(temp != null){
            Node copy = new Node(temp.val);
            hm.put(temp,copy);
            temp = temp.next;
        }

        temp = head;
        // Pass 2: connect next and random pointers
        while(temp != null){
            Node copy = hm.get(temp);
            copy.next = hm.get(temp.next);
            copy.random = hm.get(temp.random);
            temp = temp.next;
        }

        return hm.get(head);

    }
}
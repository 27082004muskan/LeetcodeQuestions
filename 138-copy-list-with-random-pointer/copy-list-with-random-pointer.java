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
        if(head==null) return null;

       HashMap<Node, Node> m = new HashMap<>();

        Node newHead = new Node(head.val);
        m.put(head, newHead);

        Node oldtemp=head.next;
        Node newtemp = newHead;
       

        while(oldtemp!=null){
            Node copyNode = new Node(oldtemp.val);
           m.put(oldtemp, copyNode);

            newtemp.next=copyNode;
            oldtemp=oldtemp.next;
            newtemp=newtemp.next;
        }

        oldtemp=head;
        newtemp = newHead;
        while(oldtemp!=null){
            if (oldtemp.random != null) {
                newtemp.random = m.get(oldtemp.random);
            }
              oldtemp=oldtemp.next;
            newtemp=newtemp.next;    
        }

return newHead;
    }
}
package org.interview.preperation.linkedlist;

/*
Insert a node x after the nth node from the end in the given singly linked list. It is guaranteed that the list contains the nth node from the end. Also 1 <= n.

Examples:

Input : list: 1->3->4->5
        n = 4, x = 2
Output : 1->2->3->4->5
4th node from the end is 1 and
insertion has been done after this node.

Input : list: 10->8->3->12->5->18
        n = 2, x = 11
Output : 10->8->3->12->5->11->18
 */
public class InsertAfterNthNode {

    public static void main(String args[]) {
        LinkedList list = new LinkedList();

        list.add(18);
        list.add(5);
        list.add(12);
        list.add(3);
        list.add(8);
        list.add(10);

        list.addAfterNthNode(11,2);
        list.print();
    }

    static class LinkedList {
        private Node root;

        public void add(int data) {
            Node node = new Node(data, root);
            root = node;
        }

        public void addAfterNthNode(int data, int n) {
            Node node = new Node(data);
            Node slow = root;
            Node fast = root;

            for (int i = 1; i < n; i++) {
                fast = fast.next;
            }

            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }

            node.next = slow.next;
            slow.next = node;
        }

        public void print() {
            Node node = root;
            while (node != null) {
                System.out.println(node.data);
                node = node.next;
            }
        }

        class Node {
            int data;
            Node next;

            Node(int data, Node next) {
                this.data = data;
                this.next = next;
            }

            Node(int data) {
                this.data = data;
            }
        }
    }
}

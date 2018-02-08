package org.interview.preperation.linkedlist;

/*
Given a linked list of n nodes which is first sorted, then rotated by k elements. Find the value of k.
Example:

Input : list: 12->11->8->5->18->15->13
Output : 2
 */
public class CountRotations {
    public static void main(String args[]) {
        LinkedList list = new LinkedList();

        list.add(13);
        list.add(15);
        list.add(18);
        list.add(5);
        list.add(8);
        list.add(11);
        list.add(12);

        System.out.println(list.countRotations());
    }

    static class LinkedList {
        private Node root;

        public void add(int data) {
            Node node = new Node(data, root);
            root = node;
        }

        public int countRotations() {
            int count = 0;
            Node node = root;
            Node prevNode = root;
            while (node != null) {
                if (prevNode.data < node.data) {
                    break;
                }
                prevNode = node;
                node = node.next;
            }

            while (node != null) {
                count++;
                node = node.next;
            }
            return count;
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

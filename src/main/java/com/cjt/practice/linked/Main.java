package com.cjt.practice.linked;

/**
 * @author caojiantao
 */
public class Main {

    public static void main(String[] args) {
        Node a = new Node(3);
        Node b = new Node(2, a);
        Node c = new Node(1, b);
        Node d = new Node(5, c);
        System.out.println(d);
        System.out.println(reverseLinkedList(d));
    }

    /**
     * 反转链表
     *
     * @param node 原始链表
     * @return 反转后的链表
     */
    private static Node reverseLinkedList(Node node) {
        Node n = null;
        Node p = node;
        while (p != null) {
            Node next = p.getNext();
            p.setNext(n);
            n = p;
            p = next;
        }
        return n;
    }
}

package com.cjt.practice.linked;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author caojiantao
 */
public class Node {

    private Object data;

    private Node next;

    public Node() {
        this(null, null);
    }

    public Node(Object data) {
        this(data, null);
    }

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        List<Object> datas = new LinkedList<>();
        Node n = this;
        do {
            datas.add(n.data);
            n = n.next;
        } while (n != null);
        return String.valueOf(datas);
    }
}

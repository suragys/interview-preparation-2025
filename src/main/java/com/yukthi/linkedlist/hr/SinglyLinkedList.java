package com.yukthi.linkedlist.hr;

public class SinglyLinkedList {
    public SinglyLinkedListNode head;
    public SinglyLinkedListNode tail;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int nodeData) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData, null);
        if (head == null) {
            head = node;
        } else {
            tail.next = node;
        }

        tail = node;
    }


}

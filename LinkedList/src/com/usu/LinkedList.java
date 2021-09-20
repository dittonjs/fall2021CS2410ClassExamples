package com.usu;

public class LinkedList {
    private ListNode tail;
    private ListNode head;

    private class ListNode {
        private String value;
        private ListNode next;
    }

    public LinkedList() {
        tail = new ListNode();
        head = tail;
    }
    public void insert(String value) {
        ListNode newNode = new ListNode();
        newNode.value = value;

        tail.next = newNode;
        tail = tail.next;
    }

}

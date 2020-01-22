package com.aed.algo;

public class SinglyLinkedList<T> {

    Node<T> head;

    public static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    public void add(T data) {
        Node node = new Node(data);
        Node current = head;

        if(head == null) {
            head = node;
            return;
        }

        while (current.next != null) {
            current = current.next;
        }

        current.next = node;
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

}

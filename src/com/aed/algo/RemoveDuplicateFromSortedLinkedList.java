package com.aed.algo;

import static com.aed.algo.SinglyLinkedList.Node;

public class RemoveDuplicateFromSortedLinkedList {

    public static void main(String[] args) {
        SinglyLinkedList<Character> list = new SinglyLinkedList<>();
        list.add('a');
        list.add('b');
        list.add('c');
        list.add('c');
        list.add('c');
        list.add('d');
        list.add('d');
        list.add('e');

        System.out.println("List!");
        list.print();

        removeDuplicates(list.head);
        System.out.println("After Removing Duplicates!");
        list.print();
    }

    private static void removeDuplicates(Node<Character> head) {
        Node<Character> p = head;
        while (p != null && p.next != null) {
            if(p.data == p.next.data) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
    }

}

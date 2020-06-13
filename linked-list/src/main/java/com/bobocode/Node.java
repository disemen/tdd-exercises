package com.bobocode;

public class Node<E> {
    private E element;
    private Node<E> next;

    public static <E> Node<E> valueOf(E element) {
        return new Node<>(element);
    }

    private Node(E element) {
        this.element = element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public E getElement() {
        return element;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getNext() {
        return next;
    }
}

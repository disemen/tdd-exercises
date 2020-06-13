package com.bobocode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * {@link LinkedList} is a list implementation that is based on singly linked generic nodes. A node is implemented as
 * inner static class {@link Node<E>}.
 *
 * @param <E> generic type parameter
 */
public class LinkedList<E> implements List<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    /**
     * This method creates a list of provided elements
     *
     * @param elements elements to add
     * @param <E>      generic type
     * @return a new list of elements the were passed as method parameters
     */
    @SafeVarargs
    public static <E> List<E> of(E... elements) {
        LinkedList<E> list = new LinkedList<>();
        Arrays.stream(elements).forEach(list::add);

        return list;
    }

    /**
     * Adds an element to the end of the list. This operation is performed in constant time O(1)
     *
     * @param element element to add
     */
    @Override
    public void add(E element) {
        add(size, element);
    }

    /**
     * Adds a new element to the specific position in the list. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index   an index of new element
     * @param element element to add
     */
    @Override
    public void add(int index, E element) {
        Node<E> node = Node.valueOf(element);
        if (index == 0) {
            node.setNext(head);
            head = node;
            if (head.getNext() == null) {
                tail = head;
            }
        } else if (index == size) {
            tail.setNext(node);
            tail = node;
        } else {
            ArrayList<Node<E>> list = new ArrayList<>();
            Node<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
                list.add(current);
            }
            node.setNext(current);
            list.get(index - 2).setNext(node);
        }
        size++;
    }

    /**
     * Changes the value of an list element at specific position. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index   an position of element to change
     * @param element a new element value
     */
    @Override
    public void set(int index, E element) {
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        current.setElement(element);
    }

    /**
     * Retrieves an elements by its position index. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index element index
     * @return an element value
     */
    @Override
    public E get(int index) {
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current.getElement();
    }

    /**
     * Returns the first element of the list. Operation is performed in constant time O(1)
     *
     * @return the first element of the list
     * @throws java.util.NoSuchElementException if list is empty
     */
    @Override
    public E getFirst() {
        return head.getElement();
    }

    /**
     * Returns the last element of the list. Operation is performed in constant time O(1)
     *
     * @return the last element of the list
     * @throws java.util.NoSuchElementException if list is empty
     */
    @Override
    public E getLast() {
        if (tail != null) {
            return tail.getElement();
        } else {
            return head.getElement();
        }
    }

    /**
     * Removes an elements by its position index. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index element index
     */
    @Override
    public void remove(int index) {
        Objects.checkIndex(index, size);
        ArrayList<Node<E>> list = new ArrayList<>();
        Node<E> current = head;
        for (int i = 0; i <= index; i++) {
            current = current.getNext();
            list.add(current);
        }
        list.get(index - 2).setNext(list.get(index));
        size--;
    }


    /**
     * Checks if a specific exists in he list
     *
     * @return {@code true} if element exist, {@code false} otherwise
     */
    @Override
    public boolean contains(E element) {
        if (head.getElement().equals(element)) {
            return true;
        } else {
            Node<E> current = head;
            for (int i = 0; i < size; i++) {
                current = current.getNext();
                if (current != null && current.getElement().equals(element)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if a list is empty
     *
     * @return {@code true} if list is empty, {@code false} otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of elements in the list
     *
     * @return number of elements
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes all list elements
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
}

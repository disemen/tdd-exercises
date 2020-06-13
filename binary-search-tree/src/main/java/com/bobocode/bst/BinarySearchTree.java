package com.bobocode.bst;

import java.util.function.Consumer;

/**
 * Binary search tree should have an API that allow provides the following functionality:
 * - insert an element and return true if it was inserted successfully
 * - search an element and return true it element exists
 * - get tree size
 * - get tree height
 * - perform in-order traversal by passing element @{@link Consumer} as a parameter
 */
public interface BinarySearchTree<T> {
    boolean insert(T element);

    void inOrderTraversal(Consumer<T> consumer);

    boolean searchElement(T element);

    int size();

    int height();
}

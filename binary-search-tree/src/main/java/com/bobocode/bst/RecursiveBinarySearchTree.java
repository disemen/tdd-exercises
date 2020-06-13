package com.bobocode.bst;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class RecursiveBinarySearchTree<T extends Comparable<T>> implements BinarySearchTree<T> {
    private Node<T> root;

    @SafeVarargs
    public static <T extends Comparable<T>> BinarySearchTree<T> of(T... elements) {
        BinarySearchTree<T> bst = new RecursiveBinarySearchTree<>();
        Stream.of(elements).forEach(bst::insert);

        return bst;
    }

    @Override
    public boolean insert(T element) {
        if (root == null) {
            root = Node.valueOf(element);
            return true;
        } else {
            return insertIntoTree(root, element);
        }
    }

    private boolean insertIntoTree(Node<T> node, T element) {
        if (element.compareTo(node.getElement()) < 0) {
            return insertIntoLeftSubTree(node, element);
        } else if (element.compareTo(node.getElement()) > 0) {
            return insertIntoRightSubTree(node, element);
        } else {
            return false;
        }
    }

    private boolean insertIntoLeftSubTree(Node<T> node, T element) {
        if (node.getLeftChild() == null) {
            node.setLeftChild(Node.valueOf(element));
            return true;
        } else {
            return insertIntoTree(node.getLeftChild(), element);
        }
    }

    private boolean insertIntoRightSubTree(Node<T> node, T element) {
        if (node.getRightChild() == null) {
            node.setRightChild(Node.valueOf(element));
            return true;
        } else {
            return insertIntoTree(node.getRightChild(), element);
        }
    }

    @Override
    public void inOrderTraversal(Consumer<T> consumer) {
        inOrderTraversal(root, consumer);
    }

    private void inOrderTraversal(Node<T> node, Consumer<T> consumer) {
        if (node != null) {
            inOrderTraversal(node.getLeftChild(), consumer);
            consumer.accept(node.getElement());
            inOrderTraversal(node.getRightChild(), consumer);
        }
    }

    @Override
    public boolean searchElement(T element) {
        return searchElement(root, element);
    }

    private boolean searchElement(Node<T> node, T element) {
        if (node != null) {
            if (node.getElement().compareTo(element) == 0) {
                return true;
            } else if (node.getElement().compareTo(element) > 0) {
                return searchElement(node.getLeftChild(), element);
            } else if (node.getElement().compareTo(element) < 0) {
                return searchElement(node.getRightChild(), element);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node<T> node) {
        if (node != null) {
            return (size(node.getLeftChild()) + 1 + size(node.getRightChild()));
        } else {
            return 0;
        }
    }

    @Override
    public int height() {
        return root != null ? height(root) - 1 : 0;
    }

    private int height(Node<T> node) {
        if (node != null) {
            return 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
        } else {
            return 0;
        }
    }
}

package com.bobocode.bst;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {

    @Test
    public void testCreateBST() {
        new RecursiveBinarySearchTree<>();
    }

    @Test
    public void testInsertIntoEmptyTree() {
        BinarySearchTree<Integer> bst = new RecursiveBinarySearchTree<>();

        boolean inserted = bst.insert(35);

        assertTrue(inserted);
    }

    @Test
    public void insertSameElementTwice() {
        BinarySearchTree<Integer> bst = RecursiveBinarySearchTree.of(35);

        boolean insertedSecondTime = bst.insert(35);

        assertFalse(insertedSecondTime);
    }

    @Test
    public void insertElements() {
        BinarySearchTree<Integer> bst = RecursiveBinarySearchTree.of(42, 14, 65, 17, 54, 76, 15, 81);

        boolean insertedNewElement = bst.insert(898);
        boolean insertedExistingElement = bst.insert(65);
        boolean insertedRootSecondTime = bst.insert(42);

        assertTrue(insertedNewElement);
        assertFalse(insertedExistingElement);
        assertFalse(insertedRootSecondTime);
    }

    @Test
    public void inOrderTraversal() {
        BinarySearchTree<Integer> bst = RecursiveBinarySearchTree.of(42, 14, 65, 17, 54, 76, 15, 81);

        List<Integer> bstElements = new ArrayList<>();
        bst.inOrderTraversal(bstElements::add);

        assertEquals(new ArrayList<>(List.of(14, 15, 17, 42, 54, 65, 76, 81)), bstElements);
    }

    @Test
    public void searchElement() {
        BinarySearchTree<Integer> bst = RecursiveBinarySearchTree.of(42, 14, 65, 17, 54, 76, 15, 81);

        boolean searchedExistingRootElement = bst.searchElement(42);
        boolean searchedExistingElement = bst.searchElement(54);
        boolean searchedNonExistingElement = bst.searchElement(111);

        assertTrue(searchedExistingRootElement);
        assertTrue(searchedExistingElement);
        assertFalse(searchedNonExistingElement);
    }

    @Test
    public void treeSize() {
        BinarySearchTree<Integer> bst = RecursiveBinarySearchTree.of(42, 14, 65, 17, 54, 76, 15, 81);

        int size = bst.size();

        assertEquals(8, size);
    }

    @Test
    public void treeHeight() {
        BinarySearchTree<Integer> bst = RecursiveBinarySearchTree.of(42, 14, 65, 17, 54, 76, 15, 81);

        int height = bst.height();

        assertEquals(3, height);
    }
}

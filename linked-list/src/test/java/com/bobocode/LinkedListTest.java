package com.bobocode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    @Test
    public void testCreateLinkedList() {
        List<Integer> list = new LinkedList<>();
    }

    @Test
    public void testOf() {
        List<Integer> list = LinkedList.of(23, 12, 34, 11, 4, 54);

        assertEquals(23, list.get(0));
        assertEquals(12, list.get(1));
        assertEquals(34, list.get(2));
        assertEquals(11, list.get(3));
        assertEquals(4, list.get(4));
        assertEquals(54, list.get(5));
        assertEquals(6, list.size());
    }

    @Test
    public void testAddElementIntoEmptyList() {
        List<Integer> list = new LinkedList<>();

        list.add(33);

        assertEquals(33, list.getFirst());
        assertEquals(1, list.size());
    }

    @Test
    public void testAddElements() {
        List<Integer> list = new LinkedList<>();

        list.add(12);
        list.add(14);
        assertEquals(14, list.get(1));
        assertEquals(2, list.size());
    }

    @Test
    public void testAddElementByIndex() {
        List<Integer> list = LinkedList.of(23, 12, 34, 11, 4, 54);

        list.add(2, 27);

        assertEquals(27, list.get(2));
        assertEquals(7, list.size());
    }

    @Test
    public void testGetFirstElement() {
        List<Integer> list = LinkedList.of(23, 12, 34, 11, 4, 54);

        assertEquals(23, list.getFirst());
    }

    @Test
    public void testGetLastElement() {
        List<Integer> list = LinkedList.of(23, 12, 34, 11, 4, 54);

        assertEquals(54, list.getLast());
    }

    @Test
    public void testGetElementsByIndex() {
        List<Integer> list = LinkedList.of(23, 12, 34, 11, 4, 54);

        assertEquals(23, list.get(0));
        assertEquals(12, list.get(1));
        assertEquals(34, list.get(2));
        assertEquals(11, list.get(3));
        assertEquals(4, list.get(4));
        assertEquals(54, list.get(5));
        assertEquals(6, list.size());
    }

    @Test
    public void testSet() {
        List<Integer> list = LinkedList.of(23, 12, 34, 11, 4, 54);

        list.set(2, 27);

        assertEquals(27, list.get(2));
        assertEquals(6, list.size());
    }

    @Test
    public void testRemove() {
        List<Integer> list = LinkedList.of(23, 12, 34, 11, 4, 54);

        list.remove(2);

        assertEquals(23, list.get(0));
        assertEquals(12, list.get(1));
        assertEquals(11, list.get(2));
        assertEquals(4, list.get(3));
        assertEquals(54, list.get(4));
        assertEquals(5, list.size());
    }

    @Test
    public void testContains() {
        List<Integer> list = LinkedList.of(23, 12, 34, 11, 4, 54);

        boolean contains = list.contains(34);
        boolean nonContains = list.contains(123);

        assertTrue(contains);
        assertFalse(nonContains);
    }

    @Test
    public void testIsEmpty() {
        List<Integer> list = new LinkedList<>();

        assertTrue(list.isEmpty());
    }

    @Test
    public void testSize() {
        List<Integer> list = LinkedList.of(23, 12, 34, 11, 4, 54);

        assertEquals(6, list.size());
    }

    @Test
    public void testClear() {
        List<Integer> list = LinkedList.of(23, 12, 34, 11, 4, 54);

        list.clear();

        assertEquals(0, list.size());
    }
}

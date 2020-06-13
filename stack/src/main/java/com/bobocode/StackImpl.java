package com.bobocode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StackImpl<T> implements Stack<T> {
    private final List<T> list = new LinkedList<>();

    @Override
    public void push(T element) {
        if (list.size() == 0) {
            list.add(0, element);
        } else {
            list.add(element);
        }
    }

    @SafeVarargs
    public static <T> Stack<T> of(T... elements) {
        Stack<T> stack = new StackImpl<>();
        Arrays.asList(elements).forEach(stack::push);
        return stack;
    }

    @Override
    public T pop() {
        int last = list.size() - 1;
        T element = list.get(last);
        list.remove(last);
        return element;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}

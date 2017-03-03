package com.learnday.spock.other;

import java.util.ArrayList;
import java.util.Objects;

public class Stack {

    private ArrayList<Object> stack;

    public void push(Object o) {
        stack.add(o);
    }

    public Object pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException();
        }
        return stack.remove(stack.size() - 1);
    }
}

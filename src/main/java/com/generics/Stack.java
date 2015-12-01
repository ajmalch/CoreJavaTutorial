package com.generics;

import java.util.Arrays;

class Stack<E> {
private E[] elements;
private int size = 0;
private static final int DEFAULT_INITIAL_CAPACITY = 16;

//It is safe to add SupressWarnings as only push() method would add to elements and only of type E 
@SuppressWarnings("unchecked")
public Stack() {
elements = (E[])new Object[DEFAULT_INITIAL_CAPACITY];
}

public void push(E e) {
ensureCapacity();
elements[size++] = e;
}

public E pop() throws EmptyStackException {
if (size == 0)
throw new EmptyStackException();
E result = elements[--size];
elements[size] = null; // Eliminate obsolete reference
return result;
}

public boolean isEmpty() {
return size == 0;
}

private void ensureCapacity() {
if (elements.length == size)
elements = Arrays.copyOf(elements, 2 * size + 1);
}
}

package com.bobocode.cs;

import com.bobocode.cs.exception.EmptyStackException;
import com.bobocode.util.ExerciseNotCompletedException;

import java.util.Objects;

/**
 * {@link LinkedStack} is a stack implementation that is based on singly linked generic nodes.
 * A node is implemented as inner static class {@link Node<T>}.
 * <p><p>
 * <strong>TODO: to get the most out of your learning, <a href="https://www.bobocode.com/learn">visit our website</a></strong>
 * <p>
 *
 * @param <T> generic type parameter
 * @author Taras Boychuk
 * @author Serhii Hryhus
 */
public class LinkedStack<T> implements Stack<T> {

    private Node<T> head;
    private int size;

    /**
     * This method creates a stack of provided elements
     *
     * @param elements elements to add
     * @param <T>      generic type
     * @return a new stack of elements that were passed as method parameters
     */
    public static <T> LinkedStack<T> of(T... elements) {
        var tLinkedStack = new LinkedStack<T>();
        Node<T> oldNode = null;
        Node<T> head = null;

        for (T elem : elements) {

            //--- new Node with elem
            var tNode = new Node<T>();
            tNode.value = elem;

            //--- attach new Node link to oldNode
            if (tLinkedStack.size != 0) {
                Objects.requireNonNull(oldNode);
                oldNode.next = tNode;
            }

            // save new Node as OldNode in order to save link to newNode
            //because every loop circle tNode has new link to new Node
            oldNode = tNode;

            if (tLinkedStack.size == 0) {
                head = oldNode;
            }

            tLinkedStack.size++;
        }
        tLinkedStack.head = head;
        return tLinkedStack;
    }

    /**
     * The method pushes an element onto the top of this stack. This has exactly the same effect as:
     * addElement(item)
     *
     * @param element elements to add
     */
    @Override
    public void push(T element) {
        if (element == null) throw new NullPointerException();
        if (head == null) head = new Node<>(element);

        Node<T> tNode = new Node<>(element);
        tNode.next = head;
        head = tNode;
        size++;
    }

    /**
     * This method removes the object at the top of this stack
     * and returns that object as the value of this function.
     *
     * @return The object at the top of this stack
     * @throws EmptyStackException - if this stack is empty
     */
    @Override
    public T pop() {
        if (head == null) throw new EmptyStackException();
        T value = head.value;
        head = head.next;
        size--;
        return value;
    }

    /**
     * Returns the number of elements in the stack
     *
     * @return number of elements
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks if a stack is empty
     *
     * @return {@code true} if a stack is empty, {@code false} otherwise
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    private static class Node<T> {
        Node<T> next;
        T value;

        Node(){
        }
        Node(T value){
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "next=" + next +
                    ", value=" + value +
                    '}';
        }
    }
}

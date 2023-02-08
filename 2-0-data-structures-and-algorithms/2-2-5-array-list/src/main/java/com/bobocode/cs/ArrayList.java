package com.bobocode.cs;

import com.bobocode.util.ExerciseNotCompletedException;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * {@link ArrayList} is an implementation of {@link List} interface. This resizable data structure
 * based on an array and is simplified version of {@link java.util.ArrayList}.
 * <p><p>
 * <strong>TODO: to get the most out of your learning, <a href="https://www.bobocode.com/learn">visit our website</a></strong>
 * <p>
 *
 * @author Serhii Hryhus
 */
public class ArrayList<T> implements List<T> {
    private static final int DEFAULT_CAPACITY = 5;
    private Object[] elementData;
    private int size;
    /**
     * This constructor creates an instance of {@link ArrayList} with a specific capacity of an array inside.
     *
     * @param initCapacity - the initial capacity of the list
     * @throws IllegalArgumentException – if the specified initial capacity is negative or 0.
     */
    public ArrayList(int initCapacity) {
        if (initCapacity <= 0) {
             throw new IllegalArgumentException();
        }
        elementData = new Object[initCapacity];
    }

    /**
     * This constructor creates an instance of {@link ArrayList} with a default capacity of an array inside.
     * A default size of inner array is 5;
     */
    public ArrayList() throws IllegalAccessException {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Creates and returns an instance of {@link ArrayList} with provided elements
     *
     * @param elements to add
     * @return new instance
     */
    public static <T> List<T> of(T... elements) throws IllegalAccessException {
        ArrayList<T> list = new ArrayList<>(elements.length);
        list.elementData = Arrays.copyOf(elements, elements.length);
        list.size = elements.length;
        return list;
    }

    /**
     * Adds an element to the array.
     *
     * @param element element to add
     */
    @Override
    public void add(T element) {
        if (elementData.length == size){
            elementData = grow();
        }
        elementData[size] = element;
        size++;
    }

    private Object[] grow() {
         return elementData = Arrays.copyOf(elementData, size * 2);
    }

    /**
     * Adds an element to the specific position in the array where
     *
     * @param index   index of position
     * @param element element to add
     */
    @Override
    public void add(int index, T element) {
        if (elementData.length == size){
            elementData = grow();
        }
        //array source -  масив з якого копіюємо
        // srcPosition - з якого місяця копіюємо масив
        // array destination - масив в який копіюємо
        // destination position - позиция в яку вставляємо
        // amount elements to copy - кількість елементів яку копіюємо
        System.arraycopy(elementData, index, elementData, index + 1, size - index);

        //15, 69, 58, 78, 68, 50
        //1 step -  копіюємо все з 2(index) індeксу (srcPos) це 58, 78, 68, 50
        //2 step -  length = size - index - кількість елементів яку копіюємо
        //3 step -  всталяємо все починаючи з 3(index + 1) індексу (dest) 15, 69, null, 58, 78, 68, 50
        //4 step -  вставляємо у індекс 2 (index) element ( elementData[index] = element )

        elementData[index] = element;
        size++;
    }

    /**
     * Retrieves an element by its position index. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index index of element
     * @return en element
     */
    @Override
    public T get(int index) {
        //if (null == elementData) throw new IndexOutOfBoundsException();
        //if (null == elementData[0]) throw new IndexOutOfBoundsException();
        Objects.checkIndex(index, size);
        return (T) elementData[index];
    }

    /**
     * Returns the first element of the list. Operation is performed in constant time O(1)
     *
     * @return the first element of the list
     * @throws java.util.NoSuchElementException if list is empty
     */
    @Override
    public T getFirst() {
        //if (null == elementData[0]) throw new NoSuchElementException();
        if (isEmpty()) throw new NoSuchElementException();
        return (T) elementData[0];
    }

    /**
     * Returns the last element of the list. Operation is performed in constant time O(1)
     *
     * @return the last element of the list
     * @throws java.util.NoSuchElementException if list is empty
     */
    @Override
    public T getLast() {
        if (isEmpty()) throw new NoSuchElementException();
        return (T) elementData[elementData.length - 1];
    }

    /**
     * Changes the value of array at specific position. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index   position of value
     * @param element a new value
     */
    @Override
    public void set(int index, T element) {
        //  0,  1,  2,  3
        // 15, 69, 48, 78
        //if (null == elementData[0]) throw new IndexOutOfBoundsException();
        //System.arraycopy(elementData, index, elementData, index, size - index);
        Objects.checkIndex(index, size);
        elementData[index] = element;
    }

    /**
     * Removes an elements by its position index. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index element index
     * @return deleted element
     */
    @Override
    public T remove(int index) {

        T data = (T) elementData[index];
        //if (null == elementData[0]) throw new IndexOutOfBoundsException();
        Objects.checkIndex(index, size);
        System.arraycopy(elementData, index + 1, elementData, index, size - index -1);
        size--;
        return data;
    }

    /**
     * Checks for existing of a specific element in the list.
     *
     * @param element is element
     * @return If element exists method returns true, otherwise it returns false
     */
    @Override
    public boolean contains(T element) {
        if (null == elementData[0]) return false;
        for (Object data : elementData) {
            if (element == data) return true;
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
     * @return amount of saved elements
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
        elementData = null;
        size = 0;
    }
}

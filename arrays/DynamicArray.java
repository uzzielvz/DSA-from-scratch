package arrays;

/**
 * A dynamic array implementation that supports variable size, fast index-based access,
 * and automatic resizing when full or underutilized.
 */
public class DynamicArray {
    private int[] array;
    private int size;
    private int capacity;

    /**
     * Constructs an empty dynamic array with a default capacity of 10.
     */
    public DynamicArray() {
        this.capacity = 10;
        this.array = new int[capacity];
        this.size = 0;
    }

    /**
     * Constructs an empty dynamic array with the specified initial capacity.
     * @param capacity the initial capacity of the array
     * @throws IllegalArgumentException if capacity is not positive
     */
    public DynamicArray(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.capacity = capacity;
        this.array = new int[capacity];
        this.size = 0;
    }

    /**
     * Adds an element at the end of the dynamic array.
     * If the array is full, its capacity is doubled.
     * @param element the element to add
     */
    public void add(int element) {
        if (size == capacity) {
            resize(capacity * 2);
        }
        array[size++] = element;
    }

    /**
     * Adds an element at the specified index, shifting subsequent elements to the right.
     * @param index the index at which to insert the element
     * @param element the element to add
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size)
     */
    public void add(int index, int element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (size == capacity) {
            resize(capacity * 2);
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    /**
     * Removes and returns the element at the specified index, shifting subsequent elements to the left.
     * If the size falls below a quarter of the capacity, the capacity is halved to save memory.
     * @param index the index of the element to remove
     * @return the removed element
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    public int removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        int element = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        if (size < capacity / 4 && capacity > 10) {
            resize(capacity / 2);
        }
        return element;
    }

    /**
     * Retrieves the element at the specified index.
     * @param index the index of the element to retrieve
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return array[index];
    }

    /**
     * Returns the number of elements in the array.
     * @return the size of the array
     */
    public int size() {
        return size;
    }

    /**
     * Returns the current capacity of the internal array.
     * @return the capacity of the array
     */
    public int capacity() {
        return capacity;
    }

    /**
     * Clears all elements from the array, resetting the size to 0.
     */
    public void clear() {
        this.array = new int[capacity];
        this.size = 0;
    }

    /**
     * Checks if the array is empty.
     * @return true if the array has no elements, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Resizes the internal array to the specified capacity.
     * @param newCapacity the new capacity of the array
     */
    private void resize(int newCapacity) {
        this.capacity = Math.max(10, newCapacity); // Ensure minimum capacity
        int[] newArray = new int[capacity];
        System.arraycopy(array, 0, newArray, 0, Math.min(size, capacity));
        array = newArray;
    }
}
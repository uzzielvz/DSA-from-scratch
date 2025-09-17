import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A generic FIFO queue implementation based on a resizing array.
 *
 * @param <Item> the generic type of an item in this queue
 */
public class Queue<Item> implements Iterable<Item> {

    private Item[] q;       // array of items
    private int n = 0;      // number of elements on queue
    private int head = 0;   // index of first element of queue
    private int tail = 0;   // index of next available slot

    /**
     * Initializes an empty queue.
     */
    public ResizingArrayQueue() {
        q = (Item[]) new Object[2]; // Start with capacity of 2
    }

    /**
     * Is this queue empty?
     * @return true if this queue is empty; false otherwise
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Returns the number of items in this queue.
     * @return the number of items in this queue
     */
    public int size() {
        return n;
    }

    /**
     * Resizes the underlying array.
     * @param capacity the new capacity
     */
    private void resize(int capacity) {
        assert capacity >= n;
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            temp[i] = q[(head + i) % q.length];
        }
        q = temp;
        head = 0;
        tail = n;
    }

    /**
     * Adds the item to this queue.
     * @param item the item to add
     */
    public void enqueue(Item item) {
        // Double size of array if necessary
        if (n == q.length) resize(2 * q.length);
        q[tail++] = item; // Add item
        if (tail == q.length) tail = 0; // Wrap-around
        n++;
    }

    /**
     * Removes and returns the item on this queue that was least recently added.
     * @return the item on this queue that was least recently added
     * @throws NoSuchElementException if this queue is empty
     */
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = q[head];
        q[head] = null; // to avoid loitering
        n--;
        head++;
        if (head == q.length) head = 0; // Wrap-around
        // Shrink size of array if necessary
        if (n > 0 && n == q.length / 4) resize(q.length / 2);
        return item;
    }

    /**
     * Returns an iterator that iterates over the items in this queue in FIFO order.
     * @return an iterator that iterates over the items in this queue in FIFO order
     */
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    // An iterator, doesn't implement remove() since it's optional
    private class ArrayIterator implements Iterator<Item> {
        private int i = 0;
        public boolean hasNext() { return i < n; }
        public void remove() { throw new UnsupportedOperationException(); }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = q[(i + head) % q.length];
            i++;
            return item;
        }
    }
}